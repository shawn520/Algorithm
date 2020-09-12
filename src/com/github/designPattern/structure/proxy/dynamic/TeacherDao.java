package com.github.designPattern.structure.proxy.dynamic;

/**
 * @author Shawn
 * @date 2019/10/12
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("teach...");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("Helle: " + name);
    }
}
