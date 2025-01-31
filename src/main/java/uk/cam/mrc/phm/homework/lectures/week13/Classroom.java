package uk.cam.mrc.phm.homework.lectures.week13;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    // The java class information needs to be documented into an XML file, the following elements are
    // included:
    //  - 20 students with their id (index start from 0) and final grade (a random number between 0 and 5)
    //  - 3 supervisors with their names
    // Please interpret this into a proper hierarchical structure, then using XMLStreamWriter to create a
    // javaClass.xml file to store these information properly

    private final Student[] students;
    private final String[] supervisors;

    public Classroom(String[] studentNames, String[] supervisors) {
        this.students = new Student[studentNames.length];
        this.supervisors = supervisors;
        for (int i = 0; i < studentNames.length; i++) {
            this.students[i] = new Student(i, studentNames[i]);
            this.students[i].gradeStudent();
        }
    }

    public List<java.util.Map<String, String>> getStudents() {
        List<java.util.Map<String, String>> studentList = new ArrayList<>();
        for (Student student : this.students) {
            studentList.add(student.getStudent());
        }
        return studentList;
    }

    public String[] getSupervisors() {
        return this.supervisors;
    }
}
