package com.BillsToCoins.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.BillsToCoins.exception.BillsToCoinsException;
import com.BillsToCoins.utility.Constants;
import com.BillsToCoins.utility.Helper;

@Service
public class BillsToCoinsService {

	private int numQuarters = 0;
	private int numDimes = 0;
	private int numNickels = 0;
	private int numPennies = 0;
	private int quarterCounter = Constants.DEFAULT_CONFIGURED_COINS;
	private int dimesCounter = Constants.DEFAULT_CONFIGURED_COINS;
	private int nickelsCounter = Constants.DEFAULT_CONFIGURED_COINS;
	private int penniesCounter = Constants.DEFAULT_CONFIGURED_COINS;
	private int centsInSystem;

	public Map<String, Integer> calculateLeastAmountOfCoins(int bill) throws BillsToCoinsException {

		int centsLeft = Helper.convertDollartoCents(bill);

		System.out.println(
				"Bill Amount: " + bill + " Cents Required:  " + centsLeft + " Cents in System:  " + getCentsInSystem());

		if (!areThereEnoughCoins(centsLeft))
			throw new BillsToCoinsException("Not Enough Coins");

		numQuarters = centsLeft / Constants.QUARTERS;
		if (numQuarters <= quarterCounter) {
			centsLeft = centsLeft % Constants.QUARTERS;
			quarterCounter = quarterCounter - numQuarters;
		} else {
			centsLeft = centsLeft - (Constants.QUARTERS * quarterCounter);
			numQuarters = quarterCounter;
			quarterCounter = 0;
		}

		numDimes = centsLeft / Constants.DIMES;
		if (numDimes <= dimesCounter) {
			centsLeft = centsLeft % Constants.DIMES;
			dimesCounter = dimesCounter - numDimes;
		} else {
			centsLeft = centsLeft - (Constants.DIMES * dimesCounter);
			numDimes = dimesCounter;
			dimesCounter = 0;
		}

		numNickels = centsLeft / Constants.NICKELS;
		if (numNickels <= nickelsCounter) {
			centsLeft = centsLeft % Constants.NICKELS;
			nickelsCounter = nickelsCounter - numNickels;
		} else {
			centsLeft = centsLeft - (Constants.NICKELS * nickelsCounter);
			numNickels = nickelsCounter;
			nickelsCounter = 0;
		}

		numPennies = centsLeft / Constants.PENNIES;
		if (numPennies <= penniesCounter) {
			centsLeft = centsLeft % Constants.PENNIES;
			penniesCounter = penniesCounter - numPennies;
		} else {
			centsLeft = centsLeft - (Constants.PENNIES * penniesCounter);
			numPennies = penniesCounter;
			penniesCounter = 0;
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Quarter", numQuarters);
		map.put("Dimes", numDimes);
		map.put("Nickels", numNickels);
		map.put("Pennis", numPennies);
		displayCoins();

		return map;

	}

	public Map<String, Integer> calculateMostAmountOfCoins(int bill) throws BillsToCoinsException {

		int centsLeft = Helper.convertDollartoCents(bill);
		System.out.println(
				"Bill Amount:  " + bill + " Cents Required:  " + centsLeft + " Cents in System:  " + getCentsInSystem());

		if (!areThereEnoughCoins(centsLeft))
			throw new BillsToCoinsException("Not Enough Coins");

		numPennies = centsLeft / Constants.PENNIES;
		if (numPennies <= penniesCounter) {
			centsLeft = centsLeft % Constants.PENNIES;
			penniesCounter = penniesCounter - numPennies;
		} else {
			centsLeft = centsLeft - (Constants.PENNIES * penniesCounter);
			numPennies = penniesCounter;
			penniesCounter = 0;
		}

		numNickels = centsLeft / Constants.NICKELS;
		if (numNickels <= nickelsCounter) {
			centsLeft = centsLeft % Constants.NICKELS;
			nickelsCounter = nickelsCounter - numNickels;
		} else {
			centsLeft = centsLeft - (Constants.NICKELS * nickelsCounter);
			numNickels = nickelsCounter;
			nickelsCounter = 0;
		}

		numDimes = centsLeft / Constants.DIMES;
		if (numDimes <= dimesCounter) {
			centsLeft = centsLeft % Constants.DIMES;
			dimesCounter = dimesCounter - numDimes;
		} else {
			centsLeft = centsLeft - (Constants.DIMES * dimesCounter);
			numDimes = dimesCounter;
			dimesCounter = 0;
		}

		System.out.println("centsLeft: " + centsLeft);
		numQuarters = centsLeft / Constants.QUARTERS;
		if (numQuarters <= quarterCounter) {
			centsLeft = centsLeft % Constants.QUARTERS;
			quarterCounter = quarterCounter - numQuarters;
		} else {
			centsLeft = centsLeft - (Constants.QUARTERS * quarterCounter);
			numQuarters = quarterCounter;
			quarterCounter = 0;
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Quarter", numQuarters);
		map.put("Dimes", numDimes);
		map.put("Nickels", numNickels);
		map.put("Pennis", numPennies);
		displayCoins();
		return map;

	}

	public void displayCoins() {
		System.out.println(" Quarters = " + numQuarters + "  Quarters Left in System:  " + quarterCounter);
		System.out.println(" Dimes    = " + numDimes + "  Dimes Left in System:  " + dimesCounter);
		System.out.println(" Nickels  = " + numNickels + "  Nickels Left in System:  " + nickelsCounter);
		System.out.println(" Pennies  = " + numPennies + "  Pennies Left in System:  " + penniesCounter);
		System.out.println();

	}

	public boolean areThereEnoughCoins(int centsLeft) {
		if (centsInSystem >= centsLeft) {
			return true;
		}
		return false;
	}

	public int getQuarterCounter() {
		return quarterCounter;
	}

	public void setQuarterCounter(int quarterCounter) {
		this.quarterCounter = quarterCounter;
	}

	public int getDimesCounter() {
		return dimesCounter;
	}

	public void setDimesCounter(int dimesCounter) {
		this.dimesCounter = dimesCounter;
	}

	public int getNickelsCounter() {
		return nickelsCounter;
	}

	public void setNickelsCounter(int nickelsCounter) {
		this.nickelsCounter = nickelsCounter;
	}

	public int getPenniesCounter() {
		return penniesCounter;
	}

	public void setPenniesCounter(int penniesCounter) {
		this.penniesCounter = penniesCounter;
	}

	public int getCentsInSystem() {
		 centsInSystem = (quarterCounter * 25) + (dimesCounter * 10) + (nickelsCounter * 5) + (penniesCounter * 1);
		return centsInSystem;
	}

}
