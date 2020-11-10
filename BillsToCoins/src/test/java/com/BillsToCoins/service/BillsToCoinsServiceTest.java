package com.BillsToCoins.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BillsToCoinsServiceTest {
	
	BillsToCoinsService billsToCoinsService;

	
	
	@Test
	void testLeastAmountOfCoinsForBillAmountOne() {
		billsToCoinsService=new BillsToCoinsService();
		billsToCoinsService.calculateLeastAmountOfCoins(1);
		Assertions.assertEquals(billsToCoinsService.getQuarterCounter(),96);
		Assertions.assertEquals(billsToCoinsService.getDimesCounter(),100);
		Assertions.assertEquals(billsToCoinsService.getNickelsCounter(),100);
		Assertions.assertEquals(billsToCoinsService.getPenniesCounter(),100);

	}
	
	@Test
	void testMostAmountOfCoinsForBillAmountOne() {
		billsToCoinsService=new BillsToCoinsService();
		billsToCoinsService.calculateMostAmountOfCoins(1);
		Assertions.assertEquals(billsToCoinsService.getQuarterCounter(),100);
		Assertions.assertEquals(billsToCoinsService.getDimesCounter(),100);
		Assertions.assertEquals(billsToCoinsService.getNickelsCounter(),100);
		Assertions.assertEquals(billsToCoinsService.getPenniesCounter(),0);	}


}
