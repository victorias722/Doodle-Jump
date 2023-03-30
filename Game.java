import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Game {
    private Doodle _doodle;
	private Platform _platform;
    private ArrayList<Platform> _platforms;
    private Pane _gamePane;
    private Label _label;

    public Game(Pane gamePane){
        gamePane.setPrefSize(800, 800);
		gamePane.setStyle("-fx-background-color: pink;");
        _gamePane = gamePane;

        _platform = new Platform(400,790);
        _platforms = new ArrayList<Platform>();
        _platforms.add(_platform);

        _label = new Label();
        _doodle = new Doodle(400,770);
        _gamePane.getChildren().addAll(_doodle.getNode(), _platform.getNode(), _label);
        KeyHandler myKeyHandler = new KeyHandler();
		_gamepane.addEventHandler(KeyEvent.KEY_PRESSED, myKeyHandler);
        _gamePane.setFocusTraversable(true);
        this.generatePlatforms();
        this.setupTimeline();
    }

    //Generates platforms that are semi-randomly located
    public double semiRandom(double x, double y){
        double range = x-y;
        double semiRandom = ((double) range * (Math.random())) + y;
        return semiRandom;
    }

    public void keepPlatformsInPane(){
        if (_platform.getXLoc()<0){
            _platform.setXLoc(50);
        }
        if (_platform.getXLoc()>800){
            _platform.setXLoc(750);
        }
    }

    public void setupTimeline(){
        KeyFrame keyframe = new KeyFrame(Duration.millis(16), new TimeHandler());
        Timeline timeline = new Timeline(keyframe);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void gameOver(){
		if (_doodle.getYLoc() >= 800){
			_label.setText("Game Over!");
        }
	}

    //Generates infinte platforms so that the game can be played indefinitly
    public void generatePlatforms(){
		
		while (_platform.getYLoc() > 0){
			Platform plat = new Platform((_platform.getXLoc() + this.semiRandom(-150,150)), (_platform.getYLoc() - this.semiRandom(140,60)));
			_platforms.add(plat);	
			_platform = plat;
			this.keepPlatformsInPane();
			
            _gamePane.getChildren().add(_platform.getNode());
        }
        private class TimeHandler implements EventHandler <ActionEvent>{
            private double _velocity;
            private double _yPosition;
            private double _yPrevPosition;

            public void handle(ActionEvent e){
                _yPosition= _doodle.getYLoc();	
                _velocity = _velocity + (Constants.GRAVITY)*(16/1000.0);
                _yPrevPosition = _yPosition;
                _yPosition = _yPosition + _velocity*(16/1000.0);
                _doodle.setYLoc(_yPosition);
                Game.this.generatePlatforms();
                
                for (int j = 0; j < _platforms.size(); j++){
                    if (_doodle.intersects(platforms.get(j).getXLoc(), platforms.get(j).getYLoc(), Constants.PLATFORM_WIDTH,Constants.PLATFORM_HEIGHT) && (_yPrevPosition < _yPosition)){
                        _velocity = Constants.REBOUND_VELOCITY;
                    }
                    if ( doodle.getYLoc() <= 400){
                        doodle.setYLoc(400);
                        platforms.get(j).setYLoc(j);(platforms.get(j).getYLoc() - _velocity*(16/1000.0));
                        
                    }	
                }
                Game.this.gameOver();
            }
            
        }
        
        private class KeyHandler implements EventHandler <KeyEvent>{
            @Override
            public void handle(KeyEvent e){
                KeyCode KeyPressed = e.getCode();
                if (KeyPressed == KeyCode.RIGHT &&  _doodle.getXLoc() < 810){
                    _doodle.setXLoc(_doodle.getXLoc() + 15);
                } else if(KeyPressed == KeyCode.LEFT && _doodle.getXLoc() > -10){
                    _doodle.setXLoc(_doodle.getXLoc() - 15);
                } e.consume();
            }
        }
         
    }
  
}
