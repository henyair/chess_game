package com.company;
import javax.swing.*;
import java.awt.*;

public class Rach extends Tool{
    private char color;

    public Rach(ImageIcon tool, int row, int col, char color){
        super(tool,row,col);
        this.color = color;
    }
    public Rach(Tool[][] tools,int i,int j){
        super(tools, i, j);
        this.color = tools[i][j].getColor();
    }// בנאי מעתיק של רץ

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
                }//מצייר מהלכים של הרץ צד ימין למטה
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
                }//מצייר מהלכים של הרץ צד ימין למעלה
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
                }//מצייר מהלכים של הרץ צד שמאל למטה
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
                                Protected[tool.getRow()-i][tool.getCol()-i]= true;
                            }
                            LU=false;
                        }
                    }
                }//מצייר מהלכים של הרץ צד שמאל למעלה
            }
        }//צעדים של רץ לבן
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
                                Protected[tool.getRow()+i][tool.getCol()+i] = true;
                            }
                            RD=false;
                        }
                    }
                }//מצייר מהלכים של הרץ צד ימין למטה
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
                                Protected[tool.getRow()-i][tool.getCol()+i] = true;
                            }
                            RU=false;
                        }
                    }
                }//מצייר מהלכים של הרץ צד ימין למעלה
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
                }//מצייר מהלכים של הרץ צד שמאל למטה
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
                }//מצייר מהלכים של הרץ צד שמאל למעלה
            }
        }//צעדים של רץ שחור
    }//צובע את הצעדים של הרץ
}
