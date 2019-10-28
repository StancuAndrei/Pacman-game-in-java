package com.Andrei;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Level1 extends JPanel implements KeyListener {

    private int xAxisOfEvilPacman = 10;
    private int yAxisOfEvilPacman = 10;
    public int widhtOfLevel = 640;
    public  int heightOfLeve = 480;

    private JFrame window = new JFrame("Pacman by Andrei Stancu.");
    private ImageIcon background = new ImageIcon("images//paddle.png");
    private Player player = new Player(5,10,10,"images//pacmanRight.png",true);
    EvilPacman evilPacman1 = new EvilPacman(5,xAxisOfEvilPacman + 20,yAxisOfEvilPacman + 100,"images//evilPacmanRight.png",true,this,player);
    EvilPacman evilPacman2 = new EvilPacman(5,xAxisOfEvilPacman + 100,yAxisOfEvilPacman + 200,"images//evilPacmanRight.png",true,this,player);
    EvilPacman evilPacman3 = new EvilPacman(5,xAxisOfEvilPacman + 100,yAxisOfEvilPacman + 150,"images//evilPacmanRight.png",true,this,player);
    EvilPacman evilPacman4 = new EvilPacman(5,xAxisOfEvilPacman + 20,yAxisOfEvilPacman + 250,"images//evilPacmanRight.png",true,this,player);



    private int speed = 10;
    private String right = "images//pacmanRight.png";
    private String left = "images//pacmanLeft.png";
    private String up_left = "images//pacmanLeftUp.png";
    private String up_right = "images//pacmanRightUp.png";
    private String down_left = "images//pacmanLeftDown.png";
    private String down_right = "images//pacmanRightDown.png";
    private String lastMove = "";




    public Level1(){

        this.setFocusable(true);
        this.addKeyListener(this);
        window.add(this);
        Thread thread = new Thread(evilPacman1);
        thread.start();
        Thread thread2 = new Thread(evilPacman2);
        thread2.start();
        Thread thread3 = new Thread(evilPacman3);
        thread3.start();
        Thread thread4 = new Thread(evilPacman4);
        thread4.start();


        window.setSize(widhtOfLevel,heightOfLeve);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);



    }

    public void paint(Graphics g){
        g.drawImage(background.getImage(),0,0,null);
        player.drawPlayer(g);
        evilPacman1.drawPlayer(g);
        evilPacman2.drawPlayer(g);
        evilPacman3.drawPlayer(g);
        evilPacman4.drawPlayer(g);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT){
            player.setImagePath("images//pacmanRight.png");
            player.setxAxis(player.getxAxis() + speed);
            lastMove = right;
        this.repaint();
        } else if (ke.getKeyCode() == KeyEvent.VK_LEFT){
            player.setImagePath("images//pacmanLeft.png");
            player.setxAxis(player.getxAxis() - speed);
            lastMove = left;
            this.repaint();
        }else if (ke.getKeyCode() == KeyEvent.VK_UP){
//            player.setImagePath("images//pacmanUp.png");
            player.setyAxis(player.getyAxis() - speed);
            if (lastMove == right){
                player.setImagePath(up_right);
            }else{
                player.setImagePath(up_left);
            }
            this.repaint();

        }else if (ke.getKeyCode() == KeyEvent.VK_DOWN){
//            player.setImagePath("images//pacmanDown.png");
            player.setyAxis(player.getyAxis() + speed);
            if (lastMove == right){
                player.setImagePath(down_right);
            }else{
                player.setImagePath(down_left);
            }
            this.repaint();
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }




}
