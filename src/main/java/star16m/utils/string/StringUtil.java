package star16m.utils.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StringUtil {

    public static void prints(String[] stringArray) {
        if (stringArray != null && stringArray.length > 0) {
            int indexSize = String.valueOf(stringArray.length).length();
            int stringIndex = 1;
            String formatString = "[%" + indexSize + "d] %s";
            for (String string : stringArray) {
                System.out.format(formatString, stringIndex++, string);
                System.out.println();
            }
        }
    }
    
    public static void prints(String formatString, Object ... formatArguments) {
        System.out.println(String.format(formatString, formatArguments));
    }
    
    public static boolean isEmpty(String string) {
        return string == null || string.trim().length() <= 0;
    }

    public static String getString(String string) {
        return string == null ? "" : string;
    }
    
    public static void usage(String message) {
        System.out.println("--------------------------------------------------");
        System.out.println(message);
        System.out.println("--------------------------------------------------");
    } 
    public static String getReplaceLine(String line, Map<String, String> replaceMapInfo) {
        String replaceLine = null;
        if (line != null && line.trim().length() > 0 && replaceMapInfo != null && replaceMapInfo.size() > 0) {
            replaceLine = line + "";
            for (String keyString : replaceMapInfo.keySet()) {
                if (line.contains(keyString)) {
                    replaceLine = replaceLine.replaceAll(keyString, replaceMapInfo.get(keyString));
                }
            }
        }
        return replaceLine;
    }
    
    public static String join(String[] joinStringArray, String delimeter) {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<joinStringArray.length; i++) {
            sb.append(joinStringArray[i]);
            if ((i+1) < joinStringArray.length) {
                sb.append(delimeter);
            }
        }
        return sb.toString();
    }
    
    public static String[] join(String[] joinStringArraySource, String[] joinStringArrayTarget, String delimeter) {
        List<String> stringList = new ArrayList<String>();
        for (int i=0; i<joinStringArraySource.length; i++) {
            stringList.add(joinStringArraySource[i] + delimeter + joinStringArrayTarget[i]);
        }
        return stringList.toArray(new String[0]);
    }
    
    public static String[] slice(String[] stringArray, int startIndex, int endIndex) {
        if (stringArray == null || stringArray.length <= 0) {
            throw new IllegalArgumentException();
        }
        String[] newArray = new String[endIndex - startIndex];
        System.arraycopy(stringArray, startIndex, newArray, 0, newArray.length);
        return newArray;
    }
}
