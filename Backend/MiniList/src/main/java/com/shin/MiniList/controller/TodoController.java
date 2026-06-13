package com.shin.MiniList.controller;

import com.shin.MiniList.model.Todo;
import com.shin.MiniList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/updateTodo/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo, Authentication authentication ) {
        String userName = authentication.getName();
        return service.updateTodo(id, todo, userName);
    }

    @DeleteMapping("/deleteTodo/{id}")
    public void deleteTodo(@PathVariable Long id, Authentication authentication) {
        String userName = authentication.getName();
        service.deleteTodo(id, userName);
    }

}
