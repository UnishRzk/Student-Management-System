package com.unish.view.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RemoveForm {

    public void showWindow() {
        // === Frame Setup ===
        JFrame frame = new JFrame("Remove Student");
        frame.setSize(420, 250);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(0xF0F0F0));
        frame.setLayout(null); // Absolute positioning
        frame.setIconImage(new ImageIcon("logo.png").getImage());

        // === Title ===
        JLabel title = new JLabel("REMOVE STUDENT");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setForeground(new Color(0xD32F2F));
        title.setBounds(95, 20, 300, 30); // X, Y, Width, Height
        frame.add(title);

        // === Label ===
        JLabel idLabel = new JLabel("Student ID:");
        idLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        idLabel.setForeground(new Color(0x333333));
        idLabel.setBounds(40, 80, 100, 25);
        frame.add(idLabel);

        // === Input Field ===
        JTextField idField = new JTextField();
        idField.setFont(new Font("SansSerif", Font.PLAIN, 13));
        idField.setBounds(150, 80, 200, 28);
        idField.setMargin(new Insets(4, 6, 4, 6));
        frame.add(idField);

        // === Remove Button ===
        JButton removeButton = new JButton("Remove");
        removeButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        removeButton.setBackground(new Color(211, 47, 47)); // Material Red
        removeButton.setForeground(Color.WHITE);
        removeButton.setFocusPainted(false);
        removeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        removeButton.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        removeButton.setBounds(150, 140, 120, 40);
        frame.add(removeButton);

        // === Button Action ===
        removeButton.addActionListener((ActionEvent e) -> {
            String id = idField.getText().trim();

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a Student ID.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Simulated removal logic
            JOptionPane.showMessageDialog(frame,
                    "Student with ID " + id + " removed successfully!",
                    "Remove Successful",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new RemoveForm().showWindow();
    }
}
