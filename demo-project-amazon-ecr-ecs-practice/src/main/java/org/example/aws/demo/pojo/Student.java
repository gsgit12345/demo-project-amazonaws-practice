package org.example.aws.demo.pojo;

public class Student {
    private String studentName;
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public Student(String studentName)
    {
        this.studentName=studentName;
    }
}
