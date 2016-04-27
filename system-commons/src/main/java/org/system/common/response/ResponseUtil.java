package org.system.common.response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyanming on 2016/3/30.
 */
public class ResponseUtil
{
    public static Map<String, Object> successResult(String msg)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("message", msg);
        return result;
    }

    public static Map<String, Object> successResult(Map result ,String msg)
    {
        result.put("success", true);
        result.put("message", msg);
        return result;
    }

    public static Map<String, Object> failResult(String msg)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);
        result.put("message", msg);
        return result;
    }

    public static Map<String, Object> failResult(Map result, String msg)
    {
        result.put("success", false);
        result.put("message", msg);
        return result;
    }
}
