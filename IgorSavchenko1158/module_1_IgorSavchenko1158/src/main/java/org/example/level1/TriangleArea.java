package org.example.level1;

public class TriangleArea {
    private TriangleArea() {
    }

    public static double calculate(int[] A, int[] B, int[] C) {
        return 0.5 * Math.abs(
                (B[0] - A[0]) * (C[1] - A[1]) - (C[0] - A[0]) * (B[1] - A[1])
        );
    }
}
