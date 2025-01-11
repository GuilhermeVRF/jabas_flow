package views.customs;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.AbstractBorder;

public class RoundedBorder extends AbstractBorder {
    private int radius;
    private Color color;
    
    // Construtor que recebe o valor do raio das bordas
    public RoundedBorder(int radius) {
        this.radius = radius;
        this.color = Color.BLACK;
    }
    
    public RoundedBorder(int radius, Color color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(this.color); 

        g2d.draw(new RoundRectangle2D.Float(x, y, width - 1, height - 1, radius, radius));
    }
}
