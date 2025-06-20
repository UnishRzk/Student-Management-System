package com.unish.view;

import com.unish.model.Student;
import com.unish.service.StudentManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public Menu() {
        options();
    }

    private void options() {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            header();
            System.out.println("1. Add ");
            System.out.println("2. Display All ");
            System.out.println("3. Find Student By Id");
            System.out.println("4. Update Student");
            System.out.println("5. Remove Student");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine();
            if (choice.length() >= 3) {
                choice = choice.trim().toLowerCase().substring(0, 3);
            }

            switch (choice) {

                case "add":
                case "1":
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter GPA: ");
                    double gpa = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter the number of courses: ");
                    int n_courses = sc.nextInt();
                    sc.nextLine();

                    ArrayList<String> courses = new ArrayList<>();
                    for (int i = 0; i < n_courses; i++) {
                        System.out.print("Enter Course " + (i + 1) + ": ");
                        courses.add(sc.nextLine());
                    }

                    Student student = new Student(id, name, age, courses, gpa);
                    manager.addStudent(student);
                    break;

                case "dis":
                case "2":
                    manager.displayAllStudents();
                    break;

                case "fin":
                case "3":
                    System.out.print("Enter the Student id: ");
                    String search_id = sc.nextLine();
                    Student found = manager.findById(search_id);

                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case "upd":
                case "4":
                    System.out.print("Enter ID to update: ");
                    String updateId = sc.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new age: ");
                    int newAge = sc.nextInt();

                    System.out.print("Enter new GPA: ");
                    double newGpa = sc.nextDouble();
                    sc.nextLine();

                    manager.updateStudent(updateId, newName, newAge, newGpa);
                    break;

                case "rem":
                case "5":
                    System.out.print("Enter ID to remove: ");
                    String removeId = sc.nextLine();
                    manager.removeStudent(removeId);
                    break;

                case "exi":
                case "0":
                    System.out.println("Exiting.....");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice Please Try again");

            }

        }


    }

    private void header () {
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.println("""
                 _____ _             _            _    ___  ___                _     _____           _                \s
                /  ___| |           | |          | |   |  \\/  |               | |   /  ___|         | |               \s
                \\ `--.| |_ _   _  __| | ___ _ __ | |_  | .  . | __ _ _ __ ___ | |_  \\ `--. _   _ ___| |_ ___ _ __ ___ \s
                 `--. \\ __| | | |/ _` |/ _ \\ '_ \\| __| | |\\/| |/ _` | '_ ` _ \\| __|  `--. \\ | | / __| __/ _ \\ '_ ` _ \\\s
                /\\__/ / |_| |_| | (_| |  __/ | | | |_  | |  | | (_| | | | | | | |_  /\\__/ / |_| \\__ \\ ||  __/ | | | | |
                \\____/ \\__|\\__,_|\\__,_|\\___|_| |_|\\__| \\_|  |_/\\__, |_| |_| |_|\\__| \\____/ \\__, |___/\\__\\___|_| |_| |_|
                                                                __/ |                       __/ |                     \s
                                                               |___/                       |___/                      \s""");
        System.out.println("---------------------------------------------------------------------------------------------------------");

    }
}