package io.ankor.tutorial;

import at.irian.ankor.fx.websocket.AnkorApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends AnkorApplication {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void startFXClient(Stage stage) throws Exception {
        stage.setTitle("Ankor Todo Sample");
        Pane myPane = FXMLLoader.load(getClass().getClassLoader().getResource("tasks.fxml"));

        Scene myScene = new Scene(myPane);
        myScene.getStylesheets().add("style.css");
        stage.setScene(myScene);
        stage.show();
    }

    @Override
    protected String getWebSocketUri() {
        return "wss://ankor-todo-sample.irian.at/websocket/ankor";
    }
}

