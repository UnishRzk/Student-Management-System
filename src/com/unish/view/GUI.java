package com.unish.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class GUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame();

        // for the logo

        ImageIcon logo = new ImageIcon("tLogo.png");
        Image scaledImage = logo.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon resizedLogo = new ImageIcon(scaledImage);

        // for the content inside of headPanel
        JLabel heading = new JLabel();
        heading.setText("com.unish.model.Student Management System");

        heading.setIcon(resizedLogo);

        heading.setHorizontalTextPosition(JLabel.RIGHT);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("SansSerif",Font.BOLD,32));
        heading.setIconTextGap(30);
        heading.setVerticalAlignment(JLabel.TOP);
        heading.setHorizontalAlignment(JLabel.LEFT);

        // For the Buttons panel
        Dimension btnSize = new Dimension(175,40);

        CustomButton addStudents = new CustomButton("Add Students",btnSize);
        CustomButton updateStudents = new CustomButton("Update Students",btnSize);
        CustomButton removeStudents = new CustomButton("Remove Students",btnSize);
        CustomButton searchStudents = new CustomButton("Search ",btnSize);



        // for table panel
        String[] columnNames = {"ID", "Name", "Age", "Courses", "GPA"};

        Object[][] data = {
                {"S001", "Alice Johnson", 20, "Math, Physics", 3.8},
                {"S002", "Bob Smith", 21, "Chemistry, English", 3.6},
                {"S003", "Charlie Lee", 19, "Biology, History", 3.9},
                {"S004", "Diana Prince", 22, "Computer Science", 3.7},
                {"S005", "Ethan Hunt", 23, "Law, Economics", 3.5},
                {"S006", "Fiona Gallagher", 20, "Psychology, Sociology", 3.4},
                {"S007", "George Miller", 21, "Political Science", 3.2},
                {"S008", "Hannah Brown", 22, "Philosophy, Art", 3.9},
                {"S009", "Ian Curtis", 19, "Music, Literature", 3.3},
                {"S010", "Jane Foster", 20, "Astrophysics", 4.0},
                {"S011", "Kyle Rayner", 22, "Graphic Design", 3.6},
                {"S012", "Laura Palmer", 21, "Criminology", 3.1},
                {"S013", "Mike Wheeler", 18, "Computer Engineering", 3.7},
                {"S014", "Nina Sharp", 24, "Medicine", 3.8},
                {"S015", "Oscar Wilde", 23, "Creative Writing", 3.9},
                {"S016", "Paula Dean", 20, "Nutrition Science", 3.5},
                {"S017", "Quinn James", 21, "Business Admin", 3.4},
                {"S018", "Riley Matthews", 20, "Early Childhood Education", 3.6},
                {"S019", "Steve Rogers", 25, "History, Military Studies", 3.7},
                {"S020", "Tony Stark", 24, "Mechanical Engineering", 3.9},
                {"S021", "Uma Thurman", 22, "Film Studies", 3.3},
                {"S022", "Victor Stone", 21, "Cybernetics", 3.8},
                {"S023", "Wanda Maximoff", 23, "Theoretical Physics", 3.9},
                {"S024", "Xander Harris", 20, "Anthropology", 3.2},
                {"S025", "Yasmin Khan", 22, "Medicine", 3.6},
                {"S026", "Zack Taylor", 21, "Martial Arts, Physics", 3.4},
                {"S027", "Lara Croft", 24, "Archaeology", 3.9},
                {"S028", "Bruce Wayne", 26, "Criminology, Business", 3.7},
                {"S029", "Clark Kent", 25, "Journalism", 4.0},
                {"S030", "Peter Parker", 21, "Biochemistry", 3.85}
        };



        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(800, 350));

        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.setRowHeight(28);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setFillsViewportHeight(true);

        // for header
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 15));
        header.setForeground(Color.WHITE);
        header.setBackground(new Color(0x687FE5));
        header.setReorderingAllowed(false);
        header.setResizingAllowed(true);
        header.setOpaque(true);
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
        header.setBorder(BorderFactory.createEmptyBorder());

        // for table
        table.setSelectionBackground(new Color(0xFFDDE8E4, true));
        table.setSelectionForeground(Color.BLACK);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setGridColor(Color.black);


        // heading panel
        JPanel headPanel = new JPanel();
        headPanel.setBounds(0,0,900,100);
        headPanel.setLayout(new BorderLayout());

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0,100,900,120);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,30,40));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        // Table panel
        JPanel tablePanel = new JPanel();
        tablePanel.setBounds(0,220,900,440);
        tablePanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
        tablePanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));






        frame.setSize(900,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("com.unish.model.Student Management System");

        frame.getContentPane().setBackground(new Color(0xEBD6FB));


        ImageIcon image = new ImageIcon("logo.png");
        frame.setIconImage(image.getImage()); // To set the Icon



        headPanel.add(heading);

//        StudentPanel.add(forId);
//        StudentPanel.add(id);
//
//        StudentPanel.add(forName);
//        StudentPanel.add(name);
//
//        StudentPanel.add(forAge);
//        StudentPanel.add(age);
//
//        StudentPanel.add(forCourse);
//        StudentPanel.add(course);
//
//        StudentPanel.add(forGpa);
//        StudentPanel.add(gpa);

        buttonPanel.add(addStudents);
        buttonPanel.add(updateStudents);
        buttonPanel.add(removeStudents);
        buttonPanel.add(searchStudents);

        tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);

        frame.add(buttonPanel);
        frame.add(headPanel);
        frame.add(tablePanel);
//        frame.add(StudentPanel);




        frame.setVisible(true);
    }
}
