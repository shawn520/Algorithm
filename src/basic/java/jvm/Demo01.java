package basic.java.jvm;

/**
 * @author Shawn
 * @date 2020/8/13
 */
public class Demo01 {
  public static void main(String[] args) {
    Object obj = new Object();
    Demo01 demo01 = new Demo01();
    System.out.println(obj.getClass().getClassLoader());
    System.out.println("-----------");
    System.out.println(demo01.getClass().getClassLoader().getParent().getParent());
    System.out.println(demo01.getClass().getClassLoader().getParent().toString());
    System.out.println(demo01.getClass().getClassLoader().toString());
    System.out.println("-----------");
  }
}
