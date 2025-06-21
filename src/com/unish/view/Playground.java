package com.unish.view;

import javax.swing.*;
import java.awt.*;

public class Playground {
    public static void main(String[] args) {

        JFrame frame = new JFrame();


        CustomButton button = new CustomButton("Test",new Dimension(100,40));

        frame.setSize(900,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.add(button);
        frame.setVisible(true);

    }
}
