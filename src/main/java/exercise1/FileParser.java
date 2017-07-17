package exercise1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileParser {

    String path;

    public FileParser(String path) {
        this.path = path;
    }

    private boolean doesFileExists(String path) {
        File f = new File(path);
        if (f.exists())
            return true;
        else return false;
    }

    public void read() {

        if (doesFileExists(path)) {
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
}
