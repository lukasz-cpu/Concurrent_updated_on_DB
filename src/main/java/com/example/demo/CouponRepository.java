package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

  @Modifying
  @Query("UPDATE Coupon c SET c.usagesLeft = c.usagesLeft + 1 WHERE c.id = :couponId")
  int incrementUsagesLeft(@Param("couponId") Long couponId);

}
