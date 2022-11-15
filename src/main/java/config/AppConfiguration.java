package config;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppConfiguration {
    private static final Logger logger = LogManager.getLogger(AppConfiguration.class);
    private static final String BUNDLE_NAME = "database";

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private AppConfiguration() {
    }

    public static String getString(String key) {
        try {
            logger.info("action=get_property, key={}, value={}", key, RESOURCE_BUNDLE.getString(key));
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            logger.error("action=get_property, error_message={}", e.getMessage());
            return StringUtils.EMPTY;
        }
    }
}
