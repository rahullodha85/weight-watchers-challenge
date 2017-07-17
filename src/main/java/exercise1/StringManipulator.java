package exercise1;

public class StringManipulator {

    public String reverseEverything(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        StringBuilder str = new StringBuilder(s);
        str = str.reverse();

        return str.toString();
    }
}
