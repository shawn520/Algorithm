package design.creation.singleton.implement2;

/**
 * 单例模式的懒汉式线程安全实现
 * 优点：需要时加载
 * 缺点：加锁效率低
 * @author Shawn
 * @date 2019/7/1
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if(null == instance) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMsg() {
        System.out.println("Hello World!");
    }
}
