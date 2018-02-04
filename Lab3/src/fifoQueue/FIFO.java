package fifoQueue;

import java.util.NoSuchElementException;
import java.util.Vector;
import java.lang.Exception;

public class FIFO implements Queue {
	private Vector<Object> m_queue;
	private int m_maxSize;
	
	FIFO() {
		m_queue = new Vector<Object>();
		m_maxSize = 0;
	}

	public void add(Object item) {
		m_queue.add(item);
		if (m_queue.size() > m_maxSize)
			m_maxSize = m_queue.size();
	}

	public void removeFirst() throws NoSuchElementException {
		if (m_queue.isEmpty())
			throw new NoSuchElementException();
		m_queue.remove(0);

	}

	public Object first() {
		return m_queue.firstElement();
	}

	public int maxSize() {
		return m_maxSize;
	}

	public boolean isEmpty() {
		return m_queue.isEmpty() ? true : false;
	}

	public int size() {
		return m_queue.size();
	}

	public boolean equals(Object f) {
		if (f instanceof FIFO)
			throw new ClassCastException();

		Object t = ((FIFO) f).clone();
		FIFO temp = (FIFO) t;
		if (temp.size() != this.size())
			return false;
		for (int i = 0; i < this.size(); i++) {
			if (temp.first() != null && this.m_queue.get(i) == null)
				return false;
			if (temp.first() == null && this.m_queue.get(i) != null)
				return false;
			if (!(this.m_queue.get(i).equals(temp.first())))
				return false;
			try {
				temp.removeFirst();
			} catch (NoSuchElementException e) {
				return false;
			}
		}
		return true;

	}

	public String toString() {
		String output = "Queue: ";
		for (Object elem : m_queue) {
			output += "(" + String.valueOf(elem) + ") ";
		}
		return output;
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World");
	}

}
