package com.gzl.base.design.adapter;

public class ConcreteTarget implements Target{
    @Override
    public void request() {
        System.out.println("普通类 具有 普通功能...");
    }
}
