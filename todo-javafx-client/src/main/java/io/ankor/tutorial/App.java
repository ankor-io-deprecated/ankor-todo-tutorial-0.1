package io.ankor.tutorial;

import at.irian.ankor.fx.websocket.AnkorApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App  extends AnkorApplication {

    // This is to start the JavaFX application.
    public static void main(String[] args) {
        launch(args);
    }

    // This method gets called after a connection has been established
    @Override
    protected void startFXClient(Stage stage) throws Exception {
        stage.setTitle("Ankor Todo Sample");

        // predefined fxml
        Pane myPane = FXMLLoader.load(getClass().getClassLoader().getResource("tasks.fxml"));

        Scene myScene = new Scene(myPane);

        // predefined styles
        myScene.getStylesheets().add("style.css");

        stage.setScene(myScene);
        stage.show();
    }

    // The WebSocket endpoint to connect to
    @Override
    protected String getWebSocketUri() {
        return "wss://ankor-todo-sample.irian.at/websocket/ankor";
    }
}

