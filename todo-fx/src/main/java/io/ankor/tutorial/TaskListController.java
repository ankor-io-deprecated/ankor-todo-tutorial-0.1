package io.ankor.tutorial;

import at.irian.ankor.action.Action;
import at.irian.ankor.annotation.ChangeListener;
import at.irian.ankor.fx.binding.fxref.FxRef;
import at.irian.ankor.fx.controller.FXControllerSupport;
import at.irian.ankor.ref.Ref;
import javafx.beans.property.Property;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class TaskListController implements Initializable {

    private FxRef modelRef;

    @FXML
    public Node footerTop;
    @FXML
    public Node footerBottom;

    @FXML
    public Label todoCountNum;
    @FXML
    public Label todoCountText;

    @FXML
    public TextField newTodo;

    @FXML
    public VBox tasksList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Ref rootRef = App.refFactory().ref("root");
        FXControllerSupport.init(this, rootRef);
        rootRef.fire(new Action("init"));
    }

    @ChangeListener(pattern = "root")
    public void myInit() {
        FxRef rootRef = App.refFactory().ref("root");
        modelRef = rootRef.appendPath("model");
        FxRef footerVisibilityRef = modelRef.appendPath("footerVisibility");

        Property<Boolean> footerVisibilityProperty = footerVisibilityRef.fxProperty();
        footerTop.visibleProperty().bind(footerVisibilityProperty);
        footerBottom.visibleProperty().bind(footerVisibilityProperty);

        todoCountText.textProperty().bind(modelRef.appendPath("itemsLeftText").<String>fxProperty());

        todoCountNum.textProperty().bindBidirectional(
                modelRef.appendPath("itemsLeft").<Number>fxProperty(),
                new NumberStringConverter());

        renderTasks(modelRef.appendPath("tasks"));
    }

    @ChangeListener(pattern = "root.model.(tasks)")
    public void renderTasks(FxRef tasksRef) {
        tasksList.getChildren().clear();

        int numTasks = tasksRef.<List>getValue().size();

        for (int index = 0; index < numTasks; index++) {
            FxRef itemRef = tasksRef.appendIndex(index);
            TaskPane node = new TaskPane(itemRef, index);
            tasksList.getChildren().add(node);
        }
    }

    @FXML
    public void newTodo(ActionEvent actionEvent) {
        String title = newTodo.getText();
        if (!title.equals("")) {
            Map<String, Object> params = new HashMap<>();
            params.put("title", title);
            modelRef.fire(new Action("newTask", params));
            newTodo.clear();
        }
    }

    @FXML
    public void toggleAll(ActionEvent actionEvent) {
        // TODO
    }

    @FXML
    public void clearTasks(ActionEvent actionEvent) {
        // TODO
    }
}
