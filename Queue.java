
public class Queue<Type> 
{	
	private LinkedList<Type> q;
	private int size;
	
	public Queue()
	{
		q = new LinkedList<Type>();
		size = 0;
	}
	
	public void enqueue(Type t)
	{
		q.addLast(t);
		size++;
	}
	
	public Type dequeue()
	{
		if(size == 0)
			return null;
		else
		{
			size--;
			return q.remFirst();
		}
	}
	
	public Type peek()
	{
		return q.getFirst();
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
