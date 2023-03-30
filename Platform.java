import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Platform {
    private Rectangle rect;
    
    public Platform(double x, double y){
        rect = new Rectangle(Constants.PLATFORM_WIDTH,Constants.PLATFORM_HEIGHT,Color.RED);
        rect.setX(x);
        rect.setY(y);
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
    public Node getNode(){
		return rect;
	}
	
}
