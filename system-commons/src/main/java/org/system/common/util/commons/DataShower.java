package org.system.common.util.commons;




import org.system.common.util.model.BinaryTree;
import org.system.common.util.model.Node;
import org.system.common.util.model.ShowType;

import java.util.ArrayList;
import java.util.Collection;


public class DataShower
{
	//一般类型输出
	public static void show(Object obj)
	{
		System.out.println(obj);
	}
	
	//数组遍历
	public static void show(int [] data)
	{
		for(int i : data)
		{
			System.out.print(i+"  ");
		}
		System.out.println();
	}

    public static void show(Object [] data)
    {
        for(Object i : data)
        {
            System.out.print(i+"  ");
        }
        System.out.println();
    }

	public static void show(int [] data, int start1 , int end1)
	{
		if(start1>end1||start1<0)
			return;
		for(int i = start1; i<=end1;i++)
			System.out.print(data[i]+" ");
		System.out.println();
	}
	
	public static void show(char [] data)
	{
		for(char i : data)
		{
			System.out.print(i+"  ");
		}
		System.out.println();
	}
	//二维数组遍历
	public static void show(int[][] arr)
	{
		System.out.println("二维数组 : ");
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				System.out.print(arr[i][j]+" \t");
			}
			System.out.println();
		}
	}
	//按照参数打印二维数组
	public static void show(int [][] arr, int xmin, int xmax, int ymin, int ymax)
	{
		System.out.println("二维数组 : ");
		for(int i=xmin;i<=xmax;i++)
		{
			for(int j=ymin;j<=ymax ; j++)
			{
				System.out.print(arr[i][j]+" \t");
			}
			System.out.println();
		}
	}
	//显示二维数组的所有子数组
	public static void showSubArray(int [][] arr, int xmin, int xmax, int ymin, int ymax)
	{
		if(xmax-xmin<=1||ymax-ymin<=1)
			return ;
		System.out.println("( "+xmin+" , "+xmax+" ) -> ( "+ymin+" , "+ymax+" )");
		DataShower.show(arr, xmin, xmax, ymin, ymax);
		showSubArray(arr, xmin+1, xmax, ymin, ymax);
		showSubArray(arr, xmin, xmax-1, ymin, ymax);
		showSubArray(arr, xmin, xmax, ymin+1, ymax);
		showSubArray(arr, xmin, xmax, ymin, ymax-1);
	}
	//链表遍历
	public  static void show(Node root)
	{
		System.out.println();
		while(root!=null)
		{
			System.out.print(root.getValue()+" ");
			root= root.next;
		}
		System.out.println();
	}
	//二叉树遍历
	public static void show(BinaryTree root, ShowType showType)
	{

		if(root==null)
			return ;
		
		switch(showType)
		{
			case ALL : 
			{
				System.out.print("先序遍历: ");
					show(root, ShowType.ROOT_FIRST);
					System.out.println();
				System.out.print("中序遍历: ");
					show(root, ShowType.ROOT_MIDLLE);
					System.out.println();
				System.out.print("后序遍历: ");
					show(root, ShowType.ROOT_LAST);
					System.out.println();
				System.out.print("层次遍历: ");
					show(root, ShowType.LAYER);
					System.out.println();
				break;
			}
			case ROOT_FIRST : 
			{
				System.out.print(root.getValue()+" ");
				show(root.left,showType);
				show(root.right,showType);
				break;
			}
			
			case ROOT_MIDLLE : 
			{
				show(root.left,showType);
				System.out.print(root.getValue()+" ");
				show(root.right,showType);
				break;
			}
			
			case ROOT_LAST : 
			{
				show(root.left,showType);
				show(root.right,showType);
				System.out.print(root.getValue()+" ");
				break;
			}
			case LAYER:
			{
				ArrayList<BinaryTree> nodes = new ArrayList<BinaryTree>();
				nodes.add(root);
				for(int i = 0; i<nodes.size();i++)
				{
					BinaryTree index = nodes.get(i);
					System.out.print(index.getValue()+" ");
					if(index.left!=null)
						nodes.add(index.left);
					if(index.right!=null)
						nodes.add(index.right);
				}
				break;
			}
			
		}
		
	}
	
	//集合遍历
	public static <E> void show(Collection<E> data)
	{
		for(E i : data)
		{
			System.out.println(i+"  ");
		}
		System.out.println();
	}

}
