package com.unish.view;

import javax.swing.*;

public class SearchForm {

    public void showWindow(){
        JFrame frame = new JFrame("Search Student");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
