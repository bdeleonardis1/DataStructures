public class Node2 <T>
{
	public Node2<T> left;
	public Node2<T> right;
	public T value;
	
	public Node2(T val, Node2<T> l, Node2<T> r)
	{
		value = val;
		left = l;
		right = r;
	}
	
	public Node2(T val)
	{
		value = val;
		left = null;
		right = null;
	}
	
	public String toString()
	{
		return value + "";
	}
}
