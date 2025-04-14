package mvc;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.Start;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

class mvcViewTest {

	@Start
	private void start(Stage stage) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(SimpleAdderModel.class
		        .getResource("SimpleAdder.fxml"));
		try {
			Pane view = loader.load();
		    SimpleAdderController cont = loader.getController();
		    cont.setModel(new SimpleAdderModel());
		      
		    Scene s = new Scene(view);
		    stage.setScene(s);
		    stage.show();
		      
		} catch (IOException e) {
		      e.printStackTrace();
		}
	}

	private void enterNumbers(FxRobot robot, String num1, String num2) {
		robot.clickOn("#num1");
		robot.write(num1);
		robot.clickOn("#num2");
		robot.write(num2);
		robot.clickOn("calculateButton");
	}
	
	@Test
	public void testAdds(FxRobot robot) {
		
	}

}
