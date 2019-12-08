package lab17;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

/**
 * utils for work with images
 *
 * @since 1, 12/7/19 1:02am
 */
public class ImageUtils {
    // Utility to read in an bImage object
    // If image cannot load, prints error output and returns null.
    public static Image readImage(String filename) {
        Image image = null;
        try {
            image = ImageIO.read(Objects.requireNonNull(ImageUtils.class.getResource("../" + filename)));
        } catch (IOException e) {
            System.out.println("Failed to load image '" + filename + "'");
            e.printStackTrace();
        }
        return (image);
    }

    public static Image scaleImage(Image img, Dimension dim){
        return img.getScaledInstance(dim.width, dim.height, Image.SCALE_SMOOTH);
    }
}
