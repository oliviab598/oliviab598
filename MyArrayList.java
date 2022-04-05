package lab2;
import java.util.AbstractList;

public class MyArrayList<E> extends AbstractList<E> {
	
	private int size;
//	number of items currently stored in the list (which may differ from the list's current capacity)
	private E[] data;
//	backing storage for MyArrayList
	private E tempElement;
	
	// set data to start size
	@SuppressWarnings("unchecked")
	MyArrayList (int startSize){
		this.data = (E[]) new Object[startSize]; //replace with actual starting size
	}
	
	// initial capacity set to 2
	MyArrayList() {
		this(2);
	}
	
	// double array size
	@SuppressWarnings("unchecked")
	private void resize() {
		// create new resized array
		E[] newArray = (E[]) new Object[2*data.length];
		// copy data over
		for (int i = 0; i<data.length; i++)
			newArray[i] = data[i];
		// set data to newly size array
		data = newArray;
	}
	
	// return size
	public int size() {
		return this.size;
	}
	
	// add element at specified index
	public void add(int index, E element) {
		//resize if not enough room to add
		if (size >= data.length - 1) {
			this.resize();
		}
		// shift to the right
		for (int i = size; i>=index+1; i--) {
			data[i] = data[i-1];
		}
		// add element at index
		data[index] = element;
		size++;

	}
	
	// add element to end
	public boolean add(E element) {
		this.add(size(), element);
		return true;
	}
	
	// return element at specified index
	public E get(int index) {
		return this.data[index];
	}
	
	// set element at specified index
	public E set(int index, E element) {
		if (index>=data.length){
			throw new IndexOutOfBoundsException();
		} else {
			tempElement = data[index];
			data[index] = element;
			return tempElement;
		}
		
		
	}
	
	// remove element at specified index
	public E remove(int index) {
		if (index>=data.length) {
			throw new IndexOutOfBoundsException();
		} else {
			tempElement = data[index];
			for (int i = size-1; i>=index+1; i--) {
				data[i-1] = data[i];
			}
			size--;
			return tempElement;
		}
	}

	// determine if empty
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// clear data
	public void clear() {
		for (int i = 0; i<=data.length-1; i++) {
			data[i] = null;
		}
	}
}
