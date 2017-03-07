package CtCI.chapter08;

/**
 * Created by sonnguyen on 3/7/17.
 */
public class MagicIndex {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, 4};
        System.out.println(magicIndex(arr, 0, 4));
    }

    public static int magicIndex(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (arr[mid] < mid) {
            return magicIndex(arr, mid + 1, end);
        } else if (arr[mid] > mid) {
            return magicIndex(arr, start, mid - 1);
        } else {
            return mid;
        }
    }
}
