
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
		if (f.getClass() != this.getClass())
			throw new ClassCastException(f.toString() + ", " + this.toString());//Classes isn't equal;

		if (((FIFO) f).size() != this.size())
			return false;//size isn't equal;
		boolean returnvalue = true;
		for (int i = 0; i < this.size(); i++) {
			if ((this.first() == null && ((FIFO) f).first() != null)
					|| (this.first() != null && ((FIFO) f).first() == null)) {
				returnvalue = false;
			}
			if (this.first() != null) {
				if (!(this.first().equals(((FIFO) f).first()))) {
					returnvalue = false;
				}
			}
			try {
				Object t = this.first();
				this.removeFirst();
				this.add(t);
				t = ((FIFO) f).first();
				((FIFO) f).removeFirst();
				((FIFO) f).add(t);
			} catch (NoSuchElementException e) {
				returnvalue = false;
			}
		}
		return returnvalue;
	}

	public String toString() {
		String output = "Queue: ";
		for (Object elem : m_queue) {
			output += "(" + String.valueOf(elem) + ") ";
		}
		return output;
	}
}