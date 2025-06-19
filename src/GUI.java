import javax.swing.*;
import java.awt.*;

public class GUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame();

        // for the logo

        ImageIcon logo = new ImageIcon("tLogo.png");
        Image scaledImage = logo.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon resizedLogo = new ImageIcon(scaledImage);




        // for the content inside of headPanel
        JLabel heading = new JLabel();
        heading.setText("Student Management System");

        heading.setIcon(resizedLogo);

        heading.setHorizontalTextPosition(JLabel.RIGHT);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("SansSerif",Font.BOLD,32));
        heading.setIconTextGap(30);
        heading.setVerticalAlignment(JLabel.TOP);
        heading.setHorizontalAlignment(JLabel.LEFT);

        // for the Student details Panel

        JLabel forId = new JLabel("Id: ");
        forId.setBounds(10, 20, 100, 30);
        JTextField id = new JTextField();
        id.setBounds(60, 20, 150, 30);

        JLabel forName = new JLabel("Name: ");
        forName.setBounds(10, 50, 100, 30);
        JTextField name = new JTextField();
        name.setBounds(60, 50, 150, 30);

        JLabel forAge = new JLabel("Age: ");
        forAge.setBounds(10, 80, 100, 30);
        JTextField age = new JTextField();
        age.setBounds(60, 80, 150, 30);

        JLabel forCourse = new JLabel("Course: ");
        forCourse.setBounds(10, 110, 100, 30);
        JTextField course = new JTextField();
        course.setBounds(60, 110, 150, 30);

        JLabel forGpa = new JLabel("Gpa: ");
        forGpa.setBounds(10, 140, 100, 30);
        JTextField gpa = new JTextField();
        gpa.setBounds(60, 140, 150, 30);



        // heading panel
        JPanel headPanel = new JPanel();
        headPanel.setBounds(0,0,1100,100);
        headPanel.setLayout(new BorderLayout());

        // student details panel
        JPanel StudentPanel = new JPanel();
        StudentPanel.setBounds(0,100,550,500);
        StudentPanel.setLayout(null);
        StudentPanel.setBorder(BorderFactory.createLineBorder(Color.RED)); // debug





        frame.setSize(1100,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
//        frame.setResizable(false);
        frame.setTitle("Student Management System");
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(0xEBD6FB));


        ImageIcon image = new ImageIcon("logo.png");
        frame.setIconImage(image.getImage()); // To set the Icon



        headPanel.add(heading);

        StudentPanel.add(forId);
        StudentPanel.add(id);

        StudentPanel.add(forName);
        StudentPanel.add(name);

        StudentPanel.add(forAge);
        StudentPanel.add(age);

        StudentPanel.add(forCourse);
        StudentPanel.add(course);

        StudentPanel.add(forGpa);
        StudentPanel.add(gpa);

        frame.add(headPanel);
        frame.add(StudentPanel);





    }
}
