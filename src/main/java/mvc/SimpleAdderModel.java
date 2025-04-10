package mvc;

import java.io.IOException;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
//import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class SimpleAdderModel {
	DoubleProperty result = new SimpleDoubleProperty();
	//double resultDouble = 0;
	BorderPane mainview;
	
	public SimpleAdderModel() {}
	
	public void showResult() {
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(SimpleAdderModel.class
	        .getResource("SimpleAdder.fxml"));
	    try {
	      Pane view = loader.load();
	      SimpleAdderController cont = loader.getController();
	      cont.setModel(this);
	      
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	public void setView (BorderPane newView) {
		mainview = newView;
	}
	
	public void addition(double num1, double num2) {
		result.set(num1 + num2);
		//resultDouble = (Double) result.get();
	}

	public DoubleProperty getResult() {
		return result;
	}

//	public double getResultDouble() {
//		return resultDouble;
//	}

	@Override
	public String toString() {
		return result.get() + " ";
	}
	
}

