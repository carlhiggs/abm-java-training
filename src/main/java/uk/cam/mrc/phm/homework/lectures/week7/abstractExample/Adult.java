package uk.cam.mrc.phm.homework.lectures.week7.abstractExample;

public class Adult extends Person {
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
        System.out.println("I can drink alcohol");
    }

    public void drive() {
        System.out.println("...... can drive.");
    }
    @Override
    public void introduceSelf() {
        super.introduceSelf();
        System.out.println("I am allowed to drink alcohol.");
    }
    public boolean hasDrivingLicense() {
        return holdingDrivingLicense;
    }
}
