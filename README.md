# Flood Fill Algorithm Project

## Project Overview
**Feb 2024 - Mar 2024**

Developed a custom **Flood Fill Algorithm** in Java, designed for efficient image processing. The algorithm utilizes a **Queue data structure** to accurately color pixels based on specified parameters, ensuring the integrity of the original image is maintained. This project demonstrates practical image processing techniques, with a focus on performance and accuracy.

## Key Features
- **Queue-Based Flood Fill:** Utilizes a queue to efficiently process and color large images.
- **Pixel Precision:** Accurately fills the desired areas based on user-specified parameters.
- **Image Preservation:** Maintains the quality and integrity of the original image during processing.

## Tech Stack
- **Language:** Java
- **Concepts Applied:** Image Processing, Queue Data Structure, Algorithms

## Usage
1. **Clone the repository.**
2. **Run the program** through the `main` method with your desired parameters(Pictures Provided for program use in Project Folder):
   ```
   public class Main {

    public static void main(String[] args) throws IOException {

        // Load the image
        BufferedImage img = ImageIO.read(new File("die_4.png"));
        // Flood fill starting at (0,0)
        FloodFill.animateFill(img,Color.blue, new Point(0,0),0.1, 100);

    }

   }
   ```
3. The algorithm will process the image and apply the flood fill based on the specified start point and color.
