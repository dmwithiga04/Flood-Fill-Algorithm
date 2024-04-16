import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Iterator;


public class FloodFill {

    /**
     * Fills the area around a starting point in an image with a specified color.
     *
     * @param img       the BufferedImage to perform flood-fill on.
     * @param fillColor the color to fill the area with.
     * @param start     the starting point for the flood-fill operation.
     * @param thresh    the threshold for color difference.
     * @return a new BufferedImage with the filled area.
     */
    public static BufferedImage fill(BufferedImage img, Color fillColor, Point start, double thresh) {
        
        // create copy of image
        BufferedImage modifiedImage = Utilities.copyImage(img);

        // create ImageWalker object using the original image (img), thresh and start
        ImageWalker imageWalker = new ImageWalker(img, start, thresh);

        // iterator to move through the images pixels
        Iterator<Point> pixelIterator = imageWalker.iterator();

        // traverse through through imgs pixels
        while (pixelIterator.hasNext()) {
            //contains current pixel / position of the iterator
            Point currentPixel = pixelIterator.next();

            //modify colors of image
            modifiedImage.setRGB(currentPixel.x, currentPixel.y, fillColor.getRGB());
            
        }

        return modifiedImage;
    }
}
