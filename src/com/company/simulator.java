package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

class simulator extends JPanel implements ActionListener, KeyListener {
    private int space;
    private int speed ;
    private int WIDTH=500;
    private int HEIGHT=700;
    private Random rand;
    private Rectangle car;
    private ArrayList<Rectangle> ocars;
    private int width=80;
    private int height=70;
    private int move=20;
    Timer t;
    public simulator(){
        rand=new Random (  );
        car=new Rectangle ( WIDTH/2-90,HEIGHT-100,width,height );
        ocars=new ArrayList <Rectangle> (  );
        space=100;
    speed=2;
    addKeyListener ( this );
    setFocusable ( true );
    t=new Timer (20,this );
    t.start ();
     addocars ( true );
        addocars ( true );

        addocars ( true );
    }
    public void addocars(boolean first){
        int positionx=rand.nextInt ()%2;
        int x=0;
        int y=0;
        int Width=width;
        int Height=height;
        if(positionx==0){
         x=WIDTH/2-90;
    }
        else{
         x=WIDTH/2+ 10;
        }
        if(first){
            ocars.add ( new Rectangle ( x,y-100-(ocars.size ()*space),Width,Height ) );
    }else{
            ocars.add ( new Rectangle ( x, ocars.get ( ocars.size () - 1).x+ space, Width, Height ) ) ;
        }
    }


public void paintComponent(Graphics g){
    super.paintComponent ( g );
    g.setColor ( Color.cyan );
    g.fillRect ( 0,0,WIDTH,HEIGHT );
    g.setColor(Color.gray);
    g.fillRect ( WIDTH/2-100,0,200,HEIGHT );
    g.setColor ( Color.red );
    g.fillRect ( car.x,car.y,car.width,car.height );
    g.setColor ( Color.blue );
    g.drawLine ( WIDTH/2,0,WIDTH/2,HEIGHT );
    g.setColor ( Color.orange );
     for(Rectangle rect:ocars){
         g.fillRect ( rect.x,rect.y,rect.width,rect.height );
     }


}
    @Override
    public void actionPerformed(ActionEvent e) {
Rectangle rect;

for(int i=0;i<ocars.size ();i++){
    rect=ocars.get(i);
    rect.y+=speed;
    }
repaint();
}


public void moveup(){
        if(car.y-move<0) {
            System.out.println ( "\b" );
        }else {
            car.y-=move;


}
    }
    public void movedown(){
        if(car.y+move+car.height>HEIGHT-1){
            System.out.println ( "\b" );
        }else {
            car.y+=move;
    }
}
public void moveleft(){
        if(car.x-move<WIDTH/2-90){
            System.out.println ( "\b" );
        }else {
            car.x-=move;
}
}
public void moveright(){
    if ( car.y + move > WIDTH / 2 + 10 ) {
        System.out.println ( "\b" );
    }else{
        car.x+=move;
}
}

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
int key=e.getKeyCode ();
switch (key){
    case KeyEvent.VK_UP:
        moveup ();
        break;
    case KeyEvent.VK_DOWN:
        movedown();
        break;
    case KeyEvent.VK_LEFT:
        moveleft ();
        break;
    case KeyEvent.VK_RIGHT:
        moveright ();
        break;

    }
}}
