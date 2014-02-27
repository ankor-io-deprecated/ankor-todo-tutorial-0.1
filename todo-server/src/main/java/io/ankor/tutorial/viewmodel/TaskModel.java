package io.ankor.tutorial.viewmodel;

import io.ankor.tutorial.model.Task;

public class TaskModel extends Task {
    private boolean editing = false;

    public TaskModel(Task task) {
        super(task);
    }

    public boolean isEditing() {
        return editing;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TaskModel taskModel = (TaskModel) o;

        return editing == taskModel.editing;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (editing ? 1 : 0);
        return result;
    }
}
