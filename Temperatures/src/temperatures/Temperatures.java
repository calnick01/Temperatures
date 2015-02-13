package temperatures;

import java.util.Scanner;

public class Temperatures {
	public static Scanner input = new Scanner(System.in);
	// Constants that will be used throughout program to set array size
	public static final int ROWS = 2;
	public static final int COLUMNS = 12;
	// Implementing two dimensional array
	public static int[][] arrayTemp = new int[ROWS][COLUMNS];
	public static String[] monthArray = new String[COLUMNS];
	public static String[] month = { "JANURARY", "FEBURARY", "MARCH", "APRIL",
			"MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER",
			"NOVEMBER", "DECEMBER" };

	// Main method is used to call methods
	public static void main(String[] args) {
		System.out.println("Welcome to the temperature calculator");
		System.out.println("What year are you calculating?");
		String year = input.next();
		arrayTemp = inputTempYear();
		displayTemp(arrayTemp);
		System.out.println("These are the results from" + year);
	}

	// Method to take values for a single month
	public static void inputTempMonth(int[][] arrayTemp, int month) {
		System.out.println("Enter the low and high temperature for month #"
				+ (month + 1));
		for (int i = 0; i < ROWS; i++) {
			arrayTemp[i][month] = input.nextInt();
		}
	}

	// Method to take values for an entire year
	public static int[][] inputTempYear() {
		int[][] temp = new int[ROWS][COLUMNS];
		for (int i = 0; i < COLUMNS; i++) {
			inputTempMonth(temp, i);
		}
		return temp;
	}

	// Method to calculate average low
	public static int calculateAvgLow(int[][] arrayTemp) {
		int temp = 0;
		for (int i = 0; i < COLUMNS; i++) {
			temp += arrayTemp[0][i];
		}
		return temp / 12;
	}

	// Method to calculate average high
	public static int calculateAvgHigh(int[][] arrayTemp) {
		int temp = 0;
		for (int i = 0; i < COLUMNS; i++) {
			temp += arrayTemp[1][i];
		}
		return temp / 12;
	}

	// Method to calculate lowest temp
	public static int calcLowTemp(int[][] arrayTemp) {
		int indexLow = 1;
		for (int i = 1; i < COLUMNS; i++) {
			if (arrayTemp[0][i] < arrayTemp[0][indexLow])
				indexLow = i;
		}
		System.out.println("The lowest month is " + month[indexLow]);
		return indexLow;
	}

	// Method to calculate the higest temp
	public static int calcHighTemp(int[][] arrayTemp) {
		int indexHigh = 1;
		for (int i = 0; i < COLUMNS; i++) {
			if (arrayTemp[1][i] > arrayTemp[1][indexHigh])
				indexHigh = i;
		}
		System.out.println("The highest month is " + month[indexHigh]);
		return indexHigh;
	}

	public static void displayTemp(int[][] arrayTemp) {
		System.out.println("Average low: " + calculateAvgLow(arrayTemp));
		System.out.println("Average high: " + calculateAvgHigh(arrayTemp));
		System.out
				.println("Lowest temperature month: " + calcLowTemp(arrayTemp));
		System.out.println("Highest temperature month: "
				+ calcHighTemp(arrayTemp));
	}
}