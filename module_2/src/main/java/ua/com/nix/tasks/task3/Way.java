package ua.com.nix.tasks.task3;

import java.io.*;
import java.util.*;

public class Way {
    public void runSearchProfitableWay() {
        File inputFile = new File("module_2/src/main/resources/input.txt");
        File outputFile = new File("module_2/src/main/resources/output.txt");
        HashMap<Integer, String> cities = new HashMap<>();
        StringBuilder graphs = new StringBuilder();
        int index = 0;
        int number = 0;
        try (FileReader fileReader = new FileReader(inputFile); FileWriter fileWriter = new FileWriter(outputFile); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String readLine = bufferedReader.readLine();
            graphs.append(readLine).append("\n");
            int start = 0;
            int finish = 0;
            while (readLine != null) {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (finishOfFile(readLine)) {
                    String[] path = readLine.split(" ");
                    for (Map.Entry<Integer, String> entry : cities.entrySet()) {
                        if (entry.getValue().equals(path[0])) {
                            start = entry.getKey();
                        }
                        if (entry.getValue().equals(path[1])) {
                            finish = entry.getKey();
                            if (number == 0) {
                                graphs = new StringBuilder(graphs.substring(0, graphs.length() - 3));
                                number++;
                            }

                            int[][] matrix = parseGraphs(graphs.toString());
                            Vector<Integer> pars = new Vector<>();
                            int[] ds = searchValue(matrix, start, pars);
                            String cost = "" + ds[finish] + "\n";
                            fileWriter.write(cost);
                        }
                    }
                    continue;
                }
                try {
                    if (readLine.split(" ").length == 1) { Integer.parseInt(readLine); }
                    if (readLine.length() > 2) { graphs.append(index - 1).append(" ").append(decisionString(readLine)).append(" \n "); }
                } catch (NumberFormatException ex) {
                    cities.put(index, readLine);
                    index++;
                }
            }
        } catch (IOException e) { System.out.println("Input Error!"); }
    }

    public static int[] searchValue(int[][] matrix, int start, Vector<Integer> parse) {
        int[] step = new int[matrix.length];
        Arrays.fill(step, 1000);
        boolean[] visit = new boolean[matrix.length];
        parse.setSize(matrix.length);
        step[start] = 0;
        int select;
        for (int[] ints : matrix) {
            select = -1;
            for (int j = 0; j < ints.length; ++j) {
                if (!visit[j] && (select == -1 || step[j] < step[select]))
                    select = j;
            }
            if (step[select] == 1000)
                break;
            visit[select] = true;
            for (int j = 0; j < matrix[select].length; ++j) {
                if (matrix[select][j] == 1000)
                    continue;
                if ((step[select] + matrix[select][j]) < step[j]) {
                    step[j] = step[select] + matrix[select][j];
                    parse.set(j, select);
                }
            }
        }
        return step;
    }

    private int[][] parseGraphs(String allGraph) {
        Scanner scanner = new Scanner(allGraph);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int[] ints : matrix) {
            Arrays.fill(ints, 1000);
        }
        int i, j, cost;
        while(scanner.hasNextInt()){
            i = scanner.nextInt();
            j = scanner.nextInt();
            cost = scanner.nextInt();
            matrix[i][j] = matrix[j][i] = cost;
        }
        return matrix;
    }


    private static String decisionString(String readLine) {
        String[] decLine = readLine.split(" ");
        return (Integer.parseInt(decLine[0]) - 1) + " " + decLine[1];
    }

    private static boolean finishOfFile(String line) {
        String[] array = line.split(" ");
        try {
            if (array.length == 1) { return false; }
            Integer.parseInt(array[0]);
            Integer.parseInt(array[1]);
        } catch (NumberFormatException exception) { return true; }
        return false;
    }
}
