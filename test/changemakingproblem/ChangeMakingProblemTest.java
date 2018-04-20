package changemakingproblem;
/*
*Authors: Scott Kaltenecker Lab Section[5]
*Date: April 19, 2018
*Overview: This program has an assigned value and a list of coins. The goal is get to the value with the fewest amount of coins
*          There is no main method. The progrm is driven off of the JUNIT tests.
*          The JUNIT tests check for null entries, impossible solutions, and correct outputs.
*          The Solution to this problem uses dynamic programing 
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChangeMakingProblemTest {

    @Test
    public void changeMakingT1() {
        System.out.println("Greedy Coins Test 1");
        int[] coins = {5,1,25,10};
        int value = 62;
        List expected = new ArrayList();
        expected.add(25);
        expected.add(25);
        expected.add(10);
        expected.add(1);
        expected.add(1);
        assertEquals(expected, ChangeMakingProblem.changeMaking(coins,value));
    }
    @Test
    public void changeMakingT2() {
        System.out.println("Greedy Coins Test 2");
        int[] coins = {5,1,25,10};
        int value = 86;
        List expected = new ArrayList();
        expected.add(25);
        expected.add(25);
        expected.add(25);
        expected.add(10);
        expected.add(1);
        assertEquals(expected, ChangeMakingProblem.changeMaking(coins,value));
    }
    @Test
    public void changeMakingT3() {
        System.out.println("Greedy Coins Test 3");
        int[] coins = {1,2,5,10,20};
        int value = 58;
        List expected = new ArrayList();
        expected.add(20);
        expected.add(20);
        expected.add(10);
        expected.add(5);
        expected.add(2);
        expected.add(1);
        assertEquals(expected, ChangeMakingProblem.changeMaking(coins,value));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void changeMakingT4() {
        System.out.println("Greedy Coins Test 4");
        int[] coins = {};
        int value = 10;
        List expected = new ArrayList();
        assertEquals(expected, ChangeMakingProblem.changeMaking(coins,value));
    }
       
    @Test(expected=IllegalArgumentException.class)
    public void changeMakingT5() {
        System.out.println("Greedy Coins Test 5");
        int[] coins = {-1,1,2,0,10};
        int value = 10;
        List expected = new ArrayList();
        assertEquals(expected, ChangeMakingProblem.changeMaking(coins,value));
    }
    
}
