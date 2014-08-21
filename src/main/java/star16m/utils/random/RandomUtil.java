package star16m.utils.random;

import java.util.Random;

public class RandomUtil {

    public static int getRandomInt(int minIntValue, int maxIntValue) {
        if (minIntValue == maxIntValue) {
            return minIntValue;
        }
        int realMinIntValue = Math.min(minIntValue, maxIntValue);
        int realMaxIntValue = Math.max(minIntValue, maxIntValue);
        Random r = new Random();
        return realMinIntValue + r.nextInt(realMaxIntValue-realMinIntValue+1);
    }
    public static String getRandomCharacter(RandomStringType randomStringType, int length) {
        if (length > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i=0;i<length;i++) {
                stringBuffer.append(randomStringType.get(RandomUtil.getRandomInt(0, randomStringType.length()-1)));
            }
            return stringBuffer.toString();
        }
        return null;
    }
    public static void fill(int[] intArray) {
        fill(intArray, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static void fill(int[] intArray, int minIntValue, int maxIntValue) {
        if (intArray == null) {
            return ;
        }
        for (int i=0; i<intArray.length; i++) {
            intArray[i] = getRandomInt(minIntValue, maxIntValue);
        }
    }
    public static void fill(RandomStringType randomStringType, String[] stringArray, int length) {
        if (length <= 0) {
            return;
        }
        for (int i=0; i<stringArray.length; i++) {
            stringArray[i] = getRandomCharacter(randomStringType, length);
        }
    }
}
