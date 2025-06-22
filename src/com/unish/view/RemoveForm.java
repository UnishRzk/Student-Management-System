package com.unish.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RemoveForm {

    public void showWindow() {
        JFrame frame = new JFrame("Remove Student");
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(0xF0F0F0));
        frame.setIconImage(new ImageIcon("logo.png").getImage());

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(0xF0F0F0));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        Font font = new Font("SansSerif", Font.BOLD, 14);
        JTextField idField = new JTextField();

        JLabel label = new JLabel("Student ID to Remove:");
        label.setFont(font);
        label.setForeground(new Color(0x333333));

        gbc.gridx = 0;
        panel.add(label, gbc);
        gbc.gridx = 1;
        panel.add(idField, gbc);
        gbc.gridy++;

        JButton removeButton = new JButton("Remove");
        styleButton(removeButton);
        gbc.gridx = 1;
        panel.add(removeButton, gbc);

        removeButton.addActionListener((ActionEvent e) -> {
            String id = idField.getText();
            JOptionPane.showMessageDialog(frame, "Student with ID " + id + " removed successfully!");
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setPreferredSize(new Dimension(120, 40));
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBackground(new Color(25, 118, 210));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
    }
}
