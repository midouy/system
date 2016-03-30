package org.system.common.util.commons;

public class DataSorter 
{
	//快速排序
	public static void sortIntArrayQuick(int [] arr)
	{
		sortIntArrayQuick(arr, 0, arr.length-1);
	}
	public static void sortIntArrayQuick(int [] arr, int from,int to)
	{
		if(from>=to)
			return;
		int a = from ; 
		int b = to;
		int middle = arr[from];
		
		while(a<b)
		{
			while(a<b&&arr[b]>=middle)
				b--;
				arr[a] = arr[b];
			while(a<b&&arr[a]<=middle)
				a++;
				arr[b] = arr[a];
		}
		arr[a]=middle;
		sortIntArrayQuick(arr, from, a-1);
		sortIntArrayQuick(arr, a+1, to);
		
	}

}
