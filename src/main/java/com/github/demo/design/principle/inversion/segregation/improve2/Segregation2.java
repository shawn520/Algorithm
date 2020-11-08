package com.github.demo.design.principle.inversion.segregation.improve2;

/**
 * 设计原则：接口隔离原则。
 * 一个类对另外一个类的依赖应该建立在最小接口上
 * 
 * @author Shawn
 * @date 2020/11/8
 */
public class Segregation2 {
    public static void main(String[] args) {
        ScienceCourse scienceCourse = new ScienceCourse();
        LiberalCourse liberalCourse = new LiberalCourse();

        ScienceStudent scienceStudent = new ScienceStudent();
        LiberalStudent liberalStudent= new LiberalStudent();

        scienceStudent.learnCommonCourse(scienceCourse);
        scienceStudent.learnChemistry(scienceCourse);
        scienceStudent.learnPhysics(scienceCourse);

        liberalStudent.learnCommonCourse(liberalCourse);
        liberalStudent.getHistoryBook(liberalCourse);
        liberalStudent.getGeographyBook(liberalCourse);
    }




}

interface CommonCourse {
    void getChineseMathEnglishBook();
}

interface ScienceElectiveCourse {
    void getChemistryBook();
    void getPhysicsBook();
}

interface LiberalElectiveCourse {
    void getHistoryBook();
    void getGeographyBook();
}

class ScienceCourse implements CommonCourse, ScienceElectiveCourse {

    @Override
    public void getChineseMathEnglishBook() {
        System.out.println("Science:getChineseMathEnglishBook");
    }

    @Override
    public void getChemistryBook() {
        System.out.println("Science: getChemistryBook");
    }

    @Override
    public void getPhysicsBook() {
        System.out.println("Science: getPhysicsBook");
    }

}

class LiberalCourse implements CommonCourse, LiberalElectiveCourse {

    @Override
    public void getChineseMathEnglishBook() {
        System.out.println("Liberal: getChineseMathEnglishBook");
    }

    @Override
    public void getHistoryBook() {
        System.out.println("Liberal: getHistoryBook");
    }

    @Override
    public void getGeographyBook() {
        System.out.println("Liberal: getGeographyBook");
    }
}

class ScienceStudent {

    void  learnCommonCourse(CommonCourse CommonCourse) {
        CommonCourse.getChineseMathEnglishBook();
    }

    void  learnChemistry(ScienceElectiveCourse ScienceElectiveCourse) {
        ScienceElectiveCourse.getChemistryBook();
    }

    void  learnPhysics(ScienceElectiveCourse ScienceElectiveCourse) {
        ScienceElectiveCourse.getPhysicsBook();
    }
}

class LiberalStudent {
    void  learnCommonCourse(CommonCourse CommonCourse) {
        CommonCourse.getChineseMathEnglishBook();
    }

    void  getHistoryBook(LiberalElectiveCourse LiberalElectiveCourse) {
        LiberalElectiveCourse.getHistoryBook();
    }

    void  getGeographyBook(LiberalElectiveCourse LiberalElectiveCourse) {
        LiberalElectiveCourse.getGeographyBook();
    }
}
