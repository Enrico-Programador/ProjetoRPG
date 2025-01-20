package Creatures;
import Main.GamePanel;
import Main.Keys;
import java.awt.Color;
import java.awt.Graphics2D;


public class Player1 extends Creatures{


    GamePanel gp;
    Keys keyH;

    public Player1(GamePanel gp, Keys keyH){

            this.gp = gp;
            this.keyH = keyH;
            setDefaultValues();

    }
    public void setDefaultValues(){

        x=100;
        y=100;
        speed=4;

    }
    public void update(){
           if(keyH.upPress){
            y -= speed;
           }
           else if(keyH.downPress){
             y += speed;
           }
           else if(keyH.rightPress){
             x += speed;
           }
           else if(keyH.leftPress){
             x -= speed;
           }
    }

    public void draw(Graphics2D g2){

        g2.setColor(Color.red);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
                     //x        y      width     height
    }

}
