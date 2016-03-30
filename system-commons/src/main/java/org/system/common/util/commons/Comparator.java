package org.system.common.util.commons;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Comparator 
{
	public static int max(int ... ints)
	{
		int max = Integer.MIN_VALUE;
		for(int i : ints)
		{
			if(i>max)
				max = i;
		}
		return max;
	}
	
	public static int min(int ... ints)
	{
		int min = Integer.MAX_VALUE;
		for(int i : ints)
		{
			if(i<min)
				min = i;
		}
		return min;
	}


	public static Comparable<?> maxObj(Comparable<?> ... objs)
	{
		Comparable<?> max = objs[0];
		for(Comparable c : objs)
		{
			if(c.compareTo(max)>0)
				max = c;
		}
		return max;
	}

	public static Comparable minObj(Comparable ... objs)
	{
		Comparable min = objs[0];
		for(Comparable c : objs)
		{
			if(c.compareTo(min)<0)
				min = c;
		}
		return min;
	}
	
}
