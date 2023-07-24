package com.company;
import javax.swing.*;
import java.awt.*;

public class King extends Tool{
    private char color;
    //private boolean ifKing;
    private boolean AlreadyMove = false;

    public King(ImageIcon tool, int row, int col, char color){
        super(tool,row,col);
        this.color = color;
    }//בנאי של מלך

    public King(Tool[][] tools,int i,int j){
        super(tools, i, j);
        this.color = tools[i][j].getColor();
    }// בנאי מעתיק של מלך

    public char getColor(){
        return this.color;
    }//מחזיר צבא של המלך

    public boolean getAlreadyMove(){
        return this.AlreadyMove;
    }

    public void setAlreadyMove(){
        this.AlreadyMove = true;
    }

    public void CanMove(Board board,Tool tool,Tool[][] tools,boolean[][] CantGoThere,boolean[][] ProtectedW,boolean[][] ProtectedB,boolean faound){
        if(tool.getColor()=='W'){
            if(tool.getRow()<7){
                if(tools[tool.getRow()+1][tool.getCol()]==null&&!CantGoThere[tool.getRow()+1][tool.getCol()]){
                        board.board[tool.getRow()+1][tool.getCol()].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()+1][tool.getCol()]!=null&&tools[tool.getRow()+1][tool.getCol()].getColor()=='B'&&!ProtectedB[tool.getRow()+1][tool.getCol()]){
                    board.board[tool.getRow()+1][tool.getCol()].setBackground(Color.green);
                }
                if(tools[tool.getRow()+1][tool.getCol()]!=null&&tools[tool.getRow()+1][tool.getCol()].getColor()=='W'){
                    ProtectedW[tool.getRow()+1][tool.getCol()] = true;
                }
                if(tool.getCol()<7&&tools[tool.getRow()+1][tool.getCol()+1]==null&&!CantGoThere[tool.getRow()+1][tool.getCol()+1]){
                    board.board[tool.getRow()+1][tool.getCol()+1].setBackground(Color.yellow);
                }
                else if(tool.getCol()<7&&tools[tool.getRow()+1][tool.getCol()+1]!=null&&tools[tool.getRow()+1][tool.getCol()+1].getColor()=='B'&&!ProtectedB[tool.getRow()+1][tool.getCol()+1]){
                    board.board[tool.getRow()+1][tool.getCol()+1].setBackground(Color.green);
                }
                if(tool.getCol()<7&&tools[tool.getRow()+1][tool.getCol()+1]!=null&&tools[tool.getRow()+1][tool.getCol()+1].getColor()=='W'){
                    ProtectedW[tool.getRow()+1][tool.getCol()+1] = true;
                }
                if(tool.getCol()>0&&tools[tool.getRow()+1][tool.getCol()-1]==null&&!CantGoThere[tool.getRow()+1][tool.getCol()-1]){
                    board.board[tool.getRow()+1][tool.getCol()-1].setBackground(Color.yellow);
                }
                else if(tool.getCol()>0&&tools[tool.getRow()+1][tool.getCol()-1]!=null&&tools[tool.getRow()+1][tool.getCol()-1].getColor()=='B'&&!ProtectedB[tool.getRow()+1][tool.getCol()-1]){
                    board.board[tool.getRow()+1][tool.getCol()-1].setBackground(Color.green);
                }
                if(tool.getCol()>0&&tools[tool.getRow()+1][tool.getCol()-1]!=null&&tools[tool.getRow()+1][tool.getCol()-1].getColor()=='W'){
                    ProtectedW[tool.getRow()+1][tool.getCol()-1] = true;
                }
            }//צובע צעדים כלפי מטה ימינה מטה ישר ומטה שמאל
            if(tool.getRow()>0){
                if(tools[tool.getRow()-1][tool.getCol()]==null&&!CantGoThere[tool.getRow()-1][tool.getCol()]){
                    board.board[tool.getRow()-1][tool.getCol()].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()-1][tool.getCol()]!=null&&tools[tool.getRow()-1][tool.getCol()].getColor()=='B'&&!ProtectedB[tool.getRow()-1][tool.getCol()]){
                    board.board[tool.getRow()-1][tool.getCol()].setBackground(Color.green);
                }
                if(tools[tool.getRow()-1][tool.getCol()]!=null&&tools[tool.getRow()-1][tool.getCol()].getColor()=='W'){
                    ProtectedW[tool.getRow()-1][tool.getCol()]=true;
                }
                if(tool.getCol()<7&&tools[tool.getRow()-1][tool.getCol()+1]==null&&!CantGoThere[tool.getRow()-1][tool.getCol()+1]){
                    board.board[tool.getRow()-1][tool.getCol()+1].setBackground(Color.yellow);
                }
                else if(tool.getCol()<7&&tools[tool.getRow()-1][tool.getCol()+1]!=null&&tools[tool.getRow()-1][tool.getCol()+1].getColor()=='B'&&!ProtectedB[tool.getRow()-1][tool.getCol()+1]){
                    board.board[tool.getRow()-1][tool.getCol()+1].setBackground(Color.green);
                }
                if(tool.getCol()<7&&tools[tool.getRow()-1][tool.getCol()+1]!=null&&tools[tool.getRow()-1][tool.getCol()+1].getColor()=='W'){
                    ProtectedW[tool.getRow()-1][tool.getCol()+1]=true;
                }
                if(tool.getCol()>0&&tools[tool.getRow()-1][tool.getCol()-1]==null&&!CantGoThere[tool.getRow()-1][tool.getCol()-1]){
                    board.board[tool.getRow()-1][tool.getCol()-1].setBackground(Color.yellow);
                }
                else if(tool.getCol()>0&&tools[tool.getRow()-1][tool.getCol()-1]!=null&&tools[tool.getRow()-1][tool.getCol()-1].getColor()=='B'&&!ProtectedB[tool.getRow()-1][tool.getCol()-1]){
                    board.board[tool.getRow()-1][tool.getCol()-1].setBackground(Color.green);
                }
                if(tool.getCol()>0&&tools[tool.getRow()-1][tool.getCol()-1]!=null&&tools[tool.getRow()-1][tool.getCol()-1].getColor()=='W'){
                    ProtectedW[tool.getRow()-1][tool.getCol()-1]=true;
                }
            }//צובע צעדים כלפי למעלה ימינה למעלה ישר ולמעלה שמאל
            if(tool.getCol()<7){
                if(tools[tool.getRow()][tool.getCol()+1]==null&&!CantGoThere[tool.getRow()][tool.getCol()+1]){
                    board.board[tool.getRow()][tool.getCol()+1].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()][tool.getCol()+1]!=null&&tools[tool.getRow()][tool.getCol()+1].getColor()=='B'&&!ProtectedB[tool.getRow()][tool.getCol()+1]){
                    board.board[tool.getRow()][tool.getCol()+1].setBackground(Color.green);
                }
                if(tools[tool.getRow()][tool.getCol()+1]!=null&&tools[tool.getRow()][tool.getCol()+1].getColor()=='W'){
                    ProtectedW[tool.getRow()][tool.getCol()+1]=true;
                }
            }//צובע צעדים כפי ימין
            if(tool.getCol()>0){
                if(tools[tool.getRow()][tool.getCol()-1]==null&&!CantGoThere[tool.getRow()][tool.getCol()-1]){
                    board.board[tool.getRow()][tool.getCol()-1].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()][tool.getCol()-1]!=null&&tools[tool.getRow()][tool.getCol()-1].getColor()=='B'&&!ProtectedB[tool.getRow()][tool.getCol()-1]){
                    board.board[tool.getRow()][tool.getCol()-1].setBackground(Color.green);
                }
                if(tools[tool.getRow()][tool.getCol()-1]!=null&&tools[tool.getRow()][tool.getCol()-1].getColor()=='W'){
                    ProtectedW[tool.getRow()][tool.getCol()-1]=true;
                }
            }//צובע צעדים כפי שמאל
            if(!(tools[tool.getRow()][tool.getCol()].getAlreadyMove())&&!faound){
                if(tools[7][7] instanceof Tura){
                    if(!(tools[7][7].getAlreadyMove())&&board.board[7][6].getIcon()==null&&board.board[7][5].getIcon()==null){
                        board.board[7][7].setBackground(Color.cyan);
                    }
                }
                if(tools[7][0] instanceof Tura){
                    if(!(tools[7][0].getAlreadyMove())&&board.board[7][3].getIcon()==null&&board.board[7][2].getIcon()==null&&board.board[7][1].getIcon()==null){
                        board.board[7][0].setBackground(Color.cyan);
                    }
                }
            }
        }//צובע צעדים למלך לבן
        else if(tool.getColor()=='B'){
            if(tool.getRow()<7){
                if(tools[tool.getRow()+1][tool.getCol()]==null&&!CantGoThere[tool.getRow()+1][tool.getCol()]){
                    board.board[tool.getRow()+1][tool.getCol()].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()+1][tool.getCol()]!=null&&tools[tool.getRow()+1][tool.getCol()].getColor()=='W'&&!ProtectedW[tool.getRow()+1][tool.getCol()]){
                    board.board[tool.getRow()+1][tool.getCol()].setBackground(Color.green);
                }
                if(tools[tool.getRow()+1][tool.getCol()]!=null&&tools[tool.getRow()+1][tool.getCol()].getColor()=='B'){
                    ProtectedB[tool.getRow()+1][tool.getCol()]=true;
                }
                if(tool.getCol()<7&&tools[tool.getRow()+1][tool.getCol()+1]==null&&!CantGoThere[tool.getRow()+1][tool.getCol()+1]){
                    board.board[tool.getRow()+1][tool.getCol()+1].setBackground(Color.yellow);
                }
                else if(tool.getCol()<7&&tools[tool.getRow()+1][tool.getCol()+1]!=null&&tools[tool.getRow()+1][tool.getCol()+1].getColor()=='W'&&!ProtectedW[tool.getRow()+1][tool.getCol()+1]){
                    board.board[tool.getRow()+1][tool.getCol()+1].setBackground(Color.green);
                }
                if(tool.getCol()<7&&tools[tool.getRow()+1][tool.getCol()+1]!=null&&tools[tool.getRow()+1][tool.getCol()+1].getColor()=='B'){
                    ProtectedB[tool.getRow()+1][tool.getCol()+1]=true;
                }
                if(tool.getCol()>0&&tools[tool.getRow()+1][tool.getCol()-1]==null&&!CantGoThere[tool.getRow()+1][tool.getCol()-1]){
                    board.board[tool.getRow()+1][tool.getCol()-1].setBackground(Color.yellow);
                }
                else if(tool.getCol()>0&&tools[tool.getRow()+1][tool.getCol()-1]!=null&&tools[tool.getRow()+1][tool.getCol()-1].getColor()=='W'&&!ProtectedW[tool.getRow()+1][tool.getCol()-1]){
                    board.board[tool.getRow()+1][tool.getCol()-1].setBackground(Color.green);
                }
                if(tool.getCol()>0&&tools[tool.getRow()+1][tool.getCol()-1]!=null&&tools[tool.getRow()+1][tool.getCol()-1].getColor()=='B'){
                    ProtectedB[tool.getRow()+1][tool.getCol()-1]=true;
                }
            }//צובע צעדים כלפי מטה ימינה מטה ישר ומטה שמאל
            if(tool.getRow()>0){
                if(tools[tool.getRow()-1][tool.getCol()]==null&&!CantGoThere[tool.getRow()-1][tool.getCol()]){
                    board.board[tool.getRow()-1][tool.getCol()].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()-1][tool.getCol()]!=null&&tools[tool.getRow()-1][tool.getCol()].getColor()=='W'&&!ProtectedW[tool.getRow()-1][tool.getCol()]){
                    board.board[tool.getRow()-1][tool.getCol()].setBackground(Color.green);
                }
                if(tools[tool.getRow()-1][tool.getCol()]!=null&&tools[tool.getRow()-1][tool.getCol()].getColor()=='B'){
                    ProtectedB[tool.getRow()-1][tool.getCol()]=true;
                }
                if(tool.getCol()<7&&tools[tool.getRow()-1][tool.getCol()+1]==null&&!CantGoThere[tool.getRow()-1][tool.getCol()+1]){
                    board.board[tool.getRow()-1][tool.getCol()+1].setBackground(Color.yellow);
                }
                else if(tool.getCol()<7&&tools[tool.getRow()-1][tool.getCol()+1]!=null&&tools[tool.getRow()-1][tool.getCol()+1].getColor()=='W'&&!ProtectedW[tool.getRow()-1][tool.getCol()+1]){
                    board.board[tool.getRow()-1][tool.getCol()+1].setBackground(Color.green);
                }
                if(tool.getCol()<7&&tools[tool.getRow()-1][tool.getCol()+1]!=null&&tools[tool.getRow()-1][tool.getCol()+1].getColor()=='B'){
                    ProtectedB[tool.getRow()-1][tool.getCol()+1]=true;
                }
                if(tool.getCol()>0&&tools[tool.getRow()-1][tool.getCol()-1]==null&&!CantGoThere[tool.getRow()-1][tool.getCol()-1]){
                    board.board[tool.getRow()-1][tool.getCol()-1].setBackground(Color.yellow);
                }
                else if(tool.getCol()>0&&tools[tool.getRow()-1][tool.getCol()-1]!=null&&tools[tool.getRow()-1][tool.getCol()-1].getColor()=='W'&&!ProtectedW[tool.getRow()-1][tool.getCol()-1]){
                    board.board[tool.getRow()-1][tool.getCol()-1].setBackground(Color.green);
                }
                if(tool.getCol()>0&&tools[tool.getRow()-1][tool.getCol()-1]!=null&&tools[tool.getRow()-1][tool.getCol()-1].getColor()=='B'){
                    ProtectedB[tool.getRow()-1][tool.getCol()-1]=true;
                }
            }//צובע צעדים כלפי למעלה ימינה למעלה ישר ולמעלה שמאל
            if(tool.getCol()<7){
                if(tools[tool.getRow()][tool.getCol()+1]==null&&!CantGoThere[tool.getRow()][tool.getCol()+1]){
                    board.board[tool.getRow()][tool.getCol()+1].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()][tool.getCol()+1]!=null&&tools[tool.getRow()][tool.getCol()+1].getColor()=='W'&&!ProtectedW[tool.getRow()][tool.getCol()+1]){
                    board.board[tool.getRow()][tool.getCol()+1].setBackground(Color.green);
                }
                if(tools[tool.getRow()][tool.getCol()+1]!=null&&tools[tool.getRow()][tool.getCol()+1].getColor()=='B'){
                    ProtectedB[tool.getRow()][tool.getCol()+1]=true;
                }
            }//צובע צעדים כפי ימין
            if(tool.getCol()>0){
                if(tools[tool.getRow()][tool.getCol()-1]==null&&!CantGoThere[tool.getRow()][tool.getCol()-1]){
                    board.board[tool.getRow()][tool.getCol()-1].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()][tool.getCol()-1]!=null&&tools[tool.getRow()][tool.getCol()-1].getColor()=='W'&&!ProtectedW[tool.getRow()][tool.getCol()-1]){
                    board.board[tool.getRow()][tool.getCol()-1].setBackground(Color.green);
                }
                if(tools[tool.getRow()][tool.getCol()-1]!=null&&tools[tool.getRow()][tool.getCol()-1].getColor()=='B'){
                    ProtectedB[tool.getRow()][tool.getCol()-1]=true;
                }
            }//צובע צעדים כפי שמאל
            if(!(tools[tool.getRow()][tool.getCol()].getAlreadyMove())&&!faound){
                if(tools[0][7] instanceof Tura){
                    if(!(tools[0][7].getAlreadyMove())&&board.board[0][6].getIcon()==null&&board.board[0][5].getIcon()==null){
                        board.board[0][7].setBackground(Color.cyan);
                    }
                }
                if(tools[0][0] instanceof Tura){
                    if(!(tools[0][0].getAlreadyMove())&&board.board[0][3].getIcon()==null&&board.board[0][2].getIcon()==null&&board.board[0][1].getIcon()==null){
                        board.board[0][0].setBackground(Color.cyan);
                    }
                }
            }
        }//צובע צעדים למלך שחור
    }//צובע צעדים למלך
}
