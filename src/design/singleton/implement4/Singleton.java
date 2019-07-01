package design.singleton.implement4;

/**
 * 单例模式的双重校验锁实现
 * 优点：需要时加载，线程安全，效率高
 * 缺点：实现稍复杂
 * @author Shawn
 * @date 2019/7/1
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if(null == instance) {
            synchronized (Singleton.class) {
                if(null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void showMsg() {
        System.out.println("Hello World!");
    }
}
