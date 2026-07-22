package CompetitiveProgrammingSolutions;

import java.sql.Array;
import java.util.*;

class XOfAKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        List<Integer> deckList = new ArrayList<Integer>();
        Set<Integer> uniqueNumbersInDeckSet = new HashSet<Integer>();
        List<Integer> uniqueNumbersInDeckList = new ArrayList<Integer>();
        uniqueNumbersInDeckList.addAll(uniqueNumbersInDeckSet);
        Map<Integer, ArrayList<Integer>> mapOfNumberToCardsWithThatNumber = new HashMap<Integer, ArrayList<Integer>>();
        int subDeckSize = 0;
        int currentSubDeckSize = 0;
        for(int i = 0; i < deckList.size(); i++){
            uniqueNumbersInDeckSet.add(deckList.get(i));
        }
        uniqueNumbersInDeckList = new ArrayList<Integer>(uniqueNumbersInDeckSet);
        for(int i = 0; i < uniqueNumbersInDeckList.size(); i++){
            mapOfNumberToCardsWithThatNumber.put(uniqueNumbersInDeckList.get(i), new ArrayList<Integer>());
        }
        for(int i = 0; i < deckList.size(); i++){
            ArrayList<Integer> temp = mapOfNumberToCardsWithThatNumber.get(Integer.valueOf(deck[i]));
            temp.add(deckList.get(i));
            mapOfNumberToCardsWithThatNumber.put(Integer.valueOf(deck[i]), temp);
        }
        for(int i = 0; i < uniqueNumbersInDeckSet.size(); i++){
            currentSubDeckSize = mapOfNumberToCardsWithThatNumber.get(uniqueNumbersInDeckList.get(i)).size();
            if(i == 0){
                subDeckSize = currentSubDeckSize;
            } else {
                if(subDeckSize != currentSubDeckSize){
                    return false;
                }
            }
        }
        return true;
    }
}
