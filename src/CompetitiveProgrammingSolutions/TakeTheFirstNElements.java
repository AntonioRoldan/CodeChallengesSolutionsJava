package CompetitiveProgrammingSolutions;


//Create a function that accepts a sequence and a non-negative integer n, and returns a sequence of the first n elements from it.
//
//If the sequence has fewer than n elements, return all of them.
//Examples
//
//[0, 1, 2, 3, 5, 8, 13], n = 3  =>  [0, 1, 2]
//[0, 1, 2, 3, 5, 8, 13], n = 0  =>  []
//                    [], n = 3  =>  []
//

public class TakeTheFirstNElements {
    public static int[] take(int[] arr, int n) {
        int[] returnedSubsequence = new int[n];
        if(arr.length < n){
            return arr;
        } else {
            for(int i = 0; i < n; i++){
                returnedSubsequence[i] = arr[i];
            }
            return returnedSubsequence;
        }
    }
}