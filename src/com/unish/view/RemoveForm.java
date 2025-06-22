package com.unish.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RemoveForm {

    public void showWindow() {
        // === Frame Setup ===
        JFrame frame = new JFrame("Remove Student");
        frame.setSize(420, 300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(0xF0F0F0));
        frame.setLayout(new BorderLayout());
        frame.setIconImage(new ImageIcon("logo.png").getImage());

        // === Title ===
        JLabel title = new JLabel("REMOVE STUDENT");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setForeground(new Color(0xD32F2F));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(new Color(0xF0F0F0));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(1, 0, 0, 0));
        titlePanel.add(title);

        frame.add(titlePanel, BorderLayout.NORTH);

        // === Panel Setup ===
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(0xF0F0F0));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 40, 20, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 12, 10, 12);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;

        Font labelFont = new Font("SansSerif", Font.BOLD, 14);
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 13);

        // === Input Field ===
        JTextField idField = new JTextField();
        styleTextField(idField, fieldFont);
        addField(panel, gbc, "Student ID:", idField, labelFont);

        // === Button Panel ===
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(0xF0F0F0));
        JButton removeButton = new JButton("Remove");
        styleButton(removeButton);
        buttonPanel.add(removeButton);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);

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

        // === Add Panel to Frame ===
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // === Helper Methods ===

    private void addField(JPanel panel, GridBagConstraints gbc, String labelText, Component input, Font labelFont) {
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

    private void styleTextField(JTextField textField, Font font) {
        textField.setPreferredSize(new Dimension(200, 28));
        textField.setFont(font);
        textField.setMargin(new Insets(4, 6, 4, 6));
    }

    private void styleButton(JButton button) {
        button.setPreferredSize(new Dimension(120, 40));
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBackground(new Color(211, 47, 47)); // Material Red
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
    }

    public static void main(String[] args) {
        new RemoveForm().showWindow();
    }
}
