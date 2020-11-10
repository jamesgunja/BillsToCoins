package com.BillsToCoins.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BillsToCoins.exception.BillsToCoinsException;
import com.BillsToCoins.service.BillsToCoinsService;

@RestController
@RequestMapping("/billsToCoins")
public class BillstoCoinsController {
	
	@Autowired
	BillsToCoinsService billsToCoinsService;
	
	@GetMapping("/LeastAmountOfCoins")
	public Map<String,Integer> billsToCoinsLeast(@RequestParam("bill") int bill) throws Exception {
		Map<String, Integer> map=billsToCoinsService.calculateLeastAmountOfCoins(bill);
		return map;		
	}
	
	@GetMapping("/MostAmountOfCoins")
	public Map<String,Integer> billsToCoinsMost(@RequestParam("bill") int bill) throws Exception {
		Map<String, Integer> map=billsToCoinsService.calculateMostAmountOfCoins(bill);
		return map;		
	}
	
	@ExceptionHandler(value = BillsToCoinsException.class)
	   public ResponseEntity<Object> exception(BillsToCoinsException exception) {
	      return new ResponseEntity<>("Not Enough Coins", HttpStatus.OK);
	   }

}
