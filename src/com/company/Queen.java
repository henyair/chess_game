package com.company;
import javax.swing.*;
import java.awt.*;

public class Queen extends Tool{
    private char color;

    public Queen(ImageIcon tool, int row, int col, char color){
        super(tool,row,col);
        this.color = color;
    }
    public Queen(Tool[][] tools,int i,int j){
        super(tools, i, j);
        this.color = tools[i][j].getColor();
    }// בנאי מעתיק של מלכה
    @Override
    public char getColor(){
        return this.color;
    }

    @Override
    public void CanMove(Board board,Tool tool,Tool[][] tools,boolean[][] Protected){
        boolean RD = true;
        boolean RU = true;
        boolean LD = true;
        boolean LU = true;
        boolean R = true;
        boolean L = true;
        boolean U = true;
        boolean D = true;
        if(tool.getColor()=='W'){
            for(int i=1;i<=7;i++){
                if(RD){
                    if(tool.getRow()+i<=7&&tool.getCol()+i<=7){
                        if(tools[tool.getRow()+i][tool.getCol()+i]==null){
                            board.board[tool.getRow()+i][tool.getCol()+i].setBackground(Color.yellow);
                        }
                        else if(tools[tool.getRow()+i][tool.getCol()+i]!=null){
                            if(tools[tool.getRow()+i][tool.getCol()+i].getColor()=='B'){
                                board.board[tool.getRow()+i][tool.getCol()+i].setBackground(Color.green);
                            }
                            else if(tools[tool.getRow()+i][tool.getCol()+i].getColor()=='W'){
                                Protected[tool.getRow()+i][tool.getCol()+i] = true;
                            }
                            RD=false;
                        }
                    }
                }//מצייר מהלכים של מלכה צד ימין למטה
                if(RU){
                    if(tool.getRow()-i>=0&&tool.getCol()+i<=7){
                        if(tools[tool.getRow()-i][tool.getCol()+i]==null){
                            board.board[tool.getRow()-i][tool.getCol()+i].setBackground(Color.yellow);
                        }
                        else if(tools[tool.getRow()-i][tool.getCol()+i]!=null){
                            if(tools[tool.getRow()-i][tool.getCol()+i].getColor()=='B'){
                                board.board[tool.getRow()-i][tool.getCol()+i].setBackground(Color.green);
                            }
                            else if(tools[tool.getRow()-i][tool.getCol()+i].getColor()=='W'){
                                Protected[tool.getRow()-i][tool.getCol()+i] = true;
                            }
                            RU=false;
                        }
                    }
                }//מצייר מהלכים של מלכה צד ימין למעלה
                if(LD){
                    if(tool.getRow()+i<=7&&tool.getCol()-i>=0){
                        if(tools[tool.getRow()+i][tool.getCol()-i]==null){
                            board.board[tool.getRow()+i][tool.getCol()-i].setBackground(Color.yellow);
                        }
                        else if(tools[tool.getRow()+i][tool.getCol()-i]!=null){
                            if(tools[tool.getRow()+i][tool.getCol()-i].getColor()=='B'){
                                board.board[tool.getRow()+i][tool.getCol()-i].setBackground(Color.green);
                            }
                            else if(tools[tool.getRow()+i][tool.getCol()-i].getColor()=='W'){
                                Protected[tool.getRow()+i][tool.getCol()-i]= true;
                            }
                            LD=false;
                        }
                    }
                }//מצייר מהלכים של מלכה צד שמאל למטה
                if(LU){
                    if(tool.getRow()-i>=0&&tool.getCol()-i>=0){
                        if(tools[tool.getRow()-i][tool.getCol()-i]==null){
                            board.board[tool.getRow()-i][tool.getCol()-i].setBackground(Color.yellow);
                        }
                        else if(tools[tool.getRow()-i][tool.getCol()-i]!=null){
                            if(tools[tool.getRow()-i][tool.getCol()-i].getColor()=='B'){
                                board.board[tool.getRow()-i][tool.getCol()-i].setBackground(Color.green);
                            }
                            else if(tools[tool.getRow()-i][tool.getCol()-i].getColor()=='W'){
                                Protected[tool.getRow()-i][tool.getCol()-i] = true;
                            }
                            LU=false;
                        }
                    }
                }//מצייר מהלכים של מלכה צד שמאל למעלה
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
                                Protected[tool.getRow()][tool.getCol()+i] =true;
                            }
                            R=false;
                        }
                    }
                }//צעדים של מלכה ימינה
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
                }//צעדים של מלכה שמאל
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
                                Protected[tool.getRow()-i][tool.getCol()]=true;
                            }
                            D=false;
                        }
                    }
                }//צעדים של מלכה למטה
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
                }//צעדים של מלכה למטה
            }
        }//צובע צעדים של מלכה לבנה
        else if(tool.getColor()=='B'){
            for(int i=1;i<=7;i++){
                if(RD){
                    if(tool.getRow()+i<=7&&tool.getCol()+i<=7){
                        if(tools[tool.getRow()+i][tool.getCol()+i]==null){
                            board.board[tool.getRow()+i][tool.getCol()+i].setBackground(Color.yellow);
                        }
                        else if(tools[tool.getRow()+i][tool.getCol()+i]!=null){
                            if(tools[tool.getRow()+i][tool.getCol()+i].getColor()=='W'){
                                board.board[tool.getRow()+i][tool.getCol()+i].setBackground(Color.green);
                            }
                            else if(tools[tool.getRow()+i][tool.getCol()+i].getColor()=='B'){
                                Protected[tool.getRow()+i][tool.getCol()+i]=true;
                            }
                            RD=false;
                        }
                    }
                }//מצייר מהלכים של מלכה צד ימין למטה
                if(RU){
                    if(tool.getRow()-i>=0&&tool.getCol()+i<=7){
                        if(tools[tool.getRow()-i][tool.getCol()+i]==null){
                            board.board[tool.getRow()-i][tool.getCol()+i].setBackground(Color.yellow);
                        }
                        else if(tools[tool.getRow()-i][tool.getCol()+i]!=null){
                            if(tools[tool.getRow()-i][tool.getCol()+i].getColor()=='W'){
                                board.board[tool.getRow()-i][tool.getCol()+i].setBackground(Color.green);
                            }
                            else if(tools[tool.getRow()-i][tool.getCol()+i].getColor()=='B'){
                                Protected[tool.getRow()-i][tool.getCol()+i]= true;
                            }
                            RU=false;
                        }
                    }
                }//מצייר מהלכים של מלכה צד ימין למעלה
                if(LD){
                    if(tool.getRow()+i<=7&&tool.getCol()-i>=0){
                        if(tools[tool.getRow()+i][tool.getCol()-i]==null){
                            board.board[tool.getRow()+i][tool.getCol()-i].setBackground(Color.yellow);
                        }
                        else if(tools[tool.getRow()+i][tool.getCol()-i]!=null){
                            if(tools[tool.getRow()+i][tool.getCol()-i].getColor()=='W'){
                                board.board[tool.getRow()+i][tool.getCol()-i].setBackground(Color.green);
                            }
                            else if(tools[tool.getRow()+i][tool.getCol()-i].getColor()=='B'){
                                Protected[tool.getRow()+i][tool.getCol()-i] = true;
                            }
                            LD=false;
                        }
                    }
                }//מצייר מהלכים של מלכה צד שמאל למטה
                if(LU){
                    if(tool.getRow()-i>=0&&tool.getCol()-i>=0){
                        if(tools[tool.getRow()-i][tool.getCol()-i]==null){
                            board.board[tool.getRow()-i][tool.getCol()-i].setBackground(Color.yellow);
                        }
                        else if(tools[tool.getRow()-i][tool.getCol()-i]!=null){
                            if(tools[tool.getRow()-i][tool.getCol()-i].getColor()=='W'){
                                board.board[tool.getRow()-i][tool.getCol()-i].setBackground(Color.green);
                            }
                            else if(tools[tool.getRow()-i][tool.getCol()-i].getColor()=='B'){
                                Protected[tool.getRow()-i][tool.getCol()-i] = true;
                            }
                            LU=false;
                        }
                    }
                }//מצייר מהלכים של מלכה צד שמאל למעלה
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
                                Protected[tool.getRow()][tool.getCol()+i]=true;
                            }
                            R=false;
                        }
                    }
                }//צעדים של מלכה ימינה
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
                                Protected[tool.getRow()][tool.getCol()-i]=true;
                            }
                            L=false;
                        }
                    }
                }//צעדים של מלכה שמאל
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
                                Protected[tool.getRow()-i][tool.getCol()]= true;
                            }
                            D=false;
                        }
                    }
                }//צעדים של מלכה למטה
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
                }//צעדים של מלכה למטה
            }
        }//צובע מעדים של מלכה שחורה
    }// צובע צעדים של מלכה
}
