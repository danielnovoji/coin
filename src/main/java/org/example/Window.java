package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Window extends JFrame {
    private Image icon;

    public Window(){
        this.setSize(800,800);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setIcon();
        this.setIconImage(this.icon);
        this.add(new Panel(0,0,800,800));
        this.setTitle("MONAYYY");
        this.setVisible(true);
    }


    private void setIcon(){
        try{
            this.icon= ImageIO.read(new File("src/main/java/org/example/ayrdIcon.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
