package CompetitiveProgrammingSolutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class PermutationsWithUniqueCharactersSolution {
    private String swapCharactersWithinString(String substringInOrder, int i, int j){
        char ch[] = substringInOrder.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }

    //We cannot use a hashset here because that would just remove repeated occurrences of characters rather than strings with repeated occurrences of characters

    private <T> void print(T elementToBePrinted){

        System.out.println(elementToBePrinted);
    }

    public ArrayList<String> getPermutationsOfString(String s){
        ArrayList<String> arrayOfPermutationsOfS = new ArrayList<String>();
        ArrayList<String> arrayOfSmallerPermutationsOfS = new ArrayList<String>();
        ArrayList<String> arrayOfUniquePermutationsOfS = new ArrayList<>();
        int combinationsAmountOfElementsCurrentlySearching = 2;
        int amountWeAreAccumulatingCount = 1;
        int indexOfCurrentlyIteratedAtSubstringOfS = 0;
        String smallerSizePermutationSubstringOfSContainer = "";
        for(int i = 0; i < s.length(); i++){ //We find permutations iterating through each character and then within our inner loop we sap it for every other character within our substring except by itself
            for(int j = 0; j < s.length(); j++){
                if(i == j){
                    continue;
                }
                arrayOfPermutationsOfS.add(this.swapCharactersWithinString(s, i, j));
            }//Abcd
        } //Now because we know that the first three elements of any given set of total permutations will give us all permutations of three characters (the characters that our permutations are made of) we iterate through our array of substrings
        //then through each string and then we extract its substrings of an ever increasing length from zero up to the total length of the string. incremmenting by one in our last third for loop and at the end of the second we add it and empty our container
        //Then we join our two arrays, make their joined array unique and return it.
        for(int i = 0; i < arrayOfPermutationsOfS.size(); i++) {
            for (int j = 1; j < s.length(); j++) {
                for (int k = 0; k < j; k++) {
                    smallerSizePermutationSubstringOfSContainer += Character.toString(arrayOfPermutationsOfS.get(i).charAt(k));
                }
                arrayOfSmallerPermutationsOfS.add(smallerSizePermutationSubstringOfSContainer);
                smallerSizePermutationSubstringOfSContainer = "";
            }
        }
        arrayOfPermutationsOfS.addAll(arrayOfSmallerPermutationsOfS);
        //Now we have just calculated above the permutations of substrings of the same length as the original string, their smaller substrings constitute the remaining permutations
        arrayOfUniquePermutationsOfS = new ArrayList<String>(new HashSet<String>(arrayOfPermutationsOfS)); //We then delete occurrences
        //print(arrayOfPermutationsOfS);
        return arrayOfUniquePermutationsOfS;
    }
}
