package share.trader.server; /**
 * Created by Cameron on 30/08/2015.
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Java_Access {



    public Java_Access(Config SettingsC) {
        String url = "jdbc:mysql://{SERVER}:3306/{DATABASE}";
        url.replace("{SERVER}",SettingsC.getDBServer());
        url.replace("{DATABASE}",SettingsC.getDatabase());

        // String url = SettingsC.getMySQLURL();
        this.user = SettingsC.getDBUser();
        this.password = SettingsC.getDBPassword();
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
        }
    }

    public PreparedStatement pst = null;
    private Connection con = null;
    private String user;
    private String password;
    private ResultSet rs = null;

    public void SetPreparedStatement(String sql) {
        try {
            pst = con.prepareStatement(sql);
        } catch (SQLException ex) {
        }


    }

    public ResultSet EXSQL_R(String Sql) {

        try {

            pst = con.prepareStatement(Sql);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }

        return (rs);
    }

    public boolean EXSQL_X(String Sql) {
        try {
            //  con = DriverManager.getConnection(url, user, password);
            pst = con.prepareStatement(Sql);
            pst.executeUpdate();
            return (true);
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            return (false);
        }

    }

    public int EXSQL_I(String Sql) {
        try {
            //   con = DriverManager.getConnection(url, user, password);
            pst = con.prepareStatement(Sql);
            return (pst.executeUpdate());

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            return (-10);

        }

    }

    public void CloseConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Main.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }


    }

}
