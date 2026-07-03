package CompetitiveProgrammingSolutions;
import java.util.ArrayList;
import java.util.List;


//PROBLEM STATEMENT: FIND ALL PERMUTATIONS OF S AND RETURN LIST OF PERMUTATIONS WITH UNIQUE CHARACTERS AND PRINT LIST OF UNIQUE CHARACTERS EACH PERMUTATION HAS
//You will be given a list of strings. You must sort it alphabetically (case-sensitive, and based on the ASCII values of the chars) and then return the first value.
//
//The returned value must be a string, and have "***" between each of its letters.
//
//You should not remove or add elements from/to the array.

public class SortAndStar {

    public static String star(String string){
        List<String> starredSplittedString = new ArrayList<String>();
        for(int i = 0; i < string.length(); i++){
            if(i == string.length() - 1){
                starredSplittedString.add(Character.toString(string.charAt(i)));
            } else {
                starredSplittedString.add(Character.toString(string.charAt(i)));
                starredSplittedString.add("*");
                starredSplittedString.add("*");
                starredSplittedString.add("*");
            }
        }
        return String.join("", starredSplittedString);
    }
    public static String twoSort(String[] s) {
        String firstString = "";
        for(int i = 0; i < s.length; i++){
            if(i == 0){
                firstString = s[i];
            } else if(s[i].charAt(0) < firstString.charAt(0)){
                firstString = s[i];
            } else if(s[i].charAt(0) == firstString.charAt(0)){
                if(s[i].length() < firstString.length()){
                    for(int j = 0; j < s[i].length(); j++){
                        if(s[i].charAt(j) < firstString.charAt(j)){
                            firstString = s[i];
                            break;
                        }
                    }
                } else if(s[i].length() >= firstString.length()){
                    for(int j = 0; j < firstString.length(); j++){
                        if(s[i].charAt(j) < firstString.charAt(j)){
                            firstString = s[i];
                            break;
                        }
                    }
                }
            }
        }
        return star(firstString);
    }
}