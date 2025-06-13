package utez.edu.mx.u2_ti_05_formulario;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Label lblNombre = new Label("Nombre: ");
        TextField txtNombre = new TextField();

        Label lblApellido = new Label("Apellido: ");
        TextField txtApellido = new TextField();

        Label lblEdad = new Label("Edad: ");
        TextField txtEdad = new TextField();

        Label lblTipo = new Label("Tipo: ");
        ComboBox<String> comboTipo = new ComboBox<>();
        comboTipo.getItems().addAll("Estudiante", "Profesor", "Administrador");

        Button btnCrear = new Button("Crear");
        Button btnReset = new Button("Reset");

        Label lblResultado = new Label();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(lblNombre, 0, 0);
        grid.add(txtNombre, 1, 0);
        grid.add(lblApellido, 0, 1);
        grid.add(txtApellido, 1, 1);
        grid.add(lblEdad, 0, 2);
        grid.add(txtEdad, 1, 2);
        grid.add(lblTipo, 0, 3);
        grid.add(comboTipo, 1, 3);
        grid.add(btnCrear, 0, 4);
        grid.add(btnReset, 1, 4);
        grid.add(lblResultado, 0, 5, 2, 1);


        btnCrear.setOnAction(e -> {
            String nombreTxt = txtNombre.getText();
            String apellidoTxt = txtApellido.getText();
            String edadInt = txtEdad.getText();
            String tipo = comboTipo.getValue();

            if (nombreTxt.isEmpty() || apellidoTxt.isEmpty() || edadInt.isEmpty()) {
                lblResultado.setText("Debe ingresar los campos");
                lblResultado.setStyle("-fx-text-fill: Red;");
            } else {
                grid.setStyle("-fx-background-color: green;");
                lblResultado.setStyle("-fx-background-color: lightblue; -fx-text-fill: black;");
                lblResultado.setText("Nombre: " + nombreTxt + "\nApellido: " + apellidoTxt + " \nEdad: " + edadInt + "\nTipo: " + tipo);
            }
        });

        btnReset.setOnAction(e -> {
           txtNombre.clear();
           txtApellido.clear();
           txtEdad.clear();
           grid.setStyle("");
           lblResultado.setText("");
           lblResultado.setStyle("");
        });

        Scene scene = new Scene(grid, 300, 250);
        stage.setTitle("Formulario");
        Image image = new Image(getClass().getResourceAsStream("/images/icons8-formulario-50.png"));
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();




    }

    public static void main(String[] args) {
        launch();
    }
}