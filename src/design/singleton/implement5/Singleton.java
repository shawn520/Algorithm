package design.singleton.implement5;

/**
 * 单例模式的静态内部类实现
 * 优点：实现简单，需要时加载，线程安全。
 * @author Shawn
 * @date 2019/7/1
 */
public class Singleton {

    private Singleton() {}

    public static Singleton getInstance() {

        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public void showMsg() {
        System.out.println("Hello World!");
    }
}
