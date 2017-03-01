package ione.controller;

import ione.view.GraphEditorView;
import ione.view.ViewFactory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GraphEditorController
{
    private final ViewFactory viewFactory;
    
    @Getter
    private GraphEditorView view;
    
    public void setup()
    {
        view = viewFactory.createGraphEditorView();
    }
}
