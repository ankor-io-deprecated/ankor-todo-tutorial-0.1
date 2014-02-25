package io.ankor.tutorial.viewmodel;

import at.irian.ankor.annotation.ActionListener;
import at.irian.ankor.annotation.Param;
import at.irian.ankor.messaging.AnkorIgnore;
import at.irian.ankor.pattern.AnkorPatterns;
import at.irian.ankor.ref.Ref;
import io.ankor.tutorial.model.Task;
import io.ankor.tutorial.model.TaskRepository;

public class TaskListModel {
    @AnkorIgnore
    private final TaskRepository taskRepository;

    @AnkorIgnore
    private final Ref modelRef;

    private Boolean footerVisibility;
    private Integer itemsLeft;
    private String itemsLeftText;


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
}
