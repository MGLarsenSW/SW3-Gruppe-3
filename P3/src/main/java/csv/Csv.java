package main.java.csv;

public class Csv {
    private String SuplierName; // add this for every row/field that we need to use in the csv file


    public Csv(String suplierName){
        super();
        this.SuplierName = suplierName;
    }

    public String getSuplierName() {return SuplierName; }
}
