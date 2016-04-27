package org.system.common.test;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wangyanming on 2016/2/24.
 */
public class JunitDemo
{
    @Test
    public void TestDemo()
    {
        Assert.assertEquals("demo","demo");

        //Assert.assertEquals("demo","demox");
    }
}
