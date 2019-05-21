package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Group;
import javafx.scene.shape.Line;

public class Arrow extends Group {

    private final Line line;

    public Arrow() {
        this(new Line(), new Line(), new Line());
    }

    private double arrowLength = 2;
    private double arrowWidth = 3;

    private Arrow(Line line, Line arrow1, Line arrow2) {
        super(line, arrow1, arrow2);
        this.line = line;
        InvalidationListener updater = o -> {
            double ex = getEndX();
            double ey = getEndY();
            double sx = getStartX();
            double sy = getStartY();

            arrow1.setEndX(ex);
            arrow1.setEndY(ey);
            arrow2.setEndX(ex);
            arrow2.setEndY(ey);

            if (ex == sx && ey == sy) {
                // arrow parts of length 0
                arrow1.setStartX(ex);
                arrow1.setStartY(ey);
                arrow2.setStartX(ex);
                arrow2.setStartY(ey);
            } else {
                double factor = arrowLength / Math.hypot(sx-ex, sy-ey);
                double factorO = arrowWidth / Math.hypot(sx-ex, sy-ey);

                // part in direction of main line
                double dx = (sx - ex) * factor;
                double dy = (sy - ey) * factor;

                // part ortogonal to main line
                double ox = (sx - ex) * factorO;
                double oy = (sy - ey) * factorO;

                arrow1.setStartX(ex + dx - oy);
                arrow1.setStartY(ey + dy + ox);
                arrow2.setStartX(ex + dx + oy);
                arrow2.setStartY(ey + dy - ox);
            }
        };

        // add updater to properties
        startXProperty().addListener(updater);
        startYProperty().addListener(updater);
        endXProperty().addListener(updater);
        endYProperty().addListener(updater);
        updater.invalidated(null);
    }

    public void setStartX(double value) {
        line.setStartX(value);
    }

    public double getStartX() {
        return line.getStartX();
    }

    public DoubleProperty startXProperty() {
        return line.startXProperty();
    }

    public void setStartY(double value) {
        line.setStartY(value);
    }

    public double getStartY() {
        return line.getStartY();
    }

    public DoubleProperty startYProperty() {
        return line.startYProperty();
    }

    public void setEndX(double value) {
        line.setEndX(value);
    }

    public double getEndX() {
        return line.getEndX();
    }

    public DoubleProperty endXProperty() {
        return line.endXProperty();
    }

    public void setEndY(double value) {
        line.setEndY(value);
    }

    public double getEndY() {
        return line.getEndY();
    }

    public DoubleProperty endYProperty() {
        return line.endYProperty();
    }

    public void setArrowWidth(double value){
        arrowWidth = value;
    }

    public void setArrowLength(double value){
        arrowLength = value;
    }

}