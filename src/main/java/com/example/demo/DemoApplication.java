package com.example.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CouponService couponService;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		couponService.saveCoupon();

		// Utwórz ExecutorService z pulą 500 wątków
		ExecutorService executorService = Executors.newFixedThreadPool(10000);

		// Uruchom 500 wątków równocześnie, każdy wykonujący couponService.addCoupon()
		for (int i = 1; i <= 2000; i++) {
			executorService.submit(() -> couponService.addCoupon());
		}

		// Zakończ ExecutorService po zakończeniu wszystkich wątków
		executorService.shutdown();
		executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

		couponService.printResult();

	}
}
