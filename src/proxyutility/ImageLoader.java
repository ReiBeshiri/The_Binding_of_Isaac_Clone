package proxyutility;

import javafx.scene.image.Image;
/**
 * Interface that represent image loader.
 *
 */
public interface ImageLoader {
    /**
     * Get loaded image.
     * @param image Image to load.
     * @return Image.
     */
    Image getImage(ImageType image);
}
