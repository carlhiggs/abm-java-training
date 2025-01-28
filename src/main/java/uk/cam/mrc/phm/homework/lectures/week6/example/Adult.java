package uk.cam.mrc.phm.homework.lectures.week6.example;

public class Adult extends Person{
    private boolean holdingDrivingLicense;
    public Adult (String name, int age, boolean holdingDrivingLicense){
        super(name, age);
        this.holdingDrivingLicense = holdingDrivingLicense;
    }
    public Adult (String name){
        super(name);
    }
    public Adult (int age){
        super(age);
    }
    public Adult (){
        super (null, 0);
    }
    @Override
    public void drink() {
        super.drink();
        System.out.println(super.getName() + " can drink alcohol.");
    }
    public void drive() {
        System.out.println(super.getName() + " can drive.");
    }
    public boolean hasDrivingLicense() {
        return holdingDrivingLicense;
    }
}
