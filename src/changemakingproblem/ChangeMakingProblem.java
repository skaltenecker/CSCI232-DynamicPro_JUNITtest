package changemakingproblem;
/*
*Authors: Scott Kaltenecker Lab Section[5]
*Date: April 19, 2018
*Overview: This program has an assigned value and a list of coins. The goal is get to the value with the fewest amount of coins
*          There is no main method. The progrm is driven off of the JUNIT tests.
           The JUNIT tests check for null entries, impossible solutions,
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Scott
 */
public class ChangeMakingProblem {

    public static List greedcoin(int[] coins, int value){     
        //exception if array is empty
        if(coins.length == 0){
            throw new IllegalArgumentException("Can't Handle Empty Arrays");
        }
        
        for(int i=0; i<coins.length; i++){
            if(coins[i] <= 0){
                throw new IllegalArgumentException("Need Positive Denominations");
            }
        }
        
        //sort array to put lowest value coins at the begining of array
        Arrays.sort(coins);

        //initialize results array
        List result = new ArrayList();
                
        //find the largest denomination that is samller than value
        //start with the largest coin values
        for(int i=coins.length-1; i>=0; i--){
            while(value >= coins[i]){
                value = value-coins[i];
                result.add(coins[i]);
            }
        }
        return result;//remove
    } 
    
}
