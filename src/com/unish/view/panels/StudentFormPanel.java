package com.unish.view.panels;

import com.unish.view.components.CustomButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class StudentFormPanel {

    public static void showWindow() {
        JFrame frame = new JFrame("Student Registration Form");
        frame.setSize(520, 700);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0xF0F0F0));
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon("logo.png").getImage());

        Font labelFont = new Font("SansSerif", Font.BOLD, 14);
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 13);

        JLabel title = new JLabel("STUDENT REGISTRATION");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setForeground(new Color(25, 118, 210));
        title.setBounds(120, 20, 400, 30);
        frame.add(title);

        int xLabel = 40, xField = 180, y = 70, gap = 40, widthLabel = 120, widthField = 250, height = 28;

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        nameLabel.setBounds(xLabel, y, widthLabel, height);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setFont(fieldFont);
        nameField.setBounds(xField, y, widthField, height);
        frame.add(nameField);

        y += gap;
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(labelFont);
        genderLabel.setBounds(xLabel, y, widthLabel, height);
        frame.add(genderLabel);

        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton other = new JRadioButton("Other");

        male.setBounds(xField, y, 70, height);
        female.setBounds(xField + 80, y, 80, height);
        other.setBounds(xField + 160, y, 80, height);
        male.setBackground(new Color(0xF0F0F0));
        female.setBackground(new Color(0xF0F0F0));
        other.setBackground(new Color(0xF0F0F0));

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        frame.add(male);
        frame.add(female);
        frame.add(other);

        y += gap;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);
        emailLabel.setBounds(xLabel, y, widthLabel, height);
        frame.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setFont(fieldFont);
        emailField.setBounds(xField, y, widthField, height);
        frame.add(emailField);

        y += gap;
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(labelFont);
        phoneLabel.setBounds(xLabel, y, widthLabel, height);
        frame.add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setFont(fieldFont);
        phoneField.setBounds(xField, y, widthField, height);
        frame.add(phoneField);

        y += gap;
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(labelFont);
        addressLabel.setBounds(xLabel, y, widthLabel, height);
        frame.add(addressLabel);

        JTextField addressField = new JTextField();
        addressField.setFont(fieldFont);
        addressField.setBounds(xField, y, widthField, height);
        frame.add(addressField);

        // === Date of Birth Dropdowns ===
        y += gap;
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setFont(labelFont);
        dobLabel.setBounds(xLabel, y, widthLabel, height);
        frame.add(dobLabel);

        String[] days = new String[31];
        for (int i = 0; i < 31; i++) days[i] = String.valueOf(i + 1);
        JComboBox<String> dayBox = new JComboBox<>(days);
        dayBox.setFont(fieldFont);
        dayBox.setBounds(xField, y, 70, height);
        frame.add(dayBox);

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        JComboBox<String> monthBox = new JComboBox<>(months);
        monthBox.setFont(fieldFont);
        monthBox.setBounds(xField + 80, y, 80, height);
        frame.add(monthBox);

        int currentYear = LocalDate.now().getYear();
        String[] years = new String[100];
        for (int i = 0; i < 100; i++) years[i] = String.valueOf(currentYear - i);
        JComboBox<String> yearBox = new JComboBox<>(years);
        yearBox.setFont(fieldFont);
        yearBox.setBounds(xField + 170, y, 80, height);
        frame.add(yearBox);

        y += gap;
        JLabel deptLabel = new JLabel("Department:");
        deptLabel.setFont(labelFont);
        deptLabel.setBounds(xLabel, y, widthLabel, height);
        frame.add(deptLabel);

        JComboBox<String> departmentBox = new JComboBox<>(new String[]{"BCA", "CSIT", "BSc.CS", "BBIS"});
        departmentBox.setFont(fieldFont);
        departmentBox.setBounds(xField, y, widthField, height);
        frame.add(departmentBox);

        y += gap;
        JLabel yearLabel = new JLabel("Year:");
        yearLabel.setFont(labelFont);
        yearLabel.setBounds(xLabel, y, widthLabel, height);
        frame.add(yearLabel);

        JComboBox<String> yearComboBox = new JComboBox<>(new String[]{"1", "2", "3", "4"});
        yearComboBox.setFont(fieldFont);
        yearComboBox.setBounds(xField, y, widthField, height);
        frame.add(yearComboBox);

        y += gap;
        JLabel semesterLabel = new JLabel("Semester:");
        semesterLabel.setFont(labelFont);
        semesterLabel.setBounds(xLabel, y, widthLabel, height);
        frame.add(semesterLabel);

        JComboBox<String> semesterBox = new JComboBox<>(new String[]{"1", "2", "3","4", "5", "6","7", "8"});
        semesterBox.setFont(fieldFont);
        semesterBox.setBounds(xField, y, widthField, height);
        frame.add(semesterBox);

        y += gap;
        JLabel gpaLabel = new JLabel("GPA:");
        gpaLabel.setFont(labelFont);
        gpaLabel.setBounds(xLabel, y, widthLabel, height);
        frame.add(gpaLabel);

        JTextField gpaField = new JTextField();
        gpaField.setFont(fieldFont);
        gpaField.setBounds(xField, y, widthField, height);
        frame.add(gpaField);

        y += gap;
        JLabel advisorLabel = new JLabel("Advisor:");
        advisorLabel.setFont(labelFont);
        advisorLabel.setBounds(xLabel, y, widthLabel, height);
        frame.add(advisorLabel);

        JTextField advisorField = new JTextField();
        advisorField.setFont(fieldFont);
        advisorField.setBounds(xField, y, widthField, height);
        frame.add(advisorField);

        // === Enrollment Date Dropdowns ===
        y += gap;
        JLabel enrollLabel = new JLabel("Enrollment Date:");
        enrollLabel.setFont(labelFont);
        enrollLabel.setBounds(xLabel, y, widthLabel, height);
        frame.add(enrollLabel);

        JComboBox<String> enrollDayBox = new JComboBox<>(days);
        enrollDayBox.setFont(fieldFont);
        enrollDayBox.setBounds(xField, y, 70, height);
        frame.add(enrollDayBox);

        JComboBox<String> enrollMonthBox = new JComboBox<>(months);
        enrollMonthBox.setFont(fieldFont);
        enrollMonthBox.setBounds(xField + 80, y, 80, height);
        frame.add(enrollMonthBox);

        JComboBox<String> enrollYearBox = new JComboBox<>(years);
        enrollYearBox.setFont(fieldFont);
        enrollYearBox.setBounds(xField + 170, y, 80, height);
        frame.add(enrollYearBox);

        y += gap;
        JCheckBox isActiveBox = new JCheckBox("Is Active");
        isActiveBox.setFont(fieldFont);
        isActiveBox.setBackground(new Color(0xF0F0F0));
        isActiveBox.setBounds(xField, y, widthField, height);
        frame.add(isActiveBox);

        y += gap + 10;
        CustomButton submitButton = new CustomButton("Submit", new Dimension(140, 40));
        submitButton.setBounds(100, y - 10, 140, 40);
        frame.add(submitButton);

        CustomButton resetButton = new CustomButton("Reset", new Dimension(140, 40));
        resetButton.setBounds(250, y - 10, 140, 40); // placed next to submit button
        frame.add(resetButton);

        // === Action Listener ===
        submitButton.addActionListener((ActionEvent e) -> {
            try {
                String name = nameField.getText().trim();
                String gender = male.isSelected() ? "Male" :
                        female.isSelected() ? "Female" :
                                other.isSelected() ? "Other" : "Other";
                String email = emailField.getText().trim();
                String phone = phoneField.getText().trim();
                String address = addressField.getText().trim();

                int dobDay = Integer.parseInt((String) dayBox.getSelectedItem());
                int dobMonth = monthBox.getSelectedIndex() + 1;
                int dobYear = Integer.parseInt((String) yearBox.getSelectedItem());
                LocalDate dob = LocalDate.of(dobYear, dobMonth, dobDay);

                String dept = (String) departmentBox.getSelectedItem();
                int year = Integer.parseInt((String) yearComboBox.getSelectedItem());
                String semester = (String) semesterBox.getSelectedItem();
                double gpa = Double.parseDouble(gpaField.getText().trim());
                String advisor = advisorField.getText().trim();

                int enrollDay = Integer.parseInt((String) enrollDayBox.getSelectedItem());
                int enrollMonth = enrollMonthBox.getSelectedIndex() + 1;
                int enrollYear = Integer.parseInt((String) enrollYearBox.getSelectedItem());
                LocalDate enrollDate = LocalDate.of(enrollYear, enrollMonth, enrollDay);

                boolean isActive = isActiveBox.isSelected();

                JOptionPane.showMessageDialog(frame, "Student Registered Successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        resetButton.addActionListener(e -> {
            nameField.setText("");
            genderGroup.clearSelection();
            emailField.setText("");
            phoneField.setText("");
            addressField.setText("");
            dayBox.setSelectedIndex(0);
            monthBox.setSelectedIndex(0);
            yearBox.setSelectedIndex(0);
            departmentBox.setSelectedIndex(0);
            yearComboBox.setSelectedIndex(0);
            semesterBox.setSelectedIndex(0);
            gpaField.setText("");
            advisorField.setText("");
            enrollDayBox.setSelectedIndex(0);
            enrollMonthBox.setSelectedIndex(0);
            enrollYearBox.setSelectedIndex(0);
            isActiveBox.setSelected(false);
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        showWindow();
    }
}
