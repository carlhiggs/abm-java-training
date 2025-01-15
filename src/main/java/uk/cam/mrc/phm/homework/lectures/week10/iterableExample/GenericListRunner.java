package uk.cam.mrc.phm.homework.lectures.week10.iterableExample;

public class GenericListRunner {
    public static void main(String[] args) {
        GenericList<String> stringList = new GenericList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");

        //for loop
//        for (int i = 0; i < 3; i ++){
//            System.out.println(stringList.get(i));
//        }
        //for-each loop
//        for (String item : stringList.items){
//            System.out.println(item);
//        }
    }
}
