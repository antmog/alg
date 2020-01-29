package sort.bubble;

import sort.CustomArray;

import java.util.function.Function;

import static sort.SortUtils.swap;

public class Bubble {

    private static final int BUBBLE_SIZE = 100;

    // O(n^2) N*(N-1)/2 ~ (N^2/2)
    // TODO: 23.01.2020 improve
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

    private static final Function<long[], long[]> BUBBLE_SORT_TWO_SIDE = arr -> {
        int maxIndex = arr.length - 1;
        int leftIndex;  // from left side to the right (highest value)
        int rightIndex; // from right side to the left (lowest value)
        boolean isSwapped;
        for (int globalCounter = maxIndex; globalCounter > maxIndex / 2; globalCounter--) {
            isSwapped = false;
            for (int in = maxIndex - globalCounter; in < globalCounter; in++) {
                leftIndex = in;
                if (arr[leftIndex] > arr[leftIndex + 1]) {
                    swap(arr, leftIndex, leftIndex + 1);
                    isSwapped = true;
                }
                rightIndex = maxIndex - in;
                if (arr[rightIndex] < arr[rightIndex - 1]) {
                    swap(arr, rightIndex, rightIndex - 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
        return arr;
    };

    public static void main(String[] args) {
        CustomArray customArray = new CustomArray(BUBBLE_SIZE);
        CustomArray newCustomArray = new CustomArray(customArray);

        customArray.print();
        customArray.sortWith(BUBBLE_SORT);
        customArray.print();
        customArray.printState();

        newCustomArray.print();
        newCustomArray.sortWith(BUBBLE_SORT_TWO_SIDE);
        newCustomArray.print();
        newCustomArray.printState();

        for (int i = 0; i < 100; i++) {
            newCustomArray.generateNewArray(BUBBLE_SIZE);
            newCustomArray.print();
            newCustomArray.sortWith(BUBBLE_SORT_TWO_SIDE);
            newCustomArray.print();
            newCustomArray.printState();
        }
    }
}
