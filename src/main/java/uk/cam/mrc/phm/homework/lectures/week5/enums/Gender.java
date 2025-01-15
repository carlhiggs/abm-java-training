package uk.cam.mrc.phm.homework.lectures.week5.enums;

public enum Gender {
    FEMALE(0.85),
    DIVERSE(0.82),
    MALE(0.70);
    private final double probabilityOfBikeOwnership;
    Gender (double probabilityOfBikeOwnership){
        this.probabilityOfBikeOwnership = probabilityOfBikeOwnership;
    }
    public double getProbabilityOfBikeOwnership(){
        return this.probabilityOfBikeOwnership;
    }
}
