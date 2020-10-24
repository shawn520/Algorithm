package com.github.demo.designPattern.action.responsibililtyChain;

/**
 * ViceSchoolMasterApprover
 * @author Shawn
 * @date 2020/8/31
 */
public class ViceSchoolMasterApprover extends Approver {
  public ViceSchoolMasterApprover(String name) {
    super(name);
  }

  @Override
  public void process(PurchaseRequest request) {
    if(request.getPrice() <= 30000) {
      System.out.println("请求编号id=" + request.getId()+ "被" + this.name + "处理");
    } else {
      approver.process(request);
    }
  }
}
