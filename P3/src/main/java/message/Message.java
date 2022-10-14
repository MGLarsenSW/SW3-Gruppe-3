package main.java.message;

import java.io.File;
import main.java.constants;

import javax.swing.text.html.CSS;
import de.siegmar.fastcsv.CsvReader; //https://github.com/osiegmar/FastCSV

public class Message {
    public static void main(String[] args) {
        init();
    }

    public static void init(){
        File file = new File(constants.reportPath);
        CsvReader csvReader = new CsvReader();
    }
}
