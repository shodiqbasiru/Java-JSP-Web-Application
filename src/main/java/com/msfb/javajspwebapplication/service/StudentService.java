package com.msfb.javajspwebapplication.service;

import com.msfb.javajspwebapplication.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {
    public Map<String, List<Student>> groupStudentsByDepartment(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));
    }

    public Map<String, Double> calculatePassPercentage(Map<String, List<Student>> studentsByDepartment) {
        Map<String, Double> passPercent = new HashMap<>();
        for (Map.Entry<String, List<Student>> entry : studentsByDepartment.entrySet()) {
            String department = entry.getKey();
            List<Student> studentInDepartment = entry.getValue();

            long passCount = studentInDepartment.stream()
                    .filter(student -> student.getMark() >= 50)
                    .count();

            double percent = (double) passCount/studentInDepartment.size() *100;
            passPercent.put(department, percent);

            for (Student student : studentInDepartment) {
                student.setPassPercentage(percent);
            }
        }
        return passPercent;
    }
}
