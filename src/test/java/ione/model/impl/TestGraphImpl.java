package ione.model.impl;

import ione.model.Graph;
import ione.model.Node;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

public class TestGraphImpl
{
    private Graph graph;
    
    @Before
    public void setup()
    {
        graph = new GraphImpl();
    }
    
    @Test
    public void testAddNode()
    {
        assertEquals(0, graph.getNodeCount());
        Node node = mock(Node.class);
        assertFalse(graph.containsNode(node));
        graph.addNode(node);
        assertEquals(1, graph.getNodeCount());
        assertTrue(graph.containsNode(node));
    }
    
    @Test
    public void testNodeListImmutable()
    {
        graph.addNode(mock(Node.class));
        try
        {
            graph.getNodes().clear();
            fail();
        }
        catch (UnsupportedOperationException e)
        {
            // OK
        }
    }
    
}
