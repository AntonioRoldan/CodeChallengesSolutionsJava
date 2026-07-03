package CompetitiveProgrammingSolutions;
import java.lang.StringBuilder;

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