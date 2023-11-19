package com.nuist.menu;


import com.nuist.model.Course;
import com.nuist.model.Student;
import com.nuist.model.Teacher;

import com.nuist.model.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Run {
    CoursesList coursesList = new CoursesList();
    ArrayList<Course> courses = new ArrayList<>();
    StudentsList studentsList = new StudentsList();
    ArrayList<Student> students = new ArrayList<>();
    TeachersList teachersList = new TeachersList();
    ArrayList<Teacher> teachers = new ArrayList<>();
    Boolean bool = true;
    Scanner input =new Scanner(System.in);
    // 主程序
    public void runMenu() {
        Initial initialOperation = new Initial();
        initialOperation.initial();

        Display disdplay = new Display();
        int option = disdplay.dispalyMenu();

        TeacherLoginIn teacherLoginIn = new TeacherLoginIn();
        StudentLoginIn studentLoginIn = new StudentLoginIn();

        Register registerOperation = new Register();

        System.out.println("""
                    请问你的身份是：
                    1)教师
                    2)学生
                    """);
        int choice = input.nextInt();

        switch (option) {
            case 0:
                System.out.println("See you ~");
                System.exit(0);
            case 1:
                switch (choice){
                    case 1:
                        teacherLoginIn.logIn(bool,teachersList);
                    case 2:
                        studentLoginIn.logIn(bool,studentsList);
                }
            case 2:
                registerOperation.register(bool);
            default:
                System.out.println("Invalid option entere. " + option);
                bool = false;
        }
        if (bool) {

            HashMap<Student, Course> map = new HashMap<>();

            switch (option) {
                case 0:
                    //这里是老师的查询功能
                    Course course1 = new Course("物理");
                    Course course2 = new Course("化学");
                    Student student1 = new Student(31, "yaoxuan" ,"31" ,"31");
                    Student student2 = new Student(29, "xuweijie" ,"29" ,"29");
                    map.put(student1 , course1);
                    map.put(student2 , course2);
                    map.get(student1);
                    map.get(student2);

                case 1:
                    //这里是学生的选课功能

                    Student studentInformation = studentLoginIn.getStudent(bool,studentsList);

                    System.out.println("""
                            下面是可以选择的课程,请回复课程名称：
                            1)物理
                            2)化学
                            """);
                    String courseChoice = input.next();
                    Course course = new Course(courseChoice);

                    map.put(studentInformation,course);
                    System.out.println("选课成功");
            }
        }
        else {
            runMenu();
        }
    }

}
