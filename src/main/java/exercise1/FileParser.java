package exercise1;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileParser {

    String path;

    public FileParser(String path) {
        this.path = path;
    }

    public boolean fileExists(String path) {
        return false;
    }

    public void read() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                if (sCurrentLine.contains("-")) {
                    String[] strArr = sCurrentLine.split("-|,");
                    for (String str : strArr) {
                        System.out.println(str.trim());
                    }
                    System.out.println();
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
