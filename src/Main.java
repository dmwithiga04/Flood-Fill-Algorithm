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
        BufferedImage filled = FloodFill.fill(img, Color.blue, new Point(0, 0), 1.5);
        // Write out the result to "out.png"
        ImageIO.write(filled, "PNG", new File("out.png"));
    }

}
