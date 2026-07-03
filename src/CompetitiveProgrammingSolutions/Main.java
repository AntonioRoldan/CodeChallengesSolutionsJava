package CompetitiveProgrammingSolutions;

//PROBLEM STATEMENT: FIND ALL PERMUTATIONS OF S AND RETURN LIST OF PERMUTATIONS WITH UNIQUE CHARACTERS AND PRINT LIST OF UNIQUE CHARACTERS EACH PERMUTATION HAS
//You will be given a list of strings. You must sort it alphabetically (case-sensitive, and based on the ASCII values of the chars) and then return the first value.
//
//The returned value must be a string, and have "***" between each of its letters.
//
//You should not remove or add elements from/to the array.

//INPUTS: SORT AND STAR ew String[] {"turns", "out", "random", "test", "cases", "are", "easier", "than", "writing", "out", "basic", "ones"}

//INPUTS: PERMUTATIONS "aloha"

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        List<String> solution = new PermutationsWithUniqueCharactersSolution().getPermutationsOfString("aloha");
        System.out.println(solution);
    }
}

