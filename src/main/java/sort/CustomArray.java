package sort;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.function.Function;

import static sort.SortUtils.generateRandomArray;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomArray {

    private long[] arr;

    public CustomArray(int size) {
        arr = generateRandomArray(size);
    }

    public void generateNewArray(int size) {
        arr = generateRandomArray(size);
    }

    public int getSize() {
        return arr.length;
    }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }

    public void sortWith(Function<long[], long[]> sorting) {
        arr = sorting.apply(arr);
    }
}
