import java.util.*;

public class MyMap<T1, T2> 
{
	LinkedList<MapElement<T1,T2>> vals;
	int size;
	
	public MyMap()
	{
		vals = new LinkedList<MapElement<T1,T2>>();
		size = 0;
	}
	
	public boolean put(T1 key, T2 value)
	{
		MapElement<T1,T2> el = new MapElement<T1,T2>(key, value);
		if(!contain(el.getKey()))
		{
			vals.add(el);
			size++;
			return true;
		}
		else
			return false;
	}
	
	public boolean contain(T1 key)
	{
		for(int i = 0; i < size; i++)
		{
			MapElement<T1, T2> temp = vals.get(i);
			if(key.equals(temp.getKey()))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public T2 get(T1 key)
	{
		for(int i = 0; i < size; i++)
		{
			MapElement<T1, T2> temp = vals.get(i);
			if(key.equals(temp.getKey()))
			{
				return temp.getVal();
			}
		}
		
		return null;
	}
}
