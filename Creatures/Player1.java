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

    private int spriteIndex = 0;
    private BufferedImage[] upSprites, downSprites, leftSprites, rightSprites;
    
    public void getPlayerSprites(){

        try {
          upSprites = new BufferedImage[]{
            ImageIO.read(getClass().getResourceAsStream("/Sprites/Character/man_up_1.png")),
            ImageIO.read(getClass().getResourceAsStream("/Sprites/Character/man_up_2.png"))
          };
          downSprites = new BufferedImage[]{
            ImageIO.read(getClass().getResourceAsStream("/Sprites/Character/man_down_1.png")),
            ImageIO.read(getClass().getResourceAsStream("/Sprites/Character/man_down_2.png"))
          };
          leftSprites = new BufferedImage[]{
            left1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Character/man_left_1.png")),
            left2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Character/man_left_2.png"))
          };
          rightSprites = new BufferedImage[]{
            right1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Character/man_right_1.png")),
            right2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/Character/man_right_2.png"))
          };
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void update() {
      Boolean moving = false;
      if (keyH.upPress) {
        direction = "up";
        y -= speed;
        moving = true;
      }
      if (keyH.downPress) {
        direction = "down";
        y += speed;
        moving = true;
      }
      if (keyH.leftPress) {
        direction = "left";
        x -= speed;
        moving = true;
      }
      if (keyH.rightPress) {
        direction = "right";
        x += speed;
        moving = true;
      }

      //lembrar de usar a lógica abaixo pra criar uma idle animation
      if (moving) {
        spriteCounter++;
        if (spriteCounter > 10) { // Troca o sprite a cada 10 frames
            spriteIndex = (spriteIndex + 1) % 2; // 2 é o número do sprite não esuqecer de alterar
            spriteCounter = 0; //"%" serve para limitar quantas vezes spriteIndex vai rodar(no caso 2x)
        }
                 }
}

    public void draw(Graphics2D g2){

        BufferedImage image = null;
        switch(direction){
          
            case "up":
             image = upSprites[spriteIndex];
             break;

             case "down":
             image = downSprites[spriteIndex];
             break;

             case "left":
             image = leftSprites[spriteIndex];
             break;

             case "right":
             image = rightSprites[spriteIndex];
             break;
             }
             
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
            /*
        g2.setColor(Color.red); código altigo provavelmente inútil
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
                     //      width        height*/
             }

 }
