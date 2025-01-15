package uk.cam.mrc.phm.homework.lectures.week10.collectionImplementation.agents;

public class Person implements AgentI {

    private int id;
    private String name;

    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId(){
        return this.id;
    }

    @Override
    public void move() {
        System.out.println("Adult move method, id: " + this.id);
    }

    public void speak(){
        System.out.println("Adult speak method, id: " + this.id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
