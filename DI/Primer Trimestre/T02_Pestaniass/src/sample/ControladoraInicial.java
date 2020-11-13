package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import sample.utils.Persona;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class ControladoraInicial implements Initializable {
    @FXML
    MenuItem menuBotones, menuTextos, menuTablas, menuListas;
    @FXML
    TabPane panelPestañas;
    @FXML
    RadioMenuItem menuActivar, menuDesactivar;
    @FXML
    Button botonImagen, botonCambio, botonCapturaTexto, boton_Listas, botonAgregarLista,
            botonDefectoLista, boton_agregar_tabla, boton_obtener_tabla, boton_borrar_tabla, boton_modificar_tabla,
            botonInformacion, botonError, botonWarning, botonConfirmacion, botonConfirmacionPerso, botonEntrada,
            botonEleccion, botonColor, botonFicheros;


    @FXML
    TableColumn columna_nombre, columna_apellido, columna_edad, columna_disponibilidad;
    @FXML
    TableView<PersonaTabla> tabla;

    @FXML
    RadioButton radio1, radio2, radio3, radio4;

    @FXML
    ToggleButton toggle1, toggle2;
    @FXML
    TextField textoNormal, texto_filtrar, nombre_añadir_tabla, apellido_añadir_tabla;
    @FXML
    TextArea textoArea;
    @FXML
    PasswordField textoPass;

    @FXML
    ComboBox combo_Box1, edad_añadir_tabla;
    @FXML
    ChoiceBox choice_Box1;
    @FXML
    ListView list_View1;

    ObservableList<Persona> listaChoice;
    ObservableList<Persona> listaCombo;
    ObservableList<Persona> listaListView;
    ObservableList listaEdades;

    ObservableList<PersonaTabla> listaTabla;
    FilteredList<PersonaTabla> listaFiltrada;

    @FXML
    CheckBox check1, disponibilidad_añadir_tabla;

    DropShadow sombraExterior;
    ToggleGroup grupoRadios, grupoToggles, grupoOpciones;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        personalizarMenu();
        personalizarBotones();
        personalizarListas();
        personalizarTabla();
        personalizarFormulario();
        acciones();

    }

    private void personalizarMenu() {
        //En dos lineas
        Image imagenTabBotones = new Image(getClass().getResourceAsStream("resources/botones.png"));
        menuBotones.setGraphic(new ImageView(imagenTabBotones));
        menuBotones.setAccelerator(KeyCombination.keyCombination("Ctrl+B"));
        //De una
        menuTextos.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/textos.png"))));
        menuTextos.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        menuTablas.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/tablas.png"))));
        menuTablas.setAccelerator(KeyCombination.keyCombination("Ctrl+T"));
        menuListas.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/listas.png"))));
        menuListas.setAccelerator(KeyCombination.keyCombination("Ctrl+L"));
    }

    private void personalizarFormulario() {
        edad_añadir_tabla.setItems(listaEdades);
        for (int i = 18; i < 100; i++) {
            listaEdades.add(i);
        }
    }

    private void personalizarTabla() {
        columna_nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columna_apellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        columna_edad.setCellValueFactory(new PropertyValueFactory("edad"));
        columna_disponibilidad.setCellValueFactory(new PropertyValueFactory("disponibilidad"));

        listaTabla.addAll(new PersonaTabla("Nacho", "Arroyo", 20, false));
        listaTabla.addAll(new PersonaTabla("Ernesto", "Gaspar", 20, false));
        listaTabla.addAll(new PersonaTabla("Roberto", "Reviriego", 21, false));
        listaTabla.addAll(new PersonaTabla("Victor", "Pellicer", 23, false));
        listaTabla.addAll(new PersonaTabla("Alvaro", "Ginarte", 22, false));

        //tabla.setItems(listaFiltrada);
        listaFiltrada = new FilteredList(listaTabla);
        tabla.setItems(listaFiltrada);
    }

    private void personalizarListas() {
        choice_Box1.setItems(listaChoice);
        listaChoice.addAll(new Persona("Nacho", "Arroyo", 559846), new Persona("Sergio", "Mayo", 5556));
        combo_Box1.setItems(listaCombo);
        listaCombo.addAll(new Persona("Alvaro", "Moran", 11556), new Persona("Alberto", "Royo", 558996));
        list_View1.setItems(listaListView);
        listaListView.addAll(new Persona("Lorenzo", "Carpacho", 5424556), new Persona("Gerne", "Gaspar", 5506));
    }

    private void instancias() {
        sombraExterior = new DropShadow();
        grupoRadios = new ToggleGroup();
        grupoToggles = new ToggleGroup();
        grupoOpciones = new ToggleGroup();

        listaChoice = FXCollections.observableArrayList();
        listaCombo = FXCollections.observableArrayList();
        listaListView = FXCollections.observableArrayList();
        listaTabla = FXCollections.observableArrayList();
        listaEdades = FXCollections.observableArrayList();


        asociarDatos();
        grupoRadios.getToggles().addAll(radio1, radio2, radio3, radio4);
        grupoToggles.getToggles().addAll(toggle1, toggle2);
        grupoOpciones.getToggles().addAll(menuActivar, menuDesactivar);
    }

    private void asociarDatos() {
        radio1.setUserData(new Persona("Borja", "Martin", 123213));
        radio2.setUserData(new Persona("Jose", "Martin", 123213));
        radio3.setUserData(new Persona("Roberto", "Martin", 123213));
        radio4.setUserData(new Persona("David", "Martin", 123213));
    }

    private void acciones() {

        botonImagen.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonImagen.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonCambio.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonCambio.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());

        botonImagen.setOnAction(new ManejoPulsaciones());
        boton_Listas.setOnAction(new ManejoPulsaciones());

        botonCapturaTexto.setOnAction(new ManejoPulsaciones());
        botonAgregarLista.setOnAction(new ManejoPulsaciones());
        botonDefectoLista.setOnAction(new ManejoPulsaciones());

        boton_agregar_tabla.setOnAction(new ManejoPulsaciones());
        boton_obtener_tabla.setOnAction(new ManejoPulsaciones());
        boton_borrar_tabla.setOnAction(new ManejoPulsaciones());
        boton_modificar_tabla.setOnAction(new ManejoPulsaciones());

        menuBotones.setOnAction(new ManejoPulsaciones());
        menuListas.setOnAction(new ManejoPulsaciones());
        menuTablas.setOnAction(new ManejoPulsaciones());
        menuTextos.setOnAction(new ManejoPulsaciones());

        botonInformacion.setOnAction(new ManejoPulsaciones());
        botonError.setOnAction(new ManejoPulsaciones());
        botonWarning.setOnAction(new ManejoPulsaciones());
        botonConfirmacion.setOnAction(new ManejoPulsaciones());
        botonConfirmacionPerso.setOnAction(new ManejoPulsaciones());
        botonEntrada.setOnAction(new ManejoPulsaciones());
        botonEleccion.setOnAction(new ManejoPulsaciones());
        botonColor.setOnAction(new ManejoPulsaciones());
        botonFicheros.setOnAction(new ManejoPulsaciones());

        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {
                /*System.out.println("cambio");
                System.out.println(oldValue);
                System.out.println(newValue);*/
                Persona personaRecuerada = (Persona) newValue.getUserData();
                System.out.println(personaRecuerada.getNombre());
            }
        });
        grupoToggles.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println("cambio");
            }
        });
        grupoOpciones.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (t1 == menuActivar) {
                    panelPestañas.setDisable(false);
                } else if (t1 == menuDesactivar) {
                    panelPestañas.setDisable(true);
                }
            }
        });
        check1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                //System.out.println(t1);
                botonImagen.setDisable(t1);
            }
        });
        textoNormal.addEventFilter(KeyEvent.KEY_TYPED, new ManejoTeclas());
        /*
        combo_Box1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println(listaCombo.get(t1.intValue()));
            }
        });

         */
        combo_Box1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Persona>() {
            @Override
            public void changed(ObservableValue observableValue, Persona o, Persona t1) {
                System.out.println(t1.getNombre());
            }
        });
        texto_filtrar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                String[] palabras = t1.split("");
                listaFiltrada.setPredicate(new Predicate<PersonaTabla>() {
                    @Override
                    public boolean test(PersonaTabla persona) {
                        /*
                        boolean cumple;
                        if (persona.getNombre().contains(t1)) {
                            cumple = true;
                        } else {
                            cumple = false;
                        }
                        return cumple;
                         */
                        return persona.getNombre().toLowerCase().contains(t1);
                        // filtrar por nombre y apellido
                        //return persona.getNombre().contains(palabras[0]) && persona.getApellido().contains(palabras[1]);
                    }
                });
            }
        });
        tabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PersonaTabla>() {
            @Override
            public void changed(ObservableValue<? extends PersonaTabla> observableValue, PersonaTabla oldValue, PersonaTabla newValue) {
                nombre_añadir_tabla.setText(newValue.getNombre());
                apellido_añadir_tabla.setText(newValue.getApellido());
                edad_añadir_tabla.getSelectionModel().select(newValue.getEdad() - 18);
                disponibilidad_añadir_tabla.setSelected(newValue.isDisponibilidad());
            }
        });


    }

    private void personalizarBotones() {

        Image imagenOk = new Image(getClass().getResourceAsStream("resources/button_on.png"));
        botonImagen.setGraphic(new ImageView(imagenOk));
        botonImagen.setBackground(null);
        botonCambio.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/button_ok.png"))));
        botonCambio.setText("");
        botonCambio.setBackground(null);
        //botonImagen.setEffect(sombraExterior);


    }

    class ManejoTeclas implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent keyEvent) {

        }
    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {

            // quien ha generado
            // que ha generado
            if (event.getSource() == botonImagen) {
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    botonImagen.setEffect(sombraExterior);
                } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                    botonImagen.setEffect(null);
                }
            } else if (event.getSource() == botonCambio) {
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    botonCambio.setGraphic(new ImageView
                            (new Image(getClass().getResourceAsStream("resources/button_cancel.png"))));
                    botonCambio.setEffect(sombraExterior);
                } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                    botonCambio.setGraphic(new ImageView
                            (new Image(getClass().getResourceAsStream("resources/button_ok.png"))));
                    botonCambio.setEffect(null);
                }
            }

            // que evento ha generado
            // quien lo ha hecho

        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonImagen) {
                System.out.println(grupoRadios.getSelectedToggle());
            } else if (actionEvent.getSource() == botonCapturaTexto) {

                System.out.println(textoNormal.getText());
                System.out.println(textoArea.getText());
                System.out.println(textoPass.getText());

                /*textoNormal.appendText("s");
                String numero = textoNormal.getText();

                 */
            } else if (actionEvent.getSource() == boton_Listas) {
                if (choice_Box1.getSelectionModel().getSelectedIndex() != -1 && combo_Box1.getSelectionModel().getSelectedIndex() != -1 && list_View1.getSelectionModel().getSelectedIndex() != -1) {
                    Persona personaChoice = listaChoice.get(choice_Box1.getSelectionModel().getSelectedIndex());
                    Persona personaCombo = listaCombo.get(combo_Box1.getSelectionModel().getSelectedIndex());
                    Persona personaListView = listaListView.get(list_View1.getSelectionModel().getSelectedIndex());
                    System.out.println("La persona del choice es:" + personaChoice);
                    System.out.println("La persona del combo es:" + personaCombo);
                    System.out.println("La persona de la lista es:" + personaListView);
                }

            } else if (actionEvent.getSource() == botonAgregarLista) {
                listaCombo.add(new Persona("Nueva", "Nueva", 123));
                listaListView.add(new Persona("Nueva", "Nueva", 123));
                listaChoice.add(new Persona("Nueva", "Nueva", 123));
            } else if (actionEvent.getSource() == botonDefectoLista) {
                combo_Box1.getSelectionModel().select(0);
                choice_Box1.getSelectionModel().select(0);
                list_View1.getSelectionModel().select(0);
            } else if (actionEvent.getSource() == boton_agregar_tabla) {

                if (!nombre_añadir_tabla.getText().equals("") && !apellido_añadir_tabla.getText().equals("") && edad_añadir_tabla.getSelectionModel().getSelectedIndex() != -1) {
                    PersonaTabla personaTabla = new PersonaTabla(nombre_añadir_tabla.getText(), apellido_añadir_tabla.getText(), (int) (edad_añadir_tabla.getSelectionModel().getSelectedItem()), disponibilidad_añadir_tabla.isSelected());
                    listaTabla.add(personaTabla);
                }
            } else if (actionEvent.getSource() == boton_borrar_tabla) {
                if (listaTabla.size() != 0) {
                    if (tabla.getSelectionModel().getSelectedIndex() != -1) {
                        listaTabla.remove(tabla.getSelectionModel().getSelectedIndex());
                    } else {
                        System.out.println("Porfavor seleccione algo");
                    }
                } else {
                    System.out.println("Tabla vacia");
                }

            } else if (actionEvent.getSource() == boton_obtener_tabla) {
                if (tabla.getSelectionModel().getSelectedIndex() != -1) {
                    /*
                    PersonaTabla personaTabla = listaTabla.get(tabla.getSelectionModel().getSelectedIndex());
                    System.out.println(personaTabla.getNombre());
                     */
                    PersonaTabla personaTabla = tabla.getSelectionModel().getSelectedItem();
                    System.out.println(personaTabla.getNombre());
                }
            } else if (actionEvent.getSource() == boton_modificar_tabla) {
                PersonaTabla personaTabla = tabla.getSelectionModel().getSelectedItem();
                personaTabla.setDisponibilidad(disponibilidad_añadir_tabla.isSelected());
                personaTabla.setApellido(apellido_añadir_tabla.getText());
                personaTabla.setNombre(nombre_añadir_tabla.getText());
                personaTabla.setEdad((Integer) edad_añadir_tabla.getSelectionModel().getSelectedItem());
                tabla.refresh();
            } else if (actionEvent.getSource() == menuBotones) {
                System.out.println("Pulsado menu botones");
                panelPestañas.getSelectionModel().select(0);
            } else if (actionEvent.getSource() == menuListas) {
                System.out.println("Pulsado menu listas");
                panelPestañas.getSelectionModel().select(3);
            } else if (actionEvent.getSource() == menuTablas) {
                System.out.println("Pulsado menu tablas");
                panelPestañas.getSelectionModel().select(2);
            } else if (actionEvent.getSource() == menuTextos) {
                System.out.println("Pulsado menu textos");
                panelPestañas.getSelectionModel().select(1);
            } else if (actionEvent.getSource() == botonInformacion) {
                Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
                alertInfo.setTitle("Diálogo información");
                alertInfo.setHeaderText("Cabecera de información");
                alertInfo.setContentText("Cuerpo del cuadro de diálogo");
                alertInfo.show();
            } else if (actionEvent.getSource() == botonError) {
                Alert alertInfo = new Alert(Alert.AlertType.WARNING);
                alertInfo.setTitle("Diálogo información");
                alertInfo.setHeaderText("Cabecera de información");
                alertInfo.setContentText("Cuerpo del cuadro de diálogo");
                alertInfo.show();
            } else if (actionEvent.getSource() == botonWarning) {
                Alert alertInfo = new Alert(Alert.AlertType.WARNING);
                alertInfo.setTitle("Diálogo información");
                alertInfo.setHeaderText("Cabecera de información");
                alertInfo.setContentText("Cuerpo del cuadro de diálogo");
                alertInfo.show();
            } else if (actionEvent.getSource() == botonConfirmacion) {
                Alert alertInfo = new Alert(Alert.AlertType.CONFIRMATION);
                alertInfo.setTitle("Diálogo información");
                alertInfo.setHeaderText("Cabecera de confirmacion");
                alertInfo.setContentText("Cuerpo del cuadro de diálogo");
                Optional<ButtonType> seccion = alertInfo.showAndWait();
                System.out.println(seccion);
                if (seccion.get() == ButtonType.OK) {
                    System.out.println("Has pulsado aceptar");
                } else if (seccion.get() == ButtonType.CANCEL) {
                    System.out.println("Has pulsado cancelar");
                }
            } else if (actionEvent.getSource() == botonConfirmacionPerso) {
                Alert confirmacionPerso = new Alert(Alert.AlertType.CONFIRMATION);
                confirmacionPerso.setTitle("Titulo");
                confirmacionPerso.setContentText("Contenido");
                confirmacionPerso.setHeaderText("Cabecera");
                ButtonType opcion1 = new ButtonType("Opcion1");
                ButtonType opcion2 = new ButtonType("Opcion2");
                ButtonType opcion3 = new ButtonType("Opcion3");
                ButtonType opcion4 = new ButtonType("Opcion4");

                confirmacionPerso.getButtonTypes().addAll(opcion1, opcion2, opcion3, opcion4);
                Optional<ButtonType> seccion = confirmacionPerso.showAndWait();
                if (seccion.get() == opcion1) {

                } else if (seccion.get() == opcion2) {

                } else if (seccion.get() == opcion3) {

                } else if (seccion.get() == opcion4) {

                }
            }
        }
    }
}