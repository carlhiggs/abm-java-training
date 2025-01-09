package uk.cam.mrc.phm.training.day2.fabiland.data;

import de.tum.bgu.msm.data.person.*;

public class PersonFactoryFabiland implements PersonFactory {

    @Override
    public PersonHealthFabiland createPerson(int id, int age,
                                        Gender gender, Occupation occupation,
                                        PersonRole role, int workplace,
                                        int income) {
        return new PersonHealthFabiland(id, age, gender,
                occupation, role, workplace,
                income);
    }

    @Override
    public Person giveBirth(Person parent, int id, Gender gender) {
        PersonHealthFabiland pp = new PersonHealthFabiland(id, 0, gender, Occupation.TODDLER, PersonRole.CHILD, 0, 0);
        return pp;
    }

    //TODO duplicate as well school attributes
    @Override
    public PersonHealthFabiland duplicate(Person originalPerson, int id) {
        PersonHealthFabiland duplicate = new PersonHealthFabiland(id,
                originalPerson.getAge(),
                originalPerson.getGender(),
                originalPerson.getOccupation(),
                originalPerson.getRole(),
                -1,
                originalPerson.getAnnualIncome());
        duplicate.setDriverLicense(originalPerson.hasDriverLicense());
        duplicate.setSchoolId(((PersonHealthFabiland) originalPerson).getSchoolId());
        return duplicate;
    }
}
