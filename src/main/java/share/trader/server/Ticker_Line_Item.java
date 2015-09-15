package share.trader.server;

import java.sql.Date;

/**
 * Created by Cameron on 14/09/2015.
 */
public class Ticker_Line_Item {
    //Ticker0,Date1,OPen2,High3,Close5,Low4,Volume6
    //ticker0,date1,open2,close5,high3, low4,volume6
    public Ticker_Line_Item(String ticker, String SDate, Double open, Double close, Double high, Double low, Double volume, String period, Boolean newRecord) {
        Ticker = ticker;
        this.SDate = SDate;
        Open = open;
        Close = close;
        High = high;
        Low = low;
        Volume = volume;
        NewRecord = newRecord;
        Period = period;
    }

    private String Ticker;
    private String SDate;
    private Date date;
    private Double Open;
    private Double Close;
    private Double High;
    private Double Low;
    private Double Volume;
    private String Period;
    private Boolean NewRecord = true;
    private Boolean Changed = false;

    public String getPeriod() {
        return Period;
    }

    public void setPeriod(String period) {
        this.Period = period;
        Changed = true;
    }

    public void setTicker(String ticker) {
        Ticker = ticker;
        Changed = true;
    }

    public void setSDate(String SDate) {
        this.SDate = SDate;
        Changed = true;
    }

    public void setDate(Date date) {
        this.date = date;
        Changed = true;
    }

    public void setOpen(Double open) {
        Open = open;
        Changed = true;
    }

    public void setClose(Double close) {
        Close = close;
        Changed = true;
    }

    public void setHigh(Double high) {
        High = high;
        Changed = true;
    }

    public void setLow(Double low) {
        Low = low;
        Changed = true;
    }

    public void setVolume(Double volume) {
        Volume = volume;
        Changed = true;
    }

    public void setNewRecord(Boolean newRecord) {
        NewRecord = newRecord;
        Changed = true;
    }

    public void setChanged(Boolean changed) {
        Changed = changed;
        Changed = true;
    }

    public String getTicker() {
        return Ticker;
    }

    public String getSDate() {
        return SDate;
    }

    public Date getDate() {
        return date;
    }

    public Double getOpen() {
        return Open;
    }

    public Double getClose() {
        return Close;
    }

    public Double getHigh() {
        return High;
    }

    public Double getLow() {
        return Low;
    }

    public Double getVolume() {
        return Volume;
    }

    public Boolean getNewRecord() {
        return NewRecord;
    }

    public Boolean getChanged() {
        return Changed;
    }
}
