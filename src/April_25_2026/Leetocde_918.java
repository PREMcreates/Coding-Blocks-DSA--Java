/*918. Maximum Sum Circular Subarray*/
package April_25_2026;

import java.util.Scanner;

public class Leetocde_918 {
    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxsum = nums[0];
        int cMaxsum = nums[0];
        int cMinsum = nums[0];
        int minsum = nums[0];
        int total = nums[0];

        for(int i=1; i<n; i++){
            cMaxsum = Math.max(cMaxsum + nums[i], nums[i]);
            maxsum = Math.max(cMaxsum, maxsum);
            cMinsum = Math.min(cMinsum+nums[i], nums[i]);
            minsum = Math.min(minsum, cMinsum);
            total += nums[i];
        }
        int circularsum = total - minsum;
        if(circularsum == 0){
            return maxsum;
        }
        return Math.max(maxsum, circularsum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }

        System.out.println(maxSubarraySumCircular(nums));
    }
}
