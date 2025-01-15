package uk.cam.mrc.phm.homework.lectures.week5.enums;

public class PersonRunner {

    public static void main(String[] args) {

        Person person1 = new Person(Gender.FEMALE);


        Person person2 = new Person(Gender.DIVERSE);

        System.out.println(Gender.valueOf("DIVERSE"));

        for (Gender gender : Gender.values()) {

            System.out.println(gender.name() + ", probability of having a bike: " + gender.getProbabilityOfBikeOwnership());

        }


        switch (person1.gender) {
            case MALE:
                System.out.println("Person 1 is male");
                break;
            case FEMALE:
                System.out.println("Person 1 is female");
                break;
            case DIVERSE:
                System.out.println("Person 1 is diverse");
                break;
        }


    }

}
