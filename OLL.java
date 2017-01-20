import java.util.*;

public class OLL <T extends Comparable<T>>
{
	private Node1<T> first;
	private int size;
	Set<T> values;

	public OLL()
	{
		first = null;
		size = 0;
		values = new HashSet<T>();
	}

	public OLL(T obj)
	{
		first = new Node1<T>(obj);
		size = 1;
		values = new HashSet<T>();
		values.add(obj);
	}

	public int add(T obj)
	{
		size++;

		values.add(obj);
		if(size == 0)
		{
			first = new Node1<T>(obj);
			return 0;
		}
		else if(size == 1)
		{
			Node1<T> curr = new Node1<T>(obj);
			if(obj.compareTo(first.getValue()) > 0)
			{
				first.setNext(curr);
				return 1;
			}
			else
			{
				curr.setNext(first);
				first = curr;
				return 0;
			}
		}
		else
		{
			Node1<T> curr = first;
			Node1<T> place = new Node1<T>(obj);

			if(obj.compareTo(first.getValue()) < 0)
			{
				place.setNext(first);
				first = place;
				return 0;
			}
			else
			{
				int count = 0;
				while(curr.getNext() != null)
				{
					//System.out.println("obj: " + obj + " curr: " + curr.getValue() + " next: " + curr.getNext().getValue());
					if(obj.compareTo(curr.getNext().getValue()) > 0)
					{
						count++;
						curr = curr.getNext();
					}
					else
					{
						place.setNext(curr.getNext());
						curr.setNext(place);
						break;
					}
				}

				curr.setNext(place);
				return count;
			}
		}
	}
	
	public boolean isIn(T obj)
	{
		boolean ret;
		ret = values.add(obj);
		values.remove(obj);
		return !ret;
	}

	public String toString()
	{
		String str = first.getValue().toString() + " ";
		Node1<T> curr = first;

		while(curr.getNext() != null)
		{
			curr = curr.getNext();
			str += curr.getValue().toString() + " ";
		}

		return str;
	}

}
