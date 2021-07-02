package nix.com.find_way;

import java.io.*;
import java.util.*;

public class FindWay {

    public FindWay() {

        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");
        try {
            outputFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap<Integer, String> nameCities = new HashMap<>();
        StringBuilder allGraph = new StringBuilder();
        int index = 0;
        int start = 0;
        int end;
        int count = 0;

        try (FileReader fr = new FileReader(inputFile);
             FileWriter fw = new FileWriter(outputFile);
             BufferedReader reader = new BufferedReader(fr)) {
            String line = reader.readLine();
            allGraph.append(line).append(" \n ");
            while (line != null) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                if (checkEndOfFile(line)) {
                    String[] path = line.split(" ");
                    for (Map.Entry<Integer, String> entry : nameCities.entrySet()) {
                        if (entry.getValue().equals(path[0])) {
                            start = entry.getKey();
                        }
                        if (entry.getValue().equals(path[1])) {
                            end = entry.getKey();

                            if (count == 0) {
                                allGraph = new StringBuilder(allGraph.substring(0, allGraph.length() - 3));
                                count++;
                            }

                            int[][] matrix = parseGraphToMatrix(allGraph.toString());
                            Vector<Integer> pars = new Vector<>();
                            int[] ds = findCost(matrix, start, pars);
                            String cost = "" + ds[end] + "\n";
                            fw.write(cost);
                        }
                    }
                    continue;
                }
                try {
                    if (line.split(" ").length == 1) {
                        Integer.parseInt(line);
                    }

                    if (line.length() > 2) {
                        allGraph.append(index - 1).append(" ").append(decString(line)).append(" \n ");
                    }

                } catch (NumberFormatException ex) {
                    nameCities.put(index, line);
                    index++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Wrong input");
        }
    }

    public static int[] findCost(int[][] matrix, int start, Vector<Integer> pars) {
        int[] ds = new int[matrix.length];
        Arrays.fill(ds, 1000);

        boolean[] visit = new boolean[matrix.length];
        pars.setSize(matrix.length);

        ds[start] = 0;
        int sel;
        for (int[] ints : matrix) {
            sel = -1;
            for (int j = 0; j < ints.length; ++j) {
                if (!visit[j] && (sel == -1 || ds[j] < ds[sel]))
                    sel = j;
            }

            if (ds[sel] == 1000)
                break;
            visit[sel] = true;

            for (int j = 0; j < matrix[sel].length; ++j) {
                if (matrix[sel][j] == 1000)
                    continue;
                if ((ds[sel] + matrix[sel][j]) < ds[j]) {
                    ds[j] = ds[sel] + matrix[sel][j];
                    pars.set(j, sel);
                }
            }
        }
        return ds;
    }

    private int[][] parseGraphToMatrix(String allGraph) {
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


    private static String decString(String line) {

        String[] decLine = line.split(" ");

        return (Integer.parseInt(decLine[0]) - 1) + " " + decLine[1];
    }

    private static boolean checkEndOfFile(String line) {
        String[] arrLine = line.split(" ");

        try {
            if (arrLine.length == 1) {
                return false;
            }
            Integer.parseInt(arrLine[0]);
            Integer.parseInt(arrLine[1]);
        } catch (NumberFormatException ex) {
            return true;
        }
        return false;
    }
}
