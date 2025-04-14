package mvc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class SimpleAdderController {
	SimpleAdderModel model;
	@FXML private TextField num1;
	@FXML private TextField num2;
	@FXML private Label sum;
	//@FXML private Button calculateButton;
  
   //converts text from FXML to double
   private double getAmt(TextField num) {
	   String val = num.textProperty().get();
	   double amt = 0;
	   try {
		   amt = Double.parseDouble(val);
	   } catch(NumberFormatException e) {
		   num.textProperty().set("");
	   }
	   return amt;
   }
  
   public void setModel(SimpleAdderModel newModel) {
	   model = newModel;
	   sum.textProperty().bind(model.result.asString());
	   //sum.textProperty().set(model.toString());
   }
  
   	//calculates sum
   @FXML
   void onClickCalculate(ActionEvent event) {
	   double number1 = getAmt(num1);
	   double number2 = getAmt(num2);
	   model.addition(number1,number2);
	   model.showResult();
	   //System.out.println(model.getResultDouble());
   }
}


