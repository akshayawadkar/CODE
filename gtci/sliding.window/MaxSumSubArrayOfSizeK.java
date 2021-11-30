public class MaxSumSubArrayOfSizeK {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 1, 3, 2 };
        int k = 3;

        int sum = helper(arr, k);
        System.out.println(sum);

    }

    private static int helper(int[] arr, int k) {

        int result = 0;

        int left = 0, right = 0;
        int n = arr.length;

        int sum = 0;

        while (right < n) {
            sum += arr[right];

            if (right - left + 1 > k) {
                sum -= arr[left++];
            }
            result = Math.max(result, sum);
            right++;
        }

        return result;
    }
}