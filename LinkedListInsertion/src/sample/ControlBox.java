package sample;

import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.ValueAxis;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.swing.*;

public class ControlBox {
    private StackPane container;
    private Button nextButton;
    private Button prevButton;

    public ControlBox(){
        container = new StackPane();
        container.setBackground(new Background(
                new BackgroundFill(javafx.scene.paint.Color.rgb(255, 255, 255, 1),
                        CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
        container.setPrefWidth(300);
        container.setPrefHeight(100);
        container.setMaxHeight(100);
        container.setMaxWidth(300);
        container.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2), javafx.geometry.Insets.EMPTY)));

        prevButton = new javafx.scene.control.Button();
        prevButton.setText("Previous step!");
        prevButton.setFont(new javafx.scene.text.Font(16));
        prevButton.setPrefWidth(130);
        prevButton.setPrefHeight(50);
        container.setAlignment(prevButton, Pos.BOTTOM_LEFT);
        container.getChildren().add(prevButton);
        container.setMargin(prevButton, new javafx.geometry.Insets(10));

        nextButton = new javafx.scene.control.Button();
        nextButton.setText("Next step!");
        nextButton.setFont(new javafx.scene.text.Font(16));
        nextButton.setPrefWidth(130);
        nextButton.setPrefHeight(50);
        container.setAlignment(nextButton, Pos.BOTTOM_RIGHT);
        container.getChildren().add(nextButton);
        container.setMargin(nextButton, new Insets(10));

        Text text = new Text();
        text.setText("Controls");
        text.setFont(new Font(20));
        container.setAlignment(text, Pos.TOP_CENTER);
        container.getChildren().add(text);
    }

    public Node getNode(){
        return container;
    }

    public void setOnNextAction(EventHandler<ActionEvent> value){
        nextButton.setOnAction(value);
    }

    public void setOnPreviousAction(EventHandler<ActionEvent> value){
        prevButton.setOnAction(value);
    }

    public void setNextButtonEnabled(boolean value){
        nextButton.setDisable(!value);
    }

    public void setPreviousButtonEnabled(boolean value){
        prevButton.setDisable(!value);
    }
}
