package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.ArrayList;

public class Main extends Application {
    private Stage primaryStage;
    private StackPane root;
    private ArrayList<Pair<VisualNode, Arrow>> Nodes;
    private Pair<VisualNode, Arrow> additionalPair;
    private ControlBox controlBox;
    private ExplanationBox explanationBox;
    private int currentStep = 0;
    private int maxSteps = 8;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Nodes = new ArrayList<>();
        this.primaryStage = primaryStage;
        root = new StackPane();
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.setHeight(primaryStage.getMaxHeight());
        primaryStage.setWidth(primaryStage.getMaxWidth());
        primaryStage.setMaximized(true);
        initializeContent();
        primaryStage.show();
        controlBox.setOnNextAction(event -> {
            handleNextStep();
        });
        controlBox.setOnPreviousAction(event -> {
            handlePreviousStep();
        });
        controlBox.setPreviousButtonEnabled(false);
        setUpStep0();
    }

    private void initializeContent(){
        explanationBox = new ExplanationBox();
        ((StackPane)explanationBox.getNode()).setMaxWidth(300);
        root.getChildren().add(explanationBox.getNode());
        root.setAlignment(explanationBox.getNode(), Pos.CENTER_RIGHT);

        controlBox = new ControlBox();
        ((StackPane)controlBox.getNode()).setMaxWidth(300);
        root.getChildren().add(controlBox.getNode());
        root.setAlignment(controlBox.getNode(), Pos.BOTTOM_RIGHT);

        VisualNode additionalNode = new VisualNode(100);
        Arrow additionalArrow = new Arrow();
        additionalArrow.setVisible(false);
        additionalNode.setVisible(false);
        root.getChildren().add(additionalArrow);
        root.getChildren().add(additionalNode.getNode());
        root.setAlignment(additionalArrow, Pos.TOP_LEFT);
        root.setAlignment(additionalNode.getNode(), Pos.TOP_LEFT);
        additionalPair = new Pair<>(additionalNode, additionalArrow);

        for(int i = 0; i < 5; i++){
            VisualNode node = new VisualNode(100);
            root.setAlignment(node.getNode(), Pos.TOP_LEFT);
            node.setTranslateX(i * 120 + 20);
            node.setTranslateY(100);
            root.getChildren().add(node.getNode());
            if(i < 4) {
                Arrow arrow = new Arrow();
                root.setAlignment(arrow, Pos.TOP_LEFT);
                root.getChildren().add(arrow);
                arrow.setStartX(0);
                arrow.setEndX(20);
                arrow.setArrowWidth(2);
                arrow.setArrowLength(3);
                arrow.setTranslateX((i + 1) * 120);
                arrow.setTranslateY(100 + node.getHeight() / 2);
                Nodes.add(new Pair<>(node, arrow));
            }
            else{
                Nodes.add(new Pair<>(node, null));
            }
        }
    }

    private void handleNextStep(){
        currentStep++;
        if(currentStep == 0){
            controlBox.setPreviousButtonEnabled(false);
        }
        else{
            controlBox.setPreviousButtonEnabled(true);
        }
        if(currentStep == maxSteps){
            controlBox.setNextButtonEnabled(false);
        }
        else {
            controlBox.setNextButtonEnabled(true);
        }

        if(currentStep > maxSteps){
            currentStep = maxSteps;
        }
        else if(currentStep < 0){
            currentStep = 0;
        }
        switchStep(currentStep);
    }

    private void handlePreviousStep(){
        currentStep--;
        if(currentStep == 0){
            controlBox.setPreviousButtonEnabled(false);
        }
        else{
            controlBox.setPreviousButtonEnabled(true);
        }
        if(currentStep == maxSteps){
            controlBox.setNextButtonEnabled(false);
        }
        else {
            controlBox.setNextButtonEnabled(true);
        }

        if(currentStep > maxSteps){
            currentStep = maxSteps;
        }
        else if(currentStep < 0){
            currentStep = 0;
        }
        switchStep(currentStep);
    }

    private void switchStep(int step){
        switch (step){
            case 0:
                setUpStep0();
                break;
            case 1:
                setUpStep1();
                break;
            case 2:
                setUpStep2();
                break;
            case 3:
                setUpStep3();
                break;
            case 4:
                setUpStep4();
                break;
            case 5:
                setUpStep5();
                break;
            case 6:
                setUpStep6();
                break;
            case 7:
                setUpStep7();
                break;
            case 8:
                setUpStep8();
                break;
        }
    }

    private void setUpStep0(){
        for(int i = 0; i < Nodes.size(); i++){
            Pair pair = Nodes.get(i);
            VisualNode node = (VisualNode)pair.getKey();
            node.setTranslateY(100);
            node.setTranslateX(i * 120 + 20);
            node.setHighlighted(false);
            node.setVisible(true);
            if(pair.getValue() != null){
                Arrow arrow = (Arrow)pair.getValue();
                arrow.setTranslateY(100 + node.getHeight() / 2);
                arrow.setTranslateX((i + 1) * 120);
                arrow.setEndY(0);
                arrow.setEndX(20);
            }
        }
        additionalPair.getKey().setVisible(false);
        additionalPair.getValue().setVisible(false);
        explanationBox.setTitle("Initial step");
        explanationBox.setDetails("We start with an existing linked list.");
    }

    private void setUpStep1(){
        for(int i = 0; i < Nodes.size(); i++){
            Pair pair = Nodes.get(i);
            VisualNode node = (VisualNode)pair.getKey();
            node.setTranslateY(100);
            node.setTranslateX(i * 120 + 20);
            node.setHighlighted(false);
            node.setVisible(true);
            if(pair.getValue() != null){
                Arrow arrow = (Arrow)pair.getValue();
                arrow.setTranslateY(100 + node.getHeight() / 2);
                arrow.setTranslateX((i + 1) * 120);
                arrow.setEndY(0);
                arrow.setEndX(20);
            }
        }
        ((VisualNode)Nodes.get(2).getKey()).setHighlighted(true);
        for(Pair<VisualNode, Arrow> pair : Nodes){
            pair.getKey().setVisible(true);
        }
        additionalPair.getKey().setVisible(false);
        additionalPair.getValue().setVisible(false);
        explanationBox.setTitle("Choosing the node");
        explanationBox.setDetails("We will perform the insertion after the highlighted node. Provided index value is 2.");
    }

    private void setUpStep2(){
        for(int i = 0; i < Nodes.size(); i++){
            Pair pair = Nodes.get(i);
            VisualNode node = (VisualNode)pair.getKey();
            node.setTranslateY(100);
            node.setTranslateX(i * 120 + 20);
            node.setHighlighted(false);
            node.setVisible(true);
            if(pair.getValue() != null){
                Arrow arrow = (Arrow)pair.getValue();
                arrow.setTranslateY(100 + node.getHeight() / 2);
                arrow.setTranslateX((i + 1) * 120);
                arrow.setEndY(0);
                arrow.setEndX(20);
            }
        }
        additionalPair.getValue().setVisible(false);
        additionalPair.getKey().setVisible(true);
        additionalPair.getKey().setHighlighted(true);
        additionalPair.getKey().setTranslateX(0 * 120 + 20);
        additionalPair.getKey().setTranslateY(250);
        explanationBox.setTitle("Choosing the location");
        explanationBox.setDetails("We traverse the list to reach the location we want to insert our node.");

    }

    private void setUpStep3(){
        for(int i = 0; i < Nodes.size(); i++){
            Pair pair = Nodes.get(i);
            VisualNode node = (VisualNode)pair.getKey();
            node.setTranslateY(100);
            node.setTranslateX(i * 120 + 20);
            node.setHighlighted(false);
            node.setVisible(true);
            if(pair.getValue() != null){
                Arrow arrow = (Arrow)pair.getValue();
                arrow.setTranslateY(100 + node.getHeight() / 2);
                arrow.setTranslateX((i + 1) * 120);
                arrow.setEndY(0);
                arrow.setEndX(20);
            }
        }
        additionalPair.getValue().setVisible(false);
        additionalPair.getKey().setVisible(true);
        additionalPair.getKey().setHighlighted(true);
        additionalPair.getKey().setTranslateX(1 * 120 + 20);
        additionalPair.getKey().setTranslateY(250);
        explanationBox.setTitle("Choosing the location");
        explanationBox.setDetails("We traverse the list to reach the location we want to insert our node.");
    }

    private void setUpStep4(){
        for(int i = 0; i < Nodes.size(); i++){
            Pair pair = Nodes.get(i);
            VisualNode node = (VisualNode)pair.getKey();
            node.setTranslateY(100);
            node.setTranslateX(i * 120 + 20);
            node.setHighlighted(false);
            node.setVisible(true);
            if(pair.getValue() != null){
                Arrow arrow = (Arrow)pair.getValue();
                arrow.setTranslateY(100 + node.getHeight() / 2);
                arrow.setTranslateX((i + 1) * 120);
                arrow.setEndY(0);
                arrow.setEndX(20);
            }
        }
        additionalPair.getValue().setVisible(false);
        additionalPair.getKey().setVisible(true);
        additionalPair.getKey().setHighlighted(true);
        additionalPair.getKey().setTranslateX(2 * 120 + 20);
        additionalPair.getKey().setTranslateY(250);
        explanationBox.setTitle("Choosing the location");
        explanationBox.setDetails("We traverse the list to reach the location we want to insert our node.");
    }

    private void setUpStep5(){
        for(int i = 0; i < Nodes.size(); i++){
            Pair pair = Nodes.get(i);
            VisualNode node = (VisualNode)pair.getKey();
            node.setTranslateY(100);
            node.setTranslateX(i * 120 + 20);
            node.setHighlighted(false);
            node.setVisible(true);
            if(pair.getValue() != null){
                Arrow arrow = (Arrow)pair.getValue();
                arrow.setTranslateY(100 + node.getHeight() / 2);
                arrow.setTranslateX((i + 1) * 120);
                arrow.setEndY(0);
                arrow.setEndX(20);
            }
        }
        additionalPair.getValue().setVisible(false);
        additionalPair.getKey().setVisible(true);
        additionalPair.getKey().setHighlighted(true);
        additionalPair.getKey().setTranslateX(3 * 120 + 20);
        additionalPair.getKey().setTranslateY(250);
        explanationBox.setTitle("Choosing the location");
        explanationBox.setDetails("We reached the location we want to insert our node.");
    }

    private void setUpStep6(){
        for(int i = 0; i < Nodes.size(); i++){
            if(i <= 2) {
                Pair pair = Nodes.get(i);
                VisualNode node = (VisualNode) pair.getKey();
                node.setTranslateY(100);
                node.setTranslateX(i * 120 + 20);
                node.setHighlighted(false);
                node.setVisible(true);
                if (pair.getValue() != null) {
                    Arrow arrow = (Arrow) pair.getValue();
                    arrow.setTranslateY(100 + node.getHeight() / 2);
                    arrow.setTranslateX((i + 1) * 120);
                    arrow.setEndY(0);
                    arrow.setEndX(20);
                }
            }
            else{
                Pair pair = Nodes.get(i);
                VisualNode node = (VisualNode) pair.getKey();
                node.setTranslateY(100);
                node.setTranslateX((i + 1) * 120 + 20);
                node.setHighlighted(false);
                node.setVisible(true);
                if (pair.getValue() != null) {
                    Arrow arrow = (Arrow) pair.getValue();
                    arrow.setTranslateY(100 + node.getHeight() / 2);
                    arrow.setTranslateX((i + 2) * 120);
                    arrow.setEndY(0);
                    arrow.setEndX(20);
                }
            }
        }
        Nodes.get(2).getValue().setEndX(140);
        additionalPair.getValue().setVisible(true);
        additionalPair.getValue().setStartY(150);
        additionalPair.getValue().setEndX(20);
        additionalPair.getValue().setTranslateX(4 * 120);
        additionalPair.getValue().setTranslateY(100 + additionalPair.getKey().getHeight() / 2);
        additionalPair.getKey().setVisible(true);
        additionalPair.getKey().setTranslateY(250);
        additionalPair.getKey().setHighlighted(true);
        explanationBox.setTitle("Performing the insertion");
        explanationBox.setDetails("We set the pointer of the new node to the node that is next to the current node in the list.");
    }

    private void setUpStep7(){
        for(int i = 0; i < Nodes.size(); i++){
            if(i <= 2) {
                Pair pair = Nodes.get(i);
                VisualNode node = (VisualNode) pair.getKey();
                node.setTranslateY(100);
                node.setTranslateX(i * 120 + 20);
                node.setHighlighted(false);
                node.setVisible(true);
                if (pair.getValue() != null) {
                    Arrow arrow = (Arrow) pair.getValue();
                    arrow.setTranslateY(100 + node.getHeight() / 2);
                    arrow.setTranslateX((i + 1) * 120);
                    arrow.setEndY(0);
                    arrow.setEndX(20);
                }
            }
            else{
                Pair pair = Nodes.get(i);
                VisualNode node = (VisualNode) pair.getKey();
                node.setTranslateY(100);
                node.setTranslateX((i + 1) * 120 + 20);
                node.setHighlighted(false);
                node.setVisible(true);
                if (pair.getValue() != null) {
                    Arrow arrow = (Arrow) pair.getValue();
                    arrow.setTranslateY(100 + node.getHeight() / 2);
                    arrow.setTranslateX((i + 2) * 120);
                    arrow.setEndY(0);
                    arrow.setEndX(20);
                }
            }
        }
        Nodes.get(2).getValue().setEndX(20);
        Nodes.get(2).getValue().setEndY(150);
        additionalPair.getValue().setVisible(true);
        additionalPair.getValue().setStartY(150);
        additionalPair.getValue().setEndX(20);
        additionalPair.getValue().setTranslateX(4 * 120);
        additionalPair.getValue().setTranslateY(100 + additionalPair.getKey().getHeight() / 2);
        additionalPair.getKey().setVisible(true);
        additionalPair.getKey().setTranslateY(250);
        additionalPair.getKey().setHighlighted(true);
        explanationBox.setTitle("Performing the insertion");
        explanationBox.setDetails("We set the next pointer of the current node in the list to the node we want to add in the list.");
    }

    private void setUpStep8(){
        for(int i = 0; i < Nodes.size(); i++){
            if(i <= 2) {
                Pair pair = Nodes.get(i);
                VisualNode node = (VisualNode) pair.getKey();
                node.setTranslateY(100);
                node.setTranslateX(i * 120 + 20);
                node.setHighlighted(false);
                node.setVisible(true);
                if (pair.getValue() != null) {
                    Arrow arrow = (Arrow) pair.getValue();
                    arrow.setTranslateY(100 + node.getHeight() / 2);
                    arrow.setTranslateX((i + 1) * 120);
                    arrow.setEndY(0);
                    arrow.setEndX(20);
                }
            }
            else{
                Pair pair = Nodes.get(i);
                VisualNode node = (VisualNode) pair.getKey();
                node.setTranslateY(100);
                node.setTranslateX((i + 1) * 120 + 20);
                node.setHighlighted(false);
                node.setVisible(true);
                if (pair.getValue() != null) {
                    Arrow arrow = (Arrow) pair.getValue();
                    arrow.setTranslateY(100 + node.getHeight() / 2);
                    arrow.setTranslateX((i + 2) * 120);
                    arrow.setEndY(0);
                    arrow.setEndX(20);
                }
            }
        }
        additionalPair.getValue().setVisible(true);
        additionalPair.getValue().setStartY(0);
        additionalPair.getValue().setEndY(0);
        additionalPair.getValue().setEndX(20);
        additionalPair.getValue().setTranslateX(4 * 120);
        additionalPair.getValue().setTranslateY(100 + additionalPair.getKey().getHeight() / 2);
        additionalPair.getKey().setVisible(true);
        additionalPair.getKey().setTranslateY(100);
        additionalPair.getKey().setHighlighted(true);
        explanationBox.setTitle("Insertion finished!");
        explanationBox.setDetails("The node is inserted into the list.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
