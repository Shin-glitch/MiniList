package com.shin.MiniList.service;

import com.shin.MiniList.model.Todo;
import com.shin.MiniList.model.Users;
import com.shin.MiniList.repo.TodoRepo;
import com.shin.MiniList.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
