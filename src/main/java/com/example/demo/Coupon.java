package com.example.demo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Coupon {

  @Id
  private Long id;
  private int usagesLeft;

  public Coupon() {
  }

  public Coupon(Long id, int usagesLeft) {
    this.id = id;
    this.usagesLeft = usagesLeft;
  }

  @Override
  public String toString() {
    return "Coupon{" +
        "id=" + id +
        ", usagesLeft=" + usagesLeft +
        '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getUsagesLeft() {
    return usagesLeft;
  }

  public void setUsagesLeft(int usagesLeft) {
    this.usagesLeft = usagesLeft;
  }
}