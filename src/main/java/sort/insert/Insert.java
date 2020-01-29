package sort.insert;

import sort.CustomArray;

import java.util.function.Function;

public class Insert {

    private static final int INSERT_SIZE = 100;

    // TODO: 23.01.2020 maybe make pictures
    // Take X element and save it to TEMP.
    // Compare X to the last element of sorted part, if X is more -> skip while, else
    // put X element on place of element of comparison, decrease index
    // Compare... , else
    // put element on place of previous element of comparison, decrease index
    // ... in the end put TEMP to the place which became free after array move
    // 1 2 3 5 6 7 8 4, 4 to temp
    // 1 2 3 X 5 6 7 8, temp to X
    // 1 2 3 4 5 6 7 8
    // TODO: 23.01.2020 improve
    private static final Function<long[], long[]> INSERT_SORT = arr -> {
        int in;
        for (int out = 1; out < arr.length; out++) {
            long temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        return arr;
    };

    public static void main(String[] args) {
        CustomArray customArray = new CustomArray(INSERT_SIZE);
        customArray.print();
        customArray.sortWith(INSERT_SORT);
        customArray.print();
        customArray.printState();
    }
}
