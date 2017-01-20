
public class Node<Type> 
{
	private Type value;
	private Node<Type> next;
	
	public Node(Type val)
	{
		value = val;
		next = null;
	}
	
	public Type getValue()
	{
		return value;
	}
	
	public Node<Type> getNext()
	{
		return next;
	}
	
	public void setNext(Node<Type> n)
	{
		next = n;
	}
	
	public String toString()
	{
		return value.toString();
	}

}
