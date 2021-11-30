public class MinSizeSubArraySum {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 2, 3, 2 };
        int k = 7;

        int sum = helper(arr, k);
        System.out.println(sum);

    }

    private static int helper(int[] arr, int k) {

        int result = Integer.MAX_VALUE;

        int left = 0, right = 0;
        int n = arr.length;

        int sum = 0;

        while (right < n) {
            sum += arr[right];

            while (sum > k) {
                sum -= arr[left++];
            }

            if (sum == k) {
                result = Math.min(result, right - left + 1);
            }

            right++;
        }

        return result;
    }

}
