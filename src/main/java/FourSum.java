/**

 Given an array S of n integers, are there elements a, b, c, and d in S such that
 a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note: The solution set must not contain duplicate quadruplets.

 For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]

 */
package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> results = new ArrayList<>();
    if (nums.length < 4)
      return results;

    Arrays.sort(nums);

    int m = 0;
    int n = 1;
    int o = 2;
    int i = nums.length - 1;

    while (true){
      int sum = nums[m] + nums[n] + nums[o] + nums[i];
      if (sum == target){
        List<Integer> list = new ArrayList<>();
        list.add(nums[m]);
        list.add(nums[n]);
        list.add(nums[o]);
        list.add(nums[i]);
        Collections.sort(list);
        if (!results.contains(list))
          results.add(list);

        if (o+1 < nums.length - 1) {
          ++o;
          i = nums.length - 1;
        }
        else if (n+1 < nums.length - 2) {
          ++n;
          o = n + 1;
          i = nums.length - 1;
        }
        else if (m+1 < nums.length - 3){
          ++m;
          n = m + 1;
          o = n + 1;
          i = nums.length - 1;
        }
        else
          break;
      }
      else if (sum > target && i-1 > o)
        --i;
      else if (o < i-1)
        ++o;
      else if (n < o-1) {
        ++n;
        o = n+1;
        i = nums.length - 1;
      }
      else if (m < n-1) {
        ++m;
        n = m+1;
        o = n+1;
        i = nums.length - 1;
      }
      else
        break;
    }

    return results;
  }

}
