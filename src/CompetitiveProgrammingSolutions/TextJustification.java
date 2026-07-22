package CompetitiveProgrammingSolutions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
//
//You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
//
//Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
//
//For the last line of text, it should be left-justified, and no extra space is inserted between words.
//
//Note:
//
//    A word is defined as a character sequence consisting of non-space characters only.
//    Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
//    The input array words contains at least one word.
//
//
//
//Example 1:
//
//Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
//Output:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
//
//Example 2:
//
//Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
//Output:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
//Note that the second line is also left-justified because it contains only one word.

//FAILED

class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int greedyMaxNumberOfWordsPerLine = (int)Math.floor(words.length / 2);
        int minimumNumberOfSpacePadsPerLine = greedyMaxNumberOfWordsPerLine - 1;
        int numberOfSpacesForALine = 0;
        int numberOfSpacesForASpacePad = 0;
        Boolean extraPadFromFlooringLeftoverAdded = false;
        int currentWidth = 0;
        ArrayList<ArrayList<String>> outputTextLines = new ArrayList<ArrayList<String>>();
        List<String> line = new ArrayList<String>();
        List<String> outputText = new ArrayList<String>();
        for(int i = 0; i < words.length; i++){
            if(i % greedyMaxNumberOfWordsPerLine == 0){ //If we start a new line NOTE: clear line array here 
                for(int j = 0; j < line.size(); j++){
                    currentWidth += line.get(j).length();
                }
                if(currentWidth + minimumNumberOfSpacePadsPerLine > maxWidth){
                    while(currentWidth + minimumNumberOfSpacePadsPerLine > maxWidth){
                        currentWidth -= line.get(line.size() - 1).length();
                        line.remove(line.size() - 1);
                    }
                }
                numberOfSpacesForALine = maxWidth - currentWidth;
                numberOfSpacesForASpacePad = (int) Math.floor(numberOfSpacesForALine / minimumNumberOfSpacePadsPerLine);
                for(int j = 0; j < line.size(); j++){ //We go line by line and add them 
                    if(!extraPadFromFlooringLeftoverAdded){
                        for(int k = 0; k <= numberOfSpacesForASpacePad + 1; k++){
                            extraPadFromFlooringLeftoverAdded = true;
                            line.add(j + 1, " ");
                        }
                        outputTextLines.add((ArrayList<String>)line);
                        line = new ArrayList<String>();
                        currentWidth = 0;
                    } else {
                        for(int k = 0; k <= numberOfSpacesForASpacePad; k++){
                            line.add(j + 1, " ");
                        }
                        outputTextLines.add((ArrayList<String>)line);
                        line = new ArrayList<String>();
                        currentWidth = 0;
                    }
                }
            }
            line.add(words[i]);
        }
        outputText = outputTextLines.stream().flatMap(List::stream).collect(Collectors.toList());
        return outputText;
    }
}