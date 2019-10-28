package com.Andrei;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class EvilPacman extends Player implements Runnable{

    boolean colision = false;
    private Player player;
    private Level1 level;
    Random random = new Random();
    public int direction = 1; // evil pacman merge spre dreapta,dreapta e 1 stanga e -1

    public EvilPacman(int lives, int xAxis, int yAxis, String imagePath, boolean isAlive,Level1 level,Player player) {
        super(lives, xAxis, yAxis, imagePath, isAlive);
        this.level = level;
        this.player = player;
    }

    public void kill(){

        Rectangle pacmanRect = new Rectangle(player.getxAxis(),player.getyAxis(),30,30);
        Rectangle evilRect = new Rectangle(this.getxAxis(),this.getyAxis(),30,30);

//        if (pacmanRect.contains(evilRect)){
//            JOptionPane.showMessageDialog(null,"You died");
//
//            System.exit(0);
//        }
        if (pacmanRect.intersects(evilRect)) {
            colision = true;
            JOptionPane.showMessageDialog(null,"Youd died");
            System.exit(0);
        }



    }

    @Override
    public void run() {
        while (true){            try{
                Thread.sleep(random.nextInt(100));
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Thread intrerrupted");
                System.exit(1);
            }
            if(getxAxis() <= new Random().nextInt(200)) {
                direction = 1;
                setImagePath("images//evilPacmanRight.png");
            } else if (getxAxis() >= new Random().nextInt(level.widhtOfLevel - 60)) {
                direction = -1;
                setImagePath("images//evilPacmanLeft.png");
            }

            kill();
            setxAxis(getxAxis() + 3 * direction);
            level.repaint();

        }
    }


}
