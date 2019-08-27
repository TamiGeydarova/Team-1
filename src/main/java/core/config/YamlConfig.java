package core.config;

import java.util.Map;

import core.exceptions.BadSetupException;
import org.apache.commons.lang3.StringUtils;

/**
 * Configuration file structure of <b>config.yml</b>, which consists of different kind of configurations to
 * customize project setup for different needs.
 *
 * @author maris.salenieks
 * @version 1.0.
 * @since 1.0
 */

public class YamlConfig {

    public static final String ERR_MESS_FMT = "Property cannot be found by given key: %s";
    public static final String ERR_MESS_FMT2 = "Property cannot be found by given key [%s], node [%s] doesn't exist";

    Map<String, Object> projectConfigurations;

    public Map<String, Object> getProjectConfigurations() {
        return projectConfigurations;
    }

    public void setProjectConfigurations(Map<String, Object> projectConfigurations) {
        this.projectConfigurations = projectConfigurations;
    }

    /**
     * Extracts concrete configuration property starting from "<b>projectConfigurations</b>"
     * by provided key <b>key</b>, e.g. "<code>engine.checkVpnConnectivity</code>", which in this case will be of type
     * <code>Boolean</code>.
     * <p><u>Note</u>: Currently <b>key</b> should be delimited separated by dots only.
     *
     * @param <T> type of desired property.
     * @return configuration property object.
     * @throws BadSetupException in case property cannot be found by provided key, either it cannot be cast to desired type.
     */
    @SuppressWarnings("unchecked")
    public <T> T getConfiguration(String key) throws BadSetupException {
        if (StringUtils.isEmpty(key))
            throw new BadSetupException(ERR_MESS_FMT, key);

        String[] path = key.split("\\.");

        if (path.length == 0)
            throw new BadSetupException(ERR_MESS_FMT, key);
        else if (path.length == 1) {
            Object res = projectConfigurations.get(path[0]);
            if (res == null)
                throw new BadSetupException(ERR_MESS_FMT, key);
            return (T) res;
        } else {
            int i = 0;
            Map<String, Object> currentNode = (Map<String, Object>) projectConfigurations.get(path[i]);
            while (++i < path.length - 1) {
                if (currentNode == null)
                    throw new BadSetupException(ERR_MESS_FMT2, key, path[i]);
                currentNode = (Map<String, Object>) currentNode.get(path[i]);
            }

            String lastNodeKey = path[path.length - 1];
            Object res = currentNode.get(lastNodeKey);
            if (res == null)
                throw new BadSetupException(ERR_MESS_FMT2, key, lastNodeKey);
            return (T) res;
        }
    }

    @Override
    public String toString() {
        return "YamlConfig{" +
                "projectConfigurations=" + projectConfigurations +
                '}';
    }
}
