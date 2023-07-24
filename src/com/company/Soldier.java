package com.company;
import javax.swing.*;
import java.awt.*;

public class Soldier extends Tool{

    private char color;
    private boolean AlreadyMove = false;

    public Soldier(ImageIcon tool,int row,int col,char color){
        super(tool,row,col);
        this.color = color;
    }//בנאי של חייל
    public Soldier(Tool[][] tools,int i,int j){
        super(tools, i, j);
        this.color = tools[i][j].getColor();
        this.AlreadyMove = ((Soldier)tools[i][j]).getAlreadyMove();
    }// בנאי מעתיק של חייל

    @Override
    public char getColor(){
        return this.color;
    }//מחזיר צבע של חייל
    public boolean getAlreadyMove(){
        return this.AlreadyMove;
    }//מחזיר האם חייל זז כבר
    public void setAlreadyMove(){
        this.AlreadyMove = true;
    }//אם חייל זז משנה את ההגדרה שלו לחייל שזז כבר
    @Override
    public void CanMove(Board board,Tool tool,Tool[][] tools,boolean[][] Protected){
        if(tool.getColor()=='W'){
            if(!((Soldier)tool).getAlreadyMove()){
                if(board.board[tool.getRow()-1][tool.getCol()].getIcon()==null){
                    board.board[tool.getRow()-1][tool.getCol()].setBackground(Color.yellow);
                    if(board.board[tool.getRow()-2][tool.getCol()].getIcon()==null){
                        board.board[tool.getRow()-2][tool.getCol()].setBackground(Color.yellow);
                    }
                }//ציור צעדים קדימה לחייל שלא זז
                if(tool.getCol()<7&&board.board[tool.getRow()-1][tool.getCol()+1].getIcon()!=null){
                    if(tools[tool.getRow()-1][tool.getCol()+1]!=null&&tools[tool.getRow()-1][tool.getCol()+1].getColor()=='B'){
                        board.board[tool.getRow()-1][tool.getCol()+1].setBackground(Color.green);
                    }
                    if(tools[tool.getRow()-1][tool.getCol()+1]!=null&&tools[tool.getRow()-1][tool.getCol()+1].getColor()=='W'){
                        Protected[tool.getRow()-1][tool.getCol()+1] =true;
                    }
                }// ציור אכילות לחייל שלא זז
                if(tool.getCol()>0&&board.board[tool.getRow()-1][tool.getCol()-1].getIcon()!=null){
                    if(tools[tool.getRow()-1][tool.getCol()-1]!=null&&tools[tool.getRow()-1][tool.getCol()-1].getColor()=='B'){
                        board.board[tool.getRow()-1][tool.getCol()-1].setBackground(Color.green);
                    }
                    if(tools[tool.getRow()-1][tool.getCol()-1]!=null&&tools[tool.getRow()-1][tool.getCol()-1].getColor()=='W'){
                        Protected[tool.getRow()-1][tool.getCol()-1] = true;
                    }
                }// ציור אכילות לחייל שלא זז
            }// חייל לבן שלא זז
            else if(((Soldier)tool).getAlreadyMove()){
                if(tool.getRow()>0&&board.board[tool.getRow()-1][tool.getCol()].getIcon()==null){
                    board.board[tool.getRow()-1][tool.getCol()].setBackground(Color.yellow);
                }//מצייר צעדים קדימה לחייל שכבר זז
                if(tool.getCol()<7&&tool.getRow()>0&&board.board[tool.getRow()-1][tool.getCol()+1].getIcon()!=null){
                    if(tools[tool.getRow()-1][tool.getCol()+1]!=null&&tools[tool.getRow()-1][tool.getCol()+1].getColor()=='B'){
                        board.board[tool.getRow()-1][tool.getCol()+1].setBackground(Color.green);
                    }
                    if(tools[tool.getRow()-1][tool.getCol()+1]!=null&&tools[tool.getRow()-1][tool.getCol()+1].getColor()=='W'){
                        Protected[tool.getRow()-1][tool.getCol()+1]= true;
                    }
                }//מצייר אכילות לחייל שכבר זז
                if(tool.getCol()>0&&tool.getRow()>0&&board.board[tool.getRow()-1][tool.getCol()-1].getIcon()!=null){
                    if(tools[tool.getRow()-1][tool.getCol()-1]!=null&&tools[tool.getRow()-1][tool.getCol()-1].getColor()=='B'){
                        board.board[tool.getRow()-1][tool.getCol()-1].setBackground(Color.green);
                    }
                    if(tools[tool.getRow()-1][tool.getCol()-1]!=null&&tools[tool.getRow()-1][tool.getCol()-1].getColor()=='W'){
                        Protected[tool.getRow()-1][tool.getCol()-1] = true;
                    }
                }//מצייר אכילות לחייל שכבר זז
            }// חייל לבן שזז
        }// אפשרויות תזוזה של חייל לבן
        else if(tool.getColor()=='B'){
            if(!((Soldier)tool).getAlreadyMove()){
                if(board.board[tool.getRow()+1][tool.getCol()].getIcon()==null){
                    board.board[tool.getRow()+1][tool.getCol()].setBackground(Color.yellow);
                    if(board.board[tool.getRow()+2][tool.getCol()].getIcon()==null){
                        board.board[tool.getRow()+2][tool.getCol()].setBackground(Color.yellow);
                    }
                }//מצייר צעדים לחייל שחור שלא זז
                if(tool.getCol()<7&&board.board[tool.getRow()+1][tool.getCol()+1].getIcon()!=null){
                    if(tools[tool.getRow()+1][tool.getCol()+1]!=null&&tools[tool.getRow()+1][tool.getCol()+1].getColor()=='W'){
                        board.board[tool.getRow()+1][tool.getCol()+1].setBackground(Color.green);
                    }
                    if(tools[tool.getRow()+1][tool.getCol()+1]!=null&&tools[tool.getRow()+1][tool.getCol()+1].getColor()=='B'){
                        Protected[tool.getRow()+1][tool.getCol()+1] = true;
                    }
                }//מצייר אכילות לחייל שחור שלא זז
                if(tool.getCol()>0&&board.board[tool.getRow()+1][tool.getCol()-1].getIcon()!=null){
                    if(tools[tool.getRow()+1][tool.getCol()-1]!=null&&tools[tool.getRow()+1][tool.getCol()-1].getColor()=='W'){
                        board.board[tool.getRow()+1][tool.getCol()-1].setBackground(Color.green);
                    }
                    if(tools[tool.getRow()+1][tool.getCol()-1]!=null&&tools[tool.getRow()+1][tool.getCol()-1].getColor()=='B'){
                        Protected[tool.getRow()+1][tool.getCol()-1]= true;
                    }
                }// ציור אכילות לחייל שלא זז
            }// חייל שחור שלא זז
            else if(((Soldier)tool).getAlreadyMove()){
                if(tool.getRow()<7&&board.board[tool.getRow()+1][tool.getCol()].getIcon()==null){
                    board.board[tool.getRow()+1][tool.getCol()].setBackground(Color.yellow);
                }//מצייר צעדים לחייל שחור שזז
                if(tool.getCol()<7&&tool.getRow()<7&&board.board[tool.getRow()+1][tool.getCol()+1].getIcon()!=null){
                    if(tools[tool.getRow()+1][tool.getCol()+1]!=null&&tools[tool.getRow()+1][tool.getCol()+1].getColor()=='W'){
                        board.board[tool.getRow()+1][tool.getCol()+1].setBackground(Color.green);
                    }
                    if(tools[tool.getRow()+1][tool.getCol()+1]!=null&&tools[tool.getRow()+1][tool.getCol()+1].getColor()=='B'){
                        Protected[tool.getRow()+1][tool.getCol()+1] = true;
                    }
                }// מצייר אכילות לחייל שחור שזז
                if(tool.getCol()>0&&tool.getRow()<7&&board.board[tool.getRow()+1][tool.getCol()-1].getIcon()!=null){
                    if(tools[tool.getRow()+1][tool.getCol()-1]!=null&&tools[tool.getRow()+1][tool.getCol()-1].getColor()=='W'){
                        board.board[tool.getRow()+1][tool.getCol()-1].setBackground(Color.green);
                    }
                    if(tools[tool.getRow()+1][tool.getCol()-1]!=null&&tools[tool.getRow()+1][tool.getCol()-1].getColor()=='B'){
                        Protected[tool.getRow()+1][tool.getCol()-1] = true;
                    }
                }// מצייר אכילות לחייל שחור שזז
            }// חייל שחור שזז
        }// אפשרויות תזוזה של חייל שחור
    }//צובע את הצעדים של חייל

}
