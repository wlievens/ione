package ione.model.impl;

import ione.model.Input;
import ione.model.Node;
import ione.model.Output;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

public class TestNodeImpl
{
    private Node node;
    
    @Before
    public void setup()
    {
        node = new NodeImpl();
    }
    
    @Test
    public void testInputListImmutable()
    {
        node.addInput(mock(Input.class));
        try
        {
            node.getInputs().clear();
            fail();
        }
        catch (UnsupportedOperationException e)
        {
            // OK
        }
    }
    
    @Test
    public void testOutputListImmutable()
    {
        node.addOutput(mock(Output.class));
        try
        {
            node.getOutputs().clear();
            fail();
        }
        catch (UnsupportedOperationException e)
        {
            // OK
        }
    }
}
