package com.eoghan;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FirstNonRepeatingWord {
    private Set<String> allWords ;
    private List<String> nonRepeatWords;

    public FirstNonRepeatingWord() {
        allWords = new HashSet<>();
        nonRepeatWords = new LinkedList<>();
    }

    public String firstNonRepeatingWord(String s){
        updateSet(toArray(s));
        return nonRepeatWords.get(0);
    }

    private void updateSet(String[] arr){
        for (String s: arr){
            if (allWords.add(s)){
                addToList(s);
            } else{
                removeFromList(s);
            }
        }
    }

    private void removeFromList(String s) {
        nonRepeatWords.remove(s);
    }

    private void addToList(String s) {
        nonRepeatWords.add(s);
    }

    private String[] toArray(String s){
        return s.replaceAll("\\p{P}", "").toLowerCase().split("\\s+");
    }
}
