package utilities;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class FileReader {
    public static Map<String, String> envPropertyMap = new HashMap();
    public Properties loadPropertyFile(String envirenmontpath){
        InputStream inittialSteam = getClass().getResourceAsStream("/envi/"+envirenmontpath+"."+"properties");
        return propertiesFileLoad(inittialSteam);
    }

    public void loadPP(String envirenmontpath){
        InputStream inittialSteam = getClass().getResourceAsStream("/envi/"+envirenmontpath+"."+"properties");
//       properties propertiesFileLoad(inittialSteam);
        System.out.println("loasd       :   " + propertiesFileLoad(inittialSteam));

    }


    public String getValues(String keyvalue) {
        String result = "";
        if (envPropertyMap.containsKey(keyvalue)) {
            result = (String)envPropertyMap.get(keyvalue);
        }

        return result;
    }

    public Properties propertiesFileLoad(InputStream initialStream) {
        Properties prop = new Properties();

        try {
            prop.load(initialStream);
            Iterator var3 = prop.stringPropertyNames().iterator();

            while(var3.hasNext()) {
                String key = (String)var3.next();
                envPropertyMap.put(key, prop.getProperty(key));
//                this.setStringVariable(prop.getProperty(key), key);
            }

            return prop;
        } catch (IOException var5) {
//            logger.error("Failed to load properties file for environment:" + initialStream);
            throw new TapException(TapExceptionType.PROCESSING_FAILED, "Failed to load properties file for environment: [{}]", new Object[]{initialStream});
        }
    }

//    public void setStringVariable(String value, String variable) {
//        if (globalPropertyMap.containsKey(variable)) {
//            globalPropertyMap.remove(variable);
//            globalPropertyMap.put(variable, value);
//        } else {
//            globalPropertyMap.put(variable, value);
//        }
//
//    }

    public String loadDataTypeSafe(){
        Config configfile = ConfigFactory.load("config.conf");
        return configfile.getString("url.base");
//        System.out.println(configfile.getString("url.base"));
//        System.out.println(config.getString("url.endpoint"));
    }


}
