package changemakingproblem;
/*
*Authors: Scott Kaltenecker Lab Section[5]
*Date: April 19, 2018
*Overview: This program has an assigned value and a list of coins. The goal is get to the value with the fewest amount of coins
*          There is no main method. The progrm is driven off of the JUNIT tests.
*          The JUNIT tests check for null entries, impossible solutions, and correct outputs.
*          The Solution to this problem uses dynamic programing 
*Sources:  We implement the same methods descibed in class and in the link provided in the assigment: 
*          http://interactivepython.org/runestone/static/pythonds/Recursion/DynamicProgramming.html
*/

import org.junit.Assert;
import org.junit.Test;

public class ChangeMakingProblemTest {

    @Test
    public void changeMakingT1() {//coins in random order
        System.out.println("Dynamic Coins Test 1");
        int[] coins = {5,1,25,10};
        int value = 62;
        int[] expected = {25,25,10,1,1};
        Assert.assertArrayEquals(expected, ChangeMakingProblem.changeMaking(coins,value));
        System.out.println("Test Done\n");
    }
    @Test
    public void changeMakingT2() {//test correct output
        System.out.println("Dynamic Coins Test 2");
        int[] coins = {1,5,10,12};
        int value = 16;
        int[] expected = {10,5,1};    
        Assert.assertArrayEquals(expected, ChangeMakingProblem.changeMaking(coins,value));
        System.out.println("Test Done\n");
    }
    @Test
    public void changeMakingT3() {//test correct output
        System.out.println("Dynamic Coins Test 3");
        int[] coins = {1,5,10,21,25};
        int value = 63;
        int[] expected = {21,21,21};
        Assert.assertArrayEquals(expected, ChangeMakingProblem.changeMaking(coins,value));
        System.out.println("Test Done\n");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void changeMakingT4() {//test for null exception throw
        System.out.println("Dynamic Coins Test 4");
        int[] coins = {};
        int value = 10;
        int[] expected = {25,25,10,1,1};
        Assert.assertArrayEquals(expected, ChangeMakingProblem.changeMaking(coins,value));
        System.out.println("Test Done\n");
    }
       
    @Test(expected=IllegalArgumentException.class)
    public void changeMakingT5() {//test for invalid argument throw
        System.out.println("Dynamic Coins Test 5");
        int[] coins = {-1,1,2,0,10};
        int value = 10;
        int[] expected = {25,25,10,1,1};    
        Assert.assertArrayEquals(expected, ChangeMakingProblem.changeMaking(coins,value));
        System.out.println("Test Done\n");
    }
    
}
