import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.TreeMap;

public class Main extends Application {
    public static void main(String[] args) {

//        TreeMap<String, Integer> grades = new TreeMap<>();
//        grades.put("COMP 1008", 100);
//        grades.put("MGMT 2003", 87);
//        grades.put("COMP 1030", 99);
//
//        ArrayList<String> courses = new ArrayList<>();
//        courses.add("COMP 1008");
//        courses.add("MGMT 2003");
//        courses.add("COMP 1030");
//
//        for (String courseCode: grades.keySet())
//        {
//            System.out.printf("%s --> %d %n", courseCode, grades.get(courseCode));
//        }
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("views/dashboardView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("EdMuse Dashboard");
        stage.show();
    }
}
