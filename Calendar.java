/** 
 * Prints the calendars of a given year.
 */
public class Calendar {	
	// Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January

	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */

	// main(string[]) - the entry point of a Java program.
    // args - args contains the supplied command-line
    // arguments as an array of String objects.
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.
		int inputYear = Integer.parseInt(args[0]);
		int yearDays = 0;
		if (isLeapYear(inputYear)) {
			yearDays = 366;
		}
		else {
			yearDays = 365;
		}

		while (year != inputYear) {
			advance();
		}

		int debugDaysCounter = 0;

	    //// Write the necessary initialization code, and replace the condition
	    //// of the while loop with the necessary condition 
		while (debugDaysCounter < yearDays) {
			System.out.print(dayOfMonth + "/" + month + "/" + year);
			if (dayOfWeek == 1) {
				System.out.println(" Sunday");
			}
			else{
				System.out.println();
			}
			advance();
			debugDaysCounter++;
        }
	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		if (dayOfMonth == nDaysInMonth) {
			if (month == 12) {
				month = 1;
				year++;
			}
			else {
				month++;
			}
			nDaysInMonth = nDaysInMonth(month, year);
			dayOfMonth = 1;
		}
		else {
			dayOfMonth++;
		}

		if (dayOfWeek == 7) {
			dayOfWeek = 1;
		}
		else {
			dayOfWeek++;
		}
	 } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	    if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){
			return true;
		}
		return false;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		}	
		else if (month == 2) {
			if (isLeapYear(year)) {
				return 29;
			}
			else {
				return 28;
			}
		}
		else {
			return 31;
		}
	}

	// check if 
}
