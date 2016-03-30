package org.system.common.util.file;

import java.io.File;

/**
 * Created by wangyanming on 2015/12/10.
 */
public class FileRename
{
    public static void main(String[] args)
    {
        // TODO 自动生成的方法存根
        String rootDir = "";

        doPrint(rootDir);
    }

    public static void doPrint(String rootDir)
    {
        File root = new File(rootDir);

        if (root.isFile())
            return;

        File[] files = root.listFiles();

        for (File f : files)
        {
            if (f.isFile()){
                if(f.getName().startsWith("y")){
                    System.out.println(f.getName());
                    f.renameTo(new File(rootDir+"\\"+f.getName().substring(f.getName().indexOf("y")+1)));
                }
            }

            if (f.isDirectory())
                doPrint(f.getAbsolutePath());
        }

    }
}
