package mvc;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
//import javafx.collections.ObservableValue;

public class SimpleAdderModel
{
	DoubleProperty result = new SimpleDoubleProperty();
	double resultDouble = 0;
	
	public SimpleAdderModel() {
		
	}
	
	public void addition(double num1, double num2) {
		result.set(num1 + num2);	
	}


	/**
	 * @return the result
	 */
	public DoubleProperty getResult()
	{
		return result;
	}
	
	public void additionDouble(double num1, double num2) {
		this.resultDouble = num1 + num2;	
	}
	
	public double getResultDouble() {
		return resultDouble;
	}

	@Override
	public String toString()
	{
		return resultDouble + " ";
	}
	
	
	
}

