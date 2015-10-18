package share.trader.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by Cameron on 14/09/2015.
 */
public class Import_Trade_Data {
    private String FileDir;
    private ArrayList<String> FileList = new ArrayList<String>();

    public ArrayList<String> getFileList() {
        return FileList;
    }

    public void setFileDir(String fileDir) {
        FileDir = fileDir;
    }

    Import_Trade_Data(Config CFC) {
        FileDir = CFC.getTradeFileDir();


    }

    public void BuildfFileList() {
        File F = new File(FileDir);
        File[] SubFiles = F.listFiles();
        for (File TheFile : SubFiles) {
            if (!TheFile.isDirectory()) {
                FileList.add(TheFile.getAbsolutePath());
            }

        }
    }

    public ArrayList<Ticker_Line_Item> LoadDataFromFile(String Filename) {
        ArrayList<Ticker_Line_Item> TLI = new ArrayList<Ticker_Line_Item>();
        BufferedReader BR;
        String line = "";
        String SplitBy = ",";

        try {

            BR = new BufferedReader(new FileReader(Filename));
            BR.readLine();
            while ((line = BR.readLine()) != null) {
                String ShareData[] = line.split(SplitBy);
//                System.out.println(ShareData[0].toString());
                //  Double high, Double low, BigInteger volume, Boolean newRecord)
                //  ticker0,date1,open2,close5,high3, low4,volume6
                TLI.add(new Ticker_Line_Item(ShareData[0], ShareData[1], Double.valueOf(ShareData[2]), Double.valueOf(ShareData[5]), Double.valueOf(ShareData[3]), Double.valueOf(ShareData[4]), Double.valueOf(ShareData[6]), "D", true));
//Ticker,Date,OPen,High,Close,Low,Volume
            }


        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return TLI;
    }


}


