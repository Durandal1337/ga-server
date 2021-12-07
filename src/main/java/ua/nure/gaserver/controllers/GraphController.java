package ua.nure.gaserver.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.gaserver.services.GraphService;
import ua.nure.gaserver.json.GraphRequest;

import java.util.Map;

@RestController
@RequestMapping("/graph")
public class GraphController {
    private final GraphService graphService;

    public GraphController(GraphService graphService) {
        this.graphService = graphService;
    }

    @PostMapping("/get")
    public Map<String, String> getGraph(@RequestBody GraphRequest graphRequest) {
    return graphService.getGraph(graphRequest);
    }
}
