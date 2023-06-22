import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Integer> list1 = List.of(1, 2, 3, 4);
        List<Integer> list2 = List.of(2, -1, 2, 3, 4, -5);
        List<Integer> list3 = List.of(-2, -3, -1, -4, -6);

        System.out.println("Max subarray sum of " + list1 + " is " + maxSubArraySum(list1));
        System.out.println("Max subsequence sum of " + list1 + " is " + maxSubSequenceSum(list1));
        System.out.println("Max subarray sum of " + list2 + " is " + maxSubArraySum(list2));
        System.out.println("Max subsequence sum of " + list2 + " is " + maxSubSequenceSum(list2));
        System.out.println("Max subarray sum of " + list3 + " is " + maxSubArraySum(list3));
        System.out.println("Max subsequence sum of " + list3 + " is " + maxSubSequenceSum(list3));
        System.out.println("Max subarrays sum of " + list1 + " is " + maxSubArrays(list1));
        System.out.println("Max subarrays sum of " + list2 + " is " + maxSubArrays(list2));
        System.out.println("Max subarrays sum of " + list3 + " is " + maxSubArrays(list3));
    }

    public static List<Integer> maxSubArrays(List<Integer> arr) {
        Integer maxSum = null;
        Integer currentSum = 0;
        Integer maxSeq = null;
        for (int i = 0; i < arr.size(); i++) {
            if (maxSeq == null) {
                maxSeq = arr.get(i);
            } else if (arr.get(i) > 0) {
                if (maxSeq < 0) {
                    maxSeq = arr.get(i);
                } else  {
                    maxSeq += arr.get(i);
                }
            } else if (maxSeq < arr.get(i)) {
                maxSeq = arr.get(i);
            }

            if (currentSum <0 && arr.get(i) > currentSum) {
                currentSum = arr.get(i);
            } else {
                currentSum += arr.get(i);
            }
            if (maxSum == null || currentSum > maxSum) {
                maxSum = Integer.valueOf(currentSum);
            }
        }

        return List.of(maxSum, maxSeq);

    }

    public static int maxSubArraySum(List<Integer> list) {
        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < list.size(); i++) {
            currentSum += list.get(i);
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public static int maxSubSequenceSum(List<Integer> list) {
        int maxSeq = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 0) {
                maxSeq += list.get(i);
            }
        }

        return maxSeq;
    }
}