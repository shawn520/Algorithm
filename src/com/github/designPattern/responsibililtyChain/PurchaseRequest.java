package com.github.designPattern.responsibililtyChain;

/**
 * 请求类
 * @author Shawn
 * @date 2020/8/31
 */
public class PurchaseRequest {

  private int id = 0;
  private int type = 0;
  private float price;  //请求金额

  public PurchaseRequest(int id, int type, float price) {
    this.id = id;
    this.type = type;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public int getType() {
    return type;
  }

  public float getPrice() {
    return price;
  }

}
