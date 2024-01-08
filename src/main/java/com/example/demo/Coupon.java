package com.example.demo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Coupon implements Serializable {

  @Id
  private Long id;
  private int usagesLeft;

//  @Version
//  @Column(name = "optlock", columnDefinition = "integer DEFAULT 0", nullable = false)
//  private long version = 0L;

  public Coupon() {
  }

  public Coupon(Long id, int usagesLeft) {
    this.id = id;
    this.usagesLeft = usagesLeft;
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

  @Override
  public String toString() {
    return "Coupon{" +
        "id=" + id +
        ", usagesLeft=" + usagesLeft +
        '}';
  }
}