import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.Queue;
public class ImageWalker implements Iterable<Point> {

  private class BFSIterator implements Iterator<Point> {

    private Queue<Point> queue;
    private boolean[][] visited;

    @Override
    public boolean hasNext() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
    }

    @Override
    public Point next() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'next'");
    }

  }

  private BufferedImage image;
  private double threshold;
  private Point start;

  public ImageWalker(BufferedImage omg, Point startPT, double thresh) {

    image = omg;
    start = startPT;
    threshold = thresh;
    
  }

  @Override
  public Iterator<Point> iterator() {
    return new BFSIterator();
  }
}