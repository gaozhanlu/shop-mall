package com.gzl.base.design.builder;

public class Client {

    public static void main(String[] args) {

        //普通房子
        CommonHouse commonHouse = new CommonHouse();

        //准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);

        //完成盖房 返回产品(房子)
        House house = houseDirector.constructHouse();



        System.out.println("--------------------------");

        HighBuilding highBuilding = new HighBuilding();

        houseDirector.setHouseBuilder(highBuilding);

        houseDirector.constructHouse();



    }


}
