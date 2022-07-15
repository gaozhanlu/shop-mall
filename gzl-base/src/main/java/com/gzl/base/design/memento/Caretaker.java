package com.gzl.base.design.memento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Caretaker {
    Memento memento;
    //对GameRole 保存多次状态
    private ArrayList<Memento> mementos;
    //对多个游戏角色保存多个状态
    private HashMap<String, ArrayList<Memento>> rolesMementos;
    //在List 集合中会有很多的备忘录对象
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    //获取到第index个Originator 的 备忘录对象(即保存状态)
    public Memento get(int index) {
        return mementoList.get(index);
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
