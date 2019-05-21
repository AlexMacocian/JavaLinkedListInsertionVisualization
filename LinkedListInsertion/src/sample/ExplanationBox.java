package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Stack;

public class ExplanationBox {
    private StackPane container;
    private Text titleBox, detailsBox;


    public ExplanationBox(){
        container = new StackPane();
        container.setBackground(new Background(new BackgroundFill(Color.rgb(255,255,255), CornerRadii.EMPTY, Insets.EMPTY)));
        titleBox = new Text();
        titleBox.setFont(new Font(18));
        titleBox.setText("Title");
        container.getChildren().add(titleBox);
        container.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2), Insets.EMPTY)));
        container.setAlignment(titleBox, Pos.TOP_CENTER);
        detailsBox = new Text();
        detailsBox.setFont(new Font(14));
        detailsBox.setText("Explanation for the current step");
        detailsBox.setWrappingWidth(300);
        container.getChildren().add(detailsBox);
        container.setMaxWidth(300);
        container.setAlignment(detailsBox, Pos.TOP_CENTER);
        container.setMargin(detailsBox, new Insets(20, 0, 0, 0));
    }

    public Node getNode(){
        return container;
    }

    public void setTitle(String title){
        titleBox.setText(title);
    }

    public void setDetails(String details){
        detailsBox.setText(details);
    }
}
