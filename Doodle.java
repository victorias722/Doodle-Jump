import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Doodle {
	private Rectangle rect;
	
	public Doodle(double x, double y){
		rect = new Rectangle(Constants.DOODLE_WIDTH, Constants.DOODLE_HEIGHT, Color.BLUE);
		rect.setY(y);
		rect.setX(x);
	}
	
	public double getXLoc(){
		return rect.getX();
	}

	public double getYLoc(){
		return rect.getY();
	}

	public void setXLoc(double h){
		rect.setX(h);
	}

	public void setYLoc(double v){
		rect.setY(v);
	}
	
	public boolean intersects(double x, double y, double w, double z){
		return rect.intersects(x,y,w,z);
	}

	public Node getNode(){
		return rect;
	}
}
