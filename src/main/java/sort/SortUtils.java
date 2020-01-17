package sort;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SortUtils {

    static long[] generateRandomArray(int size) {
        long[] randomArray = new long[size];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (long) (Math.random() * 100);
        }
        return randomArray;
    }

    public static void swap(long[] arr, int leftIndex, int rightIndex) {
        long temp = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = temp;
    }
}
