package Figure;

public class MainFigure {
	
	public static void main(String... args) {
		
		Figure triangle = new Triangle(3, 4);
		Figure circle = new Circle(2.5);
		Figure rectangle = new Rectangle(4, 5);
		
		triangle.printInfo();
		circle.printInfo();
		rectangle.printInfo();
	}

}
