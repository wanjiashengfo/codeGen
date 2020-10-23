package com.guide.composite;

public class Test {
    public static void main(String[] args) {
        CompositeEquipment ibmComputer = new CompositeEquipment("IBM computer");
        CompositeEquipment ibmMainBoard = new CompositeEquipment("IBM mainBoard");
        ibmMainBoard.add(new Disk("10GB disk"));
        ibmMainBoard.add(new Cpu("p4 cpu"));
        ibmComputer.add(ibmMainBoard);
        ibmComputer.add(new Screen("screen"));
        System.out.println("Price=" + ibmComputer.price());
    }
}
