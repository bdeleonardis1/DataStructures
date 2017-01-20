
public class Stack<Type> 
{	
	private LinkedList<Type> stack;
	private int size;
	
	public Stack()
	{
		stack = new LinkedList<Type>();
		size = 0;
	}
	
	public void push(Type t)
	{
		stack.addLast(t);
		size++;
	}
	
	public Type pop()
	{
		if(size == 0)
			return null;
		else
		{
			size--;
			return stack.remLast();
		}
	}
	
	public Type peek()
	{
		if(size == 0)
			return null;
		else
		{
			Type temp = stack.remLast();
			stack.addLast(temp);
			return temp;
		}
	}
	
	public int getSize()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return (size == 0);
	}
}
