package com.BillsToCoins.utility;

import org.springframework.stereotype.Component;

/**
 * This class contains Helper Methods. 
 *
 */
@Component
public class Helper {
	
	public static int convertDollartoCents(int dollars) {
		return 100 * dollars;
	}

}
