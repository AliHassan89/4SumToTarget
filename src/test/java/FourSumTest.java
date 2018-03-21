package test.java;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;
import main.java.FourSum;
import org.junit.Test;

public class FourSumTest {

  private FourSum sumOfFour = new FourSum();

  @Test
  public void fourSum_checkForEmptyArrayInput(){
    //given
    int[] arr = {};
    int target = 0;

    //when
    List<List<Integer>> results = sumOfFour.fourSum(arr, target);

    //then
    List<List<Integer>> expectedResults = new ArrayList<>();
    assertThat(results, equalTo(expectedResults));
  }

  @Test
  public void fourSum_checkForInput(){
    //given
    int[] arr = {1, 0, -1, 0, -2, 2};
    int target = 0;

    //when
    List<List<Integer>> results = sumOfFour.fourSum(arr, target);

    //then
    List<List<Integer>> expectedResults = new ArrayList<>();
    List<Integer> list_1 = new ArrayList<>();
    list_1.add(-2);
    list_1.add(-1);
    list_1.add(1);
    list_1.add(2);
    expectedResults.add(list_1);
    List<Integer> list_2 = new ArrayList<>();
    list_2.add(-2);
    list_2.add(0);
    list_2.add(0);
    list_2.add(2);
    expectedResults.add(list_2);
    List<Integer> list_3 = new ArrayList<>();
    list_3.add(-1);
    list_3.add(0);
    list_3.add(0);
    list_3.add(1);
    expectedResults.add(list_3);

    assertThat(results, equalTo(expectedResults));
  }
}
