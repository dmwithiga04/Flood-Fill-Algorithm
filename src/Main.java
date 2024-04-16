import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

    public static void main(String[] args) throws IOException {

        // Load the image
        BufferedImage img = ImageIO.read(new File("ovals.png"));
        // Flood fill starting at (0,0)
        BufferedImage filled = FloodFill.gridFill(img, Color.blue, Color.green, new Point(0, 0), 0.2,10);
        // Write out the result to "out.png"
        ImageIO.write(filled, "PNG", new File("out.png"));

    }

}
