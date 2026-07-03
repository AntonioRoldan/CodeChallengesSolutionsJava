package CompetitiveProgrammingSolutions;
import java.lang.StringBuilder;


//Complete the method/function so that it converts dash/underscore delimited words into camel casing. The first word within the output should be capitalized only if the original word was capitalized (known as Upper Camel Case, also often referred to as Pascal case). The next words should be always capitalized.
//Examples
//
//"the-stealth-warrior" gets converted to "theStealthWarrior"
//
//"The_Stealth_Warrior" gets converted to "TheStealthWarrior"
//
//"The_Stealth-Warrior" gets converted to "TheStealthWarrior"
class ConvertToCamelCase{


    public static StringBuilder deleteCharJava(String s, char ch) {
        StringBuilder newStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ch) {
                newStr.append(c);
            }
        }
        return newStr;
    }

    static String toCamelCase(String s){
        if(s.equals("")){
            return "";
        }
        StringBuilder stringToBeConvertedToCamelCase = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++){
            System.out.println(stringToBeConvertedToCamelCase);
            if(Character.toString(s.charAt(i)).equals("-")|| Character.toString(s.charAt(i)).equals("_")) {
                System.out.println(stringToBeConvertedToCamelCase);
                stringToBeConvertedToCamelCase.setCharAt(i + 1, Character.toString(s.charAt(i + 1)).toUpperCase().charAt(0));
            }
        }
        stringToBeConvertedToCamelCase = deleteCharJava(stringToBeConvertedToCamelCase.toString(), '-');
        stringToBeConvertedToCamelCase = deleteCharJava(stringToBeConvertedToCamelCase.toString(), '_');
        new StringBuilder(stringToBeConvertedToCamelCase).setCharAt(0, Character.toString(s.charAt(0)).toUpperCase().charAt(0));
        return stringToBeConvertedToCamelCase.toString();
    }
}