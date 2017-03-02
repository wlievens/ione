package ione.demo;

import ione.controller.GraphEditorController;
import ione.model.Graph;
import ione.model.GraphFactory;
import ione.model.Input;
import ione.model.Node;
import ione.model.Output;
import ione.model.PortValue;
import ione.model.simple.SimpleNodeValue;
import ione.model.simple.SimplePortValue;
import ione.util.Color;
import ione.view.ViewFactory;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxDemo extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage stage)
    {
        GraphFactory graphFactory = GraphFactory.create();
        Graph graph = graphFactory.createGraph();
        {
            Node node1 = graphFactory.createNode(graph, createNodeValue("Node One", new Color(0.65, 0.23, 0.44)));
            Input node1_in1 = graphFactory.createInput(node1);
            Input node1_in2 = graphFactory.createInput(node1);
            Output node1_out1 = graphFactory.createOutput(node1);
            
            Node node2 = graphFactory.createNode(graph, createNodeValue("Node Two", new Color(0.13, 0.87, 0.51)));
            Input node2_in1 = graphFactory.createInput(node2);
            Output node2_out1 = graphFactory.createOutput(node2, createPortValue("Output"));
            
            Node node3 = graphFactory.createNode(graph, createNodeValue("Node Three", new Color(0.40, 0.34, 0.84)));
            Input node3_in1 = graphFactory.createInput(node3);
            Output node3_out1 = graphFactory.createOutput(node3);
            Output node3_out2 = graphFactory.createOutput(node3);
            
            graphFactory.createEdge(graph, node1_out1, node2_in1);
            graphFactory.createEdge(graph, node2_out1, node3_in1);
            graphFactory.createEdge(graph, node3_out1, node1_in1);
            graphFactory.createEdge(graph, node3_out1, node1_in2);
            
            node1.setLocation(200, 250);
            node2.setLocation(500, 150);
            node3.setLocation(350, 400);
        }
        
        GraphEditorController controller = new GraphEditorController(ViewFactory.createJavaFX(), graph);
        controller.setup();
        
        Scene scene = new Scene((Parent)controller.getView(), 900, 700);
        stage.setTitle(FxDemo.class.getName());
        stage.setScene(scene);
        stage.show();
    }
    
    private SimpleNodeValue createNodeValue(String name, Color fillColor)
    {
        SimpleNodeValue value = new SimpleNodeValue();
        value.setName(name);
        value.setFillColor(fillColor);
        return value;
    }
    
    private PortValue createPortValue(String name)
    {
        SimplePortValue value = new SimplePortValue();
        value.setName(name);
        return value;
    }
}
