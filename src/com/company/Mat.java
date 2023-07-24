package com.company;

import javax.swing.*;

public class Mat extends JFrame {
    private JLabel label;
    String a;
    Mat(int tor){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setSize(500,500);
        if(tor ==0){
            label = new JLabel("The Black is the winner");
            this.add(label);
            label.setVerticalAlignment(JLabel.CENTER);
            label.setHorizontalAlignment(JLabel.CENTER);
        }
        else if(tor ==1){
            label = new JLabel("The White is the winner");
            this.add(label);
            label.setVerticalAlignment(JLabel.CENTER);
            label.setHorizontalAlignment(JLabel.CENTER);
        }
        this.setVisible(true);
    }
}
