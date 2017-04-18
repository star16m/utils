package star16m.utils.random;

import java.util.ArrayList;
import java.util.List;

public enum RandomStringType {

    ALPHA_LOWER_ARRAY(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}),
    ALPHA_UPPER_ARRAY(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}),
    JAPAN_HIRAKANA_ARRAY(new String[] {"あ","い","う","え","お","か","き","く","け","こ","さ","し","す","せ","そ","た","ち","つ","て","と","な","に","ぬ","ね","の","は","ひ","ふ","へ","ほ","ま","み","む","め","も","や","ゆ","よ","ら","り","る","れ","ろ","わ","を"}),
    JAPAN_KATAKANA_ARRAY(new String[] {"ア","イ","ウ","エ","オ","カ","キ","ク","ケ","コ","サ","シ","ス","セ","ソ","タ","チ","ツ","テ","ト","ナ","ニ","ヌ","ネ","ノ","ハ","ヒ","フ","ヘ","ホ","マ","ミ","ム","メ","モ","ヤ","ユ","ヨ","ラ","リ","ル","レ","ロ","ワ","ヲ"}),
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