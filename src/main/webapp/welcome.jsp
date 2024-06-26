<%@ page import="com.msfb.javajspwebapplication.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="assets/index.css">
    <script src="assets/welcome.js"></script>
</head>
<body>
    <div class="container">
        <h1>Welcome, <%= application.getAttribute("userId") %></h1>
        <table>
            <thead>
            <tr>
                <th>Department</th>
                <th>Student ID</th>
                <th>Marks</th>
                <th>Pass%</th>
            </tr>
            </thead>
            <tbody>
            <%
                Map<String, List<Student>> groupedStudents = ((List<Student>) application.getAttribute("students"))
                        .stream().collect(Collectors.groupingBy(Student::getDepartment, LinkedHashMap::new, Collectors.toList()));

                for (Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()) {
                    String department = entry.getKey();
                    List<Student> studentsInDepartment = entry.getValue();
                    for (int i = 0; i < studentsInDepartment.size(); i++) {
                        Student student = studentsInDepartment.get(i);
            %>
            <tr>
                <% if (i == 0) { %>
                <td rowspan="<%= studentsInDepartment.size() %>">
                    <%= department %>
                </td>
                <% } %>
                <td>
                    <a href="#" onclick="showPopup('<%= student.getStudentName() %>')">
                        <%= student.getStudentId() %>
                    </a>
                </td>
                <td>
                    <%= student.getMark() %>
                </td>
                <% if (i == 0) { %>
                <td rowspan="<%= studentsInDepartment.size() %>">
                    <%= student.getPassPercentage() %>
                </td>
                <% } %>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>

        <a href="logout" class="logout">Logout</a>
    </div>
    <div id="popup" class="popup">
        <div class="popup-content">
            <p id="studentName"></p>
            <span id="close" class="close">&times;</span>
        </div>
    </div>
</body>
</html>