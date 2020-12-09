/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nawara;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Mohamed Bousselmi
 */
public class Nawara extends Application{

    /**
     * @param args the command line arguments
     */
    
     private Stage primaryStage;
      @Override
    public void start(Stage primaryStage){
     
       try{
           MyConnection cnx = MyConnection.getInstance();
           
        this.primaryStage=primaryStage;
      this.primaryStage.setTitle("Nawara");
      Parent parentPage = FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));
      Scene scene = new Scene (parentPage);
      this.primaryStage.setScene(scene);
      this.primaryStage.show();
       }catch (Exception e){
           e.printStackTrace();
       }
       
    }
    public static void main(String[] args) {
        // TODO code application logic here
         launch(args);
    }
    
}
