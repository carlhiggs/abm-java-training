package uk.cam.mrc.phm.homework.lectures.week5.callByValue;

public class CartoonRunner {

    public static void main(String[] args) {

        Cartoon cartoon1 = new Cartoon();
        cartoon1.setName("Tom");
        rename(cartoon1);
        System.out.println(cartoon1.getName());
    }

    public static void rename(Cartoon cartoon2) {
        cartoon2 = new Cartoon();
        cartoon2.setName("Jerry");
    }
}
