package com.gzl.base.design.builder;

public abstract class HouseBuilder {

    protected House house = new House();

    //将建造的流程写好 抽象的方法
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();

    //建造房子
    public House buildHouse() {
        return house;
    }

}
