package utilities;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class AppConfigFactory {
    public static final String ENV_DEFAULT = "local";
    public static final String CONFIG_FILE_PATH_FORMAT = "./src/main/java/resources/config.conf";
    public static final String ENV_VARIABLE_NAME = "ENVIRONMENT";
    public static final String PREFIX_CONFIG_PATH_NAME = "CONFIG_FILE_PREFIX";

    private static Config _config = null;
    private static final Object SYNC_OBJ = new Object();

    public static Config getConfig() {
        if(_config != null){
            return _config;
        }
        synchronized (SYNC_OBJ){
            if(_config != null){
                return _config;
            }
            return loadConfig();
        }
    }

@Test
public void  loadC(){
    String env = System.getenv(ENV_VARIABLE_NAME);
    String prefixPath = System.getenv(PREFIX_CONFIG_PATH_NAME);
    if(StringUtils.isEmpty(env)){
        env = ENV_DEFAULT;
    }
    String filePath = String.format(CONFIG_FILE_PATH_FORMAT, env);
    if(!StringUtils.isEmpty(prefixPath)){
        filePath += prefixPath + "/";
    }
    _config = ConfigFactory.parseResources(filePath).resolve();
    System.out.println(_config.getString("url.base"));

}



    private static Config loadConfig(){
        String env = System.getenv(ENV_VARIABLE_NAME);
        String prefixPath = System.getenv(PREFIX_CONFIG_PATH_NAME);
        if(StringUtils.isEmpty(env)){
            env = ENV_DEFAULT;
        }
        String filePath = String.format(CONFIG_FILE_PATH_FORMAT, env);
        if(!StringUtils.isEmpty(prefixPath)){
            filePath += prefixPath + "/";
        }
        _config = ConfigFactory.parseResources(filePath).resolve();
        System.out.println(_config);
        return _config;
    }
}
