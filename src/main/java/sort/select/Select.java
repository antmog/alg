package sort.select;

import sort.CustomArray;

import java.util.function.Function;

import static sort.SortUtils.swap;

public class Select {

    private static final int SELECT_SIZE = 100;

    // put min elements 1 by 1 (N iterations) to the beginning of array
    // 3 6 2 4 7 3 1
    // 2 6 3 4 7 3 1
    // 1 6 3 4 7 3 2
    // 1 3 6 4 7 3 2
    // 1 2 6 4 7 3 3
    // 1 2 3 4 7 6 3
    // 1 2 3 3 7 6 4
    // 1 2 3 3 4 6 7
    // O(n^2), same comparisons as bubble, but less swaps
    // TODO: 23.01.2020 improve
    private static final Function<long[], long[]> SELECT_SORT = arr -> {
        int min;
        int length = arr.length;
        for (int out = 0; out < length - 1; out++) {
            min = out;
            for (int in = out + 1; in < length; in++) {
                if (arr[in] < arr[min]) {
                    min = in;
                }
            }
            swap(arr, out, min);
        }
        return arr;
    };

    public static void main(String[] args) {
        CustomArray customArray = new CustomArray(SELECT_SIZE);
        customArray.print();
        customArray.sortWith(SELECT_SORT);
        customArray.print();
        customArray.printState();
    }
}
