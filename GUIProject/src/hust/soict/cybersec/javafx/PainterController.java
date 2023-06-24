package hust.soict.cybersec.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.awt.event.MouseEvent;

public class PainterController {

    private Boolean isPenEnabled = true;
    @FXML
    private RadioButton penRadioButton, eraserRadioButton;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void drawingAreaMouseDragged(javafx.scene.input.MouseEvent event) {
        if (isPenEnabled){
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        } else {
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void onPenClicked(ActionEvent event) {
        isPenEnabled = true;
        eraserRadioButton.setSelected(false);
    }

    @FXML
    void onEraserClicked(ActionEvent event) {
        isPenEnabled = false;
        penRadioButton.setSelected(false);
    }
}

