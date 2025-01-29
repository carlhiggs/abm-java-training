package uk.cam.mrc.phm.homework.lectures.week9.generics;

public class ListRunner {
    public static void main(String[] args) {

        IntegerList list = new IntegerList();
        list.add(1);
        list.add(2);

        //Todo - uncomment the following lines after the CarList is added
        CarList carList = new CarList();
        carList.add(new Car());
        carList.add(new Car());
        carList.get(0).makeNoice();
        carList.get(1).makeNoice();

        //Todo - uncomment the following lines and try to fix an error
        ObjectList objectList = new ObjectList();
        objectList.add(1); // objectList.add(Integer.valueOf(1))
        objectList.add(new Car());
        int number = (int) objectList.get(0);
        ((Car)objectList.get(1)).makeNoice();



    }
}
