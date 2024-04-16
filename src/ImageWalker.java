import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Represents an iterator for performing flood-fill operation on an image.
 */
public class ImageWalker implements Iterable<Point> {

  /**
   * Inner class implementing the BFSIterator for the flood-fill operation.
   */
  private class BFSIterator implements Iterator<Point> {

    //needed variables
    private Queue<Point> queue;
    private boolean[][] visited;

    /**
     * Constructor method
     */
    private BFSIterator() {
      // initialize needed variables needed to for the iterator method
      queue = new LinkedList<>();
      visited = new boolean[image.getWidth()][image.getHeight()];
      queue.add(start);
      visited[start.x][start.y] = true;
    }

    /**
     * Checks if there are more points to iterate over.
     * 
     * @return true if there are more points, false otherwise.
     */
    @Override
    public boolean hasNext() {
      // check if queue is empty
      if (!queue.isEmpty()) {
        return true;
      }

      return false;
    }

    /**
     * Returns the next point to process in the flood-fill operation.
     * 
     * @return the next point.
     */
    @Override
    public Point next() {
      // check if the iterater is at the end
      if (!hasNext()) {
        throw new NoSuchElementException("Queue is empty");
      }

      // contiains the current position of the iterator
      Point currentPoint = queue.poll();
      int x = currentPoint.x;
      int y = currentPoint.y;

      // Moving through the pixels in the following order:
      // The pixel to the right (x+1)
      if (x + 1 < image.getWidth() && !visited[x + 1][y]
          && Utilities.computeDelta(image.getRGB(x + 1, y), image.getRGB(start.x, start.y)) <= threshold) {

        // mark pixel as visited
        visited[x + 1][y] = true;

        // add pixel to queue
        queue.add(new Point(x + 1, y));
      }

      // The pixel below (y+1)
      if (y + 1 < image.getHeight() && !visited[x][y + 1]
          && Utilities.computeDelta(image.getRGB(x, y + 1), image.getRGB(start.x, start.y)) <= threshold) {

        // mark pixel as visited
        visited[x][y + 1] = true;

        // add pixel to queue
        queue.add(new Point(x, y + 1));
      }

      // The pixel to the left (x-1)
      if (x - 1 >= 0 && !visited[x - 1][y]
          && Utilities.computeDelta(image.getRGB(x - 1, y), image.getRGB(start.x, start.y)) <= threshold) {

        // mark pixel as visited
        visited[x - 1][y] = true;

        // add pixel to queue
        queue.add(new Point(x - 1, y));
      }

      // The pixel above (y-1)
      if (y - 1 >= 0 && !visited[x][y - 1]
          && Utilities.computeDelta(image.getRGB(x, y - 1), image.getRGB(start.x, start.y)) <= threshold) {

        // mark pixel as visited
        visited[x][y - 1] = true;

        // add pixel to queue
        queue.add(new Point(x, y - 1));

      }

      return currentPoint;
    }

  }

  // variables needed
  private BufferedImage image;
  private double threshold;
  private Point start;

  /**
   * Constructs an ImageWalker with the provided image, starting point, and
   * threshold.
   * 
   * @param img     the BufferedImage to perform flood-fill on.
   * @param startPT the starting point for the flood-fill operation.
   * @param thresh  the threshold for color difference.
   */
  public ImageWalker(BufferedImage img, Point startPT, double thresh) {

    image = img;
    start = startPT;
    threshold = thresh;

  }

  /**
   * Returns an iterator for the flood-fill operation.
   * 
   * @return an Iterator<Point> for flood-fill operation.
   */
  @Override
  public Iterator<Point> iterator() {

    return new BFSIterator();
  }
}
