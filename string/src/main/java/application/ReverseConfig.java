package application;

import library.ReverseLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseConfig {

    public static BufferedReader reader;

    public static void start() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        String testString = "Auto String";

        try {
            System.out.println("Choose what you want to do:\n" +
                    "1 -> Reverse string\n" +
                    "2 -> Reverse substring in string\n" +
                    "3 -> Reverse for user configuration\n" +
                    "Input any other symbols for exit");
            while ((input = reader.readLine())!= null) {
                switch (input) {
                    case "1" : {
                        System.out.println("Reverse your string.");
                        System.out.println("Please enter how do u want to check: \n" +
                                "1 - Automatically \n" +
                                "2 - Input string by yourself \n" +
                                "Input any other symbols for exit");
                        switch (reader.readLine()) {
                            case "1": {
                                System.out.println("Your string is:" + testString);
                                System.out.println("Result: " + ReverseLibrary.reverse(testString));
                                System.out.println();
                                break;
                            }
                            case "2": {
                                System.out.println("Enter your string");
                                input = reader.readLine();
                                System.out.println("Your initial string is:" + input);
                                System.out.println("Result: " + ReverseLibrary.reverse(input));
                                System.out.println();
                                break;
                            }
                            default:
                                System.exit(0);
                        }
                    } break;
                    case "2" : {
                        System.out.println("Reverse your sub string.");
                        System.out.println("Please enter how do u want to check: \n" +
                                "1 - Automatically \n" +
                                "2 - Input string by yourself \n" +
                                "Input any other symbols for exit");
                        switch (reader.readLine()) {
                            case "1": {
                                System.out.println("Your string is:" + testString);
                                System.out.println("Your sub string is: Aut");
                                System.out.println("Result: " + ReverseLibrary.reverse(testString, "Aut"));
                                System.out.println();
                                break;
                            }
                            case "2": {
                                System.out.println("Enter your string");
                                input = reader.readLine();
                                System.out.println("Your initial string is:" + input);
                                System.out.println("Input substring you want to reverse: ");
                                String subStr = reader.readLine();
                                System.out.println("Result: " + ReverseLibrary.reverse(input, subStr));
                                System.out.println();
                                break;
                            }
                            default:
                                System.exit(0);
                        }
                    } break;
                    case "3" : {
                        reverseForUserConfiguration();
                    } break;
                    default: {
                        System.exit(0);
                    }break;

                }
                System.out.println("Choose what you want to do:\n" +
                        "1 -> Reverse string\n" +
                        "2 -> Reverse substring in string\n" +
                        "3 -> Reverse for user configuration\n" +
                        "Input any other symbols for exit");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reverseForUserConfiguration() {
        String input;
        String testString = "Auto String";
        try {
            System.out.println("Pick reverse format\n" +
                    "1 -> Index reverse\n" +
                    "2 -> Char reverse\n" +
                    "3 -> String reverse\n" +
                    "4 -> Char sequence\n" +
                    "Input any other symbols for exit");
            while ((input = reader.readLine())!= null) {
                switch (input) {
                    case "1" : {
                        System.out.println("Reverse by your index.");
                        System.out.println("Please enter how do u want to check: \n" +
                                "1 - Automatically \n" +
                                "2 - Input string by yourself \n" +
                                "Input any other symbols for exit");
                        switch (reader.readLine()) {
                            case "1": {
                                System.out.println("Your initial string is:" + testString);
                                System.out.println(ReverseLibrary.reverse(testString, 2, 5));
                                break;
                            }
                            case "2": {
                                reverseForIndex();
                                break;
                            }
                            default:
                                System.exit(0);
                        }
                    } break;
                    case "2" : {
                        System.out.println("Reverse by your char.");
                        System.out.println("Please enter how do u want to check: \n" +
                                "1 - Automatically \n" +
                                "2 - Input string by yourself \n" +
                                "Input any other symbols for exit");
                        switch (reader.readLine()) {
                            case "1": {
                                System.out.println("Your initial string is:" + testString);
                                System.out.println(ReverseLibrary.reverse(testString, 'u', 'r'));
                                break;
                            }
                            case "2": {
                                reverseForChar();
                                break;
                            }
                            default:
                                System.exit(0);
                        }
                    } break;
                    case "3" : {
                        System.out.println("Reverse by your sub strings.");
                        System.out.println("Please enter how do u want to check: \n" +
                                "1 - Automatically \n" +
                                "2 - Input string by yourself \n" +
                                "Input any other symbols for exit");
                        switch (reader.readLine()) {
                            case "1": {
                                System.out.println("Your initial string is:" + testString);
                                System.out.println(ReverseLibrary.reverse(testString, "Aut", "ing"));
                                break;
                            }
                            case "2": {
                                reverseForSubStr();
                                break;
                            }
                            default:
                                System.exit(0);
                        }
                    } break;
                    case "4": {
                        System.out.println("Reverse by your char sequence.");
                        System.out.println("Please enter how do u want to check: \n" +
                                "1 - Automatically \n" +
                                "2 - Input string by yourself \n" +
                                "Input any other symbols for exit");
                        switch (reader.readLine()) {
                            case "1": {
                                System.out.println("Your initial string is:" + testString);
                                System.out.println(ReverseLibrary.reverse(testString, 't', 'r'));
                                break;
                            }
                            case "2": {
                                reverseForCharSequence();
                                break;
                            }
                            default:
                                System.exit(0);
                        }
                    } break;
                    default: {
                        System.exit(0);
                    }break;
                }
                System.out.println("Pick reverse format\n" +
                        "1 -> Index reverse\n" +
                        "2 -> Char reverse\n" +
                        "3 -> String reverse\n" +
                        "4 -> Char sequence\n" +
                        "Input any other symbols for exit");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reverseForIndex() throws IOException {
        System.out.println("Enter the string: ");
        String str = reader.readLine();
        System.out.println("Enter first index: ");
        int firstIndex = Integer.parseInt(reader.readLine());
        System.out.println("Enter second index: ");
        int secondIndex = Integer.parseInt(reader.readLine());
        System.out.println(ReverseLibrary.reverse(str, firstIndex, secondIndex));
    }

    public static void reverseForChar() throws IOException {
        System.out.println("Enter string: ");
        String str = reader.readLine();
        System.out.println("Enter first symbol: ");
        char firstChar = reader.readLine().charAt(0);
        System.out.println("Enter second symbol: ");
        char secondChar = reader.readLine().charAt(0);
        System.out.println(ReverseLibrary.reverse(str, firstChar, secondChar));
    }

    public static void reverseForSubStr() throws IOException {
        System.out.println("Enter string: ");
        String str = reader.readLine();
        System.out.println("Enter first subString: ");
        String firstSubString = reader.readLine();
        System.out.println("Enter second subString: ");
        String secondSubString = reader.readLine();
        System.out.println(ReverseLibrary.reverse(str, firstSubString, secondSubString));
    }

    public static void reverseForCharSequence() throws IOException {
        System.out.println("Enter string: ");
        String str = reader.readLine();
        System.out.println("Enter first char sequence: ");
        CharSequence firstCharSequence = reader.readLine();
        System.out.println("Enter second char sequence: ");
        CharSequence secondCharSequence = reader.readLine();
        System.out.println(ReverseLibrary.reverse(str, firstCharSequence, secondCharSequence));
    }
}