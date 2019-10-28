package com.Andrei;

import javax.swing.*;
import java.awt.*;

public class Player {

    private int lives;
    private int xAxis;
    private int yAxis;
    private String imagePath;
    private boolean isAlive;

    public Player(int lives, int xAxis, int yAxis, String imagePath, boolean isAlive) {
        super();
        this.setLives(lives);
        this.setxAxis(xAxis);
        this.setyAxis(yAxis);
        this.setImagePath(imagePath);
        this.setAlive(isAlive);
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getxAxis() {
        return xAxis;
    }

    public void setxAxis(int xAxis) {
        if (isAlive){
            if (this.xAxis >= 610){
                this.xAxis = 610;
            }else if (this.xAxis <= 0){
                this.xAxis = 0;
            }else
                this.xAxis = xAxis;
        }else{
            this.xAxis = xAxis;
        }
    }

    public int getyAxis() {
        return yAxis;
    }

    public void setyAxis(int yAxis) {
        if (isAlive){
            if (this.yAxis >= 400){
                this.yAxis = 400;
            }else if (this.yAxis <= 0){
                this.yAxis = 0;
            }else
                this.yAxis = yAxis;
        }else{
            this.yAxis = yAxis;
        }
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        if (imagePath == null)
            JOptionPane.showMessageDialog(null,"Invalid String!");
        else if (imagePath.length() == 0)
            JOptionPane.showMessageDialog(null,"String empty");
        else
        this.imagePath = imagePath;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    public void drawPlayer(Graphics g){
        ImageIcon img = new ImageIcon(imagePath);
        g.drawImage(img.getImage(),xAxis,yAxis,null);

    }


}
