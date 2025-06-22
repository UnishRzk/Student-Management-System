package com.unish.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class StudentFormPanel {

    public static void showWindow() {
        JFrame frame = new JFrame("Student Registration Form");
        frame.setSize(520, 720); // Good height balance without scroll
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(0xF0F0F0));
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon("logo.png").getImage());

        // === Title Panel ===
        JLabel title = new JLabel("STUDENT REGISTRATION");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setForeground(new Color(25, 118, 210));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(new Color(0xF0F0F0));
        titlePanel.add(title);

        frame.add(titlePanel, BorderLayout.NORTH);

        // === Form Panel ===
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(0xF0F0F0));
        formPanel.setBorder(BorderFactory.createEmptyBorder(1, 30, 1, 30)); // ORIGINAL padding

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7, 8, 7, 8); // ORIGINAL spacing between components
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;

        Font labelFont = new Font("SansSerif", Font.BOLD, 14);
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 13);


        JTextField nameField = createTextField(fieldFont);
        JPanel genderPanel = createGenderPanel();
        JTextField emailField = createTextField(fieldFont);
        JTextField phoneField = createTextField(fieldFont);
        JTextField addressField = createTextField(fieldFont);
        JTextField dobField = createTextField(fieldFont);
        dobField.setText("YYYY-MM-DD");

        JComboBox<String> departmentBox = new JComboBox<>(new String[]{"BCA", "CSIT", "BSc.CS", "BBIS"});
        JComboBox<String> yearBox = new JComboBox<>(new String[]{"1", "2", "3", "4"});
        JComboBox<String> semesterBox = new JComboBox<>(new String[]{"Spring", "Fall", "Winter"});

        JTextField gpaField = createTextField(fieldFont);
        JTextField advisorField = createTextField(fieldFont);
        JTextField enrollDateField = createTextField(fieldFont);
        enrollDateField.setText("YYYY-MM-DD");

        JCheckBox isActiveBox = new JCheckBox("Is Active");
        isActiveBox.setBackground(new Color(0xF0F0F0));
        isActiveBox.setFont(fieldFont);

        // === Add Fields ===

        addField(formPanel, gbc, "Name:", nameField, labelFont);

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

        // === Submit Button ===
        JButton submitButton = new JButton("Submit");
        styleButton(submitButton);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(submitButton, gbc);

        submitButton.addActionListener((ActionEvent e) -> {
            try {

                String name = nameField.getText().trim();

                String gender = getSelectedGender(genderPanel);
                String email = emailField.getText().trim();
                String phone = phoneField.getText().trim();
                String address = addressField.getText().trim();
                LocalDate dob = LocalDate.parse(dobField.getText().trim());
                String dept = (String) departmentBox.getSelectedItem();
                int year = Integer.parseInt((String) yearBox.getSelectedItem());
                String semester = (String) semesterBox.getSelectedItem();
                double gpa = Double.parseDouble(gpaField.getText().trim());
                String advisor = advisorField.getText().trim();
                LocalDate enrollDate = LocalDate.parse(enrollDateField.getText().trim());
                boolean isActive = isActiveBox.isSelected();

                JOptionPane.showMessageDialog(frame, "Student Registered Successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.add(formPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static JTextField createTextField(Font font) {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 28)); // restored original field height
        textField.setFont(font);
        textField.setMargin(new Insets(4, 6, 4, 6)); // restored original margins
        return textField;
    }

    private static JPanel createGenderPanel() {
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton other = new JRadioButton("Other");

        male.setBackground(new Color(0xF0F0F0));
        female.setBackground(new Color(0xF0F0F0));
        other.setBackground(new Color(0xF0F0F0));

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        group.add(other);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
        genderPanel.setBackground(new Color(0xF0F0F0));
        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(other);

        return genderPanel;
    }

    private static String getSelectedGender(JPanel genderPanel) {
        for (Component comp : genderPanel.getComponents()) {
            if (comp instanceof JRadioButton) {
                JRadioButton radio = (JRadioButton) comp;
                if (radio.isSelected()) {
                    return radio.getText();
                }
            }
        }
        return "Other";
    }

    private static void addField(JPanel panel, GridBagConstraints gbc, String labelText, Component input, Font labelFont) {
        JLabel label = new JLabel(labelText);
        label.setFont(labelFont);
        label.setForeground(new Color(0x333333));

        gbc.gridx = 0;
        gbc.gridwidth = 1;
        panel.add(label, gbc);

        gbc.gridx = 1;
        panel.add(input, gbc);

        gbc.gridy++;
    }

    private static void styleButton(JButton button) {
        button.setPreferredSize(new Dimension(130, 40));
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBackground(new Color(25, 118, 210));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
    }

    public static void main(String[] args) {
        showWindow();
    }
}
