import java.lang.reflect.Array;
import java.util.Scanner;

public class creditCard {

	public static void main(String[] args)
	{
		String strCardNumber;		// A string variable to store card number.
		int sum = 0;				// An integer value to store final sum of digits.
		int checkDigit;				// An integer value to store check digit.
		
		Scanner scan = new Scanner(System.in);		// Create new Scanner object and assigning to a variable.
		
		System.out.print("Enter a credit card number with an even number of digits: ");		// Print message to get user input. 
		
		strCardNumber = scan.nextLine();		// Scan user input to the string variable.
		
		if(!(strCardNumber.length()%2 == 0))				// Check if the number of digits is even.
		{													//
			System.out.println("Invalid card number.");		// If not, print the error message and exit the program
			System.exit(-1);								//
		}
		
		char strArray[] = strCardNumber.toCharArray();		// Write characters of the string to a new array.
		int intArray[] = new int[strArray.length-1];		// Declare a new integer array.
		
		for (int i = 0; i < strArray.length-1; i++) 				// Iterate over characters of the string array except for the check digit. 
		{
			intArray[i] = Character.getNumericValue(strArray[i]);	// Convert characters to integers and write them into the integer array.
		}
		
		for (int i = intArray.length-1; i >= 0 ; i -= 2) 			// Iterate over every other element of the integer array starting from the right. 
		{
			if(intArray[i] >= 5)									//
				Array.set(intArray, i, (intArray[i]*2)%10+1);		// Double every other array element 
			else													// Sum digits if larger than 10
				Array.set(intArray, i, intArray[i]*2);				//
		}
		
		for (int i : intArray)		//
		{							//  Add all elements together.
			sum += i;				//
		}							//
		
		if (sum % 10 == 0)				// If the last digit of the sum 0, check digit is zero
			checkDigit = 0;				//
		else							// Otherwise deduct the last digit of the sum from 10 to find the check digit.
			checkDigit = 10 - sum % 10;	//
		
		System.out.printf("Credit card number entered: %s \n", strCardNumber);	//		
		System.out.printf("The check digit is " + checkDigit);					//
		
		scan.close();		// Close the scanner.
		
	}

	
}
