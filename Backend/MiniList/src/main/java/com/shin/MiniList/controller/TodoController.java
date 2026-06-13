package com.shin.MiniList.controller;

import com.shin.MiniList.model.Todo;
import com.shin.MiniList.service.TodoService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo, Authentication authentication) {
        String userName = authentication.getName();
        return service.addTodo(todo, userName);
    }

    @GetMapping("/todos/{id}")
    public Todo getTodo(@PathVariable Long id, Authentication authentication) {
        String userName = authentication.getName();
        return service.getTodo(userName, id);
    }

    @GetMapping("/todos")
    public List<Todo> getTodos(Authentication authentication) {
        String userName = authentication.getName();
        return service.getTodos(userName);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo, Authentication authentication ) {
        String userName = authentication.getName();
        return service.updateTodo(id, todo, userName);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable Long id, Authentication authentication) {
        String userName = authentication.getName();
        service.deleteTodo(id, userName);
    }

}
