package sort.bubble;

import sort.CustomArray;

import java.util.function.Function;

import static sort.SortUtils.swap;

public class Bubble {

    private static final int BUBBLE_SIZE = 100;

    // O(n^2) N*(N-1)/2 ~ (N^2/2)
    private static final Function<long[], long[]> BUBBLE_SORT = arr -> {
        for (int out = arr.length - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                if (arr[in] > arr[in + 1]) {
                    swap(arr, in, in + 1);
                }
            }
        }
        return arr;
    };


    public static void main(String[] args) {
        CustomArray customArray = new CustomArray(BUBBLE_SIZE);
        customArray.print();
        customArray.sortWith(BUBBLE_SORT);
        customArray.print();
    }
}
