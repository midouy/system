package org.system.common.util.model;

public class BinaryTree
{
    private int value;

    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }
}
