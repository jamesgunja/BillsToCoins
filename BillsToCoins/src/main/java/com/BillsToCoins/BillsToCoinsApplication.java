package com.BillsToCoins;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.BillsToCoins.exception.BillsToCoinsException;
import com.BillsToCoins.service.BillsToCoinsService;
import com.BillsToCoins.utility.Validations;

@SpringBootApplication
public class BillsToCoinsApplication {

	static boolean validState = true;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BillsToCoinsApplication.class, args);

		BillsToCoinsService billsToCoinsService = new BillsToCoinsService();

		Scanner input = new Scanner(System.in);
		while (isValidState()) {

			System.out.println("Bills to Coins Program");
			System.out.println("----------------------");
			System.out.println("Option 1: Configure the number of coins");
			System.out.println("Option 2: Get the Change for the Bill (Least amount of coins) ");
			System.out.println("Option 3: Get the Change for the Bill (Most amount of coins) ");
			System.out.println("Option 4: Exit \n");
			System.out.println("Please enter a option!");

			while (!input.hasNext("[1234]")) {
				System.out.println("That's not a option!");
				input.next();
			}
			int option = input.nextInt();
			switch (option) {

			case 1:
				System.out.println("Default coins Setup");
				System.out.println("Quarters  " + billsToCoinsService.getQuarterCounter());
				System.out.println("Dimes  " + billsToCoinsService.getDimesCounter());
				System.out.println("Nickels  " + billsToCoinsService.getNickelsCounter());
				System.out.println("Pennies  " + billsToCoinsService.getPenniesCounter());

				System.out.println("Enter Quarters in System\n");
				try {
					int quarterInput = Integer.parseInt(input.nextLine());
					billsToCoinsService.setQuarterCounter(quarterInput);
				} catch (NumberFormatException ex) {
					throw new BillsToCoinsException("Wrong Input");
				}

				System.out.println("Enter Dimes in System\n");
				try {
					int dimesInput = Integer.parseInt(input.nextLine());
					billsToCoinsService.setDimesCounter(dimesInput);
				} catch (NumberFormatException ex) {
					throw new BillsToCoinsException("Wrong Input");
				}

				try {
					System.out.println("Enter Nickels in System\n");
					int nickelInput = Integer.parseInt(input.nextLine());

					billsToCoinsService.setNickelsCounter(nickelInput);
				} catch (NumberFormatException ex) {
					throw new BillsToCoinsException("Wrong Input");
				}

				try {
					System.out.println("Enter Pennies in System\n");
					int penniesInput = Integer.parseInt(input.nextLine());

					billsToCoinsService.setPenniesCounter(penniesInput);
				} catch (NumberFormatException ex) {
					throw new BillsToCoinsException("Wrong Input");
				}
				System.out.println("Quarters  " + billsToCoinsService.getQuarterCounter());
				System.out.println("Dimes  " + billsToCoinsService.getDimesCounter());
				System.out.println("Nickels  " + billsToCoinsService.getNickelsCounter());
				System.out.println("Pennies  " + billsToCoinsService.getPenniesCounter());

				break;

			case 2:
				System.out.println("Enter bill Amount for Change. Accepted Values are (1,2,5,10,20,50,100)\n");
				try {
					int dollars = Integer.parseInt(new Scanner(System.in).nextLine());
					if (Validations.validateBillValue(dollars)) {
						billsToCoinsService.calculateLeastAmountOfCoins(dollars);
					}
				} catch (BillsToCoinsException e) {
					System.out.println(e.getMessage());

				}

				break;

			case 3:
				System.out.println("Enter bill Amount for Change. Accepted Values are (1,2,5,10,20,50,100)\n");
				try {
					int dollars = Integer.parseInt(new Scanner(System.in).nextLine());
					if (Validations.validateBillValue(dollars)) {
						billsToCoinsService.calculateMostAmountOfCoins(dollars);
					}
				} catch (BillsToCoinsException e) {
					System.out.println(e.getMessage());

				}

				break;

			case 4:
				validState = false;
				System.out.println("Exit");
				break;

			}

		}
		input.close();
	
	}

	private static boolean isValidState() {
		return validState;

	}


}
