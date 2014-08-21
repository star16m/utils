package star16m.utils.random;

import java.util.ArrayList;
import java.util.List;

public enum RandomStringType {

    ALPHA_LOWER_ARRAY(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}),
    ALPHA_UPPER_ARRAY(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}),
    ALPHA_ALL(ALPHA_LOWER_ARRAY.getStringArray(), ALPHA_UPPER_ARRAY.getStringArray()),
    NUMERIC_ARRAY(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}),
    ALPHA_NUMERIC_ARRAY(ALPHA_LOWER_ARRAY.getStringArray(), ALPHA_UPPER_ARRAY.getStringArray(), NUMERIC_ARRAY.getStringArray());

    private String[] stringArray;
    private RandomStringType(String[] ... randomStringArray) {
        List<String> stringList = new ArrayList<String>();
        for (String[] stringArray : randomStringArray) {
            for (String string : stringArray) {
                stringList.add(string);
            }
        }
        this.stringArray = stringList.toArray(new String[0]);
    }
    private String[] getStringArray() {
        return stringArray;
    }
    public int length() {
        return this.stringArray.length;
    }
    public String get(int num) {
        return this.stringArray[num];
    }
}
