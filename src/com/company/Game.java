package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener {

    private ImageIcon BlackS = new ImageIcon("src/BSolider.png");
    private ImageIcon WhiteS = new ImageIcon("src/WSolider.png");

    private ImageIcon BKing = new ImageIcon("src/BKing.png");
    private ImageIcon WKing = new ImageIcon("src/WKing.png");

    private ImageIcon BHorse = new ImageIcon("src/BHorse.png");
    private ImageIcon WHorse = new ImageIcon("src/WHorse.png");

    private ImageIcon BQueen = new ImageIcon("src/BQueen.png");
    private ImageIcon WQueen = new ImageIcon("src/WQueen.png");

    private ImageIcon BRach = new ImageIcon("src/BRach.png");
    private ImageIcon WRach = new ImageIcon("src/WRach.png");

    private ImageIcon BTura = new ImageIcon("src/BTura.png");
    private ImageIcon WTura = new ImageIcon("src/WTura.png");

    private Board board = new Board();
    private Board Dboard = new Board();

    private Tool[][] tools = new Tool[8][8];
    private Tool[][] Dtools = new Tool[8][8];

    private boolean[][] CantGoThereW = new boolean[8][8];
    private boolean[][] CantGoThereB = new boolean[8][8];

    private boolean[][] ProtectedW = new boolean[8][8];
    private boolean[][] ProtectedB = new boolean[8][8];

    private boolean[][] ifShild = new boolean[8][8];

    private int tor = 0;
    public int chooseTool=0;
    public static int count =1;

    private ImageIcon[] ChangeSoldierW = new ImageIcon[4];
    private ImageIcon[] ChangeSoldierB = new ImageIcon[4];

    private ImageIcon[] SwichToolB = new ImageIcon[6];
    private ImageIcon[] SwichToolW = new ImageIcon[6];

    ChangeSoldier changeSoldierW = new ChangeSoldier(0);
    ChangeSoldier changeSoldierB = new ChangeSoldier(1);

    Game(){
        Dboard.setVisible(false);
        ChangeSoldierW[0] = WQueen;
        ChangeSoldierW[1] = WRach;
        ChangeSoldierW[2] = WTura;
        ChangeSoldierW[3] = WHorse;
        ChangeSoldierB[0] = BQueen;
        ChangeSoldierB[1] = BRach;
        ChangeSoldierB[2] = BTura;
        ChangeSoldierB[3] = BHorse;

        SwichToolB[0] = BlackS;
        SwichToolB[1] = BRach;
        SwichToolB[2] = BTura;
        SwichToolB[3] = BQueen;
        SwichToolB[4] = BHorse;
        SwichToolB[5] = BKing;
        SwichToolW[0] = WhiteS;
        SwichToolW[1] = WRach;
        SwichToolW[2] = WTura;
        SwichToolW[3] = WQueen;
        SwichToolW[4] = WHorse;
        SwichToolW[5] = WKing;


        for(int m =0;m<8;m++){
            for(int n =0;n<8;n++){
                board.board[m][n].addActionListener(this);
                CantGoThereW[m][n] =false;
                CantGoThereB[m][n] =false;
            }
        }//מחבר את כל הכפתורים לפונקציית listener

        for(int i =0;i<8;i++){
            for(int j =0;j<8;j++){
                if(i==1){
                    board.setMakeTool(board,BlackS,i,j);
                    tools[i][j]=new Soldier(BlackS,i,j,'B');
                    Dboard.setMakeTool(Dboard,BlackS,i,j);
                    Dtools[i][j]= new Soldier(BlackS,i,j,'B');
                }//מסדר חיילים שלחורים
                else if(i==6){
                    board.setMakeTool(board,WhiteS,i,j);
                    tools[i][j]=new Soldier(WhiteS,i,j,'W');
                    Dboard.setMakeTool(Dboard,WhiteS,i,j);
                    Dtools[i][j]= new Soldier(WhiteS,i,j,'W');
                }//מסדר חיילים לבנים
            }
        }//מסדר חיילים

        board.setMakeTool(board,BTura,0,0);
        board.setMakeTool(board,BTura,0,7);
        board.setMakeTool(board,BHorse,0,1);
        board.setMakeTool(board,BHorse,0,6);
        board.setMakeTool(board,BRach,0,2);
        board.setMakeTool(board,BRach,0,5);
        board.setMakeTool(board,BQueen,0,3);
        board.setMakeTool(board,BKing,0,4);
        tools[0][0]=new Tura(BTura,0,0,'B');
        tools[0][7]=new Tura(BTura,0,7,'B');
        tools[0][1]=new Horse(BHorse,0,1,'B');
        tools[0][6]=new Horse(BHorse,0,6,'B');
        tools[0][2]=new Rach(BRach,0,2,'B');
        tools[0][5]=new Rach(BRach,0,5,'B');
        tools[0][3]=new Queen(BQueen,0,3,'B');
        tools[0][4]=new King(BKing,0,4,'B');
        //מלך מלכה רץ סוס וטורה שחורים

        board.setMakeTool(board,WTura,7,0);
        board.setMakeTool(board,WTura,7,7);
        board.setMakeTool(board,WHorse,7,1);
        board.setMakeTool(board,WHorse,7,6);
        board.setMakeTool(board,WRach,7,2);
        board.setMakeTool(board,WRach,7,5);
        board.setMakeTool(board,WQueen,7,3);
        board.setMakeTool(board,WKing,7,4);
        tools[7][0]=new Tura(WTura,7,0,'W');
        tools[7][7]=new Tura(WTura,7,7,'W');
        tools[7][1]=new Horse(WHorse,7,1,'W');
        tools[7][6]=new Horse(WHorse,7,6,'W');
        tools[7][2]=new Rach(WRach,7,2,'W');
        tools[7][5]=new Rach(WRach,7,5,'W');
        tools[7][3]=new Queen(WQueen,7,3,'W');
        tools[7][4]=new King(WKing,7,4,'W');
        //מלך מלכה רץ סוס וטורה לבנים

        Dboard.setMakeTool(Dboard,BTura,0,0);
        Dboard.setMakeTool(Dboard,BTura,0,7);
        Dboard.setMakeTool(Dboard,BHorse,0,1);
        Dboard.setMakeTool(Dboard,BHorse,0,6);
        Dboard.setMakeTool(Dboard,BRach,0,2);
        Dboard.setMakeTool(Dboard,BRach,0,5);
        Dboard.setMakeTool(Dboard,BQueen,0,3);
        Dboard.setMakeTool(Dboard,BKing,0,4);
        Dtools[0][0]=new Tura(BTura,0,0,'B');
        Dtools[0][7]=new Tura(BTura,0,7,'B');
        Dtools[0][1]=new Horse(BHorse,0,1,'B');
        Dtools[0][6]=new Horse(BHorse,0,6,'B');
        Dtools[0][2]=new Rach(BRach,0,2,'B');
        Dtools[0][5]=new Rach(BRach,0,5,'B');
        Dtools[0][3]=new Queen(BQueen,0,3,'B');
        Dtools[0][4]=new King(BKing,0,4,'B');
        // מלך מלכה רץ סוס וטורה שחורים של לוח דמה

        Dboard.setMakeTool(Dboard,WTura,7,0);
        Dboard.setMakeTool(Dboard,WTura,7,7);
        Dboard.setMakeTool(Dboard,WHorse,7,1);
        Dboard.setMakeTool(Dboard,WHorse,7,6);
        Dboard.setMakeTool(Dboard,WRach,7,2);
        Dboard.setMakeTool(Dboard,WRach,7,5);
        Dboard.setMakeTool(Dboard,WQueen,7,3);
        Dboard.setMakeTool(Dboard,WKing,7,4);
        Dtools[7][0]=new Tura(WTura,7,0,'W');
        Dtools[7][7]=new Tura(WTura,7,7,'W');
        Dtools[7][1]=new Horse(WHorse,7,1,'W');
        Dtools[7][6]=new Horse(WHorse,7,6,'W');
        Dtools[7][2]=new Rach(WRach,7,2,'W');
        Dtools[7][5]=new Rach(WRach,7,5,'W');
        Dtools[7][3]=new Queen(WQueen,7,3,'W');
        Dtools[7][4]=new King(WKing,7,4,'W');
        // מלך מלכה רץ סוס וטורה לבנים של לוח דמה
    }//מאתחל את הלוח של הכפתורים ואת הלוח של הכלים

    public static boolean ChackIfYellow(Board board){
        boolean faound = false;
        for(int i =0;i<8;i++){
            for(int j =0;j<8;j++){
                if(board.board[i][j].getBackground()== Color.yellow){
                    faound = true;
                }
            }
        }
        return faound;
    }// בודק האם כבר בחרנו חייל

    public static void Clean(Board board){
        for(int i =0;i<8;i++){
            for(int j =0;j<8;j++){
                if(board.board[i][j].getBackground()== Color.yellow||board.board[i][j].getBackground()== Color.green||board.board[i][j].getBackground()== Color.cyan){
                    if((i%2==0&& j%2==0)||(i%2==1&& j%2==1)){
                        board.board[i][j].setBackground(Color.white);
                    }
                    else{
                        board.board[i][j].setBackground(Color.DARK_GRAY);
                    }
                }
            }
        }
    }//מנקה את הבחירה הקודמת

    public static void Klik(ActionEvent e,int tor,Board board,Tool[][] tools,boolean[][] CantGoThereW,boolean[][] CantGoThereB,Board DBoard,Tool[][] Dtools,boolean[][] ProtectedW,boolean[][] ProtectedB,boolean chess,boolean[][] ifShild,ImageIcon[] SwichToolW,ImageIcon[] SwichToolB,int count){
        ChackIfKingCanGoThere(DBoard,Dtools,tor,CantGoThereW,CantGoThereB,ProtectedW,ProtectedB);
        boolean faound = ChackIfYellow(board);
        int a =0;int b=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(e.getSource()==board.board[i][j]&&board.board[i][j].getIcon()!=null&&!faound&&tor==0&&tools[i][j].getColor()=='W'){
                    if(tools[i][j] instanceof King){
                        board.board[i][j].setBackground(Color.yellow);
                        ((King)tools[i][j]).CanMove(board,tools[i][j],tools,CantGoThereW,ProtectedW,ProtectedB,chess);
                        ChackIfShild(board,tools,DBoard,Dtools,tor,ifShild,i,j,ProtectedW,ProtectedB,SwichToolW,SwichToolB,count);
                        CleanShild(board,ifShild);
                    }
                    else{
                        board.board[i][j].setBackground(Color.yellow);
                        (tools[i][j]).CanMove(board,(tools[i][j]),tools,ProtectedW);
                        ChackIfShild(board,tools,DBoard,Dtools,tor,ifShild,i,j,ProtectedW,ProtectedB,SwichToolW,SwichToolB,count);
                        CleanShild(board,ifShild);
                    }
                }// תור של שחקן לבן
                if(e.getSource()==board.board[i][j]&&board.board[i][j].getIcon()!=null&&!faound&&tor==1&&tools[i][j].getColor()=='B'){
                    if(tools[i][j] instanceof King){
                        board.board[i][j].setBackground(Color.yellow);
                        ((King)tools[i][j]).CanMove(board,tools[i][j],tools,CantGoThereB,ProtectedW,ProtectedB,chess);
                        ChackIfShild(board,tools,DBoard,Dtools,tor,ifShild,i,j,ProtectedW,ProtectedB,SwichToolW,SwichToolB,count);
                        CleanShild(board,ifShild);
                    }
                    else{
                        board.board[i][j].setBackground(Color.yellow);
                        (tools[i][j]).CanMove(board,(tools[i][j]),tools,ProtectedB);
                        ChackIfShild(board,tools,DBoard,Dtools,tor,ifShild,i,j,ProtectedW,ProtectedB,SwichToolW,SwichToolB,count);
                        CleanShild(board,ifShild);
                    }
                }// תור של שחקן שחור
                else if(e.getSource()==board.board[i][j]&&(faound||board.board[i][j].getIcon()==null)){
                    Clean(board);
                }// מנקה בחירה ראשונה
            }
        }
    }// פונקצית לחיצה השחקו לוחץ על חייל ויופיעו הצעדים האפשריים של השחקן

    public static int Move(ActionEvent e,int tor,Board board,Tool[][] tools,Board Dboard,Tool[][] Dtools,int chooseTool,ImageIcon[] ChangeSoldierW,ImageIcon[] ChangeSoldierB,ChangeSoldier changeSoldierW,ChangeSoldier changeSoldierB){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board.board[i][j].getBackground()==Color.yellow&&board.board[i][j].getIcon()!=null) {
                    for(int m=0;m<8;m++){
                        for(int n=0;n<8;n++){
                            if(e.getSource()==board.board[m][n]&&((board.board[m][n].getBackground()==Color.green&&board.board[m][n].getIcon()!=null||board.board[m][n].getBackground()==Color.yellow&&board.board[m][n].getIcon()==null))){
                                board.board[m][n].setIcon(board.board[i][j].getIcon());
                                board.board[i][j].setIcon(null);
                                Dboard.board[m][n].setIcon(Dboard.board[i][j].getIcon());
                                Dboard.board[i][j].setIcon(null);
                                if(tools[i][j] instanceof Soldier){
                                    tools[m][n] =new Soldier(tools,i,j);
                                    tools[m][n].setRow(m);
                                    tools[m][n].setCol(n);
                                    tools[m][n].setAlreadyMove();
                                    tools[i][j] = null;
                                    Dtools[m][n] = new Soldier(Dtools,i,j);
                                    Dtools[m][n].setRow(m);
                                    Dtools[m][n].setCol(n);
                                    Dtools[m][n].setAlreadyMove();
                                    Dtools[i][j] = null;
                                    ChangeSoldier(board,tools,Dboard,Dtools,ChangeSoldierW,ChangeSoldierB,changeSoldierW,changeSoldierB);
                                }//משנה מיקום של חייל
                                else if(tools[i][j] instanceof Rach){
                                    tools[m][n] =new Rach(tools,i,j);
                                    tools[m][n].setRow(m);
                                    tools[m][n].setCol(n);
                                    tools[i][j] = null;
                                    Dtools[m][n] =new Rach(Dtools,i,j);
                                    Dtools[m][n].setRow(m);
                                    Dtools[m][n].setCol(n);
                                    Dtools[i][j] = null;
                                }//משנה מיקום של רץ
                                else if(tools[i][j] instanceof Tura){
                                    tools[m][n] =new Tura(tools,i,j);
                                    tools[m][n].setRow(m);
                                    tools[m][n].setCol(n);
                                    tools[m][n].setAlreadyMove();
                                    tools[i][j] = null;
                                    Dtools[m][n] =new Tura(Dtools,i,j);
                                    Dtools[m][n].setRow(m);
                                    Dtools[m][n].setCol(n);
                                    Dtools[m][n].setAlreadyMove();
                                    Dtools[i][j] = null;
                                }//משנה מיקום של טורה
                                else if(tools[i][j] instanceof Queen){
                                    tools[m][n] =new Queen(tools,i,j);
                                    tools[m][n].setRow(m);
                                    tools[m][n].setCol(n);
                                    tools[i][j] = null;
                                    Dtools[m][n] =new Queen(Dtools,i,j);
                                    Dtools[m][n].setRow(m);
                                    Dtools[m][n].setCol(n);
                                    Dtools[i][j] = null;
                                }//משנה מיקום של מלכה
                                else if(tools[i][j] instanceof Horse){
                                    tools[m][n] =new Horse(tools,i,j);
                                    tools[m][n].setRow(m);
                                    tools[m][n].setCol(n);
                                    tools[i][j] = null;
                                    Dtools[m][n] =new Horse(Dtools,i,j);
                                    Dtools[m][n].setRow(m);
                                    Dtools[m][n].setCol(n);
                                    Dtools[i][j] = null;
                                }//משנה מיקום של סוס
                                else if(tools[i][j] instanceof King){
                                    tools[m][n] =new King(tools,i,j);
                                    tools[m][n].setRow(m);
                                    tools[m][n].setCol(n);
                                    tools[m][n].setAlreadyMove();
                                    tools[i][j] = null;
                                    Dtools[m][n] =new King(Dtools,i,j);
                                    Dtools[m][n].setRow(m);
                                    Dtools[m][n].setCol(n);
                                    Dtools[m][n].setAlreadyMove();
                                    Dtools[i][j] = null;
                                }//משנה מיוקם של מלך
                                Clean(board);
                                if(tor ==1){
                                    tor =0;
                                }//משנה את התור לשחקן הראשון
                                else{
                                    tor =1;
                                }//משנה את התור לשחקן השני
                                return tor;
                            }//בודק האם לחץ על מקום בצבע צהוב או האם לחץ על מקום בצבע ירוק
                            // לזכור בעיה : בצד ימין של המסך אם לוחצים על המלך וטורה פועלת ואז רוצים להזיז רק את המלך יזיז את הטורה כי בחיפוש המערך מוצא אותה לפני המלך
                            else if(e.getSource()==board.board[m][n]&&board.board[m][n].getBackground()==Color.cyan&&board.board[m][n].getIcon()!=null){
                               if(tools[m][n].getColor()=='W'){
                                   if(tools[m][n] instanceof Tura){
                                       if(m == 7&& n == 0){
                                           board.board[7][3].setIcon(board.board[m][n].getIcon());
                                           board.board[m][n].setIcon(null);
                                           Dboard.board[7][3].setIcon(Dboard.board[m][n].getIcon());
                                           Dboard.board[m][n].setIcon(null);
                                           tools[7][3] = new Tura(tools,m,n);
                                           tools[7][3].setRow(7);
                                           tools[7][3].setCol(3);
                                           tools[7][3].setAlreadyMove();
                                           tools[m][n] = null;
                                           Dtools[7][3] = new Tura(Dtools,m,n);
                                           Dtools[7][3].setRow(7);
                                           Dtools[7][3].setCol(3);
                                           Dtools[7][3].setAlreadyMove();
                                           Dtools[m][n] = null;
                                           board.board[7][2].setIcon(board.board[7][4].getIcon());
                                           board.board[7][4].setIcon(null);
                                           Dboard.board[7][2].setIcon(Dboard.board[7][4].getIcon());
                                           Dboard.board[7][4].setIcon(null);
                                           tools[7][2] = new King(tools,7,4);
                                           tools[7][2].setRow(7);
                                           tools[7][2].setCol(2);
                                           tools[7][2].setAlreadyMove();
                                           tools[7][4] = null;
                                           Dtools[7][2] = new King(Dtools,7,4);
                                           Dtools[7][2].setRow(7);
                                           Dtools[7][2].setCol(2);
                                           Dtools[7][2].setAlreadyMove();
                                           Dtools[7][4] = null;
                                           Clean(board);
                                           if(tor ==1){
                                               tor =0;
                                           }//משנה את התור לשחקן הראשון
                                           else{
                                               tor =1;
                                           }//משנה את התור לשחקן השני
                                           return tor;
                                       }// עושה הצרכה ללבן [7,0]
                                       else if(m == 7&& n == 7){
                                           board.board[7][5].setIcon(board.board[m][n].getIcon());
                                           board.board[m][n].setIcon(null);
                                           Dboard.board[7][5].setIcon(Dboard.board[m][n].getIcon());
                                           Dboard.board[m][n].setIcon(null);
                                           tools[7][5] = new Tura(tools,m,n);
                                           tools[7][5].setRow(7);
                                           tools[7][5].setCol(5);
                                           tools[7][5].setAlreadyMove();
                                           tools[m][n] = null;
                                           Dtools[7][5] = new Tura(Dtools,m,n);
                                           Dtools[7][5].setRow(7);
                                           Dtools[7][5].setCol(5);
                                           Dtools[7][5].setAlreadyMove();
                                           Dtools[m][n] = null;
                                           board.board[7][6].setIcon(board.board[7][4].getIcon());
                                           board.board[7][4].setIcon(null);
                                           Dboard.board[7][6].setIcon(Dboard.board[7][4].getIcon());
                                           Dboard.board[7][4].setIcon(null);
                                           tools[7][6] = new King(tools,7,4);
                                           tools[7][6].setRow(7);
                                           tools[7][6].setCol(6);
                                           tools[7][6].setAlreadyMove();
                                           tools[7][4] = null;
                                           Dtools[7][6] = new King(Dtools,7,4);
                                           Dtools[7][6].setRow(7);
                                           Dtools[7][6].setCol(6);
                                           Dtools[7][6].setAlreadyMove();
                                           Dtools[7][4] = null;
                                           Clean(board);
                                           if(tor ==1){
                                               tor =0;
                                           }//משנה את התור לשחקן הראשון
                                           else{
                                               tor =1;
                                           }//משנה את התור לשחקן השני
                                           return tor;
                                       }// עושה הצרכה ללבן [7,7]
                                   }
                               }// הצרכה ללבן
                               else if(tools[m][n].getColor()=='B'){
                                   if(tools[m][n] instanceof Tura){
                                       if(m == 0&& n == 0){
                                           board.board[0][3].setIcon(board.board[m][n].getIcon());
                                           board.board[m][n].setIcon(null);
                                           Dboard.board[0][3].setIcon(Dboard.board[m][n].getIcon());
                                           Dboard.board[m][n].setIcon(null);
                                           tools[0][3] = new Tura(tools,m,n);
                                           tools[0][3].setRow(0);
                                           tools[0][3].setCol(3);
                                           tools[m][n].setAlreadyMove();
                                           tools[m][n] = null;
                                           Dtools[0][3] = new Tura(Dtools,m,n);
                                           Dtools[0][3].setRow(0);
                                           Dtools[0][3].setCol(3);
                                           Dtools[m][n].setAlreadyMove();
                                           Dtools[m][n] = null;
                                           board.board[0][2].setIcon(board.board[0][4].getIcon());
                                           board.board[0][4].setIcon(null);
                                           Dboard.board[0][2].setIcon(Dboard.board[0][4].getIcon());
                                           Dboard.board[0][4].setIcon(null);
                                           tools[0][2] = new King(tools,0,4);
                                           tools[0][2].setRow(0);
                                           tools[0][2].setCol(2);
                                           tools[0][2].setAlreadyMove();
                                           tools[0][4] = null;
                                           Dtools[0][2] = new King(Dtools,0,4);
                                           Dtools[0][2].setRow(0);
                                           Dtools[0][2].setCol(2);
                                           Dtools[0][2].setAlreadyMove();
                                           Dtools[0][4] = null;
                                           Clean(board);
                                           if(tor ==1){
                                               tor =0;
                                           }//משנה את התור לשחקן הראשון
                                           else{
                                               tor =1;
                                           }//משנה את התור לשחקן השני
                                           return tor;
                                       }// עושה הצרכה לשחור [0,0]
                                       else if(m == 0&& n == 7){
                                           board.board[0][5].setIcon(board.board[m][n].getIcon());
                                           board.board[m][n].setIcon(null);
                                           Dboard.board[0][5].setIcon(Dboard.board[m][n].getIcon());
                                           Dboard.board[m][n].setIcon(null);
                                           tools[0][5] = new Tura(tools,m,n);
                                           tools[0][5].setRow(0);
                                           tools[0][5].setCol(5);
                                           tools[m][n].setAlreadyMove();
                                           tools[m][n] = null;
                                           Dtools[0][5] = new Tura(Dtools,m,n);
                                           Dtools[0][5].setRow(0);
                                           Dtools[0][5].setCol(5);
                                           Dtools[m][n].setAlreadyMove();
                                           Dtools[m][n] = null;
                                           board.board[0][6].setIcon(board.board[0][4].getIcon());
                                           board.board[0][4].setIcon(null);
                                           Dboard.board[0][6].setIcon(Dboard.board[0][4].getIcon());
                                           Dboard.board[0][4].setIcon(null);
                                           tools[0][6] = new King(tools,0,4);
                                           tools[0][6].setRow(0);
                                           tools[0][6].setCol(6);
                                           tools[0][6].setAlreadyMove();
                                           tools[0][4] = null;
                                           Dtools[0][6] = new King(Dtools,0,4);
                                           Dtools[0][6].setRow(0);
                                           Dtools[0][6].setCol(6);
                                           Dtools[0][6].setAlreadyMove();
                                           Dtools[0][4] = null;
                                           Clean(board);
                                           if(tor ==1){
                                               tor =0;
                                           }//משנה את התור לשחקן הראשון
                                           else{
                                               tor =1;
                                           }//משנה את התור לשחקן השני
                                           return tor;
                                       }// עושה הצרכה לשחור [0,7]
                                   }
                               }// הצרכה לשחור
                            }//הצרכה
                        }
                    }
                }//בודק האם יש חייל שהרקע שלו צהוב
            }
        }
        return tor;
    }//פונקציה שמזיזה כלי למקום הרצוי או אוכלת כלי אחר

    public static boolean Chess(int tor,Board DBoard,Tool[][] Dtools,boolean[][] ProtectedW,boolean[][] ProtectedB){
        boolean faound = false;
        boolean faound2 = false;
        for(int m = 0;m<8;m++){
            for(int n =0;n<8;n++){
                if(DBoard.board[m][n].getIcon()!=null&&tor==1&&Dtools[m][n].getColor()=='W'){
                    DBoard.board[m][n].setBackground(Color.yellow);
                    Dtools[m][n].CanMove(DBoard,Dtools[m][n],Dtools,ProtectedW);
                    faound = ChackIfKingGreen(DBoard,Dtools);
                    if(faound){
                        faound2= true;
                    }
                    Clean(DBoard);
                }//בודק האם השחקן הלבן עושה שח
                else if(DBoard.board[m][n].getIcon()!=null&&tor==0&&Dtools[m][n].getColor()=='B'){
                    DBoard.board[m][n].setBackground(Color.yellow);
                    Dtools[m][n].CanMove(DBoard,Dtools[m][n],Dtools,ProtectedB);
                    faound = ChackIfKingGreen(DBoard,Dtools);
                    if(faound){
                        faound2= true;
                    }
                    Clean(DBoard);
                }// בודק האם השחקן השחור עושה שח
            }
        }
        return faound2;
    }// בודק האם יש שח

    public static boolean ChackIfKingGreen(Board Dboard,Tool[][] Dtools){
        for(int i =0;i<8;i++){
            for(int j=0;j<8;j++){
                if(Dboard.board[i][j].getBackground()==Color.green){
                    if(Dtools[i][j] instanceof King){
                        return true;
                    }
                }
            }
        }
        return false;
    }// בודק האם המלך מאוים

    public static void ChackIfKingCanGoThere(Board board,Tool[][] tools,int tor,boolean[][] CantGoThereW,boolean[][] CantGoThereB,boolean[][] ProtectedW,boolean[][] ProtectedB){
        for(int m=0;m<8;m++){
            for(int n=0;n<8;n++){
                if(tor==1){
                    CantGoThereB[m][n]=false;
                    ProtectedW[m][n] = false;
                }//מאפס את המערך השחור
                else if(tor ==0){
                    CantGoThereW[m][n]=false;
                    ProtectedB[m][n] = false;
                }//מאפס את המערך הלהבן
            }
        }// מאפס מערכים לפני כל תור
        for(int i =0;i<8;i++){
            for(int j =0;j<8;j++){
                if(tor == 0){
                    if(board.board[i][j].getIcon()!=null&&tools[i][j].getColor()=='B'){
                        if(tools[i][j] instanceof Soldier){
                            board.board[i][j].setBackground(Color.yellow);
                            tools[i][j].CanMove(board,tools[i][j],tools,ProtectedB);
                            Clean(board);
                            if(i<7&&j<7&&board.board[i+1][j+1].getIcon()==null){
                                CantGoThereW[i+1][j+1]=true;
                            }
                            if(i<7&&j>0&&board.board[i+1][j-1].getIcon()==null){
                                CantGoThereW[i+1][j-1]=true;
                            }
                        }// בודק מקומות שחייל מגן עליו
                        else if(tools[i][j] instanceof King){
                            if(tools[i][j].getCol()<6){
                                if(tools[i][j+2] instanceof King){
                                    if(board.board[i][j+1].getIcon()==null){
                                        CantGoThereW[i][j+1]=true;
                                    }
                                    if(tools[i][j].getRow()<=6&&board.board[i+1][j+1].getIcon()==null){
                                        CantGoThereW[i+1][j+1]=true;
                                    }
                                    if(tools[i][j].getRow()>0&&board.board[i-1][j+1].getIcon()==null){
                                        CantGoThereW[i-1][j+1]=true;
                                    }
                                }
                                if(tools[i][j].getRow()<7){
                                    if(tools[i+1][j+2] instanceof King){
                                        if(board.board[i+1][j+1].getIcon()==null){
                                            CantGoThereW[i+1][j+1]=true;
                                        }
                                        if(board.board[i][j+1].getIcon()==null){
                                            CantGoThereW[i][j+1]=true;
                                        }
                                    }
                                }
                                if(tools[i][j].getRow()>0){
                                    if(tools[i-1][j+2] instanceof King){
                                        if(board.board[i][j+1].getIcon()==null){
                                            CantGoThereW[i][j+1]=true;
                                        }
                                        if(board.board[i-1][j+1].getIcon()==null){
                                            CantGoThereW[i-1][j+1]=true;
                                        }
                                    }
                                }
                            }
                            if(tools[i][j].getCol()>1){
                                if(tools[i][j-2] instanceof King){
                                    if(board.board[i][j-1].getIcon()==null){
                                        CantGoThereW[i][j-1]=true;
                                    }
                                    if(tools[i][j].getRow()<=6&&board.board[i+1][j-1].getIcon()==null){
                                        CantGoThereW[i+1][j-1]=true;
                                    }
                                    if(tools[i][j].getRow()>0&&board.board[i-1][j-1].getIcon()==null){
                                        CantGoThereW[i-1][j-1]=true;
                                    }
                                }
                                if(tools[i][j].getRow()<7){
                                    if(tools[i+1][j-2] instanceof King){
                                        if(board.board[i+1][j-1].getIcon()==null){
                                            CantGoThereW[i+1][j-1]=true;
                                        }
                                        if(board.board[i][j-1].getIcon()==null){
                                            CantGoThereW[i][j-1]=true;
                                        }
                                    }
                                }
                                if(tools[i][j].getRow()>0){
                                    if(tools[i-1][j-2] instanceof King){
                                        if(board.board[i][j-1].getIcon()==null){
                                            CantGoThereW[i][j-1]=true;
                                        }
                                        if(board.board[i-1][j-1].getIcon()==null){
                                            CantGoThereW[i-1][j-1]=true;
                                        }
                                    }
                                }
                            }
                            if(tools[i][j].getRow()<6){
                                if(tools[i+2][j] instanceof King){
                                    if(board.board[i+1][j].getIcon()==null){
                                        CantGoThereW[i+1][j]=true;
                                    }
                                    if(tools[i][j].getCol()<=6&&board.board[i+1][j+1].getIcon()==null){
                                        CantGoThereW[i+1][j+1]=true;
                                    }
                                    if(tools[i][j].getCol()>0&&board.board[i+1][j-1].getIcon()==null){
                                        CantGoThereW[i+1][j-1]=true;
                                    }
                                }
                                if(tools[i][j].getCol()<7){
                                    if(tools[i+2][j+1] instanceof King){
                                        if(board.board[i+1][j+1].getIcon()==null){
                                            CantGoThereW[i+1][j+1]=true;
                                        }
                                        if(board.board[i+1][j].getIcon()==null){
                                            CantGoThereW[i+1][j]=true;
                                        }
                                    }
                                }
                                if(tools[i][j].getCol()>0){
                                    if(tools[i+2][j-1] instanceof King){
                                        if(board.board[i+1][j].getIcon()==null){
                                            CantGoThereW[i+1][j]=true;
                                        }
                                        if(board.board[i+1][j-1].getIcon()==null){
                                            CantGoThereW[i+1][j-1]=true;
                                        }
                                    }
                                }
                            }
                            if(tools[i][j].getRow()>1){
                                if(tools[i-2][j] instanceof King){
                                    if(board.board[i-1][j].getIcon()==null){
                                        CantGoThereW[i-1][j]=true;
                                    }
                                    if(tools[i][j].getCol()<=6&&board.board[i-1][j+1].getIcon()==null){
                                        CantGoThereW[i-1][j+1]=true;
                                    }
                                    if(tools[i][j].getCol()>0&&board.board[i-1][j-1].getIcon()==null){
                                        CantGoThereW[i-1][j-1]=true;
                                    }
                                }
                                if(tools[i][j].getCol()<7){
                                    if(tools[i-2][j+1] instanceof King){
                                        if(board.board[i-1][j+1].getIcon()==null){
                                            CantGoThereW[i-1][j+1]=true;
                                        }
                                        if(board.board[i-1][j].getIcon()==null){
                                            CantGoThereW[i-1][j]=true;
                                        }
                                    }
                                }
                                if(tools[i][j].getCol()>0){
                                    if(tools[i-2][j-1] instanceof King){
                                        if(board.board[i-1][j].getIcon()==null){
                                            CantGoThereW[i-1][j]=true;
                                        }
                                        if(board.board[i-1][j-1].getIcon()==null){
                                            CantGoThereW[i-1][j-1]=true;
                                        }
                                    }
                                }
                            }
                            if(tools[i][j].getRow()<6){
                                if(tools[i][j].getCol()<6){
                                    if(tools[i+2][j+2] instanceof King){
                                        if(board.board[i+1][j+1].getIcon()==null){
                                            CantGoThereW[i+1][j+1]=true;
                                        }
                                    }
                                }
                                if(tools[i][j].getCol()>1){
                                    if(tools[i+2][j-2] instanceof King){
                                        if(board.board[i+1][j-1].getIcon()==null){
                                            CantGoThereW[i+1][j-1]=true;
                                        }
                                    }
                                }
                            }
                            if(tools[i][j].getRow()>1){
                                if(tools[i][j].getCol()<6){
                                    if(tools[i-2][j+2] instanceof King){
                                        if(board.board[i-1][j+1].getIcon()==null){
                                            CantGoThereW[i-1][j+1]=true;
                                        }
                                    }
                                }
                                if(tools[i][j].getCol()>1){
                                    if(tools[i-2][j-2] instanceof King){
                                        if(board.board[i-1][j-1].getIcon()==null){
                                            CantGoThereW[i-1][j-1]=true;
                                        }
                                    }
                                }
                            }
                            Clean(board);
                        }// בודק מקומות שמלך מגן עליו
                        else{
                            board.board[i][j].setBackground(Color.yellow);
                            tools[i][j].CanMove(board,tools[i][j],tools,ProtectedB);
                            for(int m =0;m<8;m++){
                                for(int n=0;n<8;n++){
                                    if(board.board[m][n].getBackground()==Color.yellow){
                                        CantGoThereW[m][n]=true;
                                    }
                                }
                            }
                            Clean(board);
                        }// בודק מקומות שכלי שהוא לא מלך ולא חייל מגן עליו
                    }
                }// בודק איפה כלים שחור מאיימים
                else if(tor == 1){
                    if(board.board[i][j].getIcon()!=null&&tools[i][j].getColor()=='W'){
                        if(tools[i][j] instanceof Soldier){
                            tools[i][j].CanMove(board,tools[i][j],tools,ProtectedB);
                            Clean(board);
                            if(i>0&&j<7&&board.board[i-1][j+1].getIcon()==null){
                                CantGoThereB[i-1][j+1]=true;
                            }
                            if(i>0&&j>0&&board.board[i-1][j-1].getIcon()==null){
                                CantGoThereB[i-1][j-1]=true;
                            }
                        }// בודק מקומות שחייל מגן עליו
                        else if(tools[i][j] instanceof King){
                            if(tools[i][j].getCol()<6){
                                if(tools[i][j+2] instanceof King){
                                    if(board.board[i][j+1].getIcon()==null){
                                        CantGoThereB[i][j+1]=true;
                                    }
                                    if(tools[i][j].getRow()<=6&&board.board[i+1][j+1].getIcon()==null){
                                        CantGoThereB[i+1][j+1]=true;
                                    }
                                    if(tools[i][j].getRow()>0&&board.board[i-1][j+1].getIcon()==null){
                                        CantGoThereB[i-1][j+1]=true;
                                    }
                                }
                                if(tools[i][j].getRow()<7){
                                    if(tools[i+1][j+2] instanceof King){
                                        if(board.board[i+1][j+1].getIcon()==null){
                                            CantGoThereB[i+1][j+1]=true;
                                        }
                                        if(board.board[i][j+1].getIcon()==null){
                                            CantGoThereB[i][j+1]=true;
                                        }
                                    }
                                }
                                if(tools[i][j].getRow()>0){
                                    if(tools[i-1][j+2] instanceof King){
                                        if(board.board[i][j+1].getIcon()==null){
                                            CantGoThereB[i][j+1]=true;
                                        }
                                        if(board.board[i-1][j+1].getIcon()==null){
                                            CantGoThereB[i-1][j+1]=true;
                                        }
                                    }
                                }
                            }
                            if(tools[i][j].getCol()>1){
                                if(tools[i][j-2] instanceof King){
                                    if(board.board[i][j-1].getIcon()==null){
                                        CantGoThereB[i][j-1]=true;
                                    }
                                    if(tools[i][j].getRow()<=6&&board.board[i+1][j-1].getIcon()==null){
                                        CantGoThereB[i+1][j-1]=true;
                                    }
                                    if(tools[i][j].getRow()>0&&board.board[i-1][j-1].getIcon()==null){
                                        CantGoThereB[i-1][j-1]=true;
                                    }
                                }
                                if(tools[i][j].getRow()<7){
                                    if(tools[i+1][j-2] instanceof King){
                                        if(board.board[i+1][j-1].getIcon()==null){
                                            CantGoThereB[i+1][j-1]=true;
                                        }
                                        if(board.board[i][j-1].getIcon()==null){
                                            CantGoThereB[i][j-1]=true;
                                        }
                                    }
                                }
                                if(tools[i][j].getRow()>0){
                                    if(tools[i-1][j-2] instanceof King){
                                        if(board.board[i][j-1].getIcon()==null){
                                            CantGoThereB[i][j-1]=true;
                                        }
                                        if(board.board[i-1][j-1].getIcon()==null){
                                            CantGoThereB[i-1][j-1]=true;
                                        }
                                    }
                                }
                            }
                            if(tools[i][j].getRow()<6){
                                if(tools[i+2][j] instanceof King){
                                    if(board.board[i+1][j].getIcon()==null){
                                        CantGoThereB[i+1][j]=true;
                                    }
                                    if(tools[i][j].getCol()<=6&&board.board[i+1][j+1].getIcon()==null){
                                        CantGoThereB[i+1][j+1]=true;
                                    }
                                    if(tools[i][j].getCol()>0&&board.board[i+1][j-1].getIcon()==null){
                                        CantGoThereB[i+1][j-1]=true;
                                    }
                                }
                                if(tools[i][j].getCol()<7){
                                    if(tools[i+2][j+1] instanceof King){
                                        if(board.board[i+1][j+1].getIcon()==null){
                                            CantGoThereB[i+1][j+1]=true;
                                        }
                                        if(board.board[i+1][j].getIcon()==null){
                                            CantGoThereB[i+1][j]=true;
                                        }
                                    }
                                }
                                if(tools[i][j].getCol()>0){
                                    if(tools[i+2][j-1] instanceof King){
                                        if(board.board[i+1][j].getIcon()==null){
                                            CantGoThereB[i+1][j]=true;
                                        }
                                        if(board.board[i+1][j-1].getIcon()==null){
                                            CantGoThereB[i+1][j-1]=true;
                                        }
                                    }
                                }
                            }
                            if(tools[i][j].getRow()>1){
                                if(tools[i-2][j] instanceof King){
                                    if(board.board[i-1][j].getIcon()==null){
                                        CantGoThereB[i-1][j]=true;
                                    }
                                    if(tools[i][j].getCol()<=6&&board.board[i-1][j+1].getIcon()==null){
                                        CantGoThereB[i-1][j+1]=true;
                                    }
                                    if(tools[i][j].getCol()>0&&board.board[i-1][j-1].getIcon()==null){
                                        CantGoThereB[i-1][j-1]=true;
                                    }
                                }
                                if(tools[i][j].getCol()<7){
                                    if(tools[i-2][j+1] instanceof King){
                                        if(board.board[i-1][j+1].getIcon()==null){
                                            CantGoThereB[i-1][j+1]=true;
                                        }
                                        if(board.board[i-1][j].getIcon()==null){
                                            CantGoThereB[i-1][j]=true;
                                        }
                                    }
                                }
                                if(tools[i][j].getCol()>0){
                                    if(tools[i-2][j-1] instanceof King){
                                        if(board.board[i-1][j].getIcon()==null){
                                            CantGoThereB[i-1][j]=true;
                                        }
                                        if(board.board[i-1][j-1].getIcon()==null){
                                            CantGoThereB[i-1][j-1]=true;
                                        }
                                    }
                                }
                            }
                            if(tools[i][j].getRow()<6){
                                if(tools[i][j].getCol()<6){
                                    if(tools[i+2][j+2] instanceof King){
                                        if(board.board[i+1][j+1].getIcon()==null){
                                            CantGoThereB[i+1][j+1]=true;
                                        }
                                    }
                                }
                                if(tools[i][j].getCol()>1){
                                    if(tools[i+2][j-2] instanceof King){
                                        if(board.board[i+1][j-1].getIcon()==null){
                                            CantGoThereB[i+1][j-1]=true;
                                        }
                                    }
                                }
                            }
                            if(tools[i][j].getRow()>1){
                                if(tools[i][j].getCol()<6){
                                    if(tools[i-2][j+2] instanceof King){
                                        if(board.board[i-1][j+1].getIcon()==null){
                                            CantGoThereB[i-1][j+1]=true;
                                        }
                                    }
                                }
                                if(tools[i][j].getCol()>1){
                                    if(tools[i-2][j-2] instanceof King){
                                        if(board.board[i-1][j-1].getIcon()==null){
                                            CantGoThereB[i-1][j-1]=true;
                                        }
                                    }
                                }
                            }
                            Clean(board);
                        }// בודק מקומות שמלך מגן עליו
                        else{
                            board.board[i][j].setBackground(Color.yellow);
                            tools[i][j].CanMove(board,tools[i][j],tools,ProtectedW);
                            for(int m =0;m<8;m++){
                                for(int n=0;n<8;n++){
                                    if(board.board[m][n].getBackground()==Color.yellow){
                                        CantGoThereB[m][n]=true;
                                    }
                                }
                            }
                            Clean(board);
                        }// בודק מקומות שכלי שהוא לא מלך ולא חייל מגן עליו
                    }
                }// בודק איפה כלים לבן מאיימים
            }
        }
    }// בודק איפה המלך יכול ללכת ואיפה וגם בודק אם המלך יכול לאכול או לא

    public static void ChangeSoldier(Board board,Tool[][] tools,Board Dboard,Tool[][] Dtools,ImageIcon[] ChangeSoldierW,ImageIcon[] ChangeSoldierB,ChangeSoldier changeSoldierW,ChangeSoldier changeSoldierB){
        for(int i =0;i<7;i++){
            if(tools[0][i] instanceof Soldier){
                changeSoldierW.setVisible(true);
                if(changeSoldierW.GetChooseOfTool()==1){
                    board.board[0][i].setIcon(ChangeSoldierW[0]);
                    Dboard.board[0][i].setIcon(ChangeSoldierW[0]);
                    tools[0][i] = new Queen(tools,0,i);
                    Dtools[0][i] = new Queen(tools,0,i);
                    changeSoldierW.setVisible(false);
                }// הופך למלכה
                else if(changeSoldierW.GetChooseOfTool()==2){
                    board.board[0][i].setIcon(ChangeSoldierW[1]);
                    Dboard.board[0][i].setIcon(ChangeSoldierW[1]);
                    tools[0][i] = new Rach(tools,0,i);
                    Dtools[0][i] = new Rach(tools,0,i);
                    changeSoldierW.setVisible(false);
                }//הופך לרץ
                else if(changeSoldierW.GetChooseOfTool()==3){
                    board.board[0][i].setIcon(ChangeSoldierW[2]);
                    Dboard.board[0][i].setIcon(ChangeSoldierW[2]);
                    tools[0][i] = new Tura(tools,0,i);
                    Dtools[0][i] = new Tura(tools,0,i);
                    changeSoldierW.setVisible(false);
                }//הופך לטורה
                else if(changeSoldierW.GetChooseOfTool()==4){
                    board.board[0][i].setIcon(ChangeSoldierW[3]);
                    Dboard.board[0][i].setIcon(ChangeSoldierW[3]);
                    tools[0][i] = new Horse(tools,0,i);
                    Dtools[0][i] = new Horse(tools,0,i);
                    changeSoldierW.setVisible(false);
                }//הופך לסוס
            }
            if(tools[7][i] instanceof Soldier){
                changeSoldierB.setVisible(true);
                if(changeSoldierB.GetChooseOfTool()==1){
                    board.board[7][i].setIcon(ChangeSoldierB[0]);
                    Dboard.board[7][i].setIcon(ChangeSoldierB[0]);
                    tools[7][i] = new Queen(tools,7,i);
                    Dtools[7][i] = new Queen(tools,7,i);
                    changeSoldierB.setVisible(false);
                }// הופך למלכה
                else if(changeSoldierB.GetChooseOfTool()==2){
                    board.board[7][i].setIcon(ChangeSoldierB[1]);
                    Dboard.board[7][i].setIcon(ChangeSoldierB[1]);
                    tools[7][i] = new Rach(tools,7,i);
                    Dtools[7][i] = new Rach(tools,7,i);
                    changeSoldierB.setVisible(false);
                }//הופך לרץ
                else if(changeSoldierB.GetChooseOfTool()==3){
                    board.board[7][i].setIcon(ChangeSoldierB[2]);
                    Dboard.board[7][i].setIcon(ChangeSoldierB[2]);
                    tools[7][i] = new Tura(tools,7,i);
                    Dtools[7][i] = new Tura(tools,7,i);
                    changeSoldierB.setVisible(false);
                }//הופך לטורה
                else if(changeSoldierB.GetChooseOfTool()==4){
                    board.board[7][i].setIcon(ChangeSoldierB[3]);
                    Dboard.board[7][i].setIcon(ChangeSoldierB[3]);
                    tools[7][i] = new Horse(tools,7,i);
                    Dtools[7][i] = new Horse(tools,7,i);
                    changeSoldierB.setVisible(false);
                }//הופך לסוס
            }
        }
    }//הופך חייל שהגיע לסוף לכלי אחר

    public static void ChackIfShild(Board board,Tool[][] tools,Board Dboard,Tool[][] Dtools,int tor,boolean[][] ifShild,int a,int b,boolean[][] ProtectedW,boolean[][] ProtectedB,ImageIcon[] SwichToolW,ImageIcon[] SwichToolB,int count){
        boolean shild = false;
        count =0;
        for(int n=0;n<8;n++){
            for(int m=0;m<8;m++){
                ifShild[n][m]=false;
            }
        }// מאפס את המערך שאומר האם עברנו על המשבצת הזאת
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if((board.board[i][j].getBackground()==Color.green)||(board.board[i][j].getBackground()==Color.yellow&&board.board[i][j].getIcon()==null)){
                    int type= 0;
                    if(board.board[i][j].getBackground()==Color.green&&Dtools[i][j] instanceof Soldier){
                        type = 1;
                    }//בודק אם הכלי במשבצת הירוקה חייל
                    else if(board.board[i][j].getBackground()==Color.green&&Dtools[i][j] instanceof Rach){
                        type =2;
                    }//בודק אם הכלי במשבצת הירוקה רץ
                    else if(board.board[i][j].getBackground()==Color.green&&Dtools[i][j] instanceof Tura){
                        type =3;
                    }//בודק אם הכלי במשבצת הירוקה טורה
                    else if(board.board[i][j].getBackground()==Color.green&&Dtools[i][j] instanceof Queen){
                        type =4;
                    }//בודק אם הכלי במשבצת הירוקה מלכה
                    else if(board.board[i][j].getBackground()==Color.green&&Dtools[i][j] instanceof Horse){
                        type =5;
                    }//בודק אם הכלי במשבצת הירוקה סוס
                    else if(board.board[i][j].getBackground()==Color.green&&Dtools[i][j] instanceof King){
                        type =6;
                    }//בודק אם הכלי במשבצת הירוקה מלך
                    Dboard.board[i][j].setIcon(Dboard.board[a][b].getIcon());
                    Dboard.board[a][b].setIcon(null);
                    if(Dtools[a][b] instanceof Soldier){
                        Dtools[i][j] = new Soldier(Dtools,a,b);
                        Dtools[i][j].setRow(i);
                        Dtools[i][j].setCol(j);
                        Dtools[a][b] = null;
                    }//משנה מיקום של חייל
                    else if(Dtools[a][b] instanceof Rach){
                        Dtools[i][j] =new Rach(Dtools,a,b);
                        Dtools[i][j].setRow(i);
                        Dtools[i][j].setCol(j);
                        Dtools[a][b] = null;
                    }//משנה מיקום של רץ
                    else if(Dtools[a][b] instanceof Tura){
                        Dtools[i][j] =new Tura(Dtools,a,b);
                        Dtools[i][j].setRow(i);
                        Dtools[i][j].setCol(j);
                        Dtools[a][b] = null;
                    }//משנה מיקום של טורה
                    else if(Dtools[a][b] instanceof Queen){
                        Dtools[i][j] =new Queen(Dtools,a,b);
                        Dtools[i][j].setRow(i);
                        Dtools[i][j].setCol(j);
                        Dtools[a][b] = null;
                    }//משנה מיקום של מלכה
                    else if(Dtools[a][b] instanceof Horse){
                        Dtools[i][j] =new Horse(Dtools,a,b);
                        Dtools[i][j].setRow(i);
                        Dtools[i][j].setCol(j);
                        Dtools[a][b] = null;
                    }//משנה מיקום של סוס
                    else if(Dtools[a][b] instanceof King){
                        Dtools[i][j] =new King(Dtools,a,b);
                        Dtools[i][j].setRow(i);
                        Dtools[i][j].setCol(j);
                        Dtools[a][b] = null;
                    }//משנה מיוקם של מלך
                    shild=Chess(tor,Dboard,Dtools,ProtectedW,ProtectedB);
                    if(shild){
                        ifShild[i][j]=true;
                    }//הופך את המקום לtrue ובעצם אומר שלא יכול ללכת לשם
                    else{
                        count = 1;
                    }//אומר שיש לפחות אפשרות אחת של פעולה אם לא יכנס לזה בכלל יהיה שחמט
                    Dboard.board[a][b].setIcon(Dboard.board[i][j].getIcon());
                    Dboard.board[i][j].setIcon(null);
                    if(Dtools[i][j] instanceof Soldier){
                        Dtools[a][b] = new Soldier(Dtools,i,j);
                        Dtools[a][b].setRow(a);
                        Dtools[a][b].setCol(b);
                        Dtools[i][j] = null;
                    }//משנה מיקום של חייל
                    else if(Dtools[i][j] instanceof Rach){
                        Dtools[a][b] =new Rach(Dtools,i,j);
                        Dtools[a][b].setRow(a);
                        Dtools[a][b].setCol(b);
                        Dtools[i][j] = null;
                    }//משנה מיקום של רץ
                    else if(Dtools[i][j] instanceof Tura){
                        Dtools[a][b] =new Tura(Dtools,i,j);
                        Dtools[a][b].setRow(a);
                        Dtools[a][b].setCol(b);
                        Dtools[i][j] = null;
                    }//משנה מיקום של טורה
                    else if(Dtools[i][j] instanceof Queen){
                        Dtools[a][b] =new Queen(Dtools,i,j);
                        Dtools[a][b].setRow(a);
                        Dtools[a][b].setCol(b);
                        Dtools[i][j] = null;
                    }//משנה מיקום של מלכה
                    else if(Dtools[i][j] instanceof Horse){
                        Dtools[a][b] =new Horse(Dtools,i,j);
                        Dtools[a][b].setRow(a);
                        Dtools[a][b].setCol(b);
                        Dtools[i][j] = null;
                    }//משנה מיקום של סוס
                    else if(Dtools[i][j] instanceof King){
                        Dtools[a][b] =new King(Dtools,i,j);
                        Dtools[a][b].setRow(a);
                        Dtools[a][b].setCol(b);
                        Dtools[i][j] = null;
                    }//משנה מיוקם של מלך

                    if(type ==0){

                    }
                    else if(type==1){
                        if(tor==1){
                            Dboard.board[i][j].setIcon(SwichToolW[type-1]);
                            Dtools[i][j] = new Soldier(SwichToolW[type-1],i,j,'W');
                        }
                        else if(tor==0){
                            Dboard.board[i][j].setIcon(SwichToolB[type-1]);
                            Dtools[i][j] = new Soldier(SwichToolB[type-1],i,j,'B');
                        }
                    }//מחזיר חייל לקדמותו
                    else if(type==2){
                        if(tor==1){
                            Dboard.board[i][j].setIcon(SwichToolW[type-1]);
                            Dtools[i][j] = new Rach(SwichToolW[type-1],i,j,'W');
                        }
                        else if(tor==0){
                            Dboard.board[i][j].setIcon(SwichToolB[type-1]);
                            Dtools[i][j] = new Rach(SwichToolB[type-1],i,j,'B');
                        }
                    }//מחזיר רץ לקדמותו
                    else if(type==3){
                        if(tor==1){
                            Dboard.board[i][j].setIcon(SwichToolW[type-1]);
                            Dtools[i][j] = new Tura(SwichToolW[type-1],i,j,'W');
                        }
                        else if(tor==0){
                            Dboard.board[i][j].setIcon(SwichToolB[type-1]);
                            Dtools[i][j] = new Tura(SwichToolB[type-1],i,j,'B');
                        }
                    }//מחזיר טורה לקדמותו
                    else if(type==4){
                        if(tor==1){
                            Dboard.board[i][j].setIcon(SwichToolW[type-1]);
                            Dtools[i][j] = new Queen(SwichToolW[type-1],i,j,'W');
                        }
                        else if(tor==0){
                            Dboard.board[i][j].setIcon(SwichToolB[type-1]);
                            Dtools[i][j] = new Queen(SwichToolB[type-1],i,j,'B');
                        }
                    }//מחזיר מלכה לקדמותו
                    else if(type==5){
                        if(tor==1){
                            Dboard.board[i][j].setIcon(SwichToolW[type-1]);
                            Dtools[i][j] = new Horse(SwichToolW[type-1],i,j,'W');
                        }
                        else if(tor==0){
                            Dboard.board[i][j].setIcon(SwichToolB[type-1]);
                            Dtools[i][j] = new Horse(SwichToolB[type-1],i,j,'B');
                        }
                    }//מחזיר סוס לקדמותו
                    else if(type==6){
                        if(tor==1){
                            Dboard.board[i][j].setIcon(SwichToolW[type-1]);
                            Dtools[i][j] = new King(SwichToolW[type-1],i,j,'W');
                        }
                        else if(tor==0){
                            Dboard.board[i][j].setIcon(SwichToolB[type-1]);
                            Dtools[i][j] = new King(SwichToolB[type-1],i,j,'B');
                        }
                    }//מחזיר מלך לקדמותו
                }//בודק כל משבצת צהובה אם יכול ללכת לשם
            }
        }
//        if(count == 0&&tor ==0){
//            board.setVisible(false);
//            System.out.println("black win");
//            Mat mat = new Mat(tor);
//        }// בודק האם השחור ניצח
//        else if(count == 0&&tor ==1){   ///////////////////////////////////////////////////////////////// לעשות בדיקה
//            board.setVisible(false);
//            System.out.println("white win");
//            Mat mat = new Mat(tor);
//        }// בודק האם הלבן ניצח
    }// בודק להאם לחייל מותר לזוז ולאן

    public static void CleanShild(Board board,boolean[][] ifShild){
        for(int i =0;i<8;i++){
            for(int j =0;j<8;j++){
                if(board.board[i][j].getBackground()== Color.yellow||board.board[i][j].getBackground()== Color.green){
                    if(ifShild[i][j]){
                        if((i%2==0&& j%2==0)||(i%2==1&& j%2==1)){
                            board.board[i][j].setBackground(Color.white);
                        }
                        else{
                            board.board[i][j].setBackground(Color.DARK_GRAY);
                        }
                    }
                }
            }
        }
    }//מנקה את המערך של המגנים

    @Override
    public void actionPerformed(ActionEvent e) {
        ChangeSoldier(board,tools,Dboard,Dtools,ChangeSoldierW,ChangeSoldierB,changeSoldierW,changeSoldierB);
        boolean faound = false;
        faound = Chess(tor,Dboard,Dtools,ProtectedW,ProtectedB);
        System.out.println(faound);
        tor=Move(e,tor,board,tools,Dboard,Dtools,chooseTool,ChangeSoldierW,ChangeSoldierB,changeSoldierW,changeSoldierB);
        Klik(e,tor,board,tools,CantGoThereW,CantGoThereB,Dboard,Dtools,ProtectedW,ProtectedB,faound,ifShild,SwichToolW,SwichToolB,count);
    }
}
