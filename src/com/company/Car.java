package com.company;

import javax.swing.*;
public class Car extends JFrame{

    public static void main(String[] args) {
        JFrame app=new JFrame (  );
        simulator s=new simulator ();
        app.add ( s );
        app.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        app.setSize(500,720);
        app.setVisible ( true );
    }
}
