package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    TableView<Vein> tabel;
    TextField lisaVein, lisaAasta, lisaHind, lisaHinne;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
        window.setTitle("Veinikelder");

        //veini nimi
        TableColumn<Vein, String> veiniNimi = new TableColumn<>("Veini nimi");
        veiniNimi.setMinWidth(250);
        veiniNimi.setCellValueFactory(new PropertyValueFactory<Vein, String>("vein"));

        //aastakäik
        TableColumn<Vein, Integer> veiniAasta = new TableColumn<>("Aastakäik");
        veiniAasta.setMinWidth(50);
        veiniAasta.setCellValueFactory(new PropertyValueFactory<Vein, Integer>("aasta"));

        //veini hind
        TableColumn<Vein, Double> veiniHind = new TableColumn<>("Veini hind");
        veiniHind.setMinWidth(50);
        veiniHind.setCellValueFactory(new PropertyValueFactory<Vein, Double>("hind"));

        //veini hinne
        TableColumn<Vein, Double> veiniHinne = new TableColumn<>("Veini hinne");
        veiniHinne.setMinWidth(50);
        veiniHinne.setCellValueFactory(new PropertyValueFactory<Vein, Double>("hinne"));

        //Veini sisestamine
        lisaVein = new TextField();
        lisaVein.setPromptText("Veini nimi");
        lisaVein.setMinWidth(200);

        //aasta sisestamine
        lisaAasta = new TextField();
        lisaAasta.setPromptText("Aastakäik");
        lisaAasta.setMinWidth(50);

        //hinna sisestamine
        lisaHind = new TextField();
        lisaHind.setPromptText("Hind");
        lisaHind.setMinWidth(50);

        //hinde sisestamine
        lisaHinne = new TextField();
        lisaHinne.setPromptText("Hinne");
        lisaHinne.setMinWidth(50);

        //lisa ja kustuta nupud
        Button lisaBtn = new Button("Lisa");
        lisaBtn.setOnAction(e -> lisaBtnClicked());
        Button kustutaBtn = new Button("Kustuta");
        kustutaBtn.setOnAction(e -> kustutaBtnClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(lisaVein, lisaAasta, lisaHind, lisaHinne, lisaBtn, kustutaBtn);


        tabel = new TableView<>();
        tabel.setItems(naitalisti());
        tabel.getColumns().addAll(veiniNimi, veiniAasta, veiniHind, veiniHinne);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(tabel, hBox);

        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.show();
    }

    //Lisa nupp vajutatud
    public void lisaBtnClicked(){
        Vein vein = new Vein();
        vein.setVein((lisaVein.getText()));
        vein.setAasta(Integer.parseInt(lisaAasta.getText()));
        vein.setHind(Double.parseDouble(lisaHind.getText()));
        vein.setHinne(Double.parseDouble(lisaHinne.getText()));
        tabel.getItems().addAll(vein);
        lisaVein.clear();
        lisaAasta.clear();
        lisaHind.clear();
        lisaHinne.clear();
    }

    //Kustuta nupp vajutatud
    public void kustutaBtnClicked(){
        ObservableList<Vein> valitudVein, kõikVeinid;
        kõikVeinid = tabel.getItems();
        valitudVein = tabel.getSelectionModel().getSelectedItems();

        valitudVein.forEach(kõikVeinid::remove);
    }

    //Veinide kuvamine
    public ObservableList<Vein> naitalisti() {
        ObservableList<Vein> veinid = FXCollections.observableArrayList();
        veinid.add(new Vein("Barbera d'Alba Soprano", 2011, 37.50, 5));
        veinid.add(new Vein("Barolo Leon Riserva", 2009, 34.00, 3.5));
        return veinid;
    }

}
