import java.util.*;

//Statement Equal Elements
//
//You are given an array AA of size NN. In one operation, you can do the following:
//
//    Select indices ii and jj (i≠j)(i=j) and set Ai=AjAi​=Aj​.
//
//Find the minimum number of operations required to make all elements of the array equal.
//Input Format
//
//    The first line of input will contain a single integer TT, denoting the number of test cases.
//    Each test case consists of multiple lines of input.
//        The first line of each test case contains an integer NN — the size of the array.
//        The next line contains NN space-separated integers, denoting the array AA.
//
//Output Format
//
//For each test case, output on a new line, the minimum number of operations required to make all elements of the array equal.
//Constraints
//
//    1≤T≤10001≤T≤1000
//    1≤N≤2⋅1051≤N≤2⋅105
//    1≤Ai≤N1≤Ai​≤N
//    The sum of NN over all test cases won't exceed 2⋅1052⋅105.
//
//Sample 1:
//Input
//Output
//
//3
//3
//1 2 3
//4
//2 2 3 1
//4
//3 1 2 4
//
//2
//2
//3
//
//Explanation:
//
//Test case 11: The minimum number of operations required to make all elements of the array equal is 22. A possible sequence of operations is:
//
//    Select indices 11 and 22 and set A1=A2=2A1​=A2​=2.
//    Select indices 33 and 22 and set A3=A2=2A3​=A2​=2.
//
//Thus, the final array is [2,2,2][2,2,2].
//
//Test case 22: The minimum number of operations required to make all elements of the array equal is 22. A possible sequence of operations is:
//
//    Select indices 33 and 22 and set A3=A2=2A3​=A2​=2.
//    Select indices 44 and 33 and set A4=A3=2A4​=A3​=2.
//
//Thus, the final array is [2,2,2,2][2,2,2,2].
//
//Test case 33: The minimum number of operations required to make all elements of the array equal is 33. A possible sequence of operations is:
//
//    Select indices 2 and 1 and set A2=A1=3A2​=A1​=3.
//    Select indices 3 and 1 and set A3=A1=3A3​=A1​=3.
//    Select indices 4 and 1 and set A4=A1=3A4​=A1​=3.
//
//Thus, the final array is [3,3,3,3][3,3,3,3].

import java.util.*;
import java.lang.*;
import java.io.*;

class EqualElements
{
    private static boolean checkIfArrayElementsAreDistinct(int[] arr){


        // using a HashSet to store unique elements
        HashSet<Integer> seen = new HashSet<>();

        // iterating over the array
        for (int num : arr) {

            // if element already exists, duplicate found
            if (seen.contains(num)) {
                return false;
            }

            seen.add(num);
        }

        return true;

    }

    private static boolean checkIfArrayElementsAreTheSame(int[] arr){

        // Put all array elements in a HashSet
        Set<Integer> s = new HashSet<>();
        for (int num : arr) {
            s.add(num);
        }
        // If all elements are same, size of
        // HashSet should be 1. As HashSet contains only distinct values.
        Iterator itr = s.iterator();

        // check element is present or not. if not loop will
        // break.
        //while (itr.hasNext()) {
        //System.out.println("DEBUG:" + itr.next());

        //}
        //System.out.println("DEBUG: " + "a set has been printed");
        return s.size() == 1;
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            HashMap<Integer, Integer> numbersToOccurrencesAmountMap = new HashMap<Integer, Integer>();

            // your code goes here
            int n = sc.nextInt();
            int[] inputArray;
            inputArray = new int[n];
            for(int i = 0; i < n; i++){
                int arrayElement = sc.nextInt();
                inputArray[i] = arrayElement;
                Integer arrayElementInteger = arrayElement;
                Integer oneForOccurrenceIncrease = 1;
                if(!numbersToOccurrencesAmountMap.keySet().contains(arrayElement)){

                    numbersToOccurrencesAmountMap.put(arrayElementInteger, oneForOccurrenceIncrease);
                } else {
                    Integer currentOccurrecesForThisNumber = numbersToOccurrencesAmountMap.get(arrayElement);
                    //System.out.println("DEBUG: occurrences for " + Integer.toString(arrayElement) + " are " + Integer.toString(currentOccurrecesForThisNumber));
                    numbersToOccurrencesAmountMap.put(arrayElementInteger, currentOccurrecesForThisNumber + oneForOccurrenceIncrease);
                }
            }
            if(checkIfArrayElementsAreDistinct(inputArray)){
                System.out.println(n - 1);
            } else if(checkIfArrayElementsAreTheSame(inputArray)){
                System.out.println(0);
            } else {
                Iterator<Integer> iterator = numbersToOccurrencesAmountMap.keySet().iterator();
                Integer largestAmountOfOccurrencesOfAGivenKeyNumber = 0;

                while(iterator.hasNext()){
                    Integer key = iterator.next();
                    Integer mostRepeatedNumber = 0;
                    if(numbersToOccurrencesAmountMap.get(key) > largestAmountOfOccurrencesOfAGivenKeyNumber){
                        largestAmountOfOccurrencesOfAGivenKeyNumber = numbersToOccurrencesAmountMap.get(key);
                        //System.out.println("DEBUG: " + Integer.toString(numbersToOccurrencesAmountMap.get(key)));


                        //System.out.println("DEBUG: " + "Number occurreces printed for " + Integer.toString(key));
                        mostRepeatedNumber = key;
                    }
                }
                System.out.println(n - largestAmountOfOccurrencesOfAGivenKeyNumber);
            }
        }

    }
}


