package com.example.slagalica;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SlagalicaController {
    static int missesCount = 0;
    static int movesCount = 0;
    @FXML
    private TextArea moves;
    @FXML
    private TextArea misses;
    @FXML
    private Button bt0;
    @FXML
    private Button bt1;
    @FXML
    private Button bt2;
    @FXML
    private Button bt3;
    @FXML
    private Button bt4;
    @FXML
    private Button bt5;
    @FXML
    private Button bt6;
    @FXML
    private Button bt7;
    @FXML
    private Button bt8;
    @FXML
    private Button bt9;
    @FXML
    private Button bt10;
    @FXML
    private Button bt11;
    @FXML
    private Button bt12;
    @FXML
    private Button bt13;
    @FXML
    private Button bt14;
    @FXML
    private Button bt15;
    Button[] buttons1 = new Button[16];
    List<Button> buttons;

    @FXML
    public void initialize(){
        buttons1 = new Button[] {bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bt11, bt12, bt13, bt14, bt15};
        buttons = Arrays.asList(buttons1);
    }

    @FXML
    private void restartButton(ActionEvent e){
        Collections.shuffle(buttons);
        for (int i = 0; i < 16; i++) {
            Button gumb = buttons.get(i);
            if (i==0){
                gumb.setText("");
                continue;
            }
            gumb.setText(String.valueOf(i));
        }
        missesCount=0;
        movesCount=0;
        moves.setText("0");
        misses.setText("0");
    }

    private int findPosition(Button gumb) {
        String id = gumb.getId();
        String position = id.replace("bt", "");
        return Integer.parseInt(position);
    }

    @FXML
    private void numButton(ActionEvent e){
        Button clickedButton = (Button) e.getSource();
        int idClicked = findPosition(clickedButton);
        Button emptyButton = null;
        for (Button b : buttons) {
            if (b.getText().isEmpty()) {
                emptyButton = b;
                break;
            }
        }
        int idEmpty = findPosition(emptyButton);
        //pozicije su poznate, trazimo retkove i stupce za rijesenje problema
        int rowClicked = idClicked / 4;
        int rowEmpty = idEmpty / 4;
        int columnClicked = idClicked % 4;
        int columnEmpty = idEmpty % 4;

        if (((idClicked + 1) == idEmpty && rowClicked == rowEmpty) ||
                ((idClicked - 1) == idEmpty && rowClicked == rowEmpty) ||
                ((idClicked + 4) == idEmpty && columnClicked == columnEmpty) ||
                ((idClicked - 4) == idEmpty && columnClicked == columnEmpty))
        {
            emptyButton.setText(clickedButton.getText());
            clickedButton.setText("");
        }
        else{
            missesCount++;
        }
        movesCount++;
        moves.setText(String.valueOf(movesCount));
        misses.setText(String.valueOf(missesCount));
    }
}