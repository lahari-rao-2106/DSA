class Solution {
    public int[] resultArray(int[] nums) {

        int n = nums.length;

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        int m = 0; // size of arr1
        int k = 0; // size of arr2

        // First operation
        arr1[m++] = nums[0];

        // Second operation
        arr2[k++] = nums[1];

        // Remaining elements
        for (int i = 2; i < n; i++) {

            // Compare ONLY the last elements
            if (arr1[m - 1] > arr2[k - 1]) {
                arr1[m++] = nums[i];
            } else {
                arr2[k++] = nums[i];
            }
        }

        // Create result
        int[] result = new int[n];

        int index = 0;

        // Add arr1
        for (int i = 0; i < m; i++) {
            result[index++] = arr1[i];
        }

        // Add arr2
        for (int i = 0; i < k; i++) {
            result[index++] = arr2[i];
        }

        return result;
    }
}