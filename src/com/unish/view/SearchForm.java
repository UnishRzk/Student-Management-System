package com.unish.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SearchForm {

    public void showWindow() {
        JFrame frame = new JFrame("Search Student");
        frame.setSize(450, 300);
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
        JTextField nameField = new JTextField();

        addField(panel, gbc, "Search by ID:", idField, font);
        addField(panel, gbc, "Or Name:", nameField, font);

        JButton searchButton = new JButton("Search");
        styleButton(searchButton);
        gbc.gridx = 1;
        panel.add(searchButton, gbc);

        searchButton.addActionListener((ActionEvent e) -> {
            String id = idField.getText();
            String name = nameField.getText();
            JOptionPane.showMessageDialog(frame, "Searching for: " + (id.isEmpty() ? name : id));
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

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
        button.setBackground(new Color(25, 118, 210));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
    }
}
