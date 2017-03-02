package ione.view.impl;

import ione.model.Point;
import ione.view.NodeView;
import javafx.animation.TranslateTransition;
import javafx.geometry.Bounds;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class FxNodeView extends BorderPane implements NodeView
{
    private static final Duration ANIMATION_DURATION = Duration.millis(500);
    
    private static final float PORT_CONTROL_SIZE = 11.0f;
    private static final float PORT_PADDING = 4.0f;
    private static final float BOX_ROUNDING = 5.0f;
    private static final double TITLE_MARGIN = 4.0;
    
    private static final CornerRadii CORNER_RADII = new CornerRadii(BOX_ROUNDING);
    private static final BorderWidths BORDER_WIDTHS = new BorderWidths(2);
    
    private final List<Node> inputConnectors = new ArrayList<>();
    private final List<Node> outputConnectors = new ArrayList<>();
    
    private final List<Label> inputLabels = new ArrayList<>();
    private final List<Label> outputLabels = new ArrayList<>();
    
    private Label titleLabel;
    
    @Setter
    private Listener listener;
    
    @Override
    public Point getInputLocation(int index)
    {
        if (index >= 0 && index < inputConnectors.size())
        {
            Node control = inputConnectors.get(index);
            Bounds bounds = control.localToScene(control.getBoundsInLocal());
            return getCenter(bounds);
        }
        return null;
    }
    
    @Override
    public Point getOutputLocation(int index)
    {
        if (index >= 0 && index < outputConnectors.size())
        {
            Node control = outputConnectors.get(index);
            Bounds bounds = control.localToScene(control.getBoundsInLocal());
            return getCenter(bounds);
        }
        return null;
    }
    
    @Override
    public void setBox(double x, double y, double width, double height)
    {
        setMinSize(width, height);
        setMaxSize(width, height);
        setPrefSize(width, height);
        
        TranslateTransition transition = new TranslateTransition(ANIMATION_DURATION, this);
        Bounds bounds = localToScene(getBoundsInLocal());
        transition.setByX(x - bounds.getMinX());
        transition.setByY(y - bounds.getMinY());
        transition.setOnFinished(event -> listener.onPositionUpdated());
        transition.play();
    }
    
    @Override
    public void setFillColor(ione.util.Color fillColor)
    {
        Color fxFillColor = FxUtil.fxColor(fillColor);
        setBackground(new Background(new BackgroundFill(fxFillColor, CORNER_RADII, Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(fxFillColor.darker(), BorderStrokeStyle.SOLID, CORNER_RADII, BORDER_WIDTHS)));
    }
    
    @Override
    public void setInputName(int index, String name)
    {
        if (index >= 0 && index < inputLabels.size())
        {
            inputLabels.get(index).setText(name);
        }
    }
    
    @Override
    public void setOutputName(int index, String name)
    {
        if (index >= 0 && index < outputLabels.size())
        {
            outputLabels.get(index).setText(name);
        }
    }
    
    @Override
    public void setTitle(String title)
    {
        titleLabel.setText(title == null ? "" : title);
    }
    
    @Override
    public void setup()
    {
        setLeft(setupInputBox());
        setRight(setupOutputBox());
        setTop(setupTitleBox());
        
        setFillColor(ione.util.Color.WHITE);
        
        setOnMouseClicked(event -> System.out.println(event));
    }
    
    private Shape createPortControl()
    {
        Rectangle control = new Rectangle();
        control.setArcWidth(BOX_ROUNDING);
        control.setArcHeight(BOX_ROUNDING);
        control.setWidth(PORT_CONTROL_SIZE);
        control.setHeight(PORT_CONTROL_SIZE);
        control.setFill(Color.LIGHTSALMON);
        control.setStroke(Color.DARKRED);
        control.setFill(Color.LIGHTSALMON);
        control.setStroke(Color.DARKRED);
        return control;
    }
    
    private Label createPortLabel()
    {
        Label label = new Label();
        return label;
    }
    
    private GridPane createPortPane()
    {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(PORT_PADDING));
        pane.setHgap(PORT_PADDING);
        pane.setVgap(PORT_PADDING);
        return pane;
    }
    
    private Region createVBoxSpacer()
    {
        Region spacer2 = new Region();
        VBox.setVgrow(spacer2, Priority.ALWAYS);
        return spacer2;
    }
    
    private Point getCenter(Bounds bounds)
    {
        return new Point((bounds.getMinX() + bounds.getMaxX()) / 2, (bounds.getMinY() + bounds.getMaxY()) / 2);
    }
    
    private Node setupInputBox()
    {
        VBox pane = new VBox();
        
        GridPane box = createPortPane();
        
        if (listener != null)
        {
            inputConnectors.clear();
            inputLabels.clear();
            for (int n = 0; n < listener.getInputCount(); ++n)
            {
                Node control = createPortControl();
                Label label = createPortLabel();
                GridPane.setHalignment(label, HPos.LEFT);
                box.add(control, 0, n);
                box.add(label, 1, n);
                inputConnectors.add(control);
                inputLabels.add(label);
            }
        }
        
        pane.getChildren().add(createVBoxSpacer());
        
        pane.getChildren().add(box);
        VBox.setVgrow(box, Priority.NEVER);
        
        pane.getChildren().add(createVBoxSpacer());
        
        return pane;
    }
    
    private Node setupOutputBox()
    {
        VBox pane = new VBox();
        
        GridPane box = createPortPane();
        
        if (listener != null)
        {
            outputConnectors.clear();
            outputLabels.clear();
            for (int n = 0; n < listener.getOutputCount(); ++n)
            {
                Node control = createPortControl();
                Label label = createPortLabel();
                GridPane.setHalignment(label, HPos.RIGHT);
                box.add(control, 1, n);
                box.add(label, 0, n);
                outputConnectors.add(control);
                outputLabels.add(label);
            }
        }
        pane.getChildren().add(createVBoxSpacer());
        
        pane.getChildren().add(box);
        VBox.setVgrow(box, Priority.NEVER);
        
        pane.getChildren().add(createVBoxSpacer());
        
        return pane;
    }
    
    private Node setupTitleBox()
    {
        AnchorPane pane = new AnchorPane();
        titleLabel = new Label();
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setTextAlignment(TextAlignment.CENTER);
        titleLabel.setBackground(new Background(new BackgroundFill(new Color(1.0f, 1.0f, 1.0f, 0.4f), new CornerRadii(3), null)));
        AnchorPane.setLeftAnchor(titleLabel, TITLE_MARGIN);
        AnchorPane.setRightAnchor(titleLabel, TITLE_MARGIN);
        AnchorPane.setTopAnchor(titleLabel, TITLE_MARGIN);
        AnchorPane.setBottomAnchor(titleLabel, TITLE_MARGIN);
        pane.getChildren().add(titleLabel);
        return pane;
    }
}
