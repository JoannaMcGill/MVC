package mvc;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


@ExtendWith(ApplicationExtension.class)
public class mvcViewTest {

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
		robot.clickOn("#calculateButton");
	}
	
	private void checkSum(FxRobot robot, String num) {
		String labelText = robot.lookup("#sum")
		        .queryAs(Label.class).getText();
//		System.out.println(labelText);
		Assertions.assertThat(labelText)
				.isEqualTo(num); 
	}
	
	private void resetNums(FxRobot robot) {
		KeyCode bs = javafx.scene.input.KeyCode.BACK_SPACE;
		
		robot.clickOn("#num1");
		String num1Text = robot.lookup("#num1")
		        .queryAs(TextField.class).getText();
		
		while (num1Text.length() > 0) {
			robot.press(bs).release(bs);
			num1Text = robot.lookup("#num1")
			        .queryAs(TextField.class).getText();
		}
		
		
		robot.clickOn("#num2");
		String num2Text = robot.lookup("#num2")
		        .queryAs(TextField.class).getText();
		
		while (num2Text.length() > 0) {
			robot.press(bs).release(bs);
			num2Text = robot.lookup("#num2")
			        .queryAs(TextField.class).getText();
		}
	}
	
	@Test
	public void testAdds(FxRobot robot) {
		enterNumbers(robot, "1", "1");
		checkSum(robot, "2.0");
		resetNums(robot);
		
		enterNumbers(robot, "2", "3");
		checkSum(robot, "5.0");
		
		enterNumbers(robot, ".4", ".5");
		checkSum(robot, "5.9");
		resetNums(robot);
		
		enterNumbers(robot, "11", "12");
		checkSum(robot, "23.0");
		resetNums(robot);
		
		enterNumbers(robot, "1001", "103743");
		checkSum(robot, "104744.0");
		resetNums(robot);
		
		enterNumbers(robot, "-12", "12");
		checkSum(robot, "0.0");
		resetNums(robot);
		
		enterNumbers(robot, "-46", "12");
		checkSum(robot, "-34.0");
//		resetNums(robot);
	}

}
