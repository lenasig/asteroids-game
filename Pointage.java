package asteroid;

import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import animation.AnimatedObject;

/**
 * Keeps the score of the game
 * 
 * @author Lena
 */
public class Pointage implements AnimatedObject {

    /* the physical shape representation of the point box */
    private Rectangle2D.Double box;

    /* The x coordinate of the point box */
    final private static int X = 20;

    /* The y coordinate of the point box */
    final private static int Y = 20;

    /* The width of the point box */
    final private static int WIDTH = 120;

    /* The height of the point box */
    final private static int HEIGHT = 40;

    /* The user's current number of points */
    private int points = 0;

    /* The user's current level */
    private int level = 1;

    /* Flag specifying whether game is over */
    private boolean gameOver = false;

    private BufferedImage img;

    /**
     * Creates physical representation of the point box.
     */
    public Pointage() {
        box = new Rectangle2D.Double(X, Y, WIDTH, HEIGHT);
    }

    /**
     * Draws the box and the current points and level in the top left corner.
     * 
     * @param g the graphics context to draw on.
     */
    public void paint(Graphics2D g) {
        g.setColor(Color.ORANGE);
        g.draw(box);
        // tweak coordinates so that text is inside of, rather than above, box
        g.drawString("Points: " + points, X + 5, Y + 30);
        g.drawString("Level: " + level, X + 5, Y + 15);
        if (gameOver) {
            try {
                img = ImageIO
                        .read(getClass().getResourceAsStream("/gameOver.png"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // x and y are 300, so that it appears in the middle
            g.drawImage(img, GameDemo.WINDOW_SIZE / 2, GameDemo.WINDOW_SIZE / 2,
                    WIDTH, HEIGHT, null);
        }
    }

    /**
     * Adds the specified number to point variable Note: We add 100 points for
     * each asteroid and 200 for each saucer
     * 
     * @param num points to add
     * @return true if points are high enough to level up
     */
    // returns true if level changes
    public boolean add(int num) {
        points += num;
        // level changes every 1000 points
        if ((points / level) >= 10) {
            level++;
            return true;
        }
        return false;
    }

    /**
     * Sets gameOver to true.
     * 
     */
    public void gameOver() {
        gameOver = true;
    }

    public void nextFrame() {
    }
}