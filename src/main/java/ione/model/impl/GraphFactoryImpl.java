package ione.model.impl;

import ione.model.Edge;
import ione.model.EdgeValue;
import ione.model.Graph;
import ione.model.GraphFactory;
import ione.model.Input;
import ione.model.Node;
import ione.model.NodeValue;
import ione.model.Output;
import ione.model.PortValue;
import lombok.NonNull;

public class GraphFactoryImpl implements GraphFactory
{
    @Override
    public Edge createEdge(@NonNull Graph graph, @NonNull Output origin, @NonNull Input target, EdgeValue value)
    {
        EdgeImpl edge = new EdgeImpl(origin, target);
        edge.setValue(value);
        return graph.addEdge(edge);
    }
    
    @Override
    public Graph createGraph()
    {
        return new GraphImpl();
    }
    
    @Override
    public Input createInput(@NonNull Node node, PortValue value)
    {
        InputImpl input = new InputImpl(node);
        input.setValue(value);
        return node.addInput(input);
    }
    
    @Override
    public Node createNode(@NonNull Graph graph, NodeValue value)
    {
        NodeImpl node = new NodeImpl();
        node.setValue(value);
        return graph.addNode(node);
    }
    
    @Override
    public Output createOutput(@NonNull Node node, PortValue value)
    {
        OutputImpl output = new OutputImpl(node);
        output.setValue(value);
        return node.addOutput(output);
    }
}
