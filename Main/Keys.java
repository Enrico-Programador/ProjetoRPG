package Main;
import java.awt.event.*;
import javax.swing.*;

public class Keys{

public boolean upPress, downPress, leftPress, rightPress;

public void configureKeyBindings(GamePanel gamePanel){

InputMap inputMap = gamePanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
ActionMap actionMap = gamePanel.getActionMap();

//movimento para cima
gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "moveUp");
gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released W"), "stopUp");
inputMap.put(KeyStroke.getKeyStroke("W"), "moveUp");
actionMap.put("moveUp", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        upPress = true;
    }
});
actionMap.put("stopUp", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        upPress = false;
    }
});
//movimento para cima

//movimento para baixo
gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "moveDown");
gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released S"), "stopDown");
inputMap.put(KeyStroke.getKeyStroke("S"), "moveDown");
actionMap.put("moveDown", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        downPress = true;
    }
});
actionMap.put("stopDown", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        downPress = false;
    }
});
//movimento para baixo

//movimento para esquerda
gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "moveLeft");
gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released A"), "stopLeft");
inputMap.put(KeyStroke.getKeyStroke("A"), "moveLeft");
actionMap.put("moveLeft", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        leftPress = true;
    }
});
actionMap.put("stopLeft", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        leftPress = false;
    }
});
//movimento para esquerda

//movimento para direita
gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "moveRight");
gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released D"), "stopRight");
inputMap.put(KeyStroke.getKeyStroke("D"), "moveRight");
actionMap.put("moveRight", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        rightPress = true;
    }
});
actionMap.put("stopRight", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        rightPress = false;
    }
});
//movimento para direita


 }
}