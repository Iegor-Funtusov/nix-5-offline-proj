import java.io.IOException;

public class ModuleMain {
    public static void main(String[] args) {
        /*try {
            WorkWithDates.dateMain();
            UniqueName.mainUniqueName();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        int[][] matrix = {
                {0, 1, 3, 300000},
                {1, 0, 1, 4},
                {3, 1, 0, 1},
                {300000, 4, 1, 0}
        };
        TransportationTheory tt = new TransportationTheory(4,matrix );
        System.out.println(tt.dijkstra(0,3));
    }
}
