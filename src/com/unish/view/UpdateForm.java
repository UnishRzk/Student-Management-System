package com.unish.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UpdateForm {

    public void showWindow() {
        // === Frame Setup ===
        JFrame frame = new JFrame("Update Student");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(0xF0F0F0));
        frame.setLayout(new BorderLayout());
        frame.setIconImage(new ImageIcon("logo.png").getImage());

        // === Panel Setup ===
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(0xF0F0F0));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        Font labelFont = new Font("SansSerif", Font.BOLD, 14);

        // === Fields ===
        JTextField idField = new JTextField();

        String[] updatableFields = {
                "Name", "Age", "Gender", "Email", "Phone Number",
                "Address", "Date of Birth", "Department", "Year",
                "Semester", "GPA", "Advisor", "Enrollment Date", "Active Status"
        };
        JComboBox<String> fieldBox = new JComboBox<>(updatableFields);
        JTextField newValueField = new JTextField();

        // === Add Form Components ===
        addField(panel, gbc, "Student ID:", idField, labelFont);
        addField(panel, gbc, "Field to Update:", fieldBox, labelFont);
        addField(panel, gbc, "New Value:", newValueField, labelFont);

        // === Button ===
        JButton updateButton = new JButton("Update");
        styleButton(updateButton);

        gbc.gridx = 1;
        panel.add(updateButton, gbc);

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

        // === Add Panel to Frame ===
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // === Helper Methods ===

    private void addField(JPanel panel, GridBagConstraints gbc, String labelText, Component input, Font font) {
        JLabel label = new JLabel(labelText);
        label.setFont(font);
        label.setForeground(new Color(0x333333));

        gbc.gridx = 0;
        panel.add(label, gbc);

        gbc.gridx = 1;
        panel.add(input, gbc);
        gbc.gridy++;
    }

    private void styleButton(JButton button) {
        button.setPreferredSize(new Dimension(120, 40));
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBackground(new Color(25, 118, 210)); // Blue
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
}
