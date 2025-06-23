package com.unish.view.components;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentDetailCard {

    public void showCard() {
        // === Frame Setup ===
        JFrame frame = new JFrame("Student Details");
        frame.setSize(450, 510);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.getContentPane().setBackground(new Color(0xE0F7FA));
        frame.setLayout(new BorderLayout());

        // === Card Container ===
        JPanel cardPanel = new JPanel(null);
        cardPanel.setPreferredSize(new Dimension(500, 300));
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setBorder(BorderFactory.createLineBorder(new Color(0x90A4AE), 2, true));

        // === Title ===
        JLabel title = new JLabel("Student Details");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setForeground(new Color(0x00796B));
        title.setBounds(20, 15, 300, 30);
        cardPanel.add(title);

        // === Profile Picture ===
        ImageIcon icon = new ImageIcon("logo.png"); // fallback image
        Image img = icon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        JLabel photoLabel = new JLabel(new ImageIcon(img));
        photoLabel.setBounds(270, 60, 120, 120);
        photoLabel.setBorder(BorderFactory.createLineBorder(new Color(0xB0BEC5), 1));
        cardPanel.add(photoLabel);

        // === Info Panel ===
        JPanel infoPanel = new JPanel(new GridBagLayout());
        infoPanel.setOpaque(false);
        infoPanel.setBounds(20, 60, 320, 380);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        Font labelFont = new Font("SansSerif", Font.PLAIN, 13);
        Font valueFont = new Font("SansSerif", Font.BOLD, 13);
        Color valueColor = new Color(0x333333);

        int row = 0;
        row = addRow(infoPanel, gbc, row, "Name:", "Unish Rajak", labelFont, valueFont, valueColor);
        row = addRow(infoPanel, gbc, row, "Gender:", "Male", labelFont, valueFont, valueColor);
        row = addRow(infoPanel, gbc, row, "Age:", "21", labelFont, valueFont, valueColor);
        row = addRow(infoPanel, gbc, row, "DOB:", formatDate(LocalDate.of(2004, 2, 15)), labelFont, valueFont, valueColor);
        row = addRow(infoPanel, gbc, row, "Department:", "BCA", labelFont, valueFont, valueColor);
        row = addRow(infoPanel, gbc, row, "Year:", "3", labelFont, valueFont, valueColor);
        row = addRow(infoPanel, gbc, row, "Semester:", "Spring", labelFont, valueFont, valueColor);
        row = addRow(infoPanel, gbc, row, "GPA:", "3.82", labelFont, valueFont, valueColor);
        row = addRow(infoPanel, gbc, row, "Advisor:", "Prof. Sharma", labelFont, valueFont, valueColor);
        row = addRow(infoPanel, gbc, row, "Enrollment:", formatDate(LocalDate.of(2022, 4, 15)), labelFont, valueFont, valueColor);
        row = addRow(infoPanel, gbc, row, "Phone:", "9800000000", labelFont, valueFont, valueColor);
        row = addRow(infoPanel, gbc, row, "Email:", "unish@example.com", labelFont, valueFont, valueColor);
        row = addRow(infoPanel, gbc, row, "Address:", "Lalitpur, Nepal", labelFont, valueFont, valueColor);
        row = addRow(infoPanel, gbc, row, "Active:", "Yes", labelFont, valueFont, valueColor);

        cardPanel.add(infoPanel);
        frame.add(cardPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private int addRow(JPanel panel, GridBagConstraints gbc, int row, String labelText, String valueText,
                       Font labelFont, Font valueFont, Color valueColor) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0;
        panel.add(makeLabel(labelText, labelFont), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(makeValue(valueText, valueFont, valueColor), gbc);

        return row + 1;
    }

    private JLabel makeLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(new Color(0x555555));
        return label;
    }

    private JLabel makeValue(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(color);
        return label;
    }

    private String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    // main for testing
    public static void main(String[] args) {
        new StudentDetailCard().showCard();
    }
}
