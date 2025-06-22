package com.unish.view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentDetailCard {

    public void showCard() {
        // === Frame Setup ===
        JFrame frame = new JFrame("Student Details");
        frame.setSize(550, 510);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.getContentPane().setBackground(new Color(0xE0F7FA));
        frame.setLayout(new BorderLayout());

        // === Card Container ===
        JPanel cardPanel = new JPanel();
        cardPanel.setPreferredSize(new Dimension(500, 300));
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setBorder(BorderFactory.createLineBorder(new Color(0x90A4AE), 2, true));
        cardPanel.setLayout(null);

        // === Profile Picture ===
        ImageIcon icon = new ImageIcon("logo.png");
        Image img = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        JLabel photoLabel = new JLabel(new ImageIcon(img));
        photoLabel.setBounds(390, 30, 120, 120);
        photoLabel.setBorder(BorderFactory.createLineBorder(new Color(0xB0BEC5), 1));

        // === Title ===
        JLabel title = new JLabel("STUDENT DETAILS");
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        title.setForeground(new Color(0x00796B));
        title.setBounds(20, 15, 300, 30);

        // === Fake Data ===
        String id = "STU1234";
        String name = "Unish Rajak";
        int age = 21;
        String gender = "Male";
        String email = "unish@example.com";
        String phone = "9800000000";
        String address = "Lalitpur, Nepal";
        LocalDate dob = LocalDate.of(2004, 2, 15);
        String department = "BCA";
        int year = 3;
        String semester = "Spring";
        double gpa = 3.82;
        String advisor = "Prof. Sharma";
        LocalDate enrollmentDate = LocalDate.of(2022, 4, 15);
        boolean isActive = true;

        // === Info Panel ===
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(0, 2, 12, 10));
        infoPanel.setBounds(25, 60, 340, 400);
        infoPanel.setOpaque(false);

        Font labelFont = new Font("SansSerif", Font.PLAIN, 13);
        Font valueFont = new Font("SansSerif", Font.BOLD, 13);
        Color valueColor = new Color(0x333333);

        infoPanel.add(makeLabel("ID:", labelFont));
        infoPanel.add(makeValue(id, valueFont, valueColor));

        infoPanel.add(makeLabel("Name:", labelFont));
        infoPanel.add(makeValue(name, valueFont, valueColor));

        infoPanel.add(makeLabel("Gender:", labelFont));
        infoPanel.add(makeValue(gender, valueFont, valueColor));

        infoPanel.add(makeLabel("Age:", labelFont));
        infoPanel.add(makeValue(String.valueOf(age), valueFont, valueColor));

        infoPanel.add(makeLabel("DOB:", labelFont));
        infoPanel.add(makeValue(dob.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), valueFont, valueColor));

        infoPanel.add(makeLabel("Department:", labelFont));
        infoPanel.add(makeValue(department, valueFont, valueColor));

        infoPanel.add(makeLabel("Year:", labelFont));
        infoPanel.add(makeValue(String.valueOf(year), valueFont, valueColor));

        infoPanel.add(makeLabel("Semester:", labelFont));
        infoPanel.add(makeValue(semester, valueFont, valueColor));

        infoPanel.add(makeLabel("GPA:", labelFont));
        infoPanel.add(makeValue(String.valueOf(gpa), valueFont, valueColor));

        infoPanel.add(makeLabel("Advisor:", labelFont));
        infoPanel.add(makeValue(advisor, valueFont, valueColor));

        infoPanel.add(makeLabel("Enrollment:", labelFont));
        infoPanel.add(makeValue(enrollmentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), valueFont, valueColor));

        infoPanel.add(makeLabel("Phone:", labelFont));
        infoPanel.add(makeValue(phone, valueFont, valueColor));

        infoPanel.add(makeLabel("Email:", labelFont));
        infoPanel.add(makeValue(email, valueFont, valueColor));

        infoPanel.add(makeLabel("Address:", labelFont));
        infoPanel.add(makeValue(address, valueFont, valueColor));

        infoPanel.add(makeLabel("Active:", labelFont));
        infoPanel.add(makeValue(isActive ? "Yes" : "No", valueFont, valueColor));

        // === Add to card ===
        cardPanel.add(title);
        cardPanel.add(infoPanel);
        cardPanel.add(photoLabel);

        frame.add(cardPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private JLabel makeLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(new Color(0x555555));
        return label;
    }

    private JLabel makeValue(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(color);
        return label;
    }
}