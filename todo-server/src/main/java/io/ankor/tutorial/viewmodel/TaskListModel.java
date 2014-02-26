package io.ankor.tutorial.viewmodel;

import at.irian.ankor.annotation.ActionListener;
import at.irian.ankor.annotation.Param;
import at.irian.ankor.messaging.AnkorIgnore;
import at.irian.ankor.pattern.AnkorPatterns;
import at.irian.ankor.ref.CollectionRef;
import at.irian.ankor.ref.Ref;
import io.ankor.tutorial.model.Task;
import io.ankor.tutorial.model.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskListModel {

    @AnkorIgnore
    private final Ref modelRef;
    
    @AnkorIgnore
    private final TaskRepository taskRepository;

    private Boolean footerVisibility = false;
    private Integer itemsLeft = 0;
    private String itemsLeftText;

    private List<TaskModel> tasks = new ArrayList<>();

    public TaskListModel(Ref modelRef, TaskRepository taskRepository) {
        AnkorPatterns.initViewModel(this, modelRef);

        this.modelRef = modelRef;
        this.taskRepository = taskRepository;

        footerVisibility = true;
        itemsLeft = 10;
        itemsLeftText = "imaginary items left";
    }

    @ActionListener
    public void newTask(@Param("title") final String title) {
        Task task = new Task(title);
        taskRepository.saveTask(task);

        int itemsLeft = taskRepository.getActiveTasks().size();
        modelRef.appendPath("itemsLeft").setValue(itemsLeft);

        TaskModel model = new TaskModel(task);
        tasksRef().add(model);
    }

    private CollectionRef tasksRef() {
        return modelRef.appendPath("tasks").toCollectionRef();
    }

    @ActionListener
    public void deleteTask(@Param("index") final int index) {
        Task task = tasks.get(index);
        taskRepository.deleteTask(task);

        int itemsLeft = taskRepository.getActiveTasks().size();
        modelRef.appendPath("itemsLeft").setValue(itemsLeft);

        tasksRef().delete(index);
    }

    public Boolean getFooterVisibility() {
        return footerVisibility;
    }

    public void setFooterVisibility(Boolean footerVisibility) {
        this.footerVisibility = footerVisibility;
    }

    public Integer getItemsLeft() {
        return itemsLeft;
    }

    public void setItemsLeft(Integer itemsLeft) {
        this.itemsLeft = itemsLeft;
    }

    public String getItemsLeftText() {
        return itemsLeftText;
    }

    public void setItemsLeftText(String itemsLeftText) {
        this.itemsLeftText = itemsLeftText;
    }

    public List<TaskModel> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskModel> tasks) {
        this.tasks = tasks;
    }

}
