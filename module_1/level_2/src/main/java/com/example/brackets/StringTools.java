package com.example.brackets;

import java.util.*;

public class StringTools {
    public static boolean isCorrectBrackets(String src){
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')','(');
        brackets.put('}','{');
        brackets.put(']','[');
        Deque<Character> openBrackets = new ArrayDeque<>();
        for(char c : src.toCharArray()){
            if(brackets.containsValue(c))
                openBrackets.push(c);
            else if(brackets.containsKey(c)){
                if(openBrackets.isEmpty() || brackets.get(c) != openBrackets.pop())
                    return false;
            }
        }
        return openBrackets.isEmpty();
    }
}
