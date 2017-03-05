package CtCI.chapter16;

import java.util.Arrays;

/**
 * Created by sonnguyen on 2/27/17.
 */
public class SmallestDifference {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 15, 11, 2};
        int[] arr2 = new int[]{23, 127, 235, 19, 8};

        int[] result = smallestDifference(arr1, arr2);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] smallestDifference(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) return null;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int arr1Index = 0;
        int arr2Index = 0;
        int smallest = Math.abs(arr1[arr1Index] - arr2[arr2Index]);
        int[] result = new int[]{arr1[arr1Index], arr2[arr2Index]};

        while (arr1Index < arr1.length && arr2Index < arr2.length) {
            if (Math.abs(arr1[arr1Index] - arr2[arr2Index]) < smallest) {
                smallest = Math.abs(arr1[arr1Index] - arr2[arr2Index]);
                result[0] = arr1[arr1Index];
                result[1] = arr2[arr2Index];
            }

            if (arr1[arr1Index] < arr2[arr2Index]) {
                arr1Index++;
            } else {
                arr2Index++;
            }
        }

        return result;
    }
}
