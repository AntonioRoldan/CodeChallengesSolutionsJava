package CompetitiveProgrammingSolutions;

import java.util.*;

//You are given an integer array deck where deck[i] represents the number written on the ith card.
//
//Partition the cards into one or more groups such that:
//
//    Each group has exactly x cards where x > 1, and
//    All the cards in one group have the same integer written on them.
//
//Return true if such partition is possible, or false otherwise.
//
//
//
//Example 1:
//
//Input: deck = [1,2,3,4,4,3,2,1]
//Output: true
//Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
//
//Example 2:
//
//Input: deck = [1,1,1,2,2,2,3,3]
//Output: false
//Explanation: No possible partition.
//
//
//
//Constraints:
//
//    1 <= deck.length <= 104
//    0 <= deck[i] < 104


class XOfAKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        List<Integer> deckList = new ArrayList<Integer>();
        List<Integer> deckSizes = new ArrayList<Integer>();
        Set<Integer> uniqueNumbersInDeckSet = new HashSet<Integer>();
        List<Integer> uniqueNumbersInDeckList = new ArrayList<Integer>();
        uniqueNumbersInDeckList.addAll(uniqueNumbersInDeckSet);
        Map<Integer, ArrayList<Integer>> mapOfNumberToCardsWithThatNumber = new HashMap<Integer, ArrayList<Integer>>();
        int subDeckSize = 0;
        int currentSubDeckSize = 0;
        int smallestDeckSize = 0;
        if(deck.length == 1){
            return false;
        }
        for(int i = 0; i < deck.length; i++){
            deckList.add(deck[i]);
        }
        for(int i = 0; i < deckList.size(); i++){
            uniqueNumbersInDeckSet.add(deckList.get(i));
        }
        uniqueNumbersInDeckList = new ArrayList<Integer>(uniqueNumbersInDeckSet);
        System.out.println(uniqueNumbersInDeckList);
        for(int i = 0; i < uniqueNumbersInDeckList.size(); i++){
            mapOfNumberToCardsWithThatNumber.put(uniqueNumbersInDeckList.get(i), new ArrayList<Integer>());
        }
        for(int i = 0; i < deckList.size(); i++){
            ArrayList<Integer> temp = mapOfNumberToCardsWithThatNumber.get(Integer.valueOf(deck[i]));
            temp.add(deckList.get(i));
            mapOfNumberToCardsWithThatNumber.put(Integer.valueOf(deck[i]), temp);
        }
        for(int i = 0; i < uniqueNumbersInDeckList.size(); i++){
            deckSizes.add(mapOfNumberToCardsWithThatNumber.get(uniqueNumbersInDeckList.get(i)).size());
        }
        smallestDeckSize = Collections.min(deckSizes);
        for(int i = 0; i < uniqueNumbersInDeckList.size(); i++){
            currentSubDeckSize = mapOfNumberToCardsWithThatNumber.get(uniqueNumbersInDeckList.get(i)).size();
            if(currentSubDeckSize % smallestDeckSize == 0 || currentSubDeckSize % 2 == 0 && smallestDeckSize % 2 == 0){
                if(smallestDeckSize == 1 && currentSubDeckSize > 1){
                    return false;
                }
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
