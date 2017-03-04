import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.*;
import java.lang.*;

/**
 * Created by anna on /2401/17.
 */

public class KelderMain extends Application {

    Stage window;
    Scene scene1, scene2, scene3, scene4, scene5;

    public static void main(String[] args) {
        launch(args);


    }

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        Label label1 = new Label("SAVE WATER, DRINK WINE");
        label1.setTextFill(Color.RED);
        label1.setFont(Font.font ("Verdana", 30));
        Button button1 = new Button("Veinikeldrisse");
        button1.setOnAction(e -> window.setScene(scene2));

        //Layout 1 - children are laid out in vertical column
        VBox layout1 = new VBox(15);
        layout1.getChildren().addAll(label1, button1);
        layout1.setAlignment(Pos.CENTER);
        scene1 = new Scene(layout1, 600, 400);


        //Button 2
        Button lisaVeinBtn = new Button("Lisa vein");
        lisaVeinBtn.setOnAction(e -> window.setScene(scene3));

        //Button 3
        Button veiniListBtn = new Button("Olemasolevad veinid");
        veiniListBtn.setOnAction(e -> window.setScene(scene));

        //Button4
        Button WishlistBtn = new Button("Wishlist");
        WishlistBtn.setOnAction(e -> window.setScene(scene5));

        //Button5
        Button valjuBtn = new Button("Välju");
        valjuBtn.setOnAction(e -> window.close());

        //Button6
        Button tagasiBtn = new Button("Tagasi");
        tagasiBtn.setOnAction(e -> window.setScene(scene2));


        //Layout 2
        VBox layout2 = new VBox(5);
        layout2.setAlignment(Pos.CENTER);
        layout2.getChildren().addAll(lisaVeinBtn, veiniListBtn, WishlistBtn, valjuBtn);
        scene2 = new Scene(layout2, 600, 400);

        //Layout 3
        VBox layout3 = new VBox(5);
        layout3.setAlignment(Pos.CENTER);
        layout3.getChildren().addAll(tagasiBtn);
        scene3 = new Scene(layout3, 600, 400);
/*
        //Layout 4
        VBox layout4 = new VBox(5);
        layout4.getChildren().addAll(tagasiBtn);
        scene4 = new Scene(layout4, 600, 400);

        //Layout 5
        VBox layout5 = new VBox(5);
        layout5.getChildren().addAll(tagasiBtn);
        scene5 = new Scene(layout5, 600, 400);
*/
        window.setScene(scene1);
        window.setTitle("Veinikelder");
        window.show();

    }
}
