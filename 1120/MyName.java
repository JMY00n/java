package graphic;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyName extends JFrame {

    public MyName() {
        super("윤정민");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 350);
        
        add(new DrawNamePanel());
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    class DrawNamePanel extends JPanel {
    	@Override
    	protected void paintComponent(Graphics g) {
    		super.paintComponent(g);
    		
    		drawYoon(g);
    	}
    }
    
    public void drawYoon(Graphics g) {
    	g.setColor(Color.BLACK);
    	g.drawOval(30, 30, 30, 30);
    	g.drawLine(20, 80, 80, 80);
    	g.drawLine(40, 80, 40, 120);
    	g.drawLine(60, 80, 60, 120);
    	g.drawLine(20, 110, 20, 140);
    	g.drawLine(20, 140, 60, 140);
    }

    public static void main(String[] args) {
        new MyName();
    }
}