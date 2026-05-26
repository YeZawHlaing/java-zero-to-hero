# Median of Two Sorted Arrays - Merge Sort Approach

A robust, self-contained Java solution to find the median of two separate integer arrays by combining them and sorting the resulting array via the classic **Merge Sort** algorithm.

## 📌 Problem Description

Given two arrays `nums1` and `nums2`, combine them, sort the combined elements in ascending order, and calculate the median value.
- If the total number of elements is **odd**, the median is the middle element.
- If the total number of elements is **even**, the median is the average of the two middle elements.

---

## 💡 Intuition & Approach

1. **Merge / Combine:** We initialize a new array `mixNums` with a capacity equal to `nums1.length + nums2.length`. Using a pointer tracking `position`, we sequentially copy all elements from `nums1` followed by `nums2`.

2. **Divide and Conquer (Merge Sort):** The combined array is passed into `mergeSorted()`. This recursively breaks down the array into `left` and `right` halves until individual base subarrays containing less than 2 elements are reached.

3. **Sorting with Three Trackers:** The `finalMerged()` helper reconstructs the subarrays into ascending order back into the primary array utilizing three tracking pointers (`i` for left array, `j` for right array, and `k` for the merged layout).

4. **Median Computation:** The single sorted array is evaluated. If its length is odd, the middle element is returned. If even, the two middle values are summed up and divided by `2.0` to preserve accurate decimal floating-point precision.

---

## 📊 Complexity Analysis

- **Time Complexity:** $O((m + n) \log(m + n))$
    - Combining both input arrays takes linear time: $O(m + n)$, where $m = \text{nums1.length}$ and $n = \text{nums2.length}$.
    - Sorting an array of size $(m + n)$ using the recursive Divide-and-Conquer Merge Sort architecture incurs a cost of $O((m + n) \log(m + n))$.
    - Calculating the median at a specific index occurs in constant time: $O(1)$.

- **Space Complexity:** $O(m + n)$
    - Instantiating the combined `mixNums` structure requires $O(m + n)$ space.
    - The internal execution call-stack and allocation of temporary split structures (`left` and `right`) during the sorting phase also consume $O(m + n)$ space.

---

## 💻 Code Implementation

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mixNums = new int[nums1.length + nums2.length];
        int position = 0;

        for (int i = 0; i < nums1.length; i++) {
            mixNums[position] = nums1[i];
            position++;
        }

        for (int j = 0; j < nums2.length; j++) {
            mixNums[position] = nums2[j];
            position++;
        }

        mergeSorted(mixNums);

        return findMedian(mixNums);
    }

    private void mergeSorted(int[] finalArray) {
        int mixLength = finalArray.length;

        if (mixLength < 2) {
            return;
        }

        int mid = mixLength / 2;
        int[] left = new int[mid];
        int[] right = new int[mixLength - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = finalArray[i];
        }

        for (int i = mid; i < mixLength; i++) {
            right[i - mid] = finalArray[i];
        }

        mergeSorted(left);
        mergeSorted(right);

        finalMerged(finalArray, left, right);
    }

    private void finalMerged(int[] finalArray, int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                finalArray[k] = left[i];
                i++;
            } else {
                finalArray[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            finalArray[k] = left[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            finalArray[k] = right[j];
            j++;
            k++;
        }
    }

    private double findMedian(int[] input) {
        int totalLength = input.length;

        if (totalLength % 2 != 0) {
            return input[totalLength / 2];
        } else {
            int mid1 = input[(totalLength / 2) - 1];
            int mid2 = input[totalLength / 2];
            return (mid1 + mid2) / 2.0;
        }
    }
}