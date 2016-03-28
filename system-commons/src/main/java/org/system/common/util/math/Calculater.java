package org.system.common.util.math;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Created by wangyanming on 2016/3/28.
 */
public class Calculater
{
    static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");

    public static String doCalculate(String source)throws Exception
    {
        return jse.eval(source).toString();
    }
    public static void main(String[] args) {
        String strs = "5";
        try {
//            System.out.println(jse.eval(strs));
            System.out.println(doCalculate(strs));
        } catch (Exception t) {
        }
    }
}
