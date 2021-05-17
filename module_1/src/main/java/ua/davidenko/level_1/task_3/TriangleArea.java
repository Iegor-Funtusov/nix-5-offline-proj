package ua.davidenko.level_1.task_3;

public class TriangleArea {
    public static double calculeteArea(int coordAx, int coordAy, int coordBx, int coordBy, int coordCx, int coordCy) {

        double sideAB = Math.sqrt(Math.pow(coordBx - coordAx, 2) + Math.pow(coordBy - coordAy, 2));
        double sideAC = Math.sqrt(Math.pow(coordCx - coordAx, 2) + Math.pow(coordCy - coordAy, 2));
        double sideBC = Math.sqrt(Math.pow(coordCx - coordBx, 2) + Math.pow(coordCy - coordBy, 2));
        double per = (sideAB + sideAC + sideBC) / 2;
        double area = Math.sqrt(per * (per - sideAB) * (per - sideAC) * (per - sideBC));
        return area;
    }
}
