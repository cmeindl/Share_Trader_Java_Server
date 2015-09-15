package share.trader.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Cameron on 30/08/2015.
 */
public class Config {

    public  Config() {
       DBServer = ReadSettings("DBServer");
        DBUser = ReadSettings("DBUser");
        DBPassword = ReadSettings("DBPassword");
        Database = ReadSettings("Database");
        TradeFileDir = ReadSettings("TradeFiles");
    }

    private String ReadSettings(String SettingID) {
        Properties prop = new Properties();
        InputStream input = null;
        String RTstring = "";
        try {
            input = new FileInputStream("config.properties");
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            RTstring = (prop.getProperty(SettingID));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return(RTstring);
    }


    public String getDBServer() {
        return DBServer;
    }

    public String getDBUser() {
        return DBUser;
    }

    public String getDBPassword() {
        return DBPassword;
    }

    public String getDatabase() {
        return Database;
    }

    public String getTradeFileDir() {
        return TradeFileDir;
    }

    private  String DBServer;
    private String DBUser;
    private String DBPassword;
    private String Database;
    private String TradeFileDir;


}
