package com.company;
import javax.swing.*;
import java.awt.*;

public class Horse extends Tool{
    private char color;

    public Horse(ImageIcon tool, int row, int col, char color){
        super(tool,row,col);
        this.color = color;
    }
    public Horse(Tool[][] tools,int i,int j){
        super(tools, i, j);
        this.color = tools[i][j].getColor();
    }// בנאי מעתיק של סוס
    @Override
    public char getColor(){
        return this.color;
    }
    @Override
    public void CanMove(Board board,Tool tool,Tool[][] tools,boolean[][] Protected){
        if (tool.getColor() == 'W') {
            if(tool.getRow()<6&&tool.getCol()<7){
                if(tools[tool.getRow()+2][tool.getCol()+1]==null){
                    board.board[tool.getRow()+2][tool.getCol()+1].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()+2][tool.getCol()+1]!=null){
                    if(tools[tool.getRow()+2][tool.getCol()+1].getColor()=='B'){
                        board.board[tool.getRow()+2][tool.getCol()+1].setBackground(Color.green);
                    }
                    else if(tools[tool.getRow()+2][tool.getCol()+1].getColor()=='W'){
                        Protected[tool.getRow()+2][tool.getCol()+1]=true;
                    }
                }
            }//מצייר למטהוימינה
            if(tool.getRow()<6&&tool.getCol()>0){
                if(tools[tool.getRow()+2][tool.getCol()-1]==null){
                    board.board[tool.getRow()+2][tool.getCol()-1].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()+2][tool.getCol()-1]!=null){
                    if(tools[tool.getRow()+2][tool.getCol()-1].getColor()=='B'){
                        board.board[tool.getRow()+2][tool.getCol()-1].setBackground(Color.green);
                    }
                    else if(tools[tool.getRow()+2][tool.getCol()-1].getColor()=='W'){
                        Protected[tool.getRow()+2][tool.getCol()-1] = true;
                    }
                }
            }// מצייר למטה ושמאלה
            if(tool.getRow()>1&&tool.getCol()>0){
                if(tools[tool.getRow()-2][tool.getCol()-1]==null){
                    board.board[tool.getRow()-2][tool.getCol()-1].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()-2][tool.getCol()-1]!=null){
                    if(tools[tool.getRow()-2][tool.getCol()-1].getColor()=='B'){
                        board.board[tool.getRow()-2][tool.getCol()-1].setBackground(Color.green);
                    }
                    else if(tools[tool.getRow()-2][tool.getCol()-1].getColor()=='W'){
                        Protected[tool.getRow()-2][tool.getCol()-1] = true;
                    }
                }
            }// מצייר למעלה ושמאלה
            if(tool.getRow()>1&&tool.getCol()<7){
                if(tools[tool.getRow()-2][tool.getCol()+1]==null){
                    board.board[tool.getRow()-2][tool.getCol()+1].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()-2][tool.getCol()+1]!=null){
                    if(tools[tool.getRow()-2][tool.getCol()+1].getColor()=='B'){
                        board.board[tool.getRow()-2][tool.getCol()+1].setBackground(Color.green);
                    }
                    else if(tools[tool.getRow()-2][tool.getCol()+1].getColor()=='W'){
                        Protected[tool.getRow()-2][tool.getCol()+1] = true;
                    }
                }
            }// מצייר למעלה וימינה
            if(tool.getRow()<7&&tool.getCol()<6){
                if(tools[tool.getRow()+1][tool.getCol()+2]==null){
                    board.board[tool.getRow()+1][tool.getCol()+2].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()+1][tool.getCol()+2]!=null){
                    if(tools[tool.getRow()+1][tool.getCol()+2].getColor()=='B'){
                        board.board[tool.getRow()+1][tool.getCol()+2].setBackground(Color.green);
                    }
                    else if(tools[tool.getRow()+1][tool.getCol()+2].getColor()=='W'){
                        Protected[tool.getRow()+1][tool.getCol()+2] = true;
                    }
                }
            }// מצייר ימינה ולמטה
            if(tool.getRow()>0&&tool.getCol()<6){
                if(tools[tool.getRow()-1][tool.getCol()+2]==null){
                    board.board[tool.getRow()-1][tool.getCol()+2].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()-1][tool.getCol()+2]!=null){
                    if(tools[tool.getRow()-1][tool.getCol()+2].getColor()=='B'){
                        board.board[tool.getRow()-1][tool.getCol()+2].setBackground(Color.green);
                    }
                    else if(tools[tool.getRow()-1][tool.getCol()+2].getColor()=='W'){
                        Protected[tool.getRow()-1][tool.getCol()+2] = true;
                    }
                }
            }// מצייר ימינה ולמעלה
            if(tool.getRow()>0&&tool.getCol()>1){
                if(tools[tool.getRow()-1][tool.getCol()-2]==null){
                    board.board[tool.getRow()-1][tool.getCol()-2].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()-1][tool.getCol()-2]!=null){
                    if(tools[tool.getRow()-1][tool.getCol()-2].getColor()=='B'){
                        board.board[tool.getRow()-1][tool.getCol()-2].setBackground(Color.green);
                    }
                    else if(tools[tool.getRow()-1][tool.getCol()-2].getColor()=='W'){
                        Protected[tool.getRow()-1][tool.getCol()-2] = true;
                    }
                }
            }// מצייר שמאלה ולמעלה
            if(tool.getRow()<7&&tool.getCol()>1){
                if(tools[tool.getRow()+1][tool.getCol()-2]==null){
                    board.board[tool.getRow()+1][tool.getCol()-2].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()+1][tool.getCol()-2]!=null){
                    if(tools[tool.getRow()+1][tool.getCol()-2].getColor()=='B'){
                        board.board[tool.getRow()+1][tool.getCol()-2].setBackground(Color.green);
                    }
                    if(tools[tool.getRow()+1][tool.getCol()-2].getColor()=='W'){
                        Protected[tool.getRow()+1][tool.getCol()-2] = true;
                    }
                }
            }// מצייר שמאלה ולמטה
        }//מצייר מהלכים של סוס לבן
        else if (tool.getColor() == 'B') {
            if(tool.getRow()<6&&tool.getCol()<7){
                if(tools[tool.getRow()+2][tool.getCol()+1]==null){
                    board.board[tool.getRow()+2][tool.getCol()+1].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()+2][tool.getCol()+1]!=null){
                    if(tools[tool.getRow()+2][tool.getCol()+1].getColor()=='W'){
                        board.board[tool.getRow()+2][tool.getCol()+1].setBackground(Color.green);
                    }
                    else if(tools[tool.getRow()+2][tool.getCol()+1].getColor()=='B'){
                        Protected[tool.getRow()+2][tool.getCol()+1] = true;
                    }
                }
            }//מצייר למטהוימינה
            if(tool.getRow()<6&&tool.getCol()>0){
                if(tools[tool.getRow()+2][tool.getCol()-1]==null){
                    board.board[tool.getRow()+2][tool.getCol()-1].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()+2][tool.getCol()-1]!=null){
                    if(tools[tool.getRow()+2][tool.getCol()-1].getColor()=='W'){
                        board.board[tool.getRow()+2][tool.getCol()-1].setBackground(Color.green);
                    }
                    else if(tools[tool.getRow()+2][tool.getCol()-1].getColor()=='B'){
                        Protected[tool.getRow()+2][tool.getCol()-1]= true;
                    }
                }
            }// מצייר למטה ושמאלה
            if(tool.getRow()>1&&tool.getCol()>0){
                if(tools[tool.getRow()-2][tool.getCol()-1]==null){
                    board.board[tool.getRow()-2][tool.getCol()-1].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()-2][tool.getCol()-1]!=null){
                    if(tools[tool.getRow()-2][tool.getCol()-1].getColor()=='W'){
                        board.board[tool.getRow()-2][tool.getCol()-1].setBackground(Color.green);
                    }
                    else if(tools[tool.getRow()-2][tool.getCol()-1].getColor()=='B'){
                        Protected[tool.getRow()-2][tool.getCol()-1] = true;
                    }
                }
            }// מצייר למעלה ושמאלה
            if(tool.getRow()>1&&tool.getCol()<7){
                if(tools[tool.getRow()-2][tool.getCol()+1]==null){
                    board.board[tool.getRow()-2][tool.getCol()+1].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()-2][tool.getCol()+1]!=null){
                    if(tools[tool.getRow()-2][tool.getCol()+1].getColor()=='W'){
                        board.board[tool.getRow()-2][tool.getCol()+1].setBackground(Color.green);
                    }
                    else if(tools[tool.getRow()-2][tool.getCol()+1].getColor()=='B'){
                        Protected[tool.getRow()-2][tool.getCol()+1] = true;
                    }
                }
            }// מצייר למעלה וימינה
            if(tool.getRow()<7&&tool.getCol()<6){
                if(tools[tool.getRow()+1][tool.getCol()+2]==null){
                    board.board[tool.getRow()+1][tool.getCol()+2].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()+1][tool.getCol()+2]!=null){
                    if(tools[tool.getRow()+1][tool.getCol()+2].getColor()=='W'){
                        board.board[tool.getRow()+1][tool.getCol()+2].setBackground(Color.green);
                    }
                    else if(tools[tool.getRow()+1][tool.getCol()+2].getColor()=='B'){
                        Protected[tool.getRow()+1][tool.getCol()+2] = true;
                    }
                }
            }// מצייר ימינה ולמטה
            if(tool.getRow()>0&&tool.getCol()<6){
                if(tools[tool.getRow()-1][tool.getCol()+2]==null){
                    board.board[tool.getRow()-1][tool.getCol()+2].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()-1][tool.getCol()+2]!=null){
                    if(tools[tool.getRow()-1][tool.getCol()+2].getColor()=='W'){
                        board.board[tool.getRow()-1][tool.getCol()+2].setBackground(Color.green);
                    }
                    else if(tools[tool.getRow()-1][tool.getCol()+2].getColor()=='B'){
                        Protected[tool.getRow()-1][tool.getCol()+2] = true;
                    }
                }
            }// מצייר ימינה ולמעלה
            if(tool.getRow()>0&&tool.getCol()>1){
                if(tools[tool.getRow()-1][tool.getCol()-2]==null){
                    board.board[tool.getRow()-1][tool.getCol()-2].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()-1][tool.getCol()-2]!=null){
                    if(tools[tool.getRow()-1][tool.getCol()-2].getColor()=='W'){
                        board.board[tool.getRow()-1][tool.getCol()-2].setBackground(Color.green);
                    }
                    else if(tools[tool.getRow()-1][tool.getCol()-2].getColor()=='B'){
                        Protected[tool.getRow()-1][tool.getCol()-2] = true;
                    }
                }
            }// מצייר שמאלה ולמעלה
            if(tool.getRow()<7&&tool.getCol()>1){
                if(tools[tool.getRow()+1][tool.getCol()-2]==null){
                    board.board[tool.getRow()+1][tool.getCol()-2].setBackground(Color.yellow);
                }
                else if(tools[tool.getRow()+1][tool.getCol()-2]!=null){
                    if(tools[tool.getRow()+1][tool.getCol()-2].getColor()=='W'){
                        board.board[tool.getRow()+1][tool.getCol()-2].setBackground(Color.green);
                    }
                    else if(tools[tool.getRow()+1][tool.getCol()-2].getColor()=='B'){
                        Protected[tool.getRow()+1][tool.getCol()-2] = true;
                    }
                }
            }// מצייר שמאלה ולמטה
        }//מצייר מהלכים של סוס שחור
    }//מצייר מהלכים של סוס
}
