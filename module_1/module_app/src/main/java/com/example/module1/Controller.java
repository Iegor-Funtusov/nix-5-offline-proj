package com.example.module1;

import com.example.areas.AreaController;
import com.example.knight_move.ChessController;
import com.example.unique_numbers.UniqueNumbersController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public void exec(){
        try{
            System.out.println("Select the level that you want to check: " + "\n 1 - Level 1"
                    + "\n 2 - Level 2" + "\n 3 - Level 3" +"\n 0 - exit");
            chooseLevel(reader.readLine());
        } catch (IOException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    private void chooseLevel(String read) throws IOException{
        switch (read){
            case "1":{
                selectTaskLevel1();
                break;
            }
            case "2":{
                break;
            }
            case "3":{
                break;
            }
            case "0":{
                System.exit(0);
                break;
            }
            default:{
                exec();
            }
        }
    }

    private void selectTaskLevel1() throws IOException{
        System.out.println("Select Task to check: " + "\n 1 - Unique Numbers"
                + "\n 2 - Move of knight" + "\n 3 - Area of Triangle"
                + "\n 4 - Back to level selection " +"\n 0 - exit");
        switch (reader.readLine()){
            case "1":{
                uniqueNumbersTask();
                selectTaskLevel1();
                break;
            }
            case "2":{
                chessTask();
                selectTaskLevel1();
                break;
            }
            case "3":{
                areaTask();
                selectTaskLevel1();
                break;
            }
            case "4":{
                exec();
                break;
            }
            case "0":{
                System.exit(0);
                break;
            }

        }
    }

    private void uniqueNumbersTask() throws IOException {
        UniqueNumbersController uniqueNumbersController = new UniqueNumbersController(reader);
        uniqueNumbersController.checkUniqueNumbers();
    }

    private void chessTask(){
        ChessController chess = new ChessController(reader);
        chess.exec();
    }

    private void areaTask() throws IOException {
        AreaController areaController = new AreaController(reader);
        areaController.calculateAreaOfTriangle();
    }

}
