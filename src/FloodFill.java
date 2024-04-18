import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;

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
            // contains current pixel / position of the iterator
            Point currentPixel = pixelIterator.next();

            // modify colors of image
            modifiedImage.setRGB(currentPixel.x, currentPixel.y, fillColor.getRGB());

        }

        return modifiedImage;
    }

    /**
     * Fills a BufferedImage with a grid pattern.
     *
     * @param img       the BufferedImage to fill
     * @param bgColor   the background color for areas not covered by the grid
     * @param gridColor the color of the grid lines
     * @param start     the starting point for the grid fill
     * @param thresh    the threshold value for the grid fill
     * @param spacing   the spacing between grid lines
     * @return a new BufferedImage with the grid pattern filled
     */
    public static BufferedImage gridFill(BufferedImage img, Color bgColor, Color gridColor,
            Point start, double thresh, int spacing) {

        // create copy of image
        BufferedImage modifiedImage = Utilities.copyImage(img);

        // create ImageWalker object using the original image (img), thresh and start
        ImageWalker imageWalker = new ImageWalker(img, start, thresh);

        // iterator to move through the images pixels
        Iterator<Point> pixelIterator = imageWalker.iterator();

        // traverse through through imgs pixels
        while (pixelIterator.hasNext()) {
            // contains current pixel / position of the iterator
            Point currentPixel = pixelIterator.next();

            // modify colors of image based if x or y a multiple of spacing
            if (currentPixel.x % spacing == 0 || currentPixel.y % spacing == 0) {
                modifiedImage.setRGB(currentPixel.x, currentPixel.y, gridColor.getRGB());
            }

            // if not a multiple of spacing
            else {
                modifiedImage.setRGB(currentPixel.x, currentPixel.y, bgColor.getRGB());
            }

        }
        return modifiedImage;

    }

    /**
     * Animates filling of a BufferedImage with a specified color.
     *
     * @param img      the BufferedImage to animate
     * @param c        the color to fill the BufferedImage with
     * @param start    the starting point for the fill animation
     * @param thresh   the threshold value for the animation
     * @param interval the interval at which frames are generated
     */
    public static void animateFill(BufferedImage img, Color c,
            Point start, double thresh, int interval) {
        // create copy of image
        BufferedImage modifiedImage = Utilities.copyImage(img);

        // create ImageWalker object using the original image (img), thresh and start
        ImageWalker imageWalker = new ImageWalker(img, start, thresh);

        // iterator to move through the images pixels
        Iterator<Point> pixelIterator = imageWalker.iterator();

        // count how many times pixel are changed
        int changeCounter = 0;

        // int to keep track of "frames"
        int imgNum = 0;

        // traverse through through imgs pixels
        while (pixelIterator.hasNext()) {
            // contains current pixel / position of the iterator
            Point currentPixel = pixelIterator.next();

            // modify colors of image
            modifiedImage.setRGB(currentPixel.x, currentPixel.y, c.getRGB());

            changeCounter++;

            if (changeCounter % interval == 0) {
                imgNum++;

                String fileName = String.format("animations/image-%04d.png", imgNum);

                // Frame image based on interval
                BufferedImage frame = Utilities.copyImage(modifiedImage);

                try {
                    ImageIO.write(frame, "PNG", new File(fileName));
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }

        }

    }

}
