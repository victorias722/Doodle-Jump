import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {
    @Override
    public void start(Stage stage){
        PaneOrganizer organizer = new PaneOrganizer();
        Scene scene = new Scene(organizer.getRoot(), 800, 800);
        stage.setTitle("Doodle Jump");
        stage.setScene(scene);
        stage.show();
    }
        
    public static void main(String[] argv) {
		launch(argv);
    }
}
