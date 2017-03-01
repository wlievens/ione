package ione.model.impl;

import ione.model.Graph;
import ione.model.GraphFactory;
import ione.model.Input;
import ione.model.Node;
import ione.model.Output;
import org.junit.Before;
import org.junit.Test;

public class TestGraphFactoryImpl
{
    private GraphFactory factory;
    
    @Before
    public void setup()
    {
        factory = new GraphFactoryImpl();
    }
    
    @Test
    public void testCompleteGraph()
    {
        Graph graph = factory.createGraph();
        
        Node node1 = factory.createNode(graph);
        Input node1_in1 = factory.createInput(node1);
        Output node1_out1 = factory.createOutput(node1);
        
        Node node2 = factory.createNode(graph);
        Input node2_in1 = factory.createInput(node2);
        Output node2_out1 = factory.createOutput(node2);
        
        factory.createEdge(graph, node2_out1, node1_in1);
        factory.createEdge(graph, node1_out1, node2_in1);
    }
}
