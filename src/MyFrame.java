import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{

    public MyFrame() {

        this.setSize(800,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Student Management System");
        this.setVisible(true);


        ImageIcon image = new ImageIcon("LOGO.png");
        this.setIconImage(image.getImage()); // To set the Icon

        this.getContentPane().setBackground(new Color(0xEBD6FB));
    }
}
