package com.BillsToCoins.utility;


import org.springframework.stereotype.Component;

import com.BillsToCoins.exception.BillsToCoinsException;

/**
 * This Class contains Validations. 
 *
 */
@Component
public class Validations {
	
	public static boolean validateBillValue(int billValue) throws BillsToCoinsException{
		if ((billValue == 1) || (billValue == 2) || (billValue == 5) || (billValue == 10) || (billValue == 20) ||  (billValue == 50)
				|| (billValue == 100)) {
			return true;
		}
		throw new BillsToCoinsException("Wrong Bill Value");
	}
	
	public static boolean isOptionCorrect(int option) {
		if ((option == 1) || (option == 2) || (option == 3)) {
			return true;
		}
		throw new BillsToCoinsException("Wrong Option");
	}

	

}
