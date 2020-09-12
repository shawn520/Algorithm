package com.github.designPattern.responsibililtyChain;

/**
 * @author Shawn
 * @date 2020/8/31
 */
public class Client {

  public static void main(String[] args) {
    //创建一个请求
    PurchaseRequest request = new PurchaseRequest(1,1, 50000);

    //创建相关的审批人

    DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
    CollegeApprover collegeApprover = new CollegeApprover("李院长");
    ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("王副校长");
    SchoolMaster schoolMaster = new SchoolMaster("陈校长");

    // 需要将各个审批级别的下一个设置好（）处理人构成环状
    departmentApprover.setApprover(collegeApprover);
    collegeApprover.setApprover(viceSchoolMasterApprover);
    viceSchoolMasterApprover.setApprover(schoolMaster);
    schoolMaster.setApprover(departmentApprover);

    departmentApprover.process(request);
  }
}
