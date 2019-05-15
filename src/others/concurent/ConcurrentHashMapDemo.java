package others.concurent;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * @author liuxiao_sx
 * @date 2019/5/15
 */
public class ConcurrentHashMapDemo {
    private Logger logger = Logger.getAnonymousLogger();


    @Test
    public void test() {
        testConcurrentHashMap();
    }

    void testConcurrentHashMap() {

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(16);
        concurrentHashMap.put("name", "shawn");
        concurrentHashMap.put("age", String.valueOf(18));
        int size = concurrentHashMap.size();
        logger.info(String.valueOf(size));



    }
}
