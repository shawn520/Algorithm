package basic.java;

/**
 * 测试类加载机制
 * 类经过编译后的class文件只有加载到jvm中才会被执行。
 * jvm是动态加载类的。
 * 动态加载的好处：按需加载，加快类加载时间；节省内存开销；节省编译时间。
 *
 * 类是通过类加载器加载到jvm中的。按照类的不同，分为三种类加载器。类加载器是通过委托的方式进行加载的。
 *
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
