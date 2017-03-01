package ione.model.impl;

import ione.model.Edge;
import ione.model.Graph;
import ione.model.GraphFactory;
import ione.model.Input;
import ione.model.Node;
import ione.model.Output;
import lombok.NonNull;

public class GraphFactoryImpl implements GraphFactory
{
    @Override
    public Edge createEdge(@NonNull Graph graph, @NonNull Output origin, @NonNull Input target)
    {
        return graph.addEdge(new EdgeImpl(origin, target));
    }
    
    @Override
    public Graph createGraph()
    {
        return new GraphImpl();
    }
    
    @Override
    public Input createInput(@NonNull Node node)
    {
        return node.addInput(new InputImpl(node));
    }
    
    @Override
    public Node createNode(@NonNull Graph graph)
    {
        return graph.addNode(new NodeImpl());
    }
    
    @Override
    public Output createOutput(@NonNull Node node)
    {
        return node.addOutput(new OutputImpl(node));
    }
}
