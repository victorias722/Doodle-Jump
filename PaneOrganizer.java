import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class PaneOrganizer {
	private BorderPane root;
	private Game _game;
    private VBox buttonPane;
	
	public PaneOrganizer(){
		root = new BorderPane();
		root.setStyle("-fx-background-color: white;");
		root.setPrefSize(800,800);
		Pane gamePane = new Pane();
        _game = new Game (gamePane);
        root.setCenter(gamePane);
		this.setupButton();
	}
	
	
	public Pane getRoot(){
		return root;
	}
	
	public void setupButton(){
		buttonPane = new VBox();
		Button btn = new Button("Quit");
		buttonPane.getChildren().add(btn);
		root.setBottom(buttonPane);
		btn.setOnAction(new ClickHandler());		
	}

	private class ClickHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event){
			System.exit(0);
		}
	}
}
