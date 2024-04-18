import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

    public static void main(String[] args) throws IOException {

        // Load the image
        BufferedImage img = ImageIO.read(new File("die_4.png"));
        // Flood fill starting at (0,0)
        FloodFill.animateFill(img,Color.blue, new Point(0,0),0.1, 100);

    }

}
