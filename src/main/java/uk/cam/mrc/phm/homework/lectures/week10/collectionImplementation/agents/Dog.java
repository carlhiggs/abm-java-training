package uk.cam.mrc.phm.homework.lectures.week10.collectionImplementation.agents;

public class Dog implements AgentI {

    private int id;
    private String name;

    public Dog (int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void move() {
        System.out.println("Dog move method, id: " + id);
    }

    public void bark(){
        System.out.println("Dog bark method, id: " + id);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
