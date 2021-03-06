package ione.model.impl;

import ione.model.Input;
import ione.model.Node;
import ione.model.NodeValue;
import ione.model.Output;
import ione.model.Point;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

@RequiredArgsConstructor
public class NodeImpl implements Node
{
    private final List<Input> inputs = new ArrayList<>();
    
    private final List<Output> outputs = new ArrayList<>();
    
    @Getter
    @Setter
    private NodeValue value;
    
    @Getter
    @Setter
    private Point location = Point.ORIGIN;
    
    @Override
    public Input addInput(@NonNull Input input)
    {
        inputs.add(input);
        return input;
    }
    
    @Override
    public Output addOutput(@NonNull Output output)
    {
        outputs.add(output);
        return output;
    }
    
    @Override
    public int getInputCount()
    {
        return inputs.size();
    }
    
    @Override
    public List<Input> getInputs()
    {
        return unmodifiableList(inputs);
    }
    
    @Override
    public int getOutputCount()
    {
        return outputs.size();
    }
    
    @Override
    public List<Output> getOutputs()
    {
        return unmodifiableList(outputs);
    }
    
    @Override
    public void setLocation(double x, double y)
    {
        setLocation(new Point(x, y));
    }
}
