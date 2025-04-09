package mvc;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application
{

  @Override
  public void start(Stage stage) throws Exception
  {
	  SimpleAdderModel model = new SimpleAdderModel();
	  


//    model.getGroceries().add(new GroceryItem("cat",34d));
    //model.getGroceries().add(new GroceryItem("dog",18d));
    
    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(Main.class.getResource("SimpleAdder.fxml"));

    BorderPane view = loader.load();
    
    SimpleAdderController cont = loader.getController(); 
    //ViewTransitionalModel vm = new ViewTransitionalModel(view,model);
    cont.setModel(model);
    
    
    Scene s = new Scene(view);
    stage.setScene(s);
    stage.show();
   }

  
  public static void main(String [] args)
  {
	  //System.out.println("hello there");
    launch(args);
  }
  
}
