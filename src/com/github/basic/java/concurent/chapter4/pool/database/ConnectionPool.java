package com.github.basic.java.concurent.chapter4.pool.database;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author liuxiao_sx
 * @date 2019/4/18
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    /**
     * initialize connection pool.
     * @param initialize pool size
     */
    public ConnectionPool(int initialize) {
        if(initialize >0) {
            for(int i=0; i<initialize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    /**
     * release connection
     * @param connection
     */
    public void releaseConnection(Connection connection) {
        if(null != connection) {
            synchronized (pool) {
                //连接之后需要进行通知, 其他消费者能感知到已经归还了一个连接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    /**
     * get connection from pool.
     * @param mills
     * @return
     * @throws InterruptedException
     */
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            //完全超时
            if(mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                //连接池为空且等待时间大于0
                while (pool.isEmpty() && remaining > 0) {
                    //等待remaining时间
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if(!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}
