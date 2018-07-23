package model.screenresolution;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * This Class will give the screen resolution.
 * Every PC have its personal resolution.
 */
public class ScreenResolutionImpl implements ScreenResolution {
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final double width = screenSize.getWidth();
    private final double height = screenSize.getHeight();
    /**
     * @return the width resolution.
     */
    @Override
    public double getWidthSize() {
        return this.width;
    }
    /**
     * @return the height resolution.
     */
    @Override
    public double getHeigtSize() {
        return this.height;
    }
}
