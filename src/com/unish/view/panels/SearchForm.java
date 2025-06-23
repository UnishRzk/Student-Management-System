package com.unish.view.panels;

import com.unish.view.components.StudentDetailCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SearchForm {

    public void showWindow() {
        // === Frame Setup ===
        JFrame frame = new JFrame("Search Student");
        frame.setSize(450, 290);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(0xF0F0F0));
        frame.setLayout(null);
        frame.setIconImage(new ImageIcon("logo.png").getImage());

        Font labelFont = new Font("SansSerif", Font.BOLD, 14);
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 13);

        // === Title ===
        JLabel title = new JLabel("SEARCH STUDENT");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setForeground(new Color(25, 118, 210)); // Material Blue
        title.setBounds(115, 25, 250, 30);
        frame.add(title);

        // === Labels and Fields ===
        JLabel idLabel = new JLabel("Search by ID:");
        idLabel.setFont(labelFont);
        idLabel.setBounds(50, 80, 120, 25);
        frame.add(idLabel);

        JTextField idField = new JTextField();
        styleTextField(idField, fieldFont);
        idField.setBounds(180, 80, 200, 28);
        frame.add(idField);

        JLabel nameLabel = new JLabel("Or Name:");
        nameLabel.setFont(labelFont);
        nameLabel.setBounds(50, 130, 120, 25);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        styleTextField(nameField, fieldFont);
        nameField.setBounds(180, 130, 200, 28);
        frame.add(nameField);

        // === Search Button ===
        JButton searchButton = new JButton("Search");
        styleButton(searchButton);
        searchButton.setBounds(160, 180, 120, 40);
        frame.add(searchButton);

        // === Button Action ===
        searchButton.addActionListener((ActionEvent e) -> {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();

            if (id.isEmpty() && name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter Student ID or Name.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Simulated search logic
            new StudentDetailCard().showCard();  // opens the ID-style card
            JOptionPane.showMessageDialog(frame,
                    "Searching for: " + (id.isEmpty() ? name : id),
                    "Search Info",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        frame.setVisible(true);
    }

    private void styleTextField(JTextField textField, Font font) {
        textField.setFont(font);
        textField.setMargin(new Insets(4, 6, 4, 6));
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBackground(new Color(25, 118, 210));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
    }

    public static void main(String[] args) {
        new SearchForm().showWindow();
    }
}
