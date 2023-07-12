package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Documented;

public class Panel extends JPanel {
    private int x;
    private int y;
    private int width;
    private int height;
    private String text;
    private ChromeDriver driver;
    private BufferedImage background;
    private JButton firstCurrency;
    private JButton secondCurrency;
    private JButton thirdCurrency;
    private JButton fourthCurrency;
    private JButton fifthCurrency;
    private JLabel exchangeInfo;

    public Panel(int x, int y, int width, int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.setBounds(this.x,this.y,this.width,this.height);
        this.setLayout(null);
        this.text="";
        loadBackGround();
        firstButton();
        secondButton();
        thirdButton();
        fourthButton();
        fifthButton();
        forExchangeInfo();
        //openBrowser();

    }



    public void loadBackGround(){
        try{
            this.background= ImageIO.read(new File("src/main/java/org/example/24020517-1.jpg"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void firstButton(){
        this.firstCurrency= new JButton("EUR/USD");
        this.firstCurrency.setBounds(0,100,100,100);
        this.add(this.firstCurrency);
        this.firstCurrency.setVisible(true);
        this.firstCurrency.addActionListener(e -> {
            removeAllButtons();
            openBrowser(this.firstCurrency.getText());
         //   WebElement webElement = this.driver.findElement(By.id("pair_1"));
         //   System.out.println(webElement);
          // this.exchangeInfo.setText();
        });
    }
    private void secondButton(){
        this.secondCurrency=new JButton("GBP/USD");
        this.secondCurrency.setBounds(this.firstCurrency.getX(),this.firstCurrency.getY()+100,this.firstCurrency.getWidth(),this.firstCurrency.getHeight());
        this.add(this.secondCurrency);
        this.secondCurrency.setVisible(true);
        this.secondCurrency.addActionListener(e -> {
            removeAllButtons();
            openBrowser(this.secondCurrency.getText());
        });
    }
    private void thirdButton(){
        this.thirdCurrency=new JButton("USD/JPY");
        this.thirdCurrency.setBounds(this.secondCurrency.getX(),this.secondCurrency.getY()+100,this.secondCurrency.getWidth(),this.secondCurrency.getHeight());
        this.add(this.thirdCurrency);
        this.thirdCurrency.setVisible(true);
        this.thirdCurrency.addActionListener(e -> {
            removeAllButtons();
            openBrowser(this.thirdCurrency.getText());

        });
    }
    private void fourthButton(){
        this.fourthCurrency=new JButton("AUD/USD");
        this.fourthCurrency.setBounds(this.thirdCurrency.getX(),this.thirdCurrency.getY()+100,this.thirdCurrency.getWidth(),this.thirdCurrency.getHeight());
        this.add(this.fourthCurrency);
        this.fourthCurrency.setVisible(true);
        this.fourthCurrency.addActionListener(e -> {
            removeAllButtons();
            openBrowser(this.fourthCurrency.getText());

        });
    }
    private void fifthButton(){
        this.fifthCurrency= new JButton("USD/CHF");
        this.fifthCurrency.setBounds(this.fourthCurrency.getX(),this.fourthCurrency.getY()+100,this.fourthCurrency.getWidth(),this.fourthCurrency.getHeight());
        this.add(this.fifthCurrency);
        this.fifthCurrency.setVisible(true);
        this.fifthCurrency.addActionListener(e->{
            removeAllButtons();
            openBrowser(this.fifthCurrency.getText());

        });
    }
    private void removeAllButtons(){
        this.fifthCurrency.setVisible(false);
        this.fourthCurrency.setVisible(false);
        this.thirdCurrency.setVisible(false);
        this.secondCurrency.setVisible(false);
        this.firstCurrency.setVisible(false);
        this.exchangeInfo.setVisible(true);
    }
    private void forExchangeInfo(){
        this.exchangeInfo=new JLabel("I WANNA KILL MYSELF");
        this.exchangeInfo.setBounds(0,100,300,300);
        this.exchangeInfo.setFont(new Font("Arial",Font.BOLD,15));
        this.add(this.exchangeInfo);
        this.exchangeInfo.setVisible(false);
    }

    private void openBrowser(String name){
       // System.setProperty("webdriver.openqa.driver","C:\\Users\\Anatoly\\OneDrive\\Desktop\\webdriver");
       // this.driver= new ChromeDriver();
        //driver.get("https://il.investing.com/currencies/");
        new Thread(()->{
            while (true){
                try{
                    Document document = Jsoup.connect("https://investing.com/currencies/").get();
                    Elements element = document.getElementsByClass("genTbl closedTbl crossRatesTbl");
                    String data = element.text();
                    data=data.substring(data.indexOf(name));
                    this.exchangeInfo.setText(data.substring(7,15));
                    try{
                        Thread.sleep(2000);
                    }catch (Exception e){

                    }

                }catch (IOException e){
                    System.out.println("sajna");
                }
            }
        }).start();


    }
    private void showInfo(){

    }
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        graphics.drawImage(this.background, 0,0,800,800,null);
    }
}
