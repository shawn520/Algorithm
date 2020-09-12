package com.github.demo.designPattern.structure.proxy.staticproxy;

/**
 * @author Shawn
 * @date 2019/10/12
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("老师正在上课");
    }
}
