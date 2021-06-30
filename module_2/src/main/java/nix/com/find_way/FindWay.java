package nix.com.find_way;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class FindWay {

    public FindWay() {

        File file = new File("input.txt");

        HashMap<Integer, String> nameCities = new HashMap<>();
        StringBuilder allGraph = new StringBuilder("");
        int index = 0;
        int countCities;

        try (FileReader fr = new FileReader(file);
             BufferedReader reader = new BufferedReader(fr)) {
            String line = reader.readLine();
            countCities = Integer.parseInt(line);
            allGraph.append(line).append(" \n ");
            while (line != null) {
                line = reader.readLine();
                if (checkEndOfFile(line)) {
                    break;
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

        allGraph = new StringBuilder(allGraph.substring(0, allGraph.length() - 3));

        int[][] matrix = parse(allGraph.toString());

        Vector<Integer> pars = new Vector<>();
        int[] ds = find(matrix, 0, pars);
        System.out.println("cost: " +  ds[3]);
    }

    public static void show_path(int start, int end, Vector<Integer> pars, int[] ds) {
        if(end >= ds.length || ds[end] == 1000)
            return;
        System.out.println("стоймость пути: " + ds[end]);
        System.out.println("путь: ");

        Vector<Integer> ps = new Vector<>();
        for(int i = end; i != start; i = pars.get(i)) // выделяем путь
            ps.add(i);
        ps.add(start);

        for(int i = ps.size() - 1; i >= 0; --i)
            System.out.println(ps.get(i) + "  ");
        System.out.println();
        ps.clear();
    }

    public static int[] find(int[][] m, int start, Vector<Integer> pars) {
        int[] ds = new int[m.length];
        Arrays.fill(ds, 1000);

        boolean[] visit = new boolean[m.length];
        pars.setSize(m.length);

        ds[start] = 0;
        int sel;
        for (int[] ints : m) {
            sel = -1;
            for (int j = 0; j < ints.length; ++j) {
                if (!visit[j] && (sel == -1 || ds[j] < ds[sel]))
                    sel = j;
            }

            if (ds[sel] == 1000)
                break;
            visit[sel] = true;

            for (int j = 0; j < m[sel].length; ++j) {
                if (m[sel][j] == 1000)
                    continue;
                if ((ds[sel] + m[sel][j]) < ds[j]) {
                    ds[j] = ds[sel] + m[sel][j];
                    pars.set(j, sel);
                }
            }
        }
        return ds;
    }

    private int[][] parse(String allGraph) {
        Scanner sc = new Scanner(allGraph);
        int n = sc.nextInt();
        int[][] m = new int[n][n];
        for (int[] ints : m) {
            Arrays.fill(ints, 1000);
        }

        int i, j, v;
        while(sc.hasNextInt()){
            i = sc.nextInt();
            j = sc.nextInt();
            v = sc.nextInt();
            m[i][j] = m[j][i] = v;
        }
        return m;
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
