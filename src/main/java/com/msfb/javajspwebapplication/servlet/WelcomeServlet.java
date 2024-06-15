package com.msfb.javajspwebapplication.servlet;

import com.msfb.javajspwebapplication.model.Student;
import com.msfb.javajspwebapplication.service.StudentService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "welcome", value = "/welcome")
public class WelcomeServlet extends HttpServlet {
    private StudentService studentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        studentService = new StudentService();
        List<Student> students = List.of(
                new Student("s1", "Ahmad", "Dep 1", 35),
                new Student("s2", "Benny", "Dep 1", 70),
                new Student("s3", "Cici", "Dep 1", 60),
                new Student("s4", "Denny", "Dep 1", 90),
                new Student("s5", "Ernando", "Dep 2", 30),
                new Student("s6", "Firmansyah", "Dep 3", 32),
                new Student("s7", "Hanafiah", "Dep 3", 70),
                new Student("s8", "Irfan", "Dep 3", 20)
        );


        Map<String, List<Student>> studentsByDepartment = studentService.groupStudentsByDepartment(students);
        studentService.calculatePassPercentage(studentsByDepartment);

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("students", students);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("welcome.jsp").forward(req, resp);
    }
}
