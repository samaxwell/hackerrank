package challenges.datastructures.arrayLeftShift;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {

    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */
    public List<Integer> rotateLeft(int shift, List<Integer> arr) {
        // Write your code here
        int size = arr.size();
        if (size == 0 || shift == 0) {
            return arr;
        }

        /* We need to handle scenarios where 'shift' > arr.size() by using modulo
         *      e.g. 5 % 3 = 2,     e.g. 5 % 5 = 0,     e.g. 3 % 5 = 3
         */
        shift = shift % size;
        if (shift == arr.size()) { // would just be a complete revolution
            return arr;
        }

        /* Get elements that will be shifted left all the way around */
        List<Integer> leftHalf = arr.subList(0, shift);

        /* Left shift second half */
        List<Integer> rightHalf = arr.subList(shift, size);

        return Stream.concat(
                rightHalf.stream(), leftHalf.stream()
            ).collect(Collectors.toList());
    }
    public List<Integer> rotateRight(int shift, List<Integer> arr) {
        // Write your code here
        int size = arr.size();
        if (size == 0 || shift == 0) {
            return arr;
        }

        /* We need to handle scenarios where 'shift' > arr.size() by using modulo
         *      e.g. 5 % 3 = 2,     e.g. 5 % 5 = 0,     e.g. 3 % 5 = 3
         */
        shift = shift % size;
        if (shift == arr.size()) { // would just be a complete revolution
            return arr;
        }

        /* Left shift second half */
        List<Integer> leftHalf = arr.subList(0, size-shift);

        /* Get elements that will be shifted right all the way around */
        List<Integer> rightHalf = arr.subList(size-shift, size);

        return Stream.concat(
                rightHalf.stream(), leftHalf.stream()
        ).collect(Collectors.toList());
    }

}