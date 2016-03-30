package org.system.common.util.commons;

import java.io.*;

public class DataCloner
{
	public static Object deepClone(Object src)
	{
		Object object = null;
		try
		{

			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(src);

			ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
			ObjectInputStream oi = new ObjectInputStream(bi);
			object = oi.readObject();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return object;
	}

	public static Object deepClone2(Object obj)
	{
		Object result = null;
		try
		{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);

			ByteArrayInputStream bis = new ByteArrayInputStream(
					bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			result = ois.readObject();

			return result;
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		return null;
	}

}
