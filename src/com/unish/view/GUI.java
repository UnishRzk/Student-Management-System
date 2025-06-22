package com.unish.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class GUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Management System");
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(0xEBD6FB));
        frame.setIconImage(new ImageIcon("logo.png").getImage());

        // Headd Panel
        ImageIcon logo = new ImageIcon("tLogo.png");
        Image scaledImage = logo.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedLogo = new ImageIcon(scaledImage);

        JLabel logoLabel = new JLabel(resizedLogo);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        logoLabel.setVerticalAlignment(SwingConstants.CENTER);

        JLabel titleLabel = new JLabel("Student Management System");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
        titleLabel.setForeground(new Color(0x333333));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);

        JPanel headPanel = new JPanel(new BorderLayout());
        headPanel.setBounds(0, 0, 900, 80);
        headPanel.setBackground(new Color(0xF0F0F0));
        headPanel.add(logoLabel, BorderLayout.WEST);
        headPanel.add(titleLabel, BorderLayout.CENTER);
//        headPanel.setBorder(BorderFactory.createLineBorder(Color.RED));


        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        buttonPanel.setBounds(0, 80, 900, 80);
        buttonPanel.setBackground(new Color(0xF0F0F0));

        Dimension btnSize = new Dimension(175, 40);
        CustomButton addStudents = new CustomButton("Add Students", btnSize);
        CustomButton updateStudents = new CustomButton("Update Students", btnSize);
        CustomButton removeStudents = new CustomButton("Remove Students", btnSize);
        CustomButton searchStudents = new CustomButton("Search", btnSize);

        buttonPanel.add(addStudents);
        buttonPanel.add(updateStudents);
        buttonPanel.add(removeStudents);
        buttonPanel.add(searchStudents);
//        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        // info Panel

        JPanel infoPanel = new JPanel();
        infoPanel.setBounds(0, 160, 900, 60);
        infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
        infoPanel.setBackground(new Color(0xF0F0F0));

        Font infoFont = new Font("SansSerif", Font.BOLD, 16);
        Color infoColor = new Color(0x333333);

// Placeholder summary labels
        JLabel totalLabel = new JLabel("Total Students: 5444");
        totalLabel.setFont(infoFont);
        totalLabel.setForeground(infoColor);

        JLabel avgGPALabel = new JLabel("Average GPA: --");
        avgGPALabel.setFont(infoFont);
        avgGPALabel.setForeground(infoColor);

        JLabel avgAgeLabel = new JLabel("Average Age: --");
        avgAgeLabel.setFont(infoFont);
        avgAgeLabel.setForeground(infoColor);

        JLabel topCourseLabel = new JLabel("Most Chosen Course: --");
        topCourseLabel.setFont(infoFont);
        topCourseLabel.setForeground(infoColor);

// Add all labels to the info panel
        infoPanel.add(totalLabel);
        infoPanel.add(avgGPALabel);
        infoPanel.add(avgAgeLabel);
        infoPanel.add(topCourseLabel);




        // ===== Table Panel =====
        JScrollPane tableScrollPane = createStudentTable();
        tableScrollPane.setPreferredSize(new Dimension(899, 400));

        JPanel tablePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        tablePanel.setBounds(0, 220, 900, 400);
        tablePanel.setBackground(new Color(0xF0F0F0));
        tablePanel.add(tableScrollPane);



        // ===== Credit Panel =====
        JPanel creditPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        creditPanel.setBounds(0, 620, 900, 80);
        creditPanel.setBackground(new Color(0xF0F0F0));

        JLabel creditLabel = new JLabel(
                "<html>Copyright &copy; 2025 All rights reserved | Made by " +
                        "<a href=''>Unish Rajak</a></html>"
        );
        creditLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        creditLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        creditLabel.setForeground(Color.BLACK);
        creditLabel.setToolTipText("Open GitHub");

        creditLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/UnishRzk"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        creditPanel.add(creditLabel);


//        Action Listeners For the Buttons

        addStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentFormPanel studentform = new StudentFormPanel(); // create object
                studentform.showWindow(); // call method from another class
            }
        });

        updateStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateForm updateForm = new UpdateForm(); // create object
                updateForm.showWindow(); // call method from another class
            }
        });

        removeStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveForm removeForm = new RemoveForm(); // create object
                removeForm.showWindow(); // call method from another class
            }
        });

        searchStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchForm searchForm = new SearchForm(); // create object
                searchForm.showWindow(); // call method from another class
            }
        });

        // ===== Add All Panels =====
        frame.add(headPanel);
        frame.add(buttonPanel);
        frame.add(infoPanel);
        frame.add(tablePanel);
        frame.add(creditPanel);

        frame.setVisible(true);
    }

    private static JScrollPane createStudentTable() {
        String[] columnNames = {"ID", "Name", "Age", "Courses", "GPA"};

        Object[][] data = {
                {"S001", "Alice Johnson", 20, "Math, Physics", 3.8},
                {"S002", "Bob Smith", 21, "Chemistry, English", 3.6},
                {"S003", "Charlie Lee", 19, "Biology, History", 3.9},
                {"S004", "Diana Prince", 22, "Computer Science", 3.7},
                {"S005", "Ethan Hunt", 23, "Law, Economics", 3.5},
                {"S006", "Fiona Gallagher", 20, "Psychology, Sociology", 3.4},
                {"S007", "George Miller", 21, "Political Science", 3.2},
                {"S008", "Hannah Brown", 22, "Philosophy, Art", 3.9},
                {"S009", "Ian Curtis", 19, "Music, Literature", 3.3},
                {"S010", "Jane Foster", 20, "Astrophysics", 4.0},
                {"S011", "Kyle Rayner", 22, "Graphic Design", 3.6},
                {"S012", "Laura Palmer", 21, "Criminology", 3.1},
                {"S013", "Mike Wheeler", 18, "Computer Engineering", 3.7},
                {"S014", "Nina Sharp", 24, "Medicine", 3.8},
                {"S015", "Oscar Wilde", 23, "Creative Writing", 3.9},
                {"S016", "Paula Dean", 20, "Nutrition Science", 3.5},
                {"S017", "Quinn James", 21, "Business Admin", 3.4},
                {"S018", "Riley Matthews", 20, "Early Childhood Education", 3.6},
                {"S019", "Steve Rogers", 25, "History, Military Studies", 3.7},
                {"S020", "Tony Stark", 24, "Mechanical Engineering", 3.9},
                {"S021", "Uma Thurman", 22, "Film Studies", 3.3},
                {"S022", "Victor Stone", 21, "Cybernetics", 3.8},
                {"S023", "Wanda Maximoff", 23, "Theoretical Physics", 3.9},
                {"S024", "Xander Harris", 20, "Anthropology", 3.2},
                {"S025", "Yasmin Khan", 22, "Medicine", 3.6},
                {"S026", "Zack Taylor", 21, "Martial Arts, Physics", 3.4},
                {"S027", "Lara Croft", 24, "Archaeology", 3.9},
                {"S028", "Bruce Wayne", 26, "Criminology, Business", 3.7},
                {"S029", "Clark Kent", 25, "Journalism", 4.0},
                {"S030", "Peter Parker", 21, "Biochemistry", 3.85}
        };

        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        table.setPreferredScrollableViewportSize(new Dimension(880, 400));
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.setRowHeight(28);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setFillsViewportHeight(true);
        table.setSelectionBackground(new Color(0xF0F0F0));
        table.setSelectionForeground(Color.BLACK);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setGridColor(Color.BLACK);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 15));
        header.setForeground(Color.WHITE);
        header.setBackground(new Color(25, 118, 210));
        header.setReorderingAllowed(true);
        header.setResizingAllowed(true);
        header.setOpaque(true);
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
        header.setBorder(BorderFactory.createEmptyBorder());

        return new JScrollPane(table);
    }
}
