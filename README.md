# BillsToCoins
Given an amount in Bills that can be (1, 2, 5, 10, 20, 50, 100) change it to coins that are (0.01, 0.05, 0.10, 0.25). The machine needs to assume there is a finite number of coins.
Requirements:
• Start with 100 coins of each type (BONUS* - allow for number of coins to be configurable and easily changed if needed)

• Prompt User for an amount they want to get change for. (BONUS* - allow for direct rest service inputs as an alternative as well)

• Catch bad input and display error messages or catch exceptions if applicable

• Machine should return the least amount of coins with coin type (BONUS * - allow for other routines like most amount of coins)

• Machine should display a message if it does not have enough coins

• Code should maintain the state of coins left throughout all the transaction till it runs out of the coin then it should exit.

• Deliver the code with test cases

• Write it in java using spring boot 

--------------------------------------------------------------------------------------------

Solution:

Stand Alone Interface which has 4 options

Bills to Coins Program
Option 1: Configure the number of coins
Option 2: Get the Change for the Bill (Least amount of coins) 
Option 3: Get the Change for the Bill (Most amount of coins) 
Option 4: Exit 

Please enter a option!

And Rest Interface :

URL: http://localhost:8080/billsToCoins?bill=1

Request Param : { "bill" : "1" }

Response : {
    "Quarter": 4,
    "Nickels": 0,
    "Dimes": 0,
    "Pennis": 0
}
