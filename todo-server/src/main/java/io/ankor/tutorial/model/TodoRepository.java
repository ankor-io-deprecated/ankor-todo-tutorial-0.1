package io.ankor.tutorial.model;

import java.util.ArrayList;
import java.util.List;

public class TodoRepository {
    private List<Todo> todos = new ArrayList<Todo>();

    public void saveTask(Todo task) {

        int i = 0;
        for (Todo t : todos) {
            if (t.getId().equals(task.getId())) {
                todos.set(i, new Todo(task));
                return;
            }
            i++;
        }

        todos.add(new Todo(task));
    }

    public Todo findTask(String id) {
        for (Todo t : todos) {
            if (t.getId().equals(id)) {
                return new Todo(t);
            }
        }
        return null;
    }

    public List<Todo> getTodos() {
        List<Todo> res = new ArrayList<Todo>(todos.size());
        for(Todo t : todos) {
            res.add(new Todo(t));
        }
        return res;
    }

    public List<Todo> getActiveTasks() {
        List<Todo> res = new ArrayList<Todo>(todos.size());
        for(Todo t : todos) {
            if (!t.isCompleted()) {
                res.add(new Todo(t));
            }
        }
        return res;
    }

    public List<Todo> getCompletedTasks() {
        List<Todo> res = new ArrayList<Todo>(todos.size());
        for(Todo t : todos) {
            if (t.isCompleted()) {
                res.add(new Todo(t));
            }
        }
        return res;
    }

    public void clearTasks() {
        todos = getActiveTasks();
    }

    public void deleteTask(Todo task) {
        int i = 0;
        for (Todo t : todos) {
            if (t.getId().equals(task.getId())) {
                todos.remove(i);
                return;
            }
            i++;
        }
    }
}
