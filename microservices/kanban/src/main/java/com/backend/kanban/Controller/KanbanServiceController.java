package com.backend.kanban.Controller;

import com.backend.kanban.Service.KanbanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class KanbanServiceController {
    private KanbanService kanbanService;

}
