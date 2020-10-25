package com.github.demo.design.structure.proxy.staticproxy;

/**
 * @author Shawn
 * @date 2019/10/12
 */
public class TeacherDaoProxy implements ITeacherDao {

    ITeacherDao teacherDao;

    public TeacherDaoProxy(ITeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public void teach() {
        System.out.println("代理对象开始运行");
        teacherDao.teach();
        System.out.println("代理对象运行完成");
    }
}
