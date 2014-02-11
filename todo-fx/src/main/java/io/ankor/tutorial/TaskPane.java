package io.ankor.tutorial;

import at.irian.ankor.fx.binding.fxref.FxRef;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TaskPane extends AnchorPane {
    private FxRef itemRef;
    private int index;

    @FXML
    public TextField titleTextField;
    @FXML
    public ToggleButton completedButton;
    @FXML
    public Button deleteButton;

    public TaskPane(FxRef itemRef, int index) {
        this.itemRef = itemRef;
        this.index = index;

        loadFXML();
        addEventListeners();
        setValues();
        bindProperties();
    }

    private void loadFXML() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("task.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addEventListeners() {
        // TODO
    }

    private void setValues() {
        titleTextField.textProperty().setValue(itemRef.appendPath("title").<String>getValue());
        completedButton.selectedProperty().setValue(itemRef.appendPath("completed").<Boolean>getValue());
        titleTextField.editableProperty().setValue(itemRef.appendPath("editable").<Boolean>getValue());
    }

    private void bindProperties() {
        titleTextField.textProperty().bindBidirectional(itemRef.appendPath("title").<String>fxProperty());
        completedButton.selectedProperty().bindBidirectional(itemRef.appendPath("completed").<Boolean>fxProperty());
        titleTextField.editableProperty().bindBidirectional(itemRef.appendPath("editable").<Boolean>fxProperty());
    }

    @FXML
    public void delete(ActionEvent e) {
        // TODO
    }
}
