package com.unish.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class StudentFormPanel {

    public static void showWindow() {
        JFrame frame = new JFrame("Student Registration Form");
        frame.setSize(500, 700);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(0xF0F0F0));
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon("logo.png").getImage());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBackground(new Color(0xF0F0F0));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        Font labelFont = new Font("SansSerif", Font.BOLD, 14);

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();

        // Gender - Radio Buttons
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton other = new JRadioButton("Other");
        male.setBackground(new Color(0xF0F0F0));
        female.setBackground(new Color(0xF0F0F0));
        other.setBackground(new Color(0xF0F0F0));
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.setBackground(new Color(0xF0F0F0));
        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(other);

        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField dobField = new JTextField("YYYY-MM-DD");

        JComboBox<String> departmentBox = new JComboBox<>(new String[]{"BCA", "CSIT", "BSc.CS", "BBIS"});
        JComboBox<String> yearBox = new JComboBox<>(new String[]{"1", "2", "3", "4"});
        JComboBox<String> semesterBox = new JComboBox<>(new String[]{"Spring", "Fall", "Winter"});

        JTextField gpaField = new JTextField();
        JTextField advisorField = new JTextField();
        JTextField enrollDateField = new JTextField("YYYY-MM-DD");
        JCheckBox isActiveBox = new JCheckBox("Is Active");
        isActiveBox.setBackground(new Color(0xF0F0F0));

        // Add Form Rows
        addField(formPanel, gbc, "Student ID:", idField, labelFont);
        addField(formPanel, gbc, "Name:", nameField, labelFont);
        addField(formPanel, gbc, "Age:", ageField, labelFont);
        addField(formPanel, gbc, "Gender:", genderPanel, labelFont);
        addField(formPanel, gbc, "Email:", emailField, labelFont);
        addField(formPanel, gbc, "Phone Number:", phoneField, labelFont);
        addField(formPanel, gbc, "Address:", addressField, labelFont);
        addField(formPanel, gbc, "Date of Birth:", dobField, labelFont);
        addField(formPanel, gbc, "Department:", departmentBox, labelFont);
        addField(formPanel, gbc, "Year:", yearBox, labelFont);
        addField(formPanel, gbc, "Semester:", semesterBox, labelFont);
        addField(formPanel, gbc, "GPA:", gpaField, labelFont);
        addField(formPanel, gbc, "Advisor:", advisorField, labelFont);
        addField(formPanel, gbc, "Enrollment Date:", enrollDateField, labelFont);
        addField(formPanel, gbc, "", isActiveBox, labelFont);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(120, 40));
        submitButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        submitButton.setBackground(new Color(25, 118, 210));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);

        gbc.gridx = 1;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(submitButton, gbc);

        submitButton.addActionListener((ActionEvent e) -> {
            try {
                String id = idField.getText();
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : "Other";
                String email = emailField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();
                LocalDate dob = LocalDate.parse(dobField.getText());
                String dept = (String) departmentBox.getSelectedItem();
                int year = Integer.parseInt((String) yearBox.getSelectedItem());
                String semester = (String) semesterBox.getSelectedItem();
                double gpa = Double.parseDouble(gpaField.getText());
                String advisor = advisorField.getText();
                LocalDate enrollDate = LocalDate.parse(enrollDateField.getText());
                boolean isActive = isActiveBox.isSelected();

                JOptionPane.showMessageDialog(frame, "Student Registered Successfully!");
                System.out.println("Collected: " + id + ", " + name + ", " + gender + ", GPA: " + gpa);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.add(formPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void addField(JPanel panel, GridBagConstraints gbc, String labelText, Component inputComponent, Font font) {
        JLabel label = new JLabel(labelText);
        label.setFont(font);
        label.setForeground(new Color(0x333333));
        gbc.gridx = 0;
        panel.add(label, gbc);

        gbc.gridx = 1;
        panel.add(inputComponent, gbc);
        gbc.gridy++;
    }
}
