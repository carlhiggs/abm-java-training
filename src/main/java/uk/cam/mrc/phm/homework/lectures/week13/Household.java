package uk.cam.mrc.phm.homework.lectures.week13;

public class Household {

    private int id;
    private Person[] persons;

    public Household(int id, Person[] persons) {
        this.id = id;
        this.persons = persons;
    }

    public int getId() {
        return id;
    }

    public Person[] getPersons() {
        return persons;
    }
}
