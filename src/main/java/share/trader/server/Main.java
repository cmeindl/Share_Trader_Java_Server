package share.trader.server;
import java.sql.*;
public class Main {

    public static void main(String[] args) {




        Config CFC = new Config();
        System.out.println(CFC.getDBPassword());
        System.out.println(CFC.getDBUser());
        System.out.println(CFC.getDBServer());
       // CFC.WriteSettings("DB2","DBString2");
	// write your code here
    }
}
