package ione.demo;

import ione.controller.GraphEditorController;
import ione.model.Graph;
import ione.model.GraphFactory;
import ione.model.Input;
import ione.model.Node;
import ione.model.Output;
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
            Node node1 = graphFactory.createNode(graph);
            Input node1_in1 = graphFactory.createInput(node1);
            Output node1_out1 = graphFactory.createOutput(node1);
            
            Node node2 = graphFactory.createNode(graph);
            Input node2_in1 = graphFactory.createInput(node2);
            Output node2_out1 = graphFactory.createOutput(node2);
            
            graphFactory.createEdge(graph, node2_out1, node1_in1);
            graphFactory.createEdge(graph, node1_out1, node2_in1);
            
            node1.setLocation(-100, 0);
            node2.setLocation(+100, 0);
        }
        
        GraphEditorController controller = new GraphEditorController(ViewFactory.createJavaFX());
        controller.setup();
        
        Scene scene = new Scene((Parent)controller.getView(), 400, 400);
        stage.setTitle(FxDemo.class.getName());
        stage.setScene(scene);
        stage.show();
    }
}
