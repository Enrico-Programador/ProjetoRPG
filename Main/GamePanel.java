package Main;
import Creatures.Player1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;



public class GamePanel extends JPanel implements Runnable{

      final int originalTileSize = 16;
      final int scale = 3;
      public final int tileSize = originalTileSize * scale;
      final int maxScreenCol = 16;
      final int maxScreenRow = 12;
      final int screenWidth = tileSize * maxScreenCol;
      final int screenHeight = tileSize * maxScreenRow;

      Keys keyH = new Keys();
      Thread gameThread;
      boolean running = false;
      Player1 player1 = new Player1(this, keyH);


      public GamePanel() {
      this.setPreferredSize(new Dimension(screenWidth, screenHeight));
      this.setBackground(Color.green);
      this.setDoubleBuffered(true);
      this.setFocusable(true);
      this.requestFocusInWindow();
      keyH.configureKeyBindings(this);
      }

      public void startGameThread(){
        gameThread = new Thread(this);
        running = true;
        gameThread.start();
        
      }
      
      @Override
      public void run(){

        int frames = 0;
        long timer = System.currentTimeMillis();

     while (running){
      //atualizar as informações do jogo
      update();

      //desenhar a tela com as informações atualizadas
      repaint();
      
      //incrementar contador para display
      frames++;

      if (System.currentTimeMillis() - timer >= 1000){
        System.out.println("FPS:"+frames);
        frames=0;
        timer += 1000;
      }

      //definir o fps
      try {
        Thread.sleep(16);
          } catch (Exception e) {

                                }
     }
  }

  public void update(){

    player1.update();

  }

  //paintComponent é como se fosse seu pincel/lápis
      @Override
  public void paintComponent(Graphics g){
//super é para puxar o jPanel sua "Parent Class" no caso
super.paintComponent(g);
Graphics2D g2 = (Graphics2D)g;
player1.draw(g2);
//salvar memória          
g2.dispose();
  }


  public void stopGameThread(){
    running = false;
    try {
        gameThread.join();
    } catch (InterruptedException e) {

    }
  }

}
