package core.config;

import core.exceptions.BadSetupException;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.constructor.ConstructorException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class manages YAML property file readers as singletons.
 * Instances of those property readers are created only on first request.
 *
 * @author maris.salenieks
 * @version 1.0.
 * @since 1.0.
 */

public class YamlFileManager {

    protected static Map<String, Object> configurations = new HashMap<>();

    public static YamlConfig getProjectConfigurations() {
        return loadProperties("config.yml", YamlConfig.class);
    }

    @SuppressWarnings("unchecked")
    protected static <T> T loadProperties(String pathToPropsFile, Class<T> configStructureClass) {
        Object existingProperty = configurations.get(pathToPropsFile);
        if (existingProperty != null) return (T) existingProperty;

        Constructor constructor = new Constructor(configStructureClass);
        Yaml yaml = new Yaml(constructor);

        try (FileInputStream fileStream = new FileInputStream(pathToPropsFile)) {
            T config = yaml.loadAs(fileStream, configStructureClass);
            configurations.put(pathToPropsFile, config);
            return config;
        } catch (FileNotFoundException e) {
            throw new BadSetupException("Properties file [" + pathToPropsFile + "] doesn't exist.", e);
        } catch (IOException | ConstructorException e) {
            throw new BadSetupException("Properties file [" + pathToPropsFile + "] cannot be read.", e);
        }
    }
}
