package uk.cam.mrc.phm.homework.lectures.week13;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class Student {
    // Students are assigned a null grade by default
    // hence the use of Integer data type for grade
    private final int id;
    private final String name;
    private Integer grade;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.grade = null;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getGrade() {
        return this.grade;
    }

    public void gradeStudent() {
        Random random = new Random();
        this.grade = random.nextInt(6);
    }

    public Map<String, String> getStudent() {
        Map<String, String> studentData = new LinkedHashMap<>();
        studentData.put("id", String.valueOf(this.id));
        studentData.put("name", this.name);
        studentData.put("grade", String.valueOf(this.grade));
        return studentData;
    }
}
