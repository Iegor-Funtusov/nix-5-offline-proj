package application.level_2.IsValid.ua.com.nix.valid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Valid {

    public void findByUser() throws IOException {
        System.out.println("Введите строку: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack();
        stack.push(' ');
        String str = reader.readLine();
        String result = "Верно\n";
        boolean status = true;

        for (int j = 0; j < str.length(); j++) {
            switch (str.charAt(j)) {
                case '(':
                case '[':
                case '{':
                    stack.push(str.charAt(j));
                    break;
                case ')':
                    if (stack.peek() == '(' && !stack.empty()) {
                        stack.pop();
                        break;
                    }
                    status = false;
                    break;
                case ']':
                    if (stack.peek() == '[' && !stack.empty()) {
                        stack.pop();
                        break;
                    }
                    status = false;
                    break;
                case '}':
                    if (stack.peek() == '{' && !stack.empty()) {
                        stack.pop();
                    } else {
                        status = false;
                    }
            }
            if (!status) {
                result = "Неверно\n";
                break;
            }
        }
        stack.pop();
        if (!stack.empty()) {
            result = "Неверно\n";
        }
        System.out.print(result);
    }

    public void findByProgram(){
        String line = "()askd,vlew,lv,v w,w,{ccew,,ew,,2,}cmcew,[]cewc";
        System.out.println("Строка: " + line);
        Stack<Character> stack = new Stack();
        stack.push(' ');
        String result = "Верно\n";
        boolean status = true;

        for (int j = 0; j < line.length(); j++) {
            switch (line.charAt(j)) {
                case '(':
                case '[':
                case '{':
                    stack.push(line.charAt(j));
                    break;
                case ')':
                    if (stack.peek() == '(' && !stack.empty()) {
                        stack.pop();
                        break;
                    }
                    status = false;
                    break;
                case ']':
                    if (stack.peek() == '[' && !stack.empty()) {
                        stack.pop();
                        break;
                    }
                    status = false;
                    break;
                case '}':
                    if (stack.peek() == '{' && !stack.empty()) {
                        stack.pop();
                    } else {
                        status = false;
                    }
            }
            if (!status) {
                result = "Неверно\n";
                break;
            }
        }
        stack.pop();
        if (!stack.empty()) {
            result = "Неверно\n";
        }
        System.out.print(result);

    }
}

