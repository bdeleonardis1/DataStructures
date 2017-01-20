public class LinkedList<Type>
{
	public Node<Type> first;
	private int size;

	public LinkedList()
	{
		size = 0;
		first = null;
	}

	public LinkedList(Type f)
	{
		Node<Type> temp = new Node<Type>(f);
		first = temp;
		size = 1;
	}

	//------------------------------
	//Adds element to front of list
	//------------------------------
	public void addFirst(Type f)
	{
		Node<Type> temp = new Node<Type>(f);
		if(size == 0)
			first = temp;
		else
		{
			temp.setNext(first);
			first = temp;
		}
		size++;
	}
	//------------------------------------
	//removes the last element of the list
	//------------------------------------
	public void addLast(Type last)
	{

		Node<Type> temp = new Node<Type>(last);
		if(size == 0)
			first = temp;
		else
		{
			temp.setNext(null);

			Node<Type> curr = first;

			while(curr.getNext() != null)
				curr = curr.getNext();

			curr.setNext(temp);
		}
		size++;
	}
	
	public Node<Type> getFirstNode()
	{
		return first;
	}
	
	public void reverseList()
	{
		Node<Type> previousNode = null;
		Node<Type> currNode = first;
		while(currNode != null)
		{
			Node<Type> nextNode = currNode.getNext();
			currNode.setNext(previousNode);
			previousNode = currNode;
			currNode = nextNode;
		} 
		first = previousNode;
	}
	
	public Node<Type> newReverse(Node<Type> curr)
	{
		if(curr == null || curr.getNext() == null)
			return curr;
		else
		{
			Node<Type> reversed = newReverse(curr.getNext());
			curr.getNext().setNext(curr);
			curr.setNext(null);
			first = reversed;
			return reversed;
		} 
			
	}

	//---------------------
	//removes first element
	//---------------------
	public Type remFirst()
	{
		if(size == 0)
			return null;
		else if(size == 1)
		{
			Type temp = first.getValue();
			first = null;
			size--;
			return temp;
		}
		else
		{	
			Type temp = first.getValue();
			first = first.getNext();
			size--;
			return temp;
		}
	}

	//--------------------
	//removes last element
	//--------------------
	public Type remLast()
	{
		if(size == 0)
			return null;
		else if(size == 1)
		{
			Type temp = first.getValue();
			first = null;
			size--;
			return temp;
		}
		else
		{	
			Type temp;
			Node<Type> curr = first;

			while(curr.getNext().getNext() != null)
				curr = curr.getNext();

			temp = curr.getNext().getValue();
			curr.setNext(null);

			size--;
			return temp;
		}
	}

	public int getSize()
	{
		return size;
	}

	public Type getFirst()
	{
		if(first != null)
			return first.getValue();
		return null;
	}

	public String toString()
	{
		String str = "";
		if(size == 0)
		{
			str = "The list is empty";
		}
		else
		{
			Node<Type> tem = first;
			str = tem.toString() + " ";

			while(tem.getNext() != null)
			{
				str += tem.getNext().toString() + " ";
				tem = tem.getNext();
			}
		}
		return str;
	}
}
