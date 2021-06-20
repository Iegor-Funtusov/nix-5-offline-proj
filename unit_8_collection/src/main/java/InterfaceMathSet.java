import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterfaceMathSet {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static MathSet<Integer>[] IntMathSets = new MathSet[20];
    private static MathSet<Double>[] DoubleMathSets = new MathSet[20];

    public static void start() throws IOException {
        String str;
        do {
            System.out.println("1 Auto test");
            System.out.println("2 View all sets");
            System.out.println("3 Create Set");
            System.out.println("4 Add to Set");
            System.out.println("5 Join Sets");
            System.out.println("6 Sort Set");
            System.out.println("7 Get from Set");
            System.out.println("8 Clear Set");
            System.out.println("0 Exit - \"0\"");
            str = reader.readLine();
            if (checkRegExp(str, "[0-8]")) {
                switch (str) {
                    case "1":
                        autoTest();
                        break;
                    case "2":
                        viewSets();
                        break;
                    case "3":
                        createSet();
                        break;
                    case "4":
                        addToSet();
                        break;
                    case "5":
                        joinSets();
                        break;
                    case "6":
                        sortSet();
                        break;
                    case "7":
                        getFromSet();
                        break;
                    case "8":
                        clearSet();
                        break;
                }
            } else {
                System.out.println("Wrong input");
            }
        } while (!str.equals("0"));
    }

    private static void autoTest() {
        Integer[] numbers1 = new Integer[]{5, 1, 3, 2, 4};
        Integer[] numbers2 = new Integer[]{9, 8, 6, 5, 7};
        Integer[] numbers3 = new Integer[]{15, 65, 22, 80, 53};
        System.out.println("arrays of numbers: ");
        for (Integer integer : numbers1) {
            System.out.print(integer + " ");
        }
        System.out.println();
        for (Integer integer : numbers2) {
            System.out.print(integer + " ");
        }
        System.out.println();
        for (Integer integer : numbers3) {
            System.out.print(integer + " ");
        }
        System.out.println();
        MathSet<Integer> mathSet1 = new MathSet<Integer>(numbers1);
        System.out.println("mathSet1 = " + mathSet1);
        MathSet<Integer> mathSet2 = new MathSet<Integer>(numbers2);
        System.out.println("mathSet2 = " + mathSet2);
        MathSet<Integer> mathSet3 = new MathSet<Integer>(numbers3);
        System.out.println("mathSet3 = " + mathSet3);
        System.out.println("mathSet3 + " + "11, 3, 78, 8, 9");
        mathSet3.add(11, 3, 78, 8, 9);
        System.out.println("mathSet3 = " + mathSet3);
        MathSet<Integer> mathSet4 = new MathSet<Integer>(mathSet1, mathSet2);
        System.out.println("mathSet1 + mathSet2 = mathSet4 = " + mathSet4);
        MathSet<Integer> mathSet5 = new MathSet<Integer>();
        mathSet5.join(mathSet3, mathSet4);
        System.out.println("mathSet3 + mathSet4 = mathSet5 = " + mathSet5);
        mathSet5.sortDesc(4, 14);
        System.out.println("mathSet5 sortDesk between 4, 14 " + mathSet5);
        mathSet5.sortAsc(5, 13);
        System.out.println("mathSet5 sortAsk between 5, 13 " + mathSet5);
        System.out.println("mathSet5 get 10 element = " + mathSet5.get(10));
        System.out.println("mathSet5 get Max = " + mathSet5.getMax());
        System.out.println("mathSet5 get Min = " + mathSet5.getMin());
        System.out.println("mathSet5 get Average = " + mathSet5.getAverage());
        System.out.println("mathSet5 get Median = " + mathSet5.getMedian());
        System.out.println("mathSet5 get array between 2, 8 : ");
        Number[] numbers4 = mathSet5.toArray(2, 8);
        for (Number number : numbers4) {
            System.out.print(number + " ");
        }
        System.out.println();
        mathSet5.clear(numbers4);
        System.out.println("mathSet5 clear array = " + mathSet5);
        mathSet5.clear();
        System.out.println("mathSet5 clear All = " + mathSet5);
    }

    private static void viewSets() {
        System.out.println("Integer Sets");
        int i = 0;
        for (MathSet<Integer> intMathSet : IntMathSets) {
            if (intMathSet != null) {
                i++;
                System.out.println(i + ": " + intMathSet);
            }
        }
        i = 0;
        System.out.println("Double Sets");
        for (MathSet<Double> doubleMathSet : DoubleMathSets) {
            if (doubleMathSet != null) {
                i++;
                System.out.println(i + ": " + doubleMathSet);
            }
        }
    }

    private static void createSet() throws IOException {
        String str;
        System.out.println("Please select the type of set elements");
        do {
            System.out.println("1 Integer values ");
            System.out.println("2 Floating point");
            System.out.println("0 Back - \"0\"");
            str = reader.readLine();
            if (checkRegExp(str, "[0-2]")) {
                switch (str) {
                    case "1":
                        System.out.println("Please enter the elements of the set (enter \"q\" for stop):");
                        MathSet<Integer> mathSetI = new MathSet<>();
                        do {
                            str = reader.readLine();
                            if (checkRegExp(str, "^-?\\d+$")) {
                                mathSetI.add(Integer.parseInt(str));
                            } else if (!str.equals("q")) {
                                System.out.println("Wrong input number");
                                break;
                            }
                        } while (!str.equals("q"));
                        System.out.println("Your set: " + mathSetI);
                        addIntegerSet(mathSetI);
                        break;
                    case "2":
                        System.out.println("Please enter the elements of the set (enter \"q\" for stop):");
                        MathSet<Double> mathSetD = new MathSet<>();
                        do {
                            str = reader.readLine();
                            if (checkRegExp(str, "^-?\\d*\\.\\d+$") && str != "q") {
                                mathSetD.add(Double.parseDouble(str));
                            } else if (!str.equals("q")) {
                                System.out.println("Wrong input number");
                                break;
                            }
                        } while (!str.equals("q"));
                        System.out.println("Your set: " + mathSetD);
                        addDoubleSet(mathSetD);
                        break;
                }
            } else {
                System.out.println("Wrong input");
            }
        } while (!str.equals("0"));
    }

    private static void addToSet() throws IOException {
        String str;
        System.out.println("Please select the type of set to which you will add");
        do {
            System.out.println("1 Integer values ");
            System.out.println("2 Floating point");
            System.out.println("0 Back - \"0\"");
            str = reader.readLine();
            if (checkRegExp(str, "[0-2]")) {
                switch (str) {
                    case "1":
                        System.out.println("Integer Sets");
                        int k = 0;
                        for (MathSet<Integer> intMathSet : IntMathSets) {
                            if (intMathSet != null) {
                                k++;
                                System.out.println(k + ": " + intMathSet);
                            }
                        }
                        System.out.println("Enter the number of the set you want to add");
                        int num = 0;
                        str = reader.readLine();
                        if (checkRegExp(str, "^\\d+$")) {
                            if (Integer.parseInt(str) <= 0 || Integer.parseInt(str) > IntMathSets.length || IntMathSets[Integer.parseInt(str) - 1] == null) {
                                System.out.println(" there is no such element");
                                break;
                            } else {
                                num = Integer.parseInt(str);
                            }
                        } else {
                            System.out.println("Wrong input number");
                            break;
                        }
                        System.out.println("Please enter the elements to add (enter \"q\" for stop):");
                        do {
                            str = reader.readLine();
                            if (checkRegExp(str, "^-?\\d+$")) {
                                IntMathSets[num - 1].add(Integer.parseInt(str));
                            } else if (!str.equals("q")) {
                                System.out.println("Wrong input number");
                                break;
                            }
                        } while (!str.equals("q"));
                        System.out.println("Your set: " + IntMathSets[num - 1]);
                        break;
                    case "2":
                        System.out.println("Double Sets");
                        k = 0;
                        for (MathSet<Double> doubleMathSet : DoubleMathSets) {
                            if (doubleMathSet != null) {
                                k++;
                                System.out.println(k + ": " + doubleMathSet);
                            }
                        }
                        System.out.println("Enter the number of the set you want to add");
                        num = 0;
                        str = reader.readLine();
                        if (checkRegExp(str, "^\\d+$")) {
                            if (Integer.parseInt(str) <= 0 || Integer.parseInt(str) > DoubleMathSets.length || DoubleMathSets[Integer.parseInt(str) - 1] == null) {
                                System.out.println(" there is no such element");
                                break;
                            } else {
                                num = Integer.parseInt(str);
                            }
                        } else {
                            System.out.println("Wrong input number");
                            break;
                        }
                        System.out.println("Please enter the elements to add (enter \"q\" for stop):");
                        do {
                            str = reader.readLine();
                            if (checkRegExp(str, "^-?\\d*\\.\\d+$")) {
                                DoubleMathSets[num - 1].add(Double.parseDouble(str));
                            } else if (!str.equals("q")) {
                                System.out.println("Wrong input number");
                                break;
                            }
                        } while (!str.equals("q"));
                        System.out.println("Your set: " + DoubleMathSets[num - 1]);
                        break;
                }
            } else {
                System.out.println("Wrong input");
            }
        } while (!str.equals("0"));
    }

    private static void joinSets() throws IOException {
        String str;
        System.out.println("Please select the type of set to which you will add");
        do {
            System.out.println("1 Integer values ");
            System.out.println("2 Floating point");
            System.out.println("0 Back - \"0\"");
            str = reader.readLine();
            if (checkRegExp(str, "[0-2]")) {
                switch (str) {
                    case "1":
                        System.out.println("Integer Sets");
                        int k = 0;
                        for (MathSet<Integer> intMathSet : IntMathSets) {
                            if (intMathSet != null) {
                                k++;
                                System.out.println(k + ": " + intMathSet);
                            }
                        }
                        System.out.println("Enter the numbers of the sets you want to join");
                        System.out.println("enter the number of the first set");
                        int num1 = 0;
                        str = reader.readLine();
                        if (checkRegExp(str, "^\\d+$")) {
                            if (Integer.parseInt(str) <= 0 || Integer.parseInt(str) > IntMathSets.length || IntMathSets[Integer.parseInt(str) - 1] == null) {
                                System.out.println(" there is no such element");
                                break;
                            } else {
                                num1 = Integer.parseInt(str);
                            }
                        } else {
                            System.out.println("Wrong input number");
                            break;
                        }
                        System.out.println("enter the number of the second set");
                        int num2 = 0;
                        str = reader.readLine();
                        if (checkRegExp(str, "^\\d+$")) {
                            if (Integer.parseInt(str) <= 0 || Integer.parseInt(str) > IntMathSets.length || IntMathSets[Integer.parseInt(str) - 1] == null) {
                                System.out.println(" there is no such element");
                                break;
                            } else {
                                num2 = Integer.parseInt(str);
                            }
                        } else {
                            System.out.println("Wrong input number");
                            break;
                        }
                        IntMathSets[num1 - 1].join(IntMathSets[num2 - 1]);
                        System.out.println("Join set is: " + IntMathSets[num1 - 1]);
                        break;

                    case "2":
                        System.out.println("Double Sets");
                        k = 0;
                        for (MathSet<Double> doubleMathSet : DoubleMathSets) {
                            if (doubleMathSet != null) {
                                k++;
                                System.out.println(k + ": " + doubleMathSet);
                            }
                        }
                        System.out.println("Enter the number of the set you want to add");
                        System.out.println("enter the number of the first set");
                        num1 = 0;
                        str = reader.readLine();
                        if (checkRegExp(str, "^\\d+$")) {
                            if (Integer.parseInt(str) <= 0 || Integer.parseInt(str) > DoubleMathSets.length || DoubleMathSets[Integer.parseInt(str) - 1] == null) {
                                System.out.println(" there is no such element");
                                break;
                            } else {
                                num1 = Integer.parseInt(str);
                            }
                        } else {
                            System.out.println("Wrong input number");
                            break;
                        }
                        num2 = 0;
                        System.out.println("enter the number of the second set");
                        str = reader.readLine();
                        if (checkRegExp(str, "^\\d+$")) {
                            if (Integer.parseInt(str) <= 0 || Integer.parseInt(str) > DoubleMathSets.length || DoubleMathSets[Integer.parseInt(str) - 1] == null) {
                                System.out.println(" there is no such element");
                                break;
                            } else {
                                num2 = Integer.parseInt(str);
                            }
                        } else {
                            System.out.println("Wrong input number");
                            break;
                        }
                        DoubleMathSets[num1 - 1].join(DoubleMathSets[num2 - 1]);
                        System.out.println("Join set is: " + DoubleMathSets[num1 - 1]);
                }
            } else {
                System.out.println("Wrong input");
            }
        } while (!str.equals("0"));
    }

    private static void sortSet() throws IOException {
        System.out.println("Choose the set you want to sort");
        int k = 0;
        for (MathSet<Integer> intMathSet : IntMathSets) {
            if (intMathSet != null) {
                k++;
                System.out.println(k + ": " + intMathSet);
            }
        }
        int d = k;
        for (MathSet<Double> doubleMathSet : DoubleMathSets) {
            if (doubleMathSet != null) {
                d++;
                System.out.println(d + ": " + doubleMathSet);
            }
        }
        int num = 0;
        String str;
        str = reader.readLine();
        if (checkRegExp(str, "^\\d+$") && Integer.parseInt(str) > 0 && Integer.parseInt(str) <= d) {
            num = Integer.parseInt(str);
        } else {
            System.out.println("Wrong input number");
            return;
        }

        if (num <= k) {
            IntMathSets[num - 1].sortAsc();
            System.out.println(IntMathSets[num - 1]);
            IntMathSets[num - 1].sortDesc();
            System.out.println(IntMathSets[num - 1]);
        } else {
            num = num - k;
            DoubleMathSets[num - 1].sortAsc();
            System.out.println(DoubleMathSets[num - 1]);
            DoubleMathSets[num - 1].sortDesc();
            System.out.println(DoubleMathSets[num - 1]);
        }
    }

    private static void getFromSet() throws IOException {
        System.out.println("Choose the set from which you want to get the MINIMUM, MAXIMUM, AVERAGE and MEDIAN");
        int k = 0;
        for (MathSet<Integer> intMathSet : IntMathSets) {
            if (intMathSet != null) {
                k++;
                System.out.println(k + ": " + intMathSet);
            }
        }
        int d = k;
        for (MathSet<Double> doubleMathSet : DoubleMathSets) {
            if (doubleMathSet != null) {
                d++;
                System.out.println(d + ": " + doubleMathSet);
            }
        }
        int num = 0;
        String str;
        str = reader.readLine();
        if (checkRegExp(str, "^\\d+$") && Integer.parseInt(str) > 0 && Integer.parseInt(str) <= d) {
            num = Integer.parseInt(str);
        } else {
            System.out.println("Wrong input number");
            return;
        }

        if (num <= k) {
            System.out.println(IntMathSets[num - 1]);
            System.out.println("Max = " + IntMathSets[num - 1].getMax());
            System.out.println("Min = " + IntMathSets[num - 1].getMin());
            System.out.println("Average = " + IntMathSets[num - 1].getAverage());
            System.out.println("Median = " + IntMathSets[num - 1].getMedian());
        } else {
            num = num - k;
            System.out.println(DoubleMathSets[num - 1]);
            System.out.println("Max = " + DoubleMathSets[num - 1].getMax());
            System.out.println("Min = " + DoubleMathSets[num - 1].getMin());
            System.out.println("Average = " + DoubleMathSets[num - 1].getAverage());
            System.out.println("Median = " + DoubleMathSets[num - 1].getMedian());
        }
    }

    private static void clearSet() throws IOException {
        System.out.println("Choose the set you want to clear");
        int k = 0;
        for (MathSet<Integer> intMathSet : IntMathSets) {
            if (intMathSet != null) {
                k++;
                System.out.println(k + ": " + intMathSet);
            }
        }
        int d = k;
        for (MathSet<Double> doubleMathSet : DoubleMathSets) {
            if (doubleMathSet != null) {
                d++;
                System.out.println(d + ": " + doubleMathSet);
            }
        }
        int num = 0;
        String str;
        str = reader.readLine();
        if (checkRegExp(str, "^\\d+$") && Integer.parseInt(str) > 0 && Integer.parseInt(str) <= d) {
            num = Integer.parseInt(str);
        } else {
            System.out.println("Wrong input number");
            return;
        }

        if (num <= k) {
            System.out.println(IntMathSets[num - 1]);
            IntMathSets[num - 1].clear();
            System.out.println(IntMathSets[num - 1]);
            System.out.println();
            viewSets();
        } else {
            num = num - k;
            System.out.println(DoubleMathSets[num - 1]);
            DoubleMathSets[num - 1].clear();
            System.out.println(DoubleMathSets[num - 1]);
            System.out.println();
            viewSets();
        }
    }

    private static boolean checkRegExp(String str, String reg) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    private static void addIntegerSet(MathSet<Integer> mathSet) {
        for (int i = 0; i < IntMathSets.length; i++) {
            if (IntMathSets[i] == null) {
                IntMathSets[i] = mathSet;
                return;
            }
        }
    }

    private static void addDoubleSet(MathSet<Double> mathSet) {
        for (int i = 0; i < DoubleMathSets.length; i++) {
            if (DoubleMathSets[i] == null) {
                DoubleMathSets[i] = mathSet;
                return;
            }
        }
    }
}
