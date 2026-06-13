package com.shin.MiniList.service;

import com.shin.MiniList.model.Todo;
import com.shin.MiniList.model.Users;
import com.shin.MiniList.repo.TodoRepo;
import com.shin.MiniList.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepo todoRepo;
    private final UserRepo userRepo;

    public TodoService(TodoRepo todoRepo, UserRepo userRepo) {
        this.todoRepo = todoRepo;
        this.userRepo = userRepo;
    }



    public Todo addTodo(Todo todo, String userName) {

        Users currentUser = null;
        try {
            currentUser = userRepo.findByUsername(userName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Todo todo1 = new Todo();
        todo1.setTitle(todo.getTitle());
        todo1.setDescription(todo.getDescription());
        todo1.setPriorityLevel(todo.getPriorityLevel());
        todo1.setStatus(todo.getStatus());
        todo1.setDueDate(todo.getDueDate());
        todo1.setUsers(currentUser);

        return todoRepo.save(todo1);

    }

    public Todo getTodo(String userName, Long id) {
        Todo todo = todoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        if (!todo.getUsers().getUsername().equals(userName)) {
            throw new RuntimeException("Unauthorized");
        }
        return todo;
    }

    public List<Todo> getTodos(String userName) {

        List<Todo> todos = null;
        todos = todoRepo.findByUsersUsername(userName);

        return todos;

    }

    public void deleteTodo(Long id, String userName) {

        Todo todo = todoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        if(!todo.getUsers().getUsername().equals(userName)) {
            throw new RuntimeException("unauthorized");
        }
        todoRepo.delete(todo);
    }

    public Todo updateTodo(Long id, Todo todo, String userName) {

        Todo existingTodo = todoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        if(!existingTodo.getUsers().getUsername().equals(userName)) {
            throw new RuntimeException("Unauthorized");
        }

        existingTodo.setTitle(todo.getTitle());
        existingTodo.setDescription(todo.getDescription());
        existingTodo.setPriorityLevel(todo.getPriorityLevel());
        existingTodo.setStatus(todo.getStatus());
        existingTodo.setDueDate(todo.getDueDate());

        return todoRepo.save(existingTodo);

    }
}
