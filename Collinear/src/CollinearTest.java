import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;
import java.io.*;
import java.util.Scanner;

import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 *  Test class for Collinear.java
 *
 *  @author  
 *  @version 18/09/18 12:21:26
 */
@RunWith(JUnit4.class)
public class CollinearTest
{



	//~ Constructor ........................................................
	@Test
	public void testConstructor()
	{
		new Collinear();
	}

	//~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check that the two methods work for empty arrays
	 */
	@Test
	public void testEmpty()
	{
		int expectedResult = 0;

		assertEquals("countCollinear failed with 3 empty arrays",       expectedResult, Collinear.countCollinear(new int[0], new int[0], new int[0]));
		assertEquals("countCollinearFast failed with 3 empty arrays", expectedResult, Collinear.countCollinearFast(new int[0], new int[0], new int[0]));
	}

	// ----------------------------------------------------------
	/**
	 * Check for no false positives in a single-element array
	 */
	@Test
	public void testSingleFalse()
	{
		int[] a3 = { 15 };
		int[] a2 = { 5 };
		int[] a1 = { 10 };

		int expectedResult = 0;

		assertEquals("countCollinear({10}, {5}, {15})",       expectedResult, Collinear.countCollinear(a1, a2, a3) );
		assertEquals("countCollinearFast({10}, {5}, {15})", expectedResult, Collinear.countCollinearFast(a1, a2, a3) );
	}

	// ----------------------------------------------------------
	/**
	 * Check for no false positives in a single-element array
	 */
	@Test
	public void testSingleTrue()
	{
		int[] a3 = { 15, 5 };       int[] a2 = { 5 };       int[] a1 = { 10, 15, 5 };

		int expectedResult = 1;

		assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",     expectedResult, Collinear.countCollinear(a1, a2, a3));
		assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
	}

	@Test 

	// tests to see if the binary search gives a correct false

	public void testFalseBinary () {
		int [] array = {5, 10, 15, 20};

		int number = 11;

		boolean expectedResult = false; 

		assertEquals("binarySearch(" + Arrays.toString(array) + number + ")", expectedResult, Collinear.binarySearch(array, number));
	}

	// tests to see if the binary search gives a correct true
	@Test

	public void testTrueBinary () {
		int [] array = {5, 10, 15, 20};

		int number = 10;

		boolean expectedResult = true; 

		assertEquals("binarySearch(" + Arrays.toString(array) + number + ")", expectedResult, Collinear.binarySearch(array, number));
	}

	// tests to see if sort works

	@Test

	public void testSorting () {
		int [] array = { 1, 6, 3, 7, 9, 2};

		int [] expectedResult = {1, 2, 3, 6, 7, 9};
		Collinear.sort(array);
		assertArrayEquals(expectedResult, array);

	}

	// My attempt at reading in the files to test the performance
	/*public static void main(String[] args) {
			File file1 = new File("src\\r01000-1.txt");
			File file2 = new File("src\\r01000-2.txt");
			File file3 = new File("src\\r01000-3.txt");
			int [] a1 = new int[1000];
			int [] a2 = new int[1000];
			int [] a3 = new int[1000];

			try {
				a1 = readArray(file1);
				System.out.println("bruh");
				a2 = readArray(file2);
				a3 = readArray(file3);
			} catch (IOException e) {
				e.printStackTrace();
			}
			In in1 = new In(args[0]);
			int[] a = in1.readAllInts();
			Stopwatch stopwatch = new Stopwatch();
			System.out.println("bruh");
			Collinear.countCollinear(a1, a2, a3);
			double time = stopwatch.elapsedTime();
			StdOut.println("elapsed time " + time);

		}

		static int [] readArray (File file) throws IOException {
			Reader fileReader = new FileReader(file);
			BufferedReader bufferedFileReader = new BufferedReader(fileReader);
			System.out.println("bruh");
			int [] a1 = new int[1000];
			int current;
			int count = 0;
			String s = bufferedFileReader.readLine();
			while (s!=null) {
				System.out.println("bruh");
				a1[count] = Integer.parseInt(s); 
				System.out.println("bruh");
				System.out.println(a1[count]);
				s = bufferedFileReader.readLine();
				count++;
			}

			return a1;
		}*/
}