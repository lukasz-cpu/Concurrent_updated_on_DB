package com.example.demo;

import java.util.Optional;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CouponService {

  @Autowired
  private CouponRepository couponRepository;


  @Transactional
  public void addCoupon(){
//    couponRepository.incrementUsagesLeft(1L);
    Coupon coupon = couponRepository.findById(1L).get();
    coupon.setUsagesLeft(coupon.getUsagesLeft() +1);
  }

  @Transactional
  public void saveCoupon(){
    Coupon newCoupon = new Coupon(1L, 0);
    couponRepository.saveAndFlush(newCoupon);
  }

  public void printResult(){
    Optional<Coupon> byId = couponRepository.findById(1L);
    System.out.println("-----------------");
    System.out.println(byId.get());
    System.out.println("-----------------");

  }


}
