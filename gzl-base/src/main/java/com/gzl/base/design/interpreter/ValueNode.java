package com.gzl.base.design.interpreter;

public class ValueNode implements Node{
    private int value;

    public ValueNode(int value){
        this.value=value;
    }

    public int interpret(){
        return this.value;
    }
}
