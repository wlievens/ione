package ione.controller;

import ione.model.Graph;
import ione.model.Node;
import ione.model.Point;
import ione.view.GraphEditorView;
import ione.view.NodeView;
import ione.view.ViewFactory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class GraphEditorController
{
    private final ViewFactory viewFactory;
    
    private final Map<Node, NodeController> nodeControllers = new HashMap<>();
    
    @Getter
    private final Graph graph;
    
    @Getter
    private GraphEditorView view;
    
    public void setup()
    {
        view = viewFactory.createGraphEditorView();
        view.setup();
        updateNodeViews();
    }
    
    private void updateNodeViews()
    {
        for (Node node : graph.getNodes())
        {
            NodeController nodeController = nodeControllers.get(node);
            if (nodeController == null)
            {
                nodeController = new NodeController(viewFactory, node);
                nodeController.setup();
                this.view.addNodeView(nodeController.getView());
                nodeControllers.put(node, nodeController);
            }
            NodeView nodeView = nodeController.getView();
            Point location = node.getLocation();
            double width = 220.0;
            double height = 90.0;
            nodeView.setBox(location.getX() - width / 2, location.getY() - height / 2, width, height);
        }
    }
}
