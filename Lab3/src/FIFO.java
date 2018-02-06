
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
			throw new ClassCastException(f.toString() + ", " + this.toString());

		if (((FIFO) f).size() != this.size())
			return false;
		for (int i = 0; i < this.size(); i++) {
			if ((this.first() == null && ((FIFO) f).first() != null)
					|| (this.first() != null && ((FIFO) f).first() == null)) {
				return false;
			}
			if (this.first() != null) {
				if (!(this.first().equals(((FIFO) f).first()))) {
					return false;
				}
			}
			try {
				this.add(this.first());
				this.removeFirst();
				((FIFO) f).add(((FIFO) f).first());
				((FIFO) f).removeFirst();
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

	public static void main(String[] args) {
		FIFO f1 = new FIFO(), f2 = new FIFO();
		f1.add(new Integer(1));
		f1.add(new Integer(2));
		f1.add(new Integer(3));
		f1.add(new Integer(4));
		f1.add(null);
		System.out.println(f1.toString());
		f2.add(new Integer(1));
		f2.add(new Integer(2));
		f2.add(new Integer(3));
		f2.add(new Integer(4));
		f2.add(null);
		System.out.println(f2.toString());
		System.out.println(f1.equals(f2));
		f1.removeFirst();
		f2.removeFirst();
		System.out.println(f1.toString());
		System.out.println(f2.toString());
		System.out.println(f1.equals(f2));
		f1.add(f2.first());
		System.out.println(f1.toString());
		System.out.println(f2.toString());
		System.out.println(f1.equals(f2));
		
	}
}