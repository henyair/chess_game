package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeSoldier extends JFrame implements ActionListener {

    private ImageIcon BHorse = new ImageIcon("src/BHorse.png");
    private ImageIcon WHorse = new ImageIcon("src/WHorse.png");

    private ImageIcon BQueen = new ImageIcon("src/BQueen.png");
    private ImageIcon WQueen = new ImageIcon("src/WQueen.png");

    private ImageIcon BRach = new ImageIcon("src/BRach.png");
    private ImageIcon WRach = new ImageIcon("src/WRach.png");

    private ImageIcon BTura = new ImageIcon("src/BTura.png");
    private ImageIcon WTura = new ImageIcon("src/WTura.png");

    private JButton QueenB;
    private JButton RachB;
    private JButton TuraB;
    private JButton HorseB;
    private JButton QueenW;
    private JButton RachW;
    private JButton TuraW;
    private JButton HorseW;

    private int choose =0;

    ChangeSoldier(int Tor){
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setSize(200,500);
        this.setLayout(new GridLayout(4,1));

        QueenB = new JButton();
        QueenB.setIcon(BQueen);
        QueenB.addActionListener(this);
        RachB = new JButton();
        RachB.setIcon(BRach);
        RachB.addActionListener(this);
        TuraB = new JButton();
        TuraB.setIcon(BTura);
        TuraB.addActionListener(this);
        HorseB = new JButton();
        HorseB.setIcon(BHorse);
        HorseB.addActionListener(this);

        QueenW = new JButton();
        QueenW.setIcon(WQueen);
        QueenW.addActionListener(this);
        RachW = new JButton();
        RachW.setIcon(WRach);
        RachW.addActionListener(this);
        TuraW = new JButton();
        TuraW.setIcon(WTura);
        TuraW.addActionListener(this);
        HorseW = new JButton();
        HorseW.setIcon(WHorse);
        HorseW.addActionListener(this);

        if(Tor ==0){
            this.add(QueenW);
            this.add(RachW);
            this.add(TuraW);
            this.add(HorseW);
        }
        else if(Tor ==1){
            this.add(QueenB);
            this.add(RachB);
            this.add(TuraB);
            this.add(HorseB);
        }
        this.setVisible(false);
    }// חלון של שינוי שחקן
    public int GetChooseOfTool(){
        return this.choose;
    }//מחזיר מה בחרנו

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == QueenW){
            choose = 1;
        }
        else if(e.getSource() == RachW){
            choose = 2;
        }
        else if(e.getSource() == TuraW){
            choose = 3;
        }
        else if(e.getSource() == HorseW){
            choose = 4;
        }
        else if(e.getSource() == QueenB){
            choose = 1;
            System.out.println(choose);
        }
        else if(e.getSource() == RachB){
            choose = 2;
        }
        else if(e.getSource() == TuraB){
            choose = 3;
        }
        else if(e.getSource() == HorseB){
            choose = 4;
        }
    }
}
