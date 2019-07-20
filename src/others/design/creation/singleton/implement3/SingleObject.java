package others.design.creation.singleton.implement3;

/**
 * 单例模式的饿汉式实现，线程安全
 * 缺点：类加载时就初始化，浪费内存
 * @author Shawn
 * @date 2019/7/1
 */
public class SingleObject {

    private static SingleObject instance = new SingleObject();

    private SingleObject() {}

    public static SingleObject getInstance() {
        return instance;
    }

    public void showMsg() {
        System.out.println("Hello World!");
    }
}
