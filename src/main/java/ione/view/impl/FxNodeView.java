package ione.view.impl;

import ione.view.NodeView;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import lombok.Setter;

public class FxNodeView extends BorderPane implements NodeView
{
    private static final Duration ANIMATION_DURATION = Duration.millis(500);
    
    private static final float PORT_ARC_RADIUS = 10.0f;
    
    @Setter
    private Listener listener;
    
    @Override
    public void setBox(double x, double y, double width, double height)
    {
        setMinSize(width, height);
        setMaxSize(width, height);
        setPrefSize(width, height);
        
        TranslateTransition transition = new TranslateTransition(ANIMATION_DURATION, this);
        transition.setByX(x - getLayoutX());
        transition.setByY(y - getLayoutY());
        transition.play();
    }
    
    @Override
    public void setup()
    {
        setLeft(setupLeft());
        setRight(setupRight());
        setCenter(setupCenter());
        
        setOnMouseClicked(event -> System.out.println(event));
    }
    
    private Region createVBoxSpacer()
    {
        Region spacer2 = new Region();
        VBox.setVgrow(spacer2, Priority.ALWAYS);
        return spacer2;
    }
    
    private Node setupCenter()
    {
        BorderPane pane = new BorderPane();
        pane.setTop(setupTitle());
        pane.setOpacity(1.0);
        pane.setBackground(new Background(new BackgroundFill(Color.LIGHTSALMON, null, null)));
        pane.setBorder(new Border(new BorderStroke(Color.DARKRED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        return pane;
    }
    
    private Node setupLeft()
    {
        VBox pane = new VBox();
        
        VBox box = new VBox();
        
        if (listener != null)
        {
            for (int n = 0; n < listener.getInputCount(); ++n)
            {
                Arc arc = new Arc();
                arc.setRadiusX(PORT_ARC_RADIUS);
                arc.setRadiusY(PORT_ARC_RADIUS);
                arc.setStartAngle(90);
                arc.setLength(180);
                arc.setType(ArcType.ROUND);
                arc.setFill(Color.LIGHTSALMON);
                arc.setStroke(Color.DARKRED);
                box.getChildren().add(arc);
            }
        }
        
        pane.getChildren().add(createVBoxSpacer());
        
        pane.getChildren().add(box);
        VBox.setVgrow(box, Priority.NEVER);
        
        pane.getChildren().add(createVBoxSpacer());
        
        return pane;
    }
    
    private Node setupRight()
    {
        VBox pane = new VBox();
        
        VBox box = new VBox();
        
        if (listener != null)
        {
            for (int n = 0; n < listener.getOutputCount(); ++n)
            {
                Arc arc = new Arc();
                arc.setRadiusX(PORT_ARC_RADIUS);
                arc.setRadiusY(PORT_ARC_RADIUS);
                arc.setStartAngle(270);
                arc.setLength(180);
                arc.setType(ArcType.ROUND);
                arc.setFill(Color.LIGHTSALMON);
                arc.setStroke(Color.DARKRED);
                box.getChildren().add(arc);
            }
        }
        
        pane.getChildren().add(createVBoxSpacer());
        
        pane.getChildren().add(box);
        VBox.setVgrow(box, Priority.NEVER);
        
        pane.getChildren().add(createVBoxSpacer());
        
        return pane;
    }
    
    private Node setupTitle()
    {
        AnchorPane pane = new AnchorPane();
        Label title = new Label();
        if (listener != null)
        {
            title.setText(listener.getTitle());
        }
        title.setAlignment(Pos.CENTER);
        title.setTextAlignment(TextAlignment.CENTER);
        title.setBackground(new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.4f), new CornerRadii(3), null)));
        double margin = 2.0;
        AnchorPane.setLeftAnchor(title, margin);
        AnchorPane.setRightAnchor(title, margin);
        AnchorPane.setTopAnchor(title, margin);
        AnchorPane.setBottomAnchor(title, margin);
        pane.getChildren().add(title);
        return pane;
    }
}
