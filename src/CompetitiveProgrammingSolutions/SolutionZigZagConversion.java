package CompetitiveProgrammingSolutions;

import java.util.*;

public class SolutionZigZagConversion
{
        private <T> void print(T elementToBePrinted){

            System.out.println(elementToBePrinted);
        }

        private List<Object> convertLinkedHashSetToList(LinkedHashSet<Object> linkedHashSet){
            Object[] array=new Object[linkedHashSet.size()];                // creating an Array of Double type elements
            array=linkedHashSet.toArray(array);
            return Arrays.asList(array);
        }

        private List<Object> getEncryptedStringPattern(List<Object> columnsAndDiagonals, int numOfRows){
            Boolean skipStoringDiagonalElementsForThisIterationBecauseWeAreAtFirstOrLastRow = false;
            List<Object> zigZagEncrptedString = new ArrayList<Object>();
            List<Object> tempColumnsAndDiagonalsElementContainer = new ArrayList<Object>(); //The element in this variable's name is a column or a diagonal since they are stored intermittently in a single array
            List<Object> columnsOrDiagonalTurnedFromLinkedHashSetToList = new ArrayList<Object>();
            for(int i = 0; i < numOfRows; i++){
                if(i == 0 || i == numOfRows - 1){ //If we are going to store the first character of each column or the last one
                    skipStoringDiagonalElementsForThisIterationBecauseWeAreAtFirstOrLastRow = true; //We must skip adding the diagonal elements
                }
                for(int j = 0; j < columnsAndDiagonals.size(); j++){
                    if((i) % 2 != 0){ //If we may be storing a diagonal because diagonals are at odd numbered elements which we add one to so we don't do zero modulo
                        if(skipStoringDiagonalElementsForThisIterationBecauseWeAreAtFirstOrLastRow){ //Check if we must skip it becase we are taking the first element of all columns or the last one
                            skipStoringDiagonalElementsForThisIterationBecauseWeAreAtFirstOrLastRow = false;
                            continue; //If so we skip this loop's cycle without adding the diagonal character
                        } else {
                            columnsOrDiagonalTurnedFromLinkedHashSetToList = convertLinkedHashSetToList((LinkedHashSet<Object>) columnsAndDiagonals.get(j));
                            tempColumnsAndDiagonalsElementContainer = columnsOrDiagonalTurnedFromLinkedHashSetToList;
                            zigZagEncrptedString.add(tempColumnsAndDiagonalsElementContainer.get(tempColumnsAndDiagonalsElementContainer.size() -1  - i));
                        }
                    } else {
                        columnsOrDiagonalTurnedFromLinkedHashSetToList = convertLinkedHashSetToList((LinkedHashSet<Object>) columnsAndDiagonals.get(j));
                        tempColumnsAndDiagonalsElementContainer = columnsOrDiagonalTurnedFromLinkedHashSetToList;
                        zigZagEncrptedString.add(tempColumnsAndDiagonalsElementContainer.get(i));
                        skipStoringDiagonalElementsForThisIterationBecauseWeAreAtFirstOrLastRow = false;
                    }
                }

            }
            return zigZagEncrptedString;
        }

        private List<Object> getZigZagPattern(String string, int numOfRows){
            List<String> stringCharactersOfSplittedArray = Arrays.asList(string.split(""));
            List<String> columnOrZigZagElementContainer = new ArrayList<String>();
            print(stringCharactersOfSplittedArray); //So we store odds or evens then add them before adding the next iterated elements then add the next iterated elements in the iteration of the next iterated element in the previous one we don't add it but store it for the next iterated element which is the one we are defining in this line
            List<Object> repeatedColumnsAndDiagonals = new ArrayList<>();
            List<Object> columnsAndDiagonals = new ArrayList<>();
            Boolean addReservedCharacterStringSoLastElementOfColumnIsFirstOfDiagonalAndViceversa = false;
            int elementsCountUntilItReachesNumOfRows = 0;
            for (int i = 0; i < stringCharactersOfSplittedArray.size(); i++) {
                // Expand the window
                columnOrZigZagElementContainer.add(stringCharactersOfSplittedArray.get(i));

                // Once window size is reached
                if (i >= numOfRows - 1) {
                    repeatedColumnsAndDiagonals.add(((ArrayList<String>) columnOrZigZagElementContainer).clone());
                    columnOrZigZagElementContainer.remove(stringCharactersOfSplittedArray.get(i - numOfRows + 1));
                    //print(columnOrZigZagElementContainer);
                }
            }
            columnsAndDiagonals = List.of(new LinkedHashSet<>(repeatedColumnsAndDiagonals));
            print(columnsAndDiagonals);
            return columnsAndDiagonals;
        }

        public String convert(String s, int numRows) {
            print(this.getEncryptedStringPattern(this.getZigZagPattern(s, numRows), numRows));
            return "";
        }
}
