package basic.java.map;

import java.util.HashMap;

/**
 * @author Shawn
 * @date 2019/7/19
 */
public class HashMapResize {

    private static HashMap map = new HashMap(16);

    public static void main(String[] args) {

        for(int i = 0; i < 12; i++) {
            map.put(new UserKey(), new Object());
        }
        // 扩容发生
        map.put(new UserKey(), new Object());
    }
}

class UserKey {

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object object) {
        return false;

    }
}
