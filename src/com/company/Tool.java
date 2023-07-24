package com.company;
import javax.swing.*;

public class Tool {
    protected ImageIcon tool = null;
    protected int row;
    protected int col;
    private boolean AlreadyMove = false;

    // constractor
    public Tool(ImageIcon tool,int row,int col){
        this.tool = tool;
        this.row = row;
        this.col = col;
    }//בנאי אבא של כל הכלים
    public Tool(Tool[][] tools,int i,int j){
        this.tool = tools[i][j].getKingOfTool();
        this.row = tools[i][j].getRow();
        this.col = tools[i][j].getCol();
    }//בנאי מעתיק של כלי

    // function
    public ImageIcon getKingOfTool(){
        return this.tool;
    }//מחזיר סוג של כלי
    public int getRow(){
        return row;
    }//מחזיר שורה
    public int getCol(){
        return col;
    }//מחזיר עמודה של כלי
    public char getColor(){
        return 'h';
    }//מחזיר צבע של כלי

    public boolean getAlreadyMove(){
        return this.AlreadyMove;
    }
    public void setAlreadyMove(){
        this.AlreadyMove = true;
    }

    //get fucntion
    public void setRow(int Row){
        this.row = Row;
    }//משנה מיקום שורה של כלי
    public void setCol(int Col){
        this.col = Col;
    }//משנה מיקום ענודה של כלי

    //set function
    public void CanMove(Board board,Tool tool,Tool[][] tools,boolean[][] Protected){
    }//פוקציה שלא מופעלת פה אלא מחלקות יורשות משתמשות בה
}
