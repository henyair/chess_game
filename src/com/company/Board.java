package com.company;
import javax.swing.*;
import java.awt.*;

public class Board extends JFrame{

    JButton[][] board = new JButton[8][8];

    Board(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800,800);
        this.setLayout(new GridLayout(8,8));

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j]= new JButton();
                if(i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1){
                    board[i][j].setBackground(Color.white);
                    this.add(board[i][j]);
                }//צובע משבצות לבנות
                else {
                    board[i][j] = new JButton();
                    board[i][j].setBackground(Color.DARK_GRAY);
                    this.add(board[i][j]);
                }//צובע משבצות שחורות
            }
        }//צובע משבצות
        this.setVisible(true);
    }//מאתחל לוח
    public void setMakeTool(Board board,ImageIcon icon,int i,int j){
        board.board[i][j].setIcon(icon);
    }//משנה תמונה על הלוח
}
