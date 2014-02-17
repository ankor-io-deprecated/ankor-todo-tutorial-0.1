package io.ankor.tutorial.viewmodel;

import at.irian.ankor.pattern.AnkorPatterns;
import at.irian.ankor.ref.Ref;
import io.ankor.tutorial.model.TaskRepository;

public class ModelRoot {
    private TaskListModel model;

    public ModelRoot(Ref rootRef, TaskRepository taskRepository) {
        AnkorPatterns.initViewModel(this, rootRef);
        this.model = new TaskListModel(rootRef.appendPath("model"), taskRepository);
    }

    public TaskListModel getModel() {
        return model;
    }

    public void setModel(TaskListModel model) {
        this.model = model;
    }
}
