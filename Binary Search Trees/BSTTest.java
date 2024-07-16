import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  Róisín Ní Bhriain
 */

@RunWith(JUnit4.class)
public class BSTTest
{

  
  /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
      
 @Test
 public void testPrettyPrint() {
     BST<Integer, Integer> bst = new BST<Integer, Integer>();
     assertEquals("Checking pretty printing of empty tree",
             "-null\n", bst.prettyPrintKeys());
      
                          //  -7
                          //   |-3
                          //   | |-1
                          //   | | |-null
     bst.put(7, 7);       //   | |  -2
     bst.put(8, 8);       //   | |   |-null
     bst.put(3, 3);       //   | |    -null
     bst.put(1, 1);       //   |  -6
     bst.put(2, 2);       //   |   |-4
     bst.put(6, 6);       //   |   | |-null
     bst.put(4, 4);       //   |   |  -5
     bst.put(5, 5);       //   |   |   |-null
                          //   |   |    -null
                          //   |    -null
                          //    -8
                          //     |-null
                          //      -null
     
     String result = 
      "-7\n" +
      " |-3\n" + 
      " | |-1\n" +
      " | | |-null\n" + 
      " | |  -2\n" +
      " | |   |-null\n" +
      " | |    -null\n" +
      " |  -6\n" +
      " |   |-4\n" +
      " |   | |-null\n" +
      " |   |  -5\n" +
      " |   |   |-null\n" +
      " |   |    -null\n" +
      " |    -null\n" +
      "  -8\n" +
      "   |-null\n" +
      "    -null\n";
     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
     }

  
     /** <p>Test {@link BST#delete(Comparable)}.</p> */
     @Test
     public void testDelete() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         bst.delete(1);
         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
         
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
         
         bst.delete(9);
         assertEquals("Deleting non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
 
         bst.delete(8);
         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
 
         bst.delete(6);
         assertEquals("Deleting node with single child",
                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
 
         bst.delete(3);
         assertEquals("Deleting node with two children",
                 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
     }
     
     // test the height function
     @Test
     public void testHeight() {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_     _8
         bst.put(9, 9);	  //              \
         				  //              _9_
         assertEquals("checking the height on a tree of height 2", 2, bst.height());
         bst = new BST<Integer, Integer>();
         assertEquals("checking the height on a tree of nothing", -1, bst.height());
         bst.put(7, 7);   //        _7_
         assertEquals("checking the height on a tree of just a root", 0, bst.height());
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //     3_	     _8_
         bst.put(2, 2);	  //    /
                          //   2_
         bst.put(1, 1);	  //  /
         			      //_1_
         assertEquals("checking the height on a tree of 3 to the left", 3, bst.height());
    	 
     }
     
     
     // tests the Median function
     @Test
     public void testMedian() {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 assertEquals("checking the median of a tree of nothing", null, bst.median());
    	 
    	 bst.put(7, 7);   //        _7_
    	 assertEquals("checking the median of a tree of just 7", 7, (int)bst.median());
    	 bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);
         assertEquals("checking the median of a tree", 4, (int)bst.median());
     }
     
     // test the selects
     @Test
     
     public void testSelect () {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         assertEquals("Select an invalid key", null, bst.select(9));
         assertEquals("Select an invalid key", null, bst.select(-1));
         assertEquals("Select an invalid key", null, bst.select(null, 1));
     }
     
     // Test the Contains
     @Test
     
     public void testContains () {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 bst.put(7, 7);   //        _7_
    	 assertEquals("Select an invalid key", false, bst.contains(1));
    	 assertEquals("Select an valid key", true, bst.contains(7));
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         assertEquals("Select an valid key", true, bst.contains(8));
     }
     
     // Test the Print
     
     @Test
     public void testPrint () {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 bst.put(7, 7);   //        _7_
    	 assertEquals("Print the values", "(()7())", bst.printKeysInOrder());
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         assertEquals("Print the values", "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
     }
     
     // Test the Put
     
     @Test
     public void testPut () {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 bst.put(7, 7);   //        _7_
    	 bst.put(7, null); 
    	 assertEquals("Deleting a value using put", "()", bst.printKeysInOrder());
    	 bst.put(7, 7);   //        _7_
    	 bst.put(7, 7);   //      /     \
    	 assertEquals("putting an element in the same location", "(()7())", bst.printKeysInOrder());
     }
     
}