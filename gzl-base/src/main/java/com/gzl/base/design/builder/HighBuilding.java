package com.gzl.base.design.builder;

public class HighBuilding extends HouseBuilder {

    @Override
    public void buildBasic() {
        // TODO Auto-generated method stub
        System.out.println("高楼打地基100m");
    }

    @Override
    public void buildWalls() {
        // TODO Auto-generated method stub
        System.out.println(" 高楼砌墙20cm ");
    }

    @Override
    public void roofed() {
        // TODO Auto-generated method stub
        System.out.println(" 高楼封顶 ");
    }

}
