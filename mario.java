import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SuperMario extends Frame implements KeyListener {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private BufferedImage image;
    private List<Sprite> sprites;
    private Sprite mario;

    public SuperMario() throws IOException {
        super("Super Mario");
        setSize(WIDTH, HEIGHT);
        addKeyListener(this);

        image = ImageIO.read(new File("mario.png"));
        sprites = new ArrayList<>();
        mario = new Sprite(image, 100, 100);
        sprites.add(mario);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
        for (Sprite sprite : sprites) {
            sprite.draw(g);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                mario.jump();
                break;
            case KeyEvent.VK_LEFT:
                mario.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                mario.moveRight();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public static void main(String[] args) throws IOException {
        SuperMario game = new SuperMario();
        game.setVisible(true);
        while (true) {
            game.repaint();
            Thread.sleep(100);
        }
    }
}
