package ione.controller;

import ione.model.Edge;
import ione.model.Graph;
import ione.model.Input;
import ione.model.Node;
import ione.model.Output;
import ione.model.Point;
import ione.view.EdgeView;
import ione.view.GraphEditorView;
import ione.view.NodeView;
import ione.view.ViewFactory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class GraphEditorController
{
    private final ViewFactory viewFactory;
    
    private final Map<Node, NodeController> nodeControllers = new HashMap<>();
    
    private final Map<Edge, EdgeController> edgeControllers = new HashMap<>();
    
    @Getter
    private final Graph graph;
    
    @Getter
    private GraphEditorView view;
    
    public void setup()
    {
        view = viewFactory.createGraphEditorView();
        view.setListener(new GraphEditorView.Listener()
        {
            @Override
            public void onTestClick()
            {
                for (Node node : graph.getNodes())
                {
                    do
                    {
                        double x = 140 + Math.random() * 500;
                        double y = 140 + Math.random() * 400;
                        boolean valid = graph.getNodes().stream()
                                .filter(other -> other != node)
                                .noneMatch(other -> other.getLocation().distance(new Point(x, y)) < 210);
                        if (valid)
                        {
                            node.setLocation(x, y);
                            break;
                        }
                    }
                    while (true);
                }
                
                System.out.println("DISTANCES");
                List<Node> nodes = graph.getNodes();
                for (int i = 0; i < nodes.size(); i++)
                {
                    Node node1 = nodes.get(i);
                    for (int j = i + 1; j < nodes.size(); j++)
                    {
                        Node node2 = nodes.get(j);
                        System.out.println("\t" + node1.getLocation().distance(node2.getLocation()));
                    }
                }
                
                for (EdgeController edgeController : edgeControllers.values())
                {
                    edgeController.hideView();
                }
                updateNodeViews();
            }
        });
        view.setup();
        updateNodeViews();
        updateEdgeViews();
    }
    
    private void updateEdgeViews()
    {
        for (Edge edge : graph.getEdges())
        {
            EdgeController edgeController = edgeControllers.get(edge);
            if (edgeController == null)
            {
                edgeController = new EdgeController(viewFactory, edge);
                edgeController.setListener(new EdgeController.Listener()
                {
                });
                edgeController.setup();
                this.view.addEdgeView(edgeController.getView());
                edgeControllers.put(edge, edgeController);
            }
            EdgeView edgeView = edgeController.getView();
            Output origin = edge.getOrigin();
            Input target = edge.getTarget();
            Node originNode = origin.getNode();
            Node targetNode = target.getNode();
            NodeController originNodeController = nodeControllers.get(originNode);
            NodeController targetNodeController = nodeControllers.get(targetNode);
            if (originNodeController != null && targetNodeController != null)
            {
                Point start = originNodeController.getOutputLocation(originNode.getOutputs().indexOf(origin));
                Point end = targetNodeController.getInputLocation(targetNode.getInputs().indexOf(target));
                if (start != null && end != null)
                {
                    edgeView.setLocation(start.getX(), start.getY(), end.getX(), end.getY());
                    edgeController.showView();
                }
            }
        }
    }
    
    private void updateNodeViews()
    {
        for (Node node : graph.getNodes())
        {
            NodeController nodeController = nodeControllers.get(node);
            if (nodeController == null)
            {
                nodeController = new NodeController(viewFactory, node);
                nodeController.setListener(new NodeController.Listener()
                {
                    @Override
                    public void onPositionUpdated()
                    {
                        updateEdgeViews();
                    }
                });
                nodeController.setup();
                this.view.addNodeView(nodeController.getView());
                nodeControllers.put(node, nodeController);
            }
            NodeView nodeView = nodeController.getView();
            Point location = node.getLocation();
            double width = 180.0;
            double height = 90.0;
            nodeView.setBox(location.getX() - width / 2, location.getY() - height / 2, width, height);
        }
    }
}
