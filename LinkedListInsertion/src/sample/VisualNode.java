package sample;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class VisualNode {
    private StackPane container;
    private Text text;
    private double size;

    public VisualNode(double size){
        this.size = size;
        container = new StackPane();
        container.setMaxWidth(size);
        container.setMaxHeight(size / 2);
        container.setBackground(new Background(new BackgroundFill(Color.rgb(100, 100, 100), CornerRadii.EMPTY, Insets.EMPTY)));
        text = new Text();
        text.setText("Node");
        text.setFont(new Font(14));
        container.getChildren().add(text);
    }

    public void setText(String text){
        this.text.setText(text);
    }

    public Node getNode(){
        return container;
    }

    public void setHighlighted(boolean value){
        if(value){
            container.setBackground(new Background(new BackgroundFill(Color.rgb(100, 220, 100), CornerRadii.EMPTY, Insets.EMPTY)));
        }
        else {
            container.setBackground(new Background(new BackgroundFill(Color.rgb(100, 100, 100), CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

    public void setTranslateX(double value){
        container.setTranslateX(value);
    }

    public void setTranslateY(double value){
        container.setTranslateY(value);
    }

    public double getSize(){
        return size;
    }

    public double getWidth(){
        return size;
    }

    public double getHeight(){
        return size / 2;
    }

    public void setVisible(boolean value){
        container.setVisible(value);
    }
}
