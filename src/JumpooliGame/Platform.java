package JumpooliGame;

import java.awt.*;

/**
 * WebGame
 * Created by Aria Pahlavan on Apr 2016.
 */
public class Platform {
    private int dx, x, y, width, height;

    public Platform() {
        this.dx = -10;
        this.x = 300;
        this.y = 300;
        this.width = 120;
        this.height = 40;
    }

    public Platform(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }

    /**
     * Updates the position of the platform after it moves to the left.
     *
     * @param display
     */
    public void updatePlatform(StartingPoint display, Ball b) {
//        x += dx;
        int ballY = b.getY();
        int ballX = b.getX();
        int ballRadius = b.getRADIUS();

        if ( ballY + ballRadius > y && ballY - ballRadius < y + height ) {
            if ( ballX > x && ballX < x + width ) {
                b.setY(y - ballRadius);
                b.setDy(b.getDy() * -1);
            }
        }

        if ( ballX + ballRadius > x && ballX - ballRadius < x + width ) {
            if ( ballY > y && ballY < y + height ) {
                b.setDx(b.getDx() * -1);
            }
        }
    }

    /**
     * Paints the ball on the screen
     *
     * @param g
     */
    public void paintPlatform(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(x, y, width, height);
    }
}