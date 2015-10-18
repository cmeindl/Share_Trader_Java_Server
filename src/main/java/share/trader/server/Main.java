package share.trader.server;
import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {




        Config CFC = new Config();
        System.out.println(CFC.getDBPassword());
        System.out.println(CFC.getDBUser());
        System.out.println(CFC.getDBServer());
        Import_Trade_Data ITD = new Import_Trade_Data(CFC);
        ITD.BuildfFileList();
       ArrayList<String> ALS = ITD.getFileList();
    //    System.out.println(ITD.getFileList().get(0));
        ArrayList<Ticker_Line_Item> TLI =  new ArrayList<Ticker_Line_Item>();
   for (String DaFile : ALS) {
       TLI.addAll(ITD.LoadDataFromFile(DaFile));
       System.out.println(TLI.size());
      // System.out.println(TLI.get(10).getSDate());
   }
       System.out.println("Here");
    System.out.println(TLI.get(10).getTicker());
        System.out.println(TLI.get(900).getTicker());

        // CFC.WriteSettings("DB2","DBString2");
	// write your code here
    }
}
