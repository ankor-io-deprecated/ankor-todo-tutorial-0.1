package io.ankor.tutorial;

import at.irian.ankor.action.Action;
import at.irian.ankor.annotation.ChangeListener;
import at.irian.ankor.fx.controller.FXControllerSupport;
import at.irian.ankor.ref.Ref;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class TaskListController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Ref rootRef = App.refFactory().ref("root");
        FXControllerSupport.init(this, rootRef);
        rootRef.fire(new Action("init"));
    }

    @ChangeListener(pattern = "root")
    public void myInit() {
        // TODO
    }

    @FXML
    public void newTodo(ActionEvent actionEvent) {
        // TODO
    }

    @FXML
    public void toggleAll(ActionEvent actionEvent) {
        // TODO
    }

    @FXML
    public void clearTasks(ActionEvent actionEvent) {
        // TODO
    }

    @FXML
    public void filterAllClicked(ActionEvent actionEvent) {
        // TODO
    }

    @FXML
    public void filterActiveClicked(ActionEvent actionEvent) {
        // TODO
    }

    @FXML
    public void filterCompletedClicked(ActionEvent actionEvent) {
        // TODO
    }
}
