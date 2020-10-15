package asteroid;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/***
 * Represents a saucer with attributes constituting its location and direction,
 * which are assigned randomly. Saucer is symbolized on screen by an oval and a
 * rectangle.
 * 
 * @author Lena
 *
 */
public class Saucer extends RandomizedFlyingObject {

    /* The width of the saucer, in pixels */
    private int SAUCER_WIDTH;

    /* The height of the saucer, in pixels */
    private int SAUCER_HEIGHT;

    private BufferedImage img;

    /**
     * Creates a saucer object with a specified speed and random location and
     * direction.
     * 
     * @param speed speed of saucer
     * @param size  size of saucer
     * 
     * @author Lena & Aarushi
     * 
     */
    public Saucer(int speed, int size) {
        SAUCER_WIDTH = size;
        SAUCER_HEIGHT = 2 * SAUCER_WIDTH / 3;
        place();
        setMoveAmount(speed);
        Rectangle2D.Double temp = new Rectangle2D.Double(getX(), getY(),
                SAUCER_WIDTH, SAUCER_HEIGHT);
        setShape(new Path2D.Double(temp));
    }

    /**
     * Draws a an oval and a rectangle at its current x and y coordinates.
     * 
     * @param g the graphics context to draw on.
     */
    public void paint(Graphics2D g) {
        g.setColor(Color.WHITE);
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/saucer.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        g.drawImage(img, (int) getX(), (int) getY(), SAUCER_WIDTH + 30,
                SAUCER_HEIGHT + 30, null);
    }

    public int getWidth() {
        return SAUCER_WIDTH;
    }

    public int getHeight() {
        return SAUCER_HEIGHT;
    }

}