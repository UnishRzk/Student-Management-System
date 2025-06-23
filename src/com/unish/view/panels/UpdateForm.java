package com.unish.view.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UpdateForm {

    public void showWindow() {
        // === Frame Setup ===
        JFrame frame = new JFrame("Update Student");
        frame.setSize(500, 350);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0xF0F0F0));
        frame.setIconImage(new ImageIcon("logo.png").getImage());

        Font labelFont = new Font("SansSerif", Font.BOLD, 14);
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 13);

        // === Title ===
        JLabel title = new JLabel("UPDATE STUDENT");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setForeground(new Color(25, 118, 210));
        title.setBounds(145, 20, 250, 30);
        frame.add(title);

        // === Labels and Inputs ===
        JLabel idLabel = new JLabel("Student ID:");
        idLabel.setFont(labelFont);
        idLabel.setBounds(50, 80, 120, 25);
        frame.add(idLabel);

        JTextField idField = new JTextField();
        styleTextField(idField, fieldFont);
        idField.setBounds(180, 80, 240, 28);
        frame.add(idField);

        JLabel fieldLabel = new JLabel("Field to Update:");
        fieldLabel.setFont(labelFont);
        fieldLabel.setBounds(50, 130, 120, 25);
        frame.add(fieldLabel);

        String[] updatableFields = {
                "Name", "Age", "Gender", "Email", "Phone Number",
                "Address", "Date of Birth", "Department", "Year",
                "Semester", "GPA", "Advisor", "Enrollment Date", "Active Status"
        };
        JComboBox<String> fieldBox = new JComboBox<>(updatableFields);
        fieldBox.setFont(fieldFont);
        fieldBox.setBounds(180, 130, 240, 28);
        frame.add(fieldBox);

        JLabel newValueLabel = new JLabel("New Value:");
        newValueLabel.setFont(labelFont);
        newValueLabel.setBounds(50, 180, 120, 25);
        frame.add(newValueLabel);

        JTextField newValueField = new JTextField();
        styleTextField(newValueField, fieldFont);
        newValueField.setBounds(180, 180, 240, 28);
        frame.add(newValueField);

        // === Button ===
        JButton updateButton = new JButton("Update");
        styleButton(updateButton);
        updateButton.setBounds(190, 230, 120, 40);
        frame.add(updateButton);

        // === Button Action ===
        updateButton.addActionListener((ActionEvent e) -> {
            String id = idField.getText().trim();
            String field = (String) fieldBox.getSelectedItem();
            String newValue = newValueField.getText().trim();

            if (id.isEmpty() || newValue.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Simulated update logic
            JOptionPane.showMessageDialog(frame,
                    "Updated '" + field + "' to '" + newValue + "' for student ID: " + id,
                    "Update Successful",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        frame.setVisible(true);
    }

    // === Helper Methods ===
    private void styleTextField(JTextField textField, Font font) {
        textField.setFont(font);
        textField.setMargin(new Insets(4, 6, 4, 6));
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBackground(new Color(25, 118, 210)); // Material Blue
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
    }

    public static void main(String[] args) {
        new UpdateForm().showWindow();
    }
}
