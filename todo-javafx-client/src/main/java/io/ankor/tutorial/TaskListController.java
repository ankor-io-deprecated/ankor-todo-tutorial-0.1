package io.ankor.tutorial;

import at.irian.ankor.action.Action;
import at.irian.ankor.annotation.ChangeListener;
import at.irian.ankor.fx.binding.fxref.FxRef;
import at.irian.ankor.fx.controller.FXControllerAnnotationSupport;
import at.irian.ankor.ref.Ref;
import javafx.beans.property.Property;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.net.URL;
import java.util.ResourceBundle;

import static at.irian.ankor.fx.websocket.AnkorApplication.refFactory;

public class TaskListController implements Initializable {

    @FXML
    public Node footerTop;
    @FXML
    public Node footerBottom;
    private FxRef modelRef;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Ref rootRef = refFactory().ref("root");
        rootRef.fire(new Action("init"));
        FXControllerAnnotationSupport.scan(rootRef, this);
    }

    @ChangeListener(pattern = "root")
    public void myInit() {
        FxRef rootRef = refFactory().ref("root");
        modelRef = rootRef.appendPath("model");

        FxRef footerVisibilityRef = modelRef.appendPath("footerVisibility");

        Property<Boolean> footerVisibilityProperty = footerVisibilityRef.fxProperty();
        footerTop.visibleProperty().bind(footerVisibilityProperty);
        footerBottom.visibleProperty().bind(footerVisibilityProperty);
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
}
