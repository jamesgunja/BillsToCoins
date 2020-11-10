package com.BillsToCoins;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.BillsToCoins.service.BillsToCoinsService;

@SpringBootTest
class BillsToCoinsApplicationTests {
	
	@Autowired
	BillsToCoinsService billToCoinsService;

	@Test
	void contextLoads() {
	}

}
