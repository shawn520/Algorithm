package basic.java;

/**
 * 测试类加载机制
 * @author Shawn
 * @date 2019/7/9
 */
public class TestLoader {
    public static void main(String[] args) {
        ClassLoader appClassloader = TestLoader.class.getClassLoader();
        System.out.println(appClassloader);

        ClassLoader extClassLoader = appClassloader.getParent();
        System.out.println(extClassLoader);

        ClassLoader bootStrapClassLoader = extClassLoader.getParent();
        System.out.println(bootStrapClassLoader);

    }
}
