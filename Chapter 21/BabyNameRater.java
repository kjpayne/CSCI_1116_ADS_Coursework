/*
 * Author: Kaden Payne
 * Date: 9/21/2020
 * 
 * Checking the rating of baby names by year and gender
 */
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 *
 * @author kjpay
 */
public class BabyNameRater extends Application {
    //Map arrays for baby names
    private Map<String, Integer>[] mapForBoy = new HashMap[10];
    private Map<String, Integer>[] mapForGirl = new HashMap[10];
    
    //Button, ComboBoxes, TextField, and Label for find name rating
    private Button btFindRanking = new Button("Find Ranking");
    private ComboBox<Integer> cboYear = new ComboBox<>();
    private ComboBox<String> cboGender = new ComboBox<>();
    private TextField tfName = new TextField();
    private Label lblResult = new Label();
    private URL url;
    private Scanner input;
    
    @Override
    public void start(Stage primaryStage) {
        //Creating GridPane for selecting year, gender, and entering name
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Select a year:"), 0, 0);
        gridPane.add(new Label("Boy or girl?"), 0, 1);
        gridPane.add(new Label("Enter a name:"), 0, 2);
        gridPane.add(cboYear, 1, 0);
        gridPane.add(cboGender, 1, 1);
        gridPane.add(tfName, 1, 2);
        gridPane.add(btFindRanking, 1, 3);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
        //Creating BorderBox with GridPane and Label in it
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(lblResult);
        BorderPane.setAlignment(lblResult, Pos.CENTER);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 370, 160);
        primaryStage.setTitle("Baby Name Rater");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //Setting values for ComboBoxes
        for (int year = 2001; year <= 2010; year++) {
            cboYear.getItems().add(year);
        }
        cboYear.setValue(2001);
        
        cboGender.getItems().addAll("Male", "Female");
        cboGender.setValue("Male");
        
        try {
            for (int i = 0; i <= 9; i++) {
                url = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking" + (2001 + i) + ".txt");
                input = new Scanner(url.openStream());
                
                mapForBoy[i] = new HashMap<>();
                mapForGirl[i] = new HashMap<>();
                while (input.hasNext()) {
                    int rank = input.nextInt();
                    String nameBoy = input.next();
                    input.nextInt();
                    String nameGirl = input.next();
                    input.nextInt();
                    
                    mapForBoy[i].put(nameBoy, rank);
                    mapForGirl[i].put(nameGirl, rank);
                }
            }   
            } catch (MalformedURLException ex) {
                System.out.println("Error with URL");
            } catch (IOException ex) {
                System.out.println("Error with the input/output");
            }
        
        //Setting EventAction to btFindRanking
        btFindRanking.setOnAction(e -> {
            int year = cboYear.getValue();
            String gender;
            if (cboGender.getValue().equals("Male")) {
                gender = "boy";
            }
            else {
                gender = "girl";
            }
            String name = tfName.getText().trim();
            if (gender.equals("boy")) {
                if (mapForBoy[year - 2001].containsKey(name)) {
                    lblResult.setText("The " + gender + " name " + name + " is rank #" + mapForBoy[year - 2001].get(name) + " in the year " + year);
                }
                else {
                    lblResult.setText("The " + gender + " name " + name + " is not ranked in the year " + year);
                }
            }
            else {
                if (mapForGirl[year - 2001].containsKey(name)) {
                    lblResult.setText("The " + gender + " name " + name + " is rank #" + mapForGirl[year - 2001].get(name) + " in the year " + year);
                }
                else {
                    lblResult.setText("The " + gender + " name " + name + " is not ranked in the year " + year);
                }
            }
        });
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
