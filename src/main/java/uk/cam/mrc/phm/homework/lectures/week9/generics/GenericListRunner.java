package uk.cam.mrc.phm.homework.lectures.week9.generics;

public class GenericListRunner {
    public static void main(String[] args) {
        GenericList<Integer> integerGenericList = new GenericList<Integer>();
        integerGenericList.add(1);
        //integerGenericList.add("1");
//        integerGenericList.add(new Car());

        GenericList<Car> carGenericList = new GenericList<>();
        carGenericList.add(new Car());
        //carGenericList.add(1);
        carGenericList.get(0).makeNoice();

        GenericList emptyGenericList = new GenericList();
        emptyGenericList.add(1);
        emptyGenericList.add(new Car());

        int number = (int) emptyGenericList.get(0);
        Car car = (Car) emptyGenericList.get(1);
        ((Car)emptyGenericList.get(1)).makeNoice();

    }
}
