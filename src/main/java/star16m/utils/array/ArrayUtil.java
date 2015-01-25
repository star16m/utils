package star16m.utils.array;

import java.io.File;

public class ArrayUtil {

	public static boolean isEmpty(Object[] objectArray) {
		return objectArray == null || objectArray.length == 0;
	}
	public static boolean isEmpty(int [] intArray) {
		return intArray == null || intArray.length == 0;
	}
	public static boolean isEmpty(long[] longArray) {
		return longArray == null || longArray.length == 0;
	}
	public static boolean isEmpty(boolean[] booleanArray) {
		return booleanArray == null || booleanArray.length == 0;
	}
	public static boolean isEmpty(File[] fileArray) {
		return fileArray == null || fileArray.length == 0;
	}
}
