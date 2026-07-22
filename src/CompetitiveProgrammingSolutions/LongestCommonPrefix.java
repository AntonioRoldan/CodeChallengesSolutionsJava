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
        String longestCommonPrefix = "";
        char currentCharacter = '0';
        Boolean commonPrefixCharacterFoundAndExtended = true;
        for(int i = 0; i < strs[0].length(); i++){
            for(int j = 1; j < strs.length; j++){
                if(!commonPrefixCharacterFoundAndExtended){
                    break;
                }
                if(strs[j].length() - 1 < i){
                    return longestCommonPrefix;
                } else {
                    if(strs[0].charAt(i) == strs[j].charAt(i)){
                        commonPrefixCharacterFoundAndExtended = true;
                    } else {
                        commonPrefixCharacterFoundAndExtended = false;
                    }
                }
            }
            if(commonPrefixCharacterFoundAndExtended){
                longestCommonPrefix += Character.toString(strs[0].charAt(i));
            }
        }
        return longestCommonPrefix;
    }
}