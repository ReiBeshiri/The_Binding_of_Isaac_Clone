package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import view.controller.ControllerFXML;
/**
 * Class that represent proxy for FXML files.
 *
 */
public final class ProxyFXMLLoader implements LoaderFXML {
    private final Map<SceneType, ControllerFXML> loadedMap;
    private final RealFXMLLoader realLoader;
    private static ProxyFXMLLoader proxy;

    private ProxyFXMLLoader() {
        loadedMap = new HashMap<>();
        realLoader = new RealFXMLLoader();
    }
    /**
     * Return ControllerFXML for a scene.
     */
    @Override
    public ControllerFXML getFXMLController(final SceneType scene) {
        if (loadedMap.containsKey(scene)) {
            return loadedMap.get(scene);
        } else {
            loadedMap.put(scene, realLoader.getFXMLController(scene));
            return loadedMap.get(scene);
        }
    }
    /**
     * Singleton to returns only instance of this class.
     * @return Only instance of this class.
     */
    public static ProxyFXMLLoader get() {
        if (Objects.isNull(proxy)) {
            proxy = new ProxyFXMLLoader();
        }
        return proxy;
    }
}
