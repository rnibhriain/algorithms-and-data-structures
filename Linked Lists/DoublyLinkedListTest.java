import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  Róisín Ní Bhriain
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
	//~ Constructor ........................................................
	@Test
	public void testConstructor()
	{
		new DoublyLinkedList<Integer>();
	}

	//~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check if the insertBefore works
	 */
	
	// Checks if isEmpty works

	@Test

	public void testIsEmpty()
	{
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		boolean expectedResult = true;
		assertEquals("Checking if the isEmpty test returns true when it is empty", expectedResult, testDLL.isEmpty());
		expectedResult = false;
		testDLL.insertBefore(0,1);
		assertEquals("Checking if the isEmpty test returns false when it is not empty", expectedResult, testDLL.isEmpty());
	}
	
	@Test
	public void testInsertBefore()
	{
		// test non-empty list
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,2);
		testDLL.insertBefore(2,3);

		testDLL.insertBefore(0,4);
		assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
		testDLL.insertBefore(1,5);
		assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
		testDLL.insertBefore(2,6);       
		assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
		testDLL.insertBefore(-1,7);        
		assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
		testDLL.insertBefore(7,8);        
		assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
		testDLL.insertBefore(700,9);        
		assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

		// test empty list
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);        
		assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(10,1);        
		assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(-10,1);        
		assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
	}



	// TODO: add more tests here. Each line of code in DoublyLinkedList.java should
	// be executed at least once from at least one test.





	// checks if get works

	@Test

	public void testGet()
	{
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,2);
		testDLL.insertBefore(2,3);
		Object expectedResult = 3;
		assertEquals("Checking if the get returns the 3 when checking position 2", expectedResult, testDLL.get(2));
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,78);
		testDLL.insertBefore(2,67);
		testDLL.insertBefore(3,89);
		testDLL.insertBefore(4,402);
		testDLL.insertBefore(5,20);
		expectedResult = 67;
		assertEquals("Checking if the get returns the 67 when checking position 2", expectedResult, testDLL.get(2));
		testDLL = new DoublyLinkedList<Integer>();
		expectedResult = null;
		assertEquals("Checking if the get returns null when checking position a position that does not exist", expectedResult, testDLL.get(2));
		assertEquals("Checking if the get returns null when checking position a position that does not exist", expectedResult, testDLL.get(-1));
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,78);
		testDLL.insertBefore(2,67);
		testDLL.insertBefore(3,89);
		testDLL.insertBefore(4,402);
		testDLL.insertBefore(5,20);
		expectedResult = 20;
		assertEquals("Checking if the get returns the 20 when checking position 5", expectedResult, testDLL.get(5));
	}

	// checks if the deleteAt works
	@Test 

	public void testDeleteAt()
	{
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,2);
		testDLL.insertBefore(2,3);
		testDLL.insertBefore(3, 4);
		boolean expectedResult = true;
		assertEquals("Checking if the delete returns true when deleting position 0", expectedResult, testDLL.deleteAt(0));
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,2);
		testDLL.insertBefore(2,3);
		testDLL.insertBefore(3, 4);
		testDLL.deleteAt(3);
		assertEquals( "Checking if the delete returns the list correctly", "1,2,3", testDLL.toString() );
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,2);
		testDLL.insertBefore(2,3);
		expectedResult = false;
		assertEquals("Checking if the delete returns false when deleting a position below 0", expectedResult, testDLL.deleteAt(-1));
		assertEquals("Checking if the delete returns false when deleting a position over the getSize", expectedResult, testDLL.deleteAt(4));
		testDLL = new DoublyLinkedList<Integer>();
		assertEquals("Checking if the delete returns false when the list is empty", expectedResult, testDLL.deleteAt(0));
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,2);
		testDLL.insertBefore(2,3);
		testDLL.insertBefore(3,4);
		testDLL.insertBefore(4,5);
		testDLL.insertBefore(5,6);
		testDLL.deleteAt(5);
		assertEquals( "Checking if the delete returns the list correctly", "1,2,3,4,5", testDLL.toString() );
		testDLL.deleteAt(3);
		assertEquals( "Checking if the delete returns the list correctly", "1,2,3,5", testDLL.toString());
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		expectedResult = true;
		assertEquals("Checking if the delete returns true when there is one value", expectedResult, testDLL.deleteAt(0));
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.deleteAt(0);
		assertEquals("Checking if the delete returns the correct list when there is one value", "", testDLL.toString());
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,2);
		testDLL.deleteAt(0);
		assertEquals("Checking if the delete returns the correct list when there is one value", "2", testDLL.toString());
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(0,2);
	}

	
	// check the reverse
	@Test 

	public void testReverse()
	{
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,2);
		testDLL.insertBefore(2,3);
		testDLL.insertBefore(3,4);
		testDLL.insertBefore(4,5);
		testDLL.insertBefore(5,6);
		testDLL.reverse();
		assertEquals( "Checking if the reverse returns the reversed array correctly", "6,5,4,3,2,1", testDLL.toString() );
		// lecturer code
		String msg = "";
        testDLL = new DoublyLinkedList<Integer>();
        String exp, initial, res;
        msg = "Testing reverse on an empty list - list should remain empty";
        exp = "";
        testDLL.reverse();
        res = testDLL.toString();
        assertEquals(msg, (String) exp, (String) res);
        msg = "Testing reverse on a 1-element list - list should remain the same";
        testDLL.insertBefore(0, 900);
        exp = testDLL.toString();
        testDLL.reverse();
        res = testDLL.toString();
        assertEquals(msg, (String) exp, (String) res);
        exp = "900,800";
        msg = "Testing reverse on a 2-element list";
        testDLL.insertBefore(0, 800);
        msg = msg + "[" + testDLL.toString() + "]";
        initial = testDLL.toString();
        testDLL.reverse();
        res = testDLL.toString();
        assertEquals(msg + " - list should become [" + exp + "]  but got [" + res + "]", exp, (String) res);
		
		// my code
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,2);
		testDLL.insertBefore(2,3);
		testDLL.insertBefore(3,4);
		testDLL.insertBefore(4,5);
		testDLL.insertBefore(5,6);
		testDLL.reverse();
		assertEquals( "Checking if the reverse returns the reversed array correctly", "6,5,4,3,2,1", testDLL.toString() );
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		assertEquals( "Checking if the reverse returns the reversed array correctly", "1", testDLL.toString() );
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.reverse();
		assertEquals( "Checking if the reverse returns the reversed array correctly", "", testDLL.toString() );
		testDLL.insertBefore(0,800);
		testDLL.insertBefore(1,900);
		testDLL.reverse();
		assertEquals( "Checking if the reverse returns the reversed array correctly", "900,800", testDLL.toString() );
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,28);
		testDLL.insertBefore(0,7);
		testDLL.insertBefore(0,4);
		testDLL.reverse();
		assertEquals( "Checking if the reverse returns the reversed array correctly", "28,7,4", testDLL.toString() );
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,2);
		testDLL.insertBefore(2,3);
		testDLL.reverse();
		assertEquals( "Checking if the reverse returns the reversed array correctly", "3,2,1", testDLL.toString() );
	}

	
	// check the makeUnique
	@Test
	
	public void testMakeUnique () {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0, 1);
		testDLL.insertBefore(0, 2);
		testDLL.insertBefore(0, 1);
		testDLL.insertBefore(0, 1);
		testDLL.insertBefore(0,2);
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(0,2);
		testDLL.makeUnique();
		assertEquals( "Checking if it returns the list correctly", "2,1", testDLL.toString() );
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.makeUnique();
		assertEquals( "Checking if it returns the list correctly", "", testDLL.toString() );
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,2);
		testDLL.insertBefore(2,3);
		testDLL.insertBefore(3,1);
		testDLL.insertBefore(4,2);
		testDLL.makeUnique();
		assertEquals( "Checking if it returns the list correctly", "1,2,3", testDLL.toString() );
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,1);
		testDLL.insertBefore(2,1);
		testDLL.insertBefore(3,1);
		testDLL.insertBefore(4,1);
		testDLL.makeUnique();
		assertEquals( "Checking if it returns the list correctly", "1", testDLL.toString() );
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,8);
		testDLL.insertBefore(1,9);
		testDLL.insertBefore(3,1);
		testDLL.insertBefore(4,3);
		testDLL.insertBefore(5,4);
		testDLL.insertBefore(6,9);
		testDLL.insertBefore(7,3);
		testDLL.insertBefore(8,8);
		testDLL.insertBefore(9,1);
		testDLL.makeUnique();
		assertEquals( "Checking if it returns the list correctly", "8,9,1,3,4", testDLL.toString() );
		
	}
	
	
	//Check the Push 
	@Test
	
	public void testPush() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,2);
		testDLL.insertBefore(2,3);
		testDLL.insertBefore(3,4);
		testDLL.insertBefore(4,5);
		testDLL.insertBefore(5,6);
		testDLL.push(7);
		assertEquals( "Checking if the push returns the pushed item correctly", "7,1,2,3,4,5,6", testDLL.toString() );
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.push(7);
		assertEquals( "Checking if the push returns the pushed item correctly", "7", testDLL.toString() );
		
	}
	
	//Check the Pop
	@Test
	
	public void testPop() {
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,2);
		testDLL.insertBefore(2,3);
		testDLL.insertBefore(3,4);
		testDLL.insertBefore(4,5);
		testDLL.insertBefore(5,6);
		Integer expectedResult = 1;
		assertEquals("Checking if the pop returns the correct result", expectedResult, testDLL.pop());
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,2);
		testDLL.insertBefore(2,3);
		testDLL.insertBefore(3,4);
		testDLL.insertBefore(4,5);
		testDLL.insertBefore(5,6);
		testDLL.pop();
		assertEquals( "Checking if the pop returns the popped list correctly", "2,3,4,5,6", testDLL.toString() );
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.pop();
		assertEquals( "Checking if the pop returns the popped list correctly", "", testDLL.toString() );
		testDLL = new DoublyLinkedList<Integer>();
		expectedResult = null;
		assertEquals( "Checking if the pop returns the popped list correctly", expectedResult, testDLL.pop() );
	}
	
	//Check the enqueue
		@Test
		
		public void testEnqueue() {
			DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
			testDLL.insertBefore(0,1);
			testDLL.insertBefore(1,2);
			testDLL.insertBefore(2,3);
			testDLL.insertBefore(3,4);
			testDLL.insertBefore(4,5);
			testDLL.insertBefore(5,6);
			testDLL.enqueue(7);
			assertEquals( "Checking if the enqueue returns the list correctly", "1,2,3,4,5,6,7", testDLL.toString() );
			testDLL = new DoublyLinkedList<Integer>();
			testDLL.enqueue(7);
			assertEquals( "Checking if the enqueue returns the list correctly", "7", testDLL.toString() );
		}

		//Check the enqueue
		@Test

		public void testDequeue() {
			DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
			testDLL.enqueue(1);
			testDLL.enqueue(2);
			testDLL.enqueue(3);
			testDLL.enqueue(4);
			testDLL.enqueue(5);
			testDLL.enqueue(6);
			Integer expectedResult = 1;
			assertEquals("Checking if the dequeue returns the correct result", expectedResult, testDLL.dequeue());
			testDLL = new DoublyLinkedList<Integer>();
			testDLL.enqueue(1);
			testDLL.enqueue(2);
			testDLL.enqueue(3);
			testDLL.enqueue(4);
			testDLL.enqueue(5);
			testDLL.enqueue(6);
			testDLL.dequeue();
			assertEquals( "Checking if the dequeue returns the list correctly", "2,3,4,5,6", testDLL.toString() );
			testDLL = new DoublyLinkedList<Integer>();
	        Integer result = testDLL.dequeue();
	        testDLL.enqueue(100);
	        result = testDLL.dequeue();
	        result = testDLL.dequeue();
	        testDLL.enqueue(100);
	        testDLL.enqueue(200);
	        testDLL.enqueue(300);
	        result = testDLL.dequeue();
	        result = testDLL.dequeue();
	        assertEquals("should return: 200 - received: " + result, (long)200, (long)result);
		}

}
