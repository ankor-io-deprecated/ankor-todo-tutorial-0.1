package io.ankor.tutorial.viewmodel;

import at.irian.ankor.messaging.AnkorIgnore;
import at.irian.ankor.pattern.AnkorPatterns;
import at.irian.ankor.ref.Ref;
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
