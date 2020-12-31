package Presentacion.Vista;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class VistaGeneral extends JPanel {
	
	private Image imagen;
	private URL fondo;
	
	public VistaGeneral() {
		
		init();
		
	}
	
	
	
	public void init() {
		
		
		imagen = loadImage("general.png");
		
		
		this.setVisible(true);
	}
	
	private Image loadImage(String img) {
        Image i = null;
        try {
            return ImageIO.read(new File("resources/" + img));
        } catch (IOException e) {

        }
        return i;
    }
	
	public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
	
}
