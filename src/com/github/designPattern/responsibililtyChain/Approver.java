package com.github.designPattern.responsibililtyChain;

/**
 * @author Shawn
 * @date 2020/8/31
 */
public abstract class Approver {

  Approver approver;  //下一个处理者
  String name;

  public Approver(String name) {
    this.name = name;
  }

  /**
   * 设置下一个处理请求的approver
   * @param approver
   */
  public void setApprover(Approver approver) {
    this.approver = approver;
  }

  /**
   * 处理审批请求的方法，得到一个请求，处理是子类完成，因此该方法做成抽象
   * @param request
   */
  public abstract void process(PurchaseRequest request);



}
