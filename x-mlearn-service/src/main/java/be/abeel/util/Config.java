/**
 * %HEADER%
 */
package be.abeel.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class Config {

    private Properties prop;

    private File file;

    public synchronized void set(String key, String value) throws IOException {
        prop.put(key, value);
        save();
    }

    public synchronized String get(String key) {
        return prop.getProperty(key);
    }

    public synchronized String get(String name, String defaultValue) {
        return prop.getProperty(name, defaultValue);
    }

    public Config(String name) throws IOException {
        String home = System.getProperty("user.home");
        file = new File(home + "/." + name);
        if (!file.exists())

            file.createNewFile();

        prop = new Properties();

        FileInputStream fis = new FileInputStream(file);
        prop.load(fis);
        fis.close();

    }

    private void save() throws IOException {

        FileOutputStream fos = new FileOutputStream(file);
        prop.store(fos, "Saved: " + new Date());
        fos.close();

    }

}
