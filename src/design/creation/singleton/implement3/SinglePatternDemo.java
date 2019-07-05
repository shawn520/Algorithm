package design.creation.singleton.implement3;

/**
 * @author Shawn
 * @date 2019/7/1
 */
public class SinglePatternDemo {

    public static void main(String[] args) {

        SingleObject object = SingleObject.getInstance();

        object.showMsg();
    }
}
