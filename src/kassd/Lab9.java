/*
 * SE-1011-001
 * Winter 2010-2011
 * Lab 9
 * Dan Kass
 * 2/15/11
 */
/**
 * @author Kass
 * This class contains only class (static) methods 
 */
package kassd;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab9 {
	public static void main(String[] args) {

		// The tests for Series Up
		ArrayList<Integer> answer1 = new ArrayList<Integer>();
		answer1 = ArrayListMaker("1 1 2 1 2 3");
		checkSeriesUp(3, answer1);

		ArrayList<Integer> answer2 = new ArrayList<Integer>();
		answer2 = ArrayListMaker("1 1 2 1 2 3 1 2 3 4");
		checkSeriesUp(4, answer2);

		ArrayList<Integer> answer3 = new ArrayList<Integer>();
		answer3 = ArrayListMaker("1 1 2");
		checkSeriesUp(2, answer3);

		ArrayList<Integer> answer4 = new ArrayList<Integer>();
		answer4 = ArrayListMaker("1");
		checkSeriesUp(1, answer4);

		ArrayList<Integer> answer5 = new ArrayList<Integer>();
		answer5 = ArrayListMaker(" ");
		checkSeriesUp(0, answer5);

		ArrayList<Integer> answer6 = new ArrayList<Integer>();
		answer6 = ArrayListMaker("1 1 2 1 2 3 1 2 3 4 1 2 3 4 5 1 2 3 4 5 6 ");
		checkSeriesUp(6, answer6);

		// Tests for Count Clumps
		ArrayList<Integer> countAnswer1 = new ArrayList<Integer>();
		countAnswer1 = ArrayListMaker("1 2 2 3 4 4");
		checkCountClumps(countAnswer1, 2);

		ArrayList<Integer> countAnswer2 = new ArrayList<Integer>();
		countAnswer2 = ArrayListMaker("1 1 2 1 1");
		checkCountClumps(countAnswer2, 2);

		ArrayList<Integer> countAnswer3 = new ArrayList<Integer>();
		countAnswer3 = ArrayListMaker("1 1 1 1 1");
		checkCountClumps(countAnswer3, 1);

		ArrayList<Integer> countAnswer4 = new ArrayList<Integer>();
		countAnswer4 = ArrayListMaker("1 2 3");
		checkCountClumps(countAnswer4, 0);

		ArrayList<Integer> countAnswer5 = new ArrayList<Integer>();
		countAnswer5 = ArrayListMaker("2 2 1 1 1 2 1 1 2 2 4");
		checkCountClumps(countAnswer5, 4);

		ArrayList<Integer> countAnswer6 = new ArrayList<Integer>();
		countAnswer6 = ArrayListMaker("0 2 2 1 1 1 2 1 1 2 2 4");
		checkCountClumps(countAnswer6, 4);

		ArrayList<Integer> countAnswer7 = new ArrayList<Integer>();
		countAnswer7 = ArrayListMaker("0 0 2 2 1 1 1 2 1 1 2 2");
		checkCountClumps(countAnswer7, 5);

		ArrayList<Integer> countAnswer8 = new ArrayList<Integer>();
		countAnswer8 = ArrayListMaker("0 0 0 2 2 1 1 1 2 1 1 2 2");
		checkCountClumps(countAnswer8, 5);

		ArrayList<Integer> countAnswer9 = new ArrayList<Integer>();
		countAnswer9 = ArrayListMaker(" ");
		checkCountClumps(countAnswer9, 0);
		
		//Equals ArrayList tester
		
		System.out.println("These 2 ArrayList are equal?: " + equalArrayList(ArrayListMaker("1 2 3"), ArrayListMaker("1 2 3")));
		System.out.println("These 2 ArrayList are equal?: " + equalArrayList(ArrayListMaker("1 2 3"), ArrayListMaker("0 1 2")));
		System.out.println("These 2 ArrayList are equal?: " + equalArrayList(ArrayListMaker("0 2 5 6 7"), ArrayListMaker("2 5 6 8 7 9 6 3 ")));

	}

	/**
	 * This turn's Strings of ints to ArrayLists
	 * 
	 * @param list
	 *            is a string of ints
	 * @return an ArrayList of the ints in order they were in the String
	 */
	private static ArrayList<Integer> ArrayListMaker(String list) {
		ArrayList<Integer> newList = new ArrayList<Integer>();
		Scanner numbers = new Scanner(list);
		while (numbers.hasNextInt()) {
			newList.add(numbers.nextInt());
		}
		return newList;
	}



	/**
	 * This method compares to ArrayList to see if they are equal or not
	 * @param list1 is the first ArrayList
	 * @param list2 is the second ArrayList
	 * @return a boolean if it is true of false
	 */
	private static boolean equalArrayList(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		boolean equals = (list1.size() == list2.size());
		if (equals){
			for (int i=0; i<list1.size() && equals; i++){
				equals = list1.get(i) == list2.get(i);
			}
		}
		return equals;
	}
	
	/**
	 * This checks to see if the answer from the seriesUp method is equal to the
	 * expected Answer
	 * 
	 * @param testNum
	 *            is the int that the seriesUp method uses
	 * @param answer
	 *            is the expected answer in an ArrayList form
	 */
	private static void checkSeriesUp(int testNum, ArrayList<Integer> answer) {
		boolean correct = false;
		if (seriesUp(testNum).equals(answer)) {
			correct = true;
		}
		System.out.println("Series Up");
		System.out.println("Your answer" + seriesUp(testNum));
		System.out.println("The correct answer" + answer);
		System.out
				.println("Your answer is " + correct + " for test " + testNum);
	}

	/**
	 * Creates on ArrayList that will have a patter that counts up 1 then 1,2
	 * and so on up until "n"
	 * 
	 * @param n
	 *            an integer that will determine the size of the ArrayList
	 * @return an ArrayList
	 */
	private static ArrayList<Integer> seriesUp(int n) {

		int totalLength = (n * (n + 1) / 2);
		int number = 1;
		int numberInCount = 1;

		ArrayList<Integer> pattern = new ArrayList<Integer>();

		for (int i = 0; i < totalLength; i++) {
			if (number != numberInCount) {
				pattern.add(number);
				number++;
			} else {
				pattern.add(number);
				number = 1;
				numberInCount++;
			}
		}
		return pattern;
	}

	/**
	 * This checks to see if the answer from the countClumps method is is equal
	 * to the expected answer
	 * 
	 * @param input
	 *            is ArrayList that the is used with the countClumps method
	 * @param countAnswer
	 *            is the expected answer
	 */
	private static void checkCountClumps(ArrayList<Integer> input,
			int countAnswer) {
		boolean correct = false;
		if (countClumps(input) == (countAnswer)) {
			correct = true;
		}
		System.out.println("Count Clumps");
		System.out.println("Your answer " + countClumps(input));
		System.out.println("The correct Answer " + countAnswer);
		System.out.println("Your Answer is " + correct + " for test " + input);
	}

	/**
	 * Counts the number of the same number clumps in an ArrayList
	 * 
	 * @param nums
	 *            is an ArrayList of ints
	 * @return and int value of the number of the same number in the ArrayList
	 */
	private static int countClumps(ArrayList<Integer> nums) {
		int count = 0;
		int first = 0;
		int second = 0;
		boolean same = false;

		for (int i = 0; i < nums.size() - 1; i++) {
			second = first + 1;
			if (nums.get(first) == nums.get(second) && !same) {
				count++;
				first++;
				same = true;
			} else if (nums.get(first) == nums.get(second)) {
				first++;
			} else {
				first++;
				same = false;
			}
		}
		return count;
	}

}
