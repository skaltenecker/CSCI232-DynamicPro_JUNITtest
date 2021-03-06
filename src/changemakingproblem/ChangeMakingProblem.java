package changemakingproblem;
/*
*Authors: Scott Kaltenecker Lab Section[5], Blake Mitchell Lab Section [4], Franki Taylor: Lab Section [4]
*Date: April 19, 2018
*Overview: This program has an assigned value and a list of coins. The goal is get to the value with the fewest amount of coins
*          There is no main method. The progrm is driven off of the JUNIT tests.
*          The JUNIT tests check for null entries, impossible solutions, and correct outputs.
*          The Solution to this problem uses dynamic programing 
*Sources:  We implement the same methods descibed in class and in the link provided in the assigment: 
*          http://interactivepython.org/runestone/static/pythonds/Recursion/DynamicProgramming.html
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Scott
 */
public class ChangeMakingProblem {

    public static int[] changeMaking(int[] coins, int value){     
        //exception if array is empty
        if(coins.length == 0){
            throw new IllegalArgumentException("Can't Handle Empty Arrays");
        }
        //exception if array or value has negative numbers
        for(int i=0; i<coins.length; i++){
            if(coins[i] <= 0){
                throw new IllegalArgumentException("Need Positive Denominations");
            }
        }
       
       //exception when value is less than 0
       if(value < 0){
           throw new IllegalArgumentException("Need Positive Value Requested");
       }
        
        //sort array to put lowest value coins at the begining of array
        Arrays.sort(coins);
        
        //exception if array contains duplicate denominations
        for(int i = 1; i < coins.length; i++)
        {
            if(coins[i] == coins[i - 1]){
                throw new IllegalArgumentException("Can't Handle Duplicate Denominations");
            }
        }
        
        //initialize results array
        List result = new ArrayList();
        
        int[] coinTableUsed = new int[value+1];//stores the coins used for coinTable
        int[] coinTable = new int[value+1];//stores the min number of coins for every value
        int minNum = 0;//minimum number of coins required for value
        //a is amount we are calculating in the table
        for(int a=1; a<=value; a++){
            //for each coin denomination
            for(int d=0; d<coins.length; d++){
                if(a>=coins[d]){
                    int den = coins[d];
                    minNum = coinTable[a-den] +1;
                    if((minNum <= coinTable[a]) || (coinTable[a] == 0)){
                        coinTable[a] = minNum;
                        coinTableUsed[a] = den;
                    }
                }                
            }      
        }
        minNum = coinTable[value];
        int[] usedCoins = new int[minNum];
        int n = 0;
        int a = value;
        //calculate the coins used from the coinTables
        while(usedCoins[minNum-1] == 0){
            usedCoins[n] = coinTableUsed[a]; 
            a = a-usedCoins[n];
            n++;
            
            
        }
        System.out.println("The Minimum Number of Coins for "+value+" is : "+coinTable[value]);
        System.out.println("The coins are: ");
        for(int i=0; i<usedCoins.length; i++){
            System.out.println(usedCoins[i]);
        }
        System.out.println("Coin Table List: ");
        int enter = 0;
        for(int i=0; i< coinTable.length; i++){
            if(enter == 10){
                System.out.println();
                System.out.print(coinTable[i]+", ");
                enter = 0;
            }
            else if(i == (coinTable.length)-1){
                System.out.print(coinTable[i]+"\n");
            }
            else{
                System.out.print(coinTable[i]+", ");
                enter++;
            }
        }
                    
        return usedCoins;
    } 
    
}
