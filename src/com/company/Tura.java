package com.company;
import javax.swing.*;
import java.awt.*;

public class Tura extends Tool{
    private char color;
    private boolean AlreadyMove = false;

    public Tura(ImageIcon tool, int row, int col, char color){
        super(tool,row,col);
        this.color = color;
    }
    public Tura(Tool[][] tools,int i,int j){
        super(tools, i, j);
        this.color = tools[i][j].getColor();
    }// בנאי מעתיק של טורה

    @Override
    public char getColor(){
        return this.color;
    }
    public boolean getAlreadyMove(){
        return this.AlreadyMove;
    }
    public void setAlreadyMove(){
        this.AlreadyMove = true;
    }

    @Override
    public void CanMove(Board board,Tool tool,Tool[][] tools,boolean[][] Protected){
        boolean R = true;
        boolean L = true;
        boolean U = true;
        boolean D = true;
        if(tool.getColor()=='W'){
            for(int i =1;i<=7;i++){
                if(R){
                    if(tool.getCol()+i<=7){
                        if(tools[tool.getRow()][tool.getCol()+i]==null){
                            board.board[tool.getRow()][tool.getCol()+i].setBackground(Color.yellow);
                        }
                        else if(tools[tool.getRow()][tool.getCol()+i]!=null){
                            if(tools[tool.getRow()][tool.getCol()+i].getColor()=='B'){
                                board.board[tool.getRow()][tool.getCol()+i].setBackground(Color.green);
                            }
                            else if(tools[tool.getRow()][tool.getCol()+i].getColor()=='W'){
                                Protected[tool.getRow()][tool.getCol()+i] = true;
                            }
                            R=false;
                        }
                    }
                }//צעדים של טורה ימינה
                if(L){
                    if(tool.getCol()-i>=0){
                        if(tools[tool.getRow()][tool.getCol()-i]==null){
                            board.board[tool.getRow()][tool.getCol()-i].setBackground(Color.yellow);
                        }
                        else if(tools[tool.getRow()][tool.getCol()-i]!=null){
                            if(tools[tool.getRow()][tool.getCol()-i].getColor()=='B'){
                                board.board[tool.getRow()][tool.getCol()-i].setBackground(Color.green);
                            }
                            else if(tools[tool.getRow()][tool.getCol()-i].getColor()=='W'){
                                Protected[tool.getRow()][tool.getCol()-i] = true;
                            }
                            L=false;
                        }
                    }
                }//צעדים של טורה שמאל
                if(D){
                    if(tool.getRow()-i>=0){
                        if(tools[tool.getRow()-i][tool.getCol()]==null){
                            board.board[tool.getRow()-i][tool.getCol()].setBackground(Color.yellow);
                        }
                        else if(tools[tool.getRow()-i][tool.getCol()]!=null){
                            if(tools[tool.getRow()-i][tool.getCol()].getColor()=='B'){
                                board.board[tool.getRow()-i][tool.getCol()].setBackground(Color.green);
                            }
                            else if(tools[tool.getRow()-i][tool.getCol()].getColor()=='W'){
                                Protected[tool.getRow()-i][tool.getCol()] = true;
                            }
                            D=false;
                        }
                    }
                }//צעדים של טורה למטה
                if(U){
                    if(tool.getRow()+i<=7){
                        if(tools[tool.getRow()+i][tool.getCol()]==null){
                            board.board[tool.getRow()+i][tool.getCol()].setBackground(Color.yellow);
                        }
                        else if(tools[tool.getRow()+i][tool.getCol()]!=null){
                            if(tools[tool.getRow()+i][tool.getCol()].getColor()=='B'){
                                board.board[tool.getRow()+i][tool.getCol()].setBackground(Color.green);
                            }
                            else if(tools[tool.getRow()+i][tool.getCol()].getColor()=='W'){
                                Protected[tool.getRow()+i][tool.getCol()] = true;
                            }
                            U=false;
                        }
                    }
                }//צעדים של טורה למטה
            }
        }//צובע צעדים של טורה לבן
        else if(tool.getColor()=='B'){
            for(int i =1;i<=7;i++){
                if(R){
                    if(tool.getCol()+i<=7){
                        if(tools[tool.getRow()][tool.getCol()+i]==null){
                            board.board[tool.getRow()][tool.getCol()+i].setBackground(Color.yellow);
                        }
                        else if(tools[tool.getRow()][tool.getCol()+i]!=null){
                            if(tools[tool.getRow()][tool.getCol()+i].getColor()=='W'){
                                board.board[tool.getRow()][tool.getCol()+i].setBackground(Color.green);
                            }
                            else if(tools[tool.getRow()][tool.getCol()+i].getColor()=='B'){
                                Protected[tool.getRow()][tool.getCol()+i] = true;
                            }
                            R=false;
                        }
                    }
                }//צעדים של טורה ימינה
                if(L){
                    if(tool.getCol()-i>=0){
                        if(tools[tool.getRow()][tool.getCol()-i]==null){
                            board.board[tool.getRow()][tool.getCol()-i].setBackground(Color.yellow);
                        }
                        else if(tools[tool.getRow()][tool.getCol()-i]!=null){
                            if(tools[tool.getRow()][tool.getCol()-i].getColor()=='W'){
                                board.board[tool.getRow()][tool.getCol()-i].setBackground(Color.green);
                            }
                            else if(tools[tool.getRow()][tool.getCol()-i].getColor()=='B'){
                                Protected[tool.getRow()][tool.getCol()-i] = true;
                            }
                            L=false;
                        }
                    }
                }//צעדים של טורה שמאל
                if(D){
                    if(tool.getRow()-i>=0){
                        if(tools[tool.getRow()-i][tool.getCol()]==null){
                            board.board[tool.getRow()-i][tool.getCol()].setBackground(Color.yellow);
                        }
                        else if(tools[tool.getRow()-i][tool.getCol()]!=null){
                            if(tools[tool.getRow()-i][tool.getCol()].getColor()=='W'){
                                board.board[tool.getRow()-i][tool.getCol()].setBackground(Color.green);
                            }
                            else if(tools[tool.getRow()-i][tool.getCol()].getColor()=='B'){
                                Protected[tool.getRow()-i][tool.getCol()] = true;
                            }
                            D=false;
                        }
                    }
                }//צעדים של טורה למטה
                if(U){
                    if(tool.getRow()+i<=7){
                        if(tools[tool.getRow()+i][tool.getCol()]==null){
                            board.board[tool.getRow()+i][tool.getCol()].setBackground(Color.yellow);
                        }
                        else if(tools[tool.getRow()+i][tool.getCol()]!=null){
                            if(tools[tool.getRow()+i][tool.getCol()].getColor()=='W'){
                                board.board[tool.getRow()+i][tool.getCol()].setBackground(Color.green);
                            }
                            else if(tools[tool.getRow()+i][tool.getCol()].getColor()=='B'){
                                Protected[tool.getRow()+i][tool.getCol()] = true;
                            }
                            U=false;
                        }
                    }
                }//צעדים של טורה למטה
            }
        }//צובע צעדים של טורה שחור
    }//צובע צעדים של טורה
}
