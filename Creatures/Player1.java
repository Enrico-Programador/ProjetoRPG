package Creatures;
import Main.GamePanel;
import Main.Keys;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Player1 extends Creatures{


    GamePanel gp;
    Keys keyH;


    public Player1(GamePanel gp, Keys keyH){

            this.gp = gp;
            this.keyH = keyH;
            setDefaultValues();
            getPlayerSprites();
    }

    public void setDefaultValues(){
        x=100;
        y=100;
        speed=4;
        direction = "down";
    }

    public void getPlayerSprites(){

        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Character/man_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Character/man_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Character/man_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Character/man_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Character/man_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Character/man_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Character/man_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Character/man_right_2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }





    }

    public void update() {
      if (keyH.upPress) {
        direction = "up";
        y -= speed;
    }
      if (keyH.downPress) {
        direction = "down";
        y += speed;
    }
      if (keyH.leftPress) {
        direction = "left";
        x -= speed;
    }
      if (keyH.rightPress) {
        direction = "right";
        x += speed;
      }
  }

    public void draw(Graphics2D g2){

        BufferedImage image = null;
        switch(direction){
            case "up":
             image = up1;
             break;
             case "down":
             image = down1;
             break;
             case "left":
             image = left1;
             break;
             case "right":
             image = right1;
             break;
        }
        g2.drawImage(image, x, y,gp.tileSize, gp.tileSize, null);

        //g2.setColor(Color.red);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);
                     //      width        height

    }

}
