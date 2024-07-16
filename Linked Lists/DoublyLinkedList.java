import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  Róisín Ní Bhriain
 *  @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

	/**
	 * private class DLLNode: implements a *generic* Doubly Linked List node.
	 */
	private class DLLNode
	{
		public final T data; // this field should never be updated. It gets its
		// value once from the constructor DLLNode.
		public DLLNode next;
		public DLLNode prev;

		/**
		 * Constructor
		 * @param theData : data of type T, to be stored in the node
		 * @param prevNode : the previous Node in the Doubly Linked List
		 * @param nextNode : the next Node in the Doubly Linked List
		 * @return DLLNode
		 */
		public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
		{
			data = theData;
			prev = prevNode;
			next = nextNode;
		}
	}

	// Fields head and tail point to the first and last nodes of the list.
	private DLLNode head, tail;
	private int size = 0;

	/**
	 * Constructor of an empty DLL
	 * @return DoublyLinkedList
	 */
	public DoublyLinkedList() 
	{
		head = null;
		tail = null;
	}

	/**
	 * Tests if the doubly linked list is empty
	 * @return true if list is empty, and false otherwise
	 *
	 * Worst-case asymptotic running time cost: O(1)
	 *
	 * Justification:
	 *  This returns true if the head is empty because if the head is empty then the tail is empty.
	 */
	public boolean isEmpty()
	{
		return head == null;
	}

	/**
	 * Inserts an element in the doubly linked list
	 * @param pos : The integer location at which the new data should be
	 *      inserted in the list. We assume that the first position in the list
	 *      is 0 (zero). If pos is less than 0 then add to the head of the list.
	 *      If pos is greater or equal to the size of the list then add the
	 *      element at the end of the list.
	 * @param data : The new data of class T that needs to be added to the list
	 * @return none
	 *
	 * Worst-case asymptotic running time cost: O(N)
	 *
	 * Justification:
	 * Worst case is the for loop must be used to find the correct position to insert the item. 
	 */
	public void insertBefore( int pos, T data ) 
	{
		if (isEmpty()) {
			head = new DLLNode(data, null, null);
			tail = head;
			size++;
		} else if (pos <= 0) {
			DLLNode newNode = new DLLNode(data, null, head);
			head.prev = newNode;
			head = newNode;
			if (size == 1) {
				tail.prev = head;
			}
			size++;
		} else if (pos >= size) {
			DLLNode newNode = new DLLNode(data, tail, null);
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
			size++;
		} else {
			DLLNode temp = new DLLNode(data, null, null);
			DLLNode currentNode = head;
			for (int count = 0; count < pos; count++) {
				currentNode = currentNode.next;
			}
			temp.next = currentNode;
			temp.prev = currentNode.prev;
			currentNode.prev.next = temp;
			currentNode.prev = temp;
			size++;
		}
	}

	/**
	 * Returns the data stored at a particular position
	 * @param pos : the position
	 * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
	 *
	 * Worst-case asymptotic running time cost: O(N)
	 *
	 * Justification:
	 *  This uses one loop in the worst cases scenario that the list must be scanned.
	 *
	 */
	public T get(int pos) 
	{
		if (pos < 0 || pos >= size) {
			System.out.println("this is not a valid position");
			return null;
		} else {
			DLLNode currentNode = head;

			for (int count = 0; count < pos; count++) {
				currentNode = currentNode.next;
			}
			return currentNode.data;
		}
	}

	/**
	 * Deletes the element of the list at position pos.
	 * First element in the list has position 0. If pos points outside the
	 * elements of the list then no modification happens to the list.
	 * @param pos : the position to delete in the list.
	 * @return true : on successful deletion, false : list has not been modified. 
	 *
	 * Worst-case asymptotic running time cost: O(N)
	 *
	 * Justification:
	 *  Worst case is that the list must find the last element to delete and use the forr loop to do so.
	 */
	public boolean deleteAt(int pos) 
	{
		if (isEmpty() || pos < 0 || pos >= size) {
			System.out.println("No items were deleted.");
			return false;
		} else {
			if (size == 1) {
				head = null;
				tail = null;
			} else if (pos == size-1) {
				if (size == 2) {
					head.next = null;
					head.prev = null;
					tail = head;
				} else {
					DLLNode tempPrev = tail.prev;
					tempPrev.next = null;
					tail = tempPrev;
				}
			} else {
				DLLNode currentNode = head;
				for (int count = 0; count < pos; count++) {
					currentNode = currentNode.next;
				}
				if (currentNode.prev == null) {
					head = currentNode.next;
					head.prev = null;
				} else {
					DLLNode tempNext = currentNode.next;
					DLLNode tempPrev = currentNode.prev;
					tempNext.prev = tempPrev;
					tempPrev.next = tempNext;
					currentNode = null;
				}
			}
			size--;
			return true;
		}
	}

	/**
	 * Reverses the list.
	 * If the list contains "A", "B", "C", "D" before the method is called
	 * Then it should contain "D", "C", "B", "A" after it returns.
	 *
	 * Worst-case asymptotic running time cost: O(N)
	 *
	 * Justification:
	 *  The worst case is the list reverses every node in the list using the while loop.
	 */
	public void reverse()
	{
		if (!isEmpty()) {
			DLLNode current = head;
			DLLNode temp = null;
			while (current != null) {
				temp = current.prev;
				current.prev = current.next;
				current.next = temp;
				current = current.prev;
			}
			temp = tail;
			tail = head;
			head = temp;
		}

		System.out.println("after reverse: " + toString());
	}

	/**
	 * Removes all duplicate elements from the list.
	 * The method should remove the _least_number_ of elements to make all elements uniqueue.
	 * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
	 * Then it should contain "A", "B", "C", "D" after it returns.
	 * The relative order of elements in the resulting list should be the same as the starting list.
	 *
	 * Worst-case asymptotic running time cost: O(N^2)
	 *
	 * Justification:
	 *  Worst case to delete everything other than the first element. To delete is N and to scan the list is N so N*N.
	 * 	Or there is nothing to delete and the list is scanned to end looking for duplicates with no delete which is still N*N.
	 */
	public void makeUnique()
	{
		DLLNode node1 = head;
		DLLNode node2 = null;
		int count1 = 0;
		while (node1 != null) {
			node2 = node1.next;
			int count2 = count1+1;
			while (node2 != null) {
				if (node1.data == node2.data) {
					deleteAt(count2);
					count2--;
				}
				count2++;
				node2 = node2.next;
			}
			count1++;
			node1 = node1.next;
		}
	}


	/*----------------------- STACK API 
	 * If only the push and pop methods are called the data structure should behave like a stack.
	 */

	/**
	 * This method adds an element to the data structure.
	 * How exactly this will be represented in the Doubly Linked List is up to the programmer.
	 * @param item : the item to push on the stack
	 *
	 * Worst-case asymptotic running time cost: O(N)
	 *
	 * Justification: Worst case you have to go to the end of the list.
	 *  
	 */
	public void push(T item) 
	{
		insertBefore(0, item);
	}

	/**
	 * This method returns and removes the element that was most recently added by the push method.
	 * @return the last item inserted with a push; or null when the list is empty.
	 *
	 * Worst-case asymptotic running time cost: O(2N)
	 *
	 * Justification:
	 *  If you have to go to the end of the list for the get function and the delete function.
	 */
	public T pop() 
	{
		if (!isEmpty()) {
			T data = get(0);
			deleteAt(0);
			return data;
		}
		return null;
	}

	/*----------------------- QUEUE API
	 * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
	 */

	/**
	 * This method adds an element to the data structure.
	 * How exactly this will be represented in the Doubly Linked List is up to the programmer.
	 * @param item : the item to be enqueued to the stack
	 *
	 * Worst-case asymptotic running time cost: O(N)
	 *
	 * Justification: the insert function would have to go to the end of the list.
	 * 
	 */
	public void enqueue(T item) 
	{
		insertBefore(size, item);
	}

	/**
	 * This method returns and removes the element that was least recently added by the enqueue method.
	 * @return the earliest item inserted with an enqueue; or null when the list is empty.
	 *
	 * Worst-case asymptotic running time cost: O(2N)
	 *
	 * Justification: Worst case it will run to the end of the linked list
	 *  
	 */
	public T dequeue() 
	{
		if (isEmpty()) {
			return null;
		}
		T data = get(0);
		deleteAt(0);
		return data;
	}


	/**
	 * @return a string with the elements of the list as a comma-separated
	 * list, from beginning to end
	 *
	 * Worst-case asymptotic running time cost:   Theta(n)
	 *
	 * Justification:
	 *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
	 *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
	 *  Thus, every one iteration of the for-loop will have cost Theta(1).
	 *  Suppose the doubly-linked list has 'n' elements.
	 *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
	 */
	public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }


}