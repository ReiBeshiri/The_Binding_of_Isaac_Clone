package test;

import static org.junit.Assert.fail;
import org.junit.jupiter.api.Test;
import utility.ImageType;
import view.utility.ProxyImageLoader;


class ImageLoaderTest {

    @Test
    public void imageLoaderTest() {
        try {
            ProxyImageLoader.get().getImage(ImageType.PLAYER);
            ProxyImageLoader.get().getImage(ImageType.BOSS_ENEMY);
            ProxyImageLoader.get().getImage(ImageType.FULL_HEART);
        } catch (Exception ex) {
            fail();
        }
    }
}
