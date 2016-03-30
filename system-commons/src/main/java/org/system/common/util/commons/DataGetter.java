package org.system.common.util.commons;




import org.system.common.util.model.BinaryTree;
import org.system.common.util.model.Node;

import java.util.Random;

public class DataGetter
{
	private static Random random = new Random();

	// 随即整数数组
	public static int[] randomIntArray(int arrayLength, int intMax)
	{
		int[] result = new int[arrayLength];

		for (int i = 0; i < arrayLength; i++)
		{
			result[i] = random.nextInt(intMax);
		}

		return result;
	}

	public static int[] randomIntArray(int arrayLength, int intMax, boolean isUnsign)
	{
		int[] result = new int[arrayLength];

		for (int i = 0; i < arrayLength; i++)
		{
			if (isUnsign)
				result[i] = random.nextInt(intMax) * (random.nextInt(100000) % 2 == 1 ? 1 : -1);
			else
				result[i] = random.nextInt(intMax);
		}

		return result;
	}

	// 随机排序整数数组
	public static int[] randomSortedIntArray(int arrayLength, int intMax)
	{
		int[] arr = randomIntArray(arrayLength, intMax);
		DataSorter.sortIntArrayQuick(arr, 0, arrayLength - 1);
		return arr;
	}

	// 随机排序整数链表
	public static Node randomSortedIntLinkedList(int listLength, int intMax)
	{
		int[] arr = randomSortedIntArray(listLength, intMax);
		Node head = new Node(arr[0]);
		Node index = head;

		for (int i = 1; i < arr.length; i++)
		{
			index.next = new Node(arr[i]);
			index = index.next;
		}
		return head;
	}

	// 随机二维数组
	public static int[][] randomIntArrayXY(int x, int y, int intMax)
	{
		int[][] result = new int[x][y];

		for (int i = 0; i < x; i++)
		{
			for (int j = 0; j < y; j++)
			{
				result[i][j] = random.nextInt(intMax);
			}
		}
		return result;
	}

	// 随机二维下三角数组
	public static int[][] randomIntArrayDownXY(int x, int y, int intMax)
	{
		int[][] result = new int[x][y];

		for (int i = 0; i < x; i++)
		{
			for (int j = 0; j < y; j++)
			{
				if (i >= j)
					result[i][j] = random.nextInt(intMax);
			}
		}
		return result;
	}

	// 随机字符数组
	public static char[] randomCharArray(int arrayLength)
	{
		char[] result = new char[arrayLength];

		for (int i = 0; i < arrayLength; i++)
		{
			result[i] = (char) random.nextInt('z');
			if (!(result[i] >= 'A' && result[i] <= 'Z' || result[i] >= 'a' && result[i] <= 'z' || result[i] == ' '))
				i--;
		}

		return result;
	}

	public static char[] randomCharArray(int arrayLength, char from, char to)
	{
		char[] result = new char[arrayLength];

		for (int i = 0; i < arrayLength; i++)
		{
			result[i] = (char) random.nextInt('z');
			if (!(result[i] >= from && result[i] <= to))
				i--;
		}

		return result;
	}

	// 随机文本, 带空格
	public static char[] randomText(int arrayLength)
	{
		char[] result = new char[arrayLength];

		for (int i = 0; i < arrayLength; i++)
		{
			result[i] = (char) random.nextInt('z');
			if (!(result[i] >= 'A' && result[i] <= 'Z' || result[i] >= 'a' && result[i] <= 'z'))
				i--;
		}

		for (int i = 0; i <= arrayLength / 4; i++)
		{
			result[randomInt(arrayLength - 1)] = ' ';
		}

		return result;
	}

	// 随机整数
	public static int randomInt(int intMax)
	{
		return random.nextInt(intMax);
	}

	public static int randomInt(int intMin, int intMax)
	{
		return intMin + random.nextInt(intMax - intMin);
	}

	// 随机整数链表

	public static Node randomIntLinkedList(int length, int intMax)
	{
		if (length <= 0)
			return null;

		Node root = new Node(random.nextInt(intMax));
		Node temp = root;
		while (length > 1)
		{
			length--;
			temp.next = new Node(random.nextInt(intMax));
			temp = temp.next;
		}

		return root;
	}

	// 随机二叉树

	public static BinaryTree randomIntSortedBinaryTree(int nodeNum, int intMax)
	{

		if (nodeNum <= 0)
			return null;

		// HashSet<BinaryTree> nodesAdded = new HashSet<BinaryTree>();
		BinaryTree root = new BinaryTree(random.nextInt(intMax));

		// nodesAdded.add(root);
		System.out.println("root : " + root.getValue());
		for (int i = 1; i < nodeNum; i++)
		{
			try
			{
				insertTreeNode(root, new BinaryTree(randomInt(intMax)));
			}
			catch (Exception e)
			{
				// e.printStackTrace();
				i--;
			}
		}
		return root;

	}

	public static BinaryTree insertTreeNode(BinaryTree root, BinaryTree element)
	{
		if (root == null)
		{
			System.out.println("insert : " + element.getValue());
			return element;
		}
		if (root.getValue() > element.getValue())
			root.left = insertTreeNode(root.left, element);

		if (root.getValue() < element.getValue())
			root.right = insertTreeNode(root.right, element);

		if (root.getValue() == element.getValue())
		{
			throw new RuntimeException("相同值异常");
		}

		return root;
	}

}
