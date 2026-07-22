package CompetitiveProgrammingSolutions;


//Write a function to find the longest common prefix string amongst an array of strings.
//
//If there is no common prefix, return an empty string "".
//
//
//
//Example 1:
//
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
//
//Example 2:
//
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
//
//
class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        StringBuilder longestCommonPrefix = new StringBuilder();
        char currentCharacter = '0';
        Boolean commonPrefixCharacterFoundAndExtended = true; //THis should initially be set to true so the first loop runs
        for(int i = 0; i < strs[0].length(); i++){
            for(int j = 1; j < strs.length; j++){
                if(!commonPrefixCharacterFoundAndExtended){ //If a common character is not found between the first string and any of the consecutive strings we are done
                    break;
                }
                if(strs[j].length() - 1 < i){ //If the length of the next string for comparison is smaller than the index we are at we are done
                    return longestCommonPrefix.toString();
                } else {
                    if(strs[0].charAt(i) == strs[j].charAt(i)){
                        commonPrefixCharacterFoundAndExtended = true;
                    } else {
                        commonPrefixCharacterFoundAndExtended = false;
                    }
                }
            }
            if(commonPrefixCharacterFoundAndExtended){
                longestCommonPrefix.append(Character.toString(strs[0].charAt(i)));
            }
        }
        return longestCommonPrefix.toString();
    }
}