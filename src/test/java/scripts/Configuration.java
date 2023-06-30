package scripts;
import java.util.Properties;

public class Configurations {

        private static final String LANGUAGE = System.getProperty("language", "EN");
        ////////////////////////////////////////////////////////////////////////
        // FILES
        ////////////////////////////////////////////////////////////////////////
        public static final String PROPERTIES_FILE_PATH = "../app/src/test/resources/properties/";
        public static final String KEY_PROPERTIES_FILE_PATH = PROPERTIES_FILE_PATH + String.format("keys_%s.properties", LANGUAGE);


        ////////////////////////////////////////////////////////////////////////
        // PROPERTIES OBJECT
        ////////////////////////////////////////////////////////////////////////
        public static final Properties KEY_PROPERTIES_FILE = Commons.getProperties(KEY_PROPERTIES_FILE_PATH);
    }
}
