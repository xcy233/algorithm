package util;

public class Util {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static String array2Str(int[] arr, int i, int j) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(arr[i]);
        for (int k = i + 1; k <= j; k++) {
            sb.append(",");
            sb.append(arr[k]);
        }
        sb.append("]");
        return sb.toString();
    }

}