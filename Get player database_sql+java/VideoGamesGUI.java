package exercise1;

	import javafx.application.Application;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.stage.Stage;

public class VideoGamesGUI extends Application {
	    @Override
	    public void start(Stage stage) throws Exception {
	    	Parent root = FXMLLoader.load(getClass().getResource("games_GUI.fxml"));
	    	stage.setTitle("Profile Manager");
	        stage.setScene(new Scene(root));
	        stage.show();
	    }

	    public static void main(String[] args) {
	        launch();
	    }
}

