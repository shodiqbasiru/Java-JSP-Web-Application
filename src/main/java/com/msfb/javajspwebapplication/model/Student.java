package com.msfb.javajspwebapplication.model;

public class Student {
    private String studentId;
    private String studentName;
    private String department;
    private int mark;
    private Double passPercentage;

    public Student(String studentId, String studentName, String department, int mark) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.mark = mark;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDepartment() {
        return department;
    }

    public int getMark() {
        return mark;
    }

    public Double getPassPercentage() {
        return passPercentage;
    }

    public void setPassPercentage(Double passPercentage) {
        this.passPercentage = passPercentage;
    }

}


