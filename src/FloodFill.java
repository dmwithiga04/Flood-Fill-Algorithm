import java.awt.*;
import java.awt.image.BufferedImage;

public class FloodFill {

/**
 * A class containing a few helper methods that may be useful for the flood-fill lab assignment.
 */
public class Utilities {

    /**
     * Copies a BufferedImage and returns the copy.
     * @param img a BufferedImage
     * @return an independent copy of img
     */
    public static BufferedImage copyImage(BufferedImage img ) {
        BufferedImage clone = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        Graphics2D g2d = clone.createGraphics();
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();
        return clone;
    }

    /**
     * Computes and returns a "distance" between the colors of two pixels.
     *
     * @param pixelA an integer pixel value (in the form produced by BufferedImage.getRGB(x,y) )
     * @param pixelB an integer pixel value (in the form produced by BufferedImage.getRGB(x,y) )
     * @return a "distance" between the two colors
     */
    public static double computeDelta( int pixelA, int pixelB ) {
        float[] hsbA = Color.RGBtoHSB((pixelA >> 16) & 0xff, (pixelA >> 8) & 0xff, pixelA & 0xff, null );
        float[] hsbB = Color.RGBtoHSB((pixelB >> 16) & 0xff, (pixelB >> 8) & 0xff, pixelB & 0xff, null );

        float dist2 =
                (hsbA[0] - hsbB[0]) * (hsbA[0] - hsbB[0]) +
                (hsbA[1] - hsbB[1]) * (hsbA[1] - hsbB[1]) +
                (hsbA[2] - hsbB[2]) * (hsbA[2] - hsbB[2]);

        return Math.sqrt(dist2);
    }

}

public static BufferedImage fill (BufferedImage img, Color fillColor, Point start, double thresh) {
    return null;
}
}
