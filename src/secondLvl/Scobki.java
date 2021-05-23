package secondLvl;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Scobki {


    public static void rightsScobki() throws Exception
    {
        Map<Character, Character> brackets = new Hashtable<>();
        brackets.put(']', '[');
        brackets.put('}', '{');
        brackets.put(')', '(');
        boolean pr = true;


        Scanner s = new Scanner(System.in);

            System.out.println("Enter a string");

            System.out.format("balanced: %b%n", isBalanced(s.nextLine(), brackets));

    }

    public static boolean isBalanced(String str, Map<Character, Character> brk)
    {
        Stack<Character> stk = new Stack<>();

        for (char c : str.toCharArray())
        {
            if (brk.containsValue(c))
            {
                stk.push(c);
            }
            else
            {
                if (brk.containsKey(c))
                {
                    if (stk.isEmpty() || !brk.get(c).equals(stk.pop()))
                    {
                        return false;
                    }
                }
            }
        }

        return stk.isEmpty();
    }}