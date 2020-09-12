package com.github.designPattern.responsibililtyChain;

/**
 * CollegeApprover
 * @author Shawn
 * @date 2020/8/31
 */
public class CollegeApprover extends Approver {
  public CollegeApprover(String name) {
    super(name);
  }

  @Override
  public void process(PurchaseRequest request) {
    if(request.getPrice() <= 10000) {
      System.out.println("请求编号id=" + request.getId()+ "被" + this.name + "处理");
    } else {
      approver.process(request);
    }
  }
}
