package Rkc.Sorting;

import java.util.ArrayList;

public class Sorting {

    public static ArrayList<Integer> BobbleSort(ArrayList<Integer> inputArr) {
        var arr = new ArrayList<>(inputArr);
        return InternalBobbleSort(arr, arr.size() - 1);
    }

    public static ArrayList<Integer> QuickSort(ArrayList<Integer> inputArr) {
        var arr = new ArrayList<>(inputArr);
        InternalQuickSort(arr, 0, arr.size() - 1);
        return arr;
    }

    public static ArrayList<Integer> InsertSort(ArrayList<Integer> inputArr) {
        var arr = new ArrayList<>(inputArr);

        for (int i = 0; i < arr.size(); i++) {
            var originalValue = arr.get(i);
            var originalPosition = i;
            for (int j = i - 1; j > -1; j--) {
                var compare = arr.get(j);
                if (compare > originalValue) {
                    arr.set(j, originalValue);
                    arr.set(originalPosition, compare);
                }
                originalPosition = j;
            }
        }
        return arr;
    }

    private static void InternalQuickSort(ArrayList<Integer> inputArr, int start, int end) {
        if (start < 0 || end <= start || inputArr.size() < end) {
            return;
        }
        var pivot = inputArr.get(end);
        var lastMinorIndex = start - 1;

        for (int i = start; i < end; i++) {
            var currentValue = inputArr.get(i);
            var smaller = currentValue < pivot;

            if(!smaller) {
                continue;
            }

            lastMinorIndex++;
            if (lastMinorIndex == start && i == start) {
                continue;
            }

            var lastMinorValue = inputArr.get(lastMinorIndex);
            inputArr.set(lastMinorIndex, currentValue);
            inputArr.set(i, lastMinorValue);
        }


        var swapValue = inputArr.get(lastMinorIndex + 1);
        inputArr.set(lastMinorIndex + 1, pivot);
        inputArr.set(end, swapValue);

        var minorEnd = lastMinorIndex;
        InternalQuickSort(inputArr, start, minorEnd);

        var majorStart = lastMinorIndex + 2;
        InternalQuickSort(inputArr, majorStart, end);
    }

    private static ArrayList<Integer> InternalBobbleSort(ArrayList<Integer> arr, int lastIndex) {
        for (int j = 0; j < lastIndex + 1; j++) {
            try {
                var left = arr.get(j);
                var right = arr.get(j + 1);
                if (left > right) {
                    arr.set(j, right);
                    arr.set(j + 1, left);
                }
            } catch (Exception e) {
                break;
            }
        }

        if (lastIndex == 0) {
            return arr;
        }
        return InternalBobbleSort(arr, lastIndex - 1);
    }
}
