import java.util.*;
public class BST<Type extends Comparable<Type>>
{
	Node2<Type> root;
	int size;
	
	/**
	 * Constructor that initializes an empty tree
	 */
	public BST()
	{
		root = null;
		size = 0;
	}
	
	/**
	 * Constructor that initializes a binary 
	 * search tree with the root being val
	 * @param val the first value to be added to the tree
	 */
	public BST(Type val)
	{
		Node2<Type> r = new Node2<Type>(val);
		root = r;
		size = 1;
	}
	
	/**
	 * Adds a value to the binary search tree
	 * @param val the value to be added to the tree
	 * @return true if the element is successfully added, false if otherwise
	 */
	public boolean put(Type val)
	{
		if(search(val))
			return false;
		
		Node2<Type> node = new Node2<Type>(val);
		if(root == null)
			root = node;
		else
			put(root, node);
		
		size++;
		
		return true;
	}
	
	//Helper for the public put method
	private void put(Node2<Type> curr, Node2<Type> node)
	{
		if(node.value.compareTo(curr.value) <= 0)
		{
			if(curr.left == null)
				curr.left = node;
			else
				put(curr.left, node);
		}
		else
		{
			if(curr.right == null)
				curr.right = node;
			else
				put(curr.right, node);
		}
	}
	
	/**
	 * Checks if the value is in the tree
	 * @param val value to be searched for
	 * @return true if value is in tree, false if otherwise
	 */
	public boolean search(Type val)
	{
		if(root != null)
			if(root.value == val)
				return true;
			else 
				return search(root, val);
		
		return false;
	}
	
	//Helper for search public search method
	private boolean search(Node2<Type> curr, Type val)
	{
		
		if(val.compareTo(curr.value) < 0)
			if(curr.left == null)
				return false;
			else if(curr.left.value.equals(val))
				return true;
			else 
				return search(curr.left, val);
		else
			if(curr.right == null)
				return false;
			else if(curr.right.value.equals(val))
				return true;
			else 
				return search(curr.right, val);
		
	}
	
	/**
	 * Deletes the value from the tree
	 * @param val value to be deleted
	 * @return true if successful, false if not
	 */
	public boolean delete(Type val)
	{
		if(root.value.equals(val))
			return delete(root, val, true);
		else
			return delete(root, val, false);
	}
	
	//Helper method for delete
	private boolean delete(Node2<Type> curr, Type val, boolean isRoot)
	{
		if(curr.left != null && curr.left.value.equals(val))
		{
			Node2<Type> del = curr.left;
			deleteWork(curr, del, false);
		}
		
		else if(curr.right != null && curr.right.value.equals(val))
		{
			Node2<Type> del = curr.right;
			deleteWork(curr, del, false);
		}
		
		else if(val.compareTo(curr.value) < 0 && curr.left != null)
			return delete(curr.left, val, isRoot);
		
		else if(val.compareTo(curr.value) > 0 && curr.right != null)
			return delete(curr.right, val, isRoot);

		else if(isRoot)
			deleteWork(null, root, true);
		
		else
			return false;
	
		size--;
		return true;
	}
	
	//Additional helper method for delete
	private void deleteWork(Node2<Type> parent, Node2<Type> del, boolean isRoot)
	{
		if(del.left == null && del.right == null) //no children
			if(parent.left == del)
				parent.left = null;
			else
				parent.right = null;
	
		else if(del.left == null) //right child
			parent.right = del.right;
			
		else if(del.right == null) //left child
			parent.left = del.left;
	
		else //two children
		{
			Node2<Type> rep = del.right;
			Node2<Type> repParent = new Node2<Type>(del.value);
			while(rep.left != null) //goes right one and all the way to the left to find replacement
			{
				repParent = rep;
				rep = rep.left;
			}
			
			rep.left = del.left;
			if(del.right != rep)
				rep.right = del.right;
			if(!isRoot)
				if(parent.left == del)
					parent.left = rep;
				else
					parent.right = rep;
			
			if(repParent != del)
				repParent.left = null;
			
			if(isRoot)
				root = rep;
		}
	}
	

	public void inorderTraversal(Node2<Type> curr)
	{
		if(curr.left != null)
			inorderTraversal(curr.left);
		System.out.println(curr.value);
		if(curr.right != null)
			inorderTraversal(curr.right);
	}
	
	public void preorderTraversal(Node2<Type> curr)
	{
		System.out.println(curr.value);
		if(curr.left != null)
			postOrderTraversal(curr.left);
		if(curr.right != null)
			postOrderTraversal(curr.right);
	}
	
	public void postOrderTraversal(Node2<Type> curr)
	{
		if(curr.left != null)
			postOrderTraversal(curr.left);
		if(curr.right != null)
			postOrderTraversal(curr.right);
		System.out.println(curr.value);
	}
	
	public void levelOrderTraversal()
	{
		Queue<Node2<Type>> q = new LinkedList<Node2<Type>>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node2<Type> curr = q.remove();
			System.out.println(curr.value);
			if(curr.left != null)
				q.add(curr.left);
			if(curr.right != null)
				q.add(curr.right);
		}
		
	}
	
	/**
	 * Prints tree using a borrowed class
	 */
	public void print()
	{
		BTreePrinter.printNode(root);
	}

}
