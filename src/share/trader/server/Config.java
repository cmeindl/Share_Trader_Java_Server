package share.trader.server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Created by Cameron on 30/08/2015.
 */
public class Config {

    public void Config() {
        Properties prop = new Properties();
        InputStream input = null;


    }

    public void WriteSettings() {


    }

    public void WriteSettings(String SettingName, String SettingValue) {

        Properties prop = new Properties();
        OutputStream output = null;
        try {

            output = new FileOutputStream("config.properties");

            // set the properties value
            prop.setProperty(SettingName, SettingValue);

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    String DBServer;
    String DBUser;
    String DBPassword;


}
