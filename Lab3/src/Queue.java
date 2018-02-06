

public interface Queue {
	public void add(Object item);
	public void removeFirst();
	public Object first();
	public int maxSize();
	public boolean isEmpty();
	public int size();
	public String toString();
	public boolean equals(Object f);
}
