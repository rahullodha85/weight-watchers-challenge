import exercise1.FileParser;
import exercise1.StringManipulator;
import exercise1.WebPageTest;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Reverse String
        System.out.println("Enter a string to reverse: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringManipulator stringManipulator = new StringManipulator();
        System.out.println("Reverse String: " + stringManipulator.reverseEverything(input));

        //Webpage parsing with selenium webdriver
        System.out.println("------------------------------------------");
        System.out.println("Web Page parsing using selenium web-driver:");
        WebPageTest test = new WebPageTest();
        System.out.println("Third item from list: " + test.readItemByIndex(2));
        System.out.println("Fifth item from list: " + test.readItemByIndex(4));
        Map<String, String> items = test.readAll();
        System.out.println("\nAll Items:");
        for (String key : items.keySet()) {
            System.out.println("Food Item: " + key + ", Serving: " + items.get(key));
        }
        test.closeBrowser();

        //File parser
        System.out.println("------------------------------------------");
        System.out.println("File parsing: ");
        FileParser parser = new FileParser(Main.class.getClassLoader().getResource("testFile.txt").getPath());
        parser.read();
    }
}
