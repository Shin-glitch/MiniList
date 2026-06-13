package com.shin.MiniList.controller;

import com.shin.MiniList.model.Todo;
import com.shin.MiniList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping("/addTodo")
    public Todo addTodo(@RequestBody Todo todo, Authentication authentication) {
        String userName = authentication.getName();
        return service.addTodo(todo, userName);
    }

}
