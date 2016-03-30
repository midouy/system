package org.system.common.util.commons;

import java.nio.charset.Charset;

/**
 * Created by wangyanming on 2015/7/27.
 */
//各种数据类型的转换
public class Convertor
{
    //整型数组转换为Integer数组
    public static Integer [] parseIntArrayToInteger(int [] arr)
    {
        Integer[] result = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            result[i] = arr[i];
        }
        return result;
    }

    //字符串转换成字符数组
    public static char [] parseStringToCharArray(String string)
    {
        return string.toCharArray();
    }
    //字符数组转换成字符串
    public static String parseCharArrayToString(char [] chars)
    {
        return new String (chars);
    }
    //字符串转换成字节数组
    public static byte[] parseStringToByteArray(String string, Charset charset, String chartSetString)throws Exception
    {
        if(chartSetString==null)
            return charset==null?string.getBytes():string.getBytes(charset);
        else
            return string.getBytes(chartSetString);
    }

}
