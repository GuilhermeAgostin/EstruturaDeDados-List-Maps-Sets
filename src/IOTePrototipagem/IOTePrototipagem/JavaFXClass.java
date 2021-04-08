package IOTePrototipagem;

import java.util.HashSet;

//para formatar o codigo em JAVA na IDE VSCODE deve pressionar as teclas Shift+Alt+F
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXClass extends Application { // Toda classe principal de JavaFX deve herdar de Application e
                                               // implementar o método start;

   

    @Override
    public void start(Stage palco) throws Exception {
        VBox raiz = new VBox(10);
        raiz.setAlignment(Pos.CENTER);
        raiz.setTranslateX(10);
        raiz.setTranslateY(20);

        //int gpios [] = {1,2,3,4,5,6,7,8,9,10};

        Label lblTitulo = new Label("Cadastro de uma nova placa");
        lblTitulo.setUnderline(true); // 1

        TextField txtNome = new TextField();
        HBox hbNome = new HBox(10); // 2
        hbNome.getChildren().addAll(new Label("Nome"), txtNome);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        TextField txtCor = new TextField();
        HBox hbCor = new HBox(10); // 2
        hbCor.getChildren().addAll(new Label("Cor    "), txtCor); // dei esses espaços para ficar alinhado o texto

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        TextField txtAnoDeLancamento = new TextField();
        HBox hbAnoDeLancamento = new HBox(10); // 2
        hbAnoDeLancamento.getChildren().addAll(new Label("Ano   "), txtAnoDeLancamento); // dei esses espaços para ficar alinhado o texto

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////

        TextField txtPaisFabricacao = new TextField();
        HBox hbPaisFabricacao = new HBox(10); // 2
        hbPaisFabricacao.getChildren().addAll(new Label("Pais de fabricação"), txtPaisFabricacao); // dei esses espaços para ficar alinhado o texto

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////

        TextField txtEstadoFabricacao = new TextField();
        HBox hbEstadoFabricacao = new HBox(10); // 2
        hbEstadoFabricacao.getChildren().addAll(new Label("Estado de fabricação"), txtEstadoFabricacao); // dei esses espaços para ficar alinhado o texto

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////

        TextField txtGPIO = new TextField();
        HBox hbGPIO = new HBox(10); // 2
        hbGPIO.getChildren().addAll(new Label("Quantidade de GPIO's"), txtGPIO); // dei esses espaços para ficar alinhado o texto

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////

        HBox hbSo = new HBox(20);
        ToggleButton tbBluetooth = new ToggleButton("Bluetooth"); // 3
        // tbBluetooth.setSelected(true);

        ToggleButton tbWIFI = new ToggleButton("Wi-Fi");

        ToggleButton tbBTWF = new ToggleButton("Bluetooth e Wi-Fi");

        ToggleButton tbNada = new ToggleButton("Nenhuma");

        final ToggleGroup tgSo = new ToggleGroup(); // 4

        tgSo.getToggles().addAll(tbBluetooth, tbWIFI, tbBTWF, tbNada); // 5

        hbSo.getChildren().addAll(new Label("Quais tipos de conexão essa placa fornece?"), tbBluetooth, tbWIFI, tbBTWF, tbNada);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////

         ///////////////////////////////////////////////////////////////////////////////////////////////////////////

        final ToggleGroup tgSistemaDeControle = new ToggleGroup();
        HBox hbSistemasDeControle = new HBox(10); // se eu deixar esse valor muito grande todas as seleções vão ficar
                                                  // muito longe uma da outra

        RadioButton rbMicroprocessador = new RadioButton("Microprocessador"); // 6
        // rbMicroprocessador.setSelected(true);

        RadioButton rbMicrocontrolador = new RadioButton("Microcontrolador");

        tgSistemaDeControle.getToggles().addAll(rbMicroprocessador, rbMicrocontrolador);
        hbSistemasDeControle.getChildren().addAll(new Label("Possui qual sistema de controle?"), rbMicroprocessador,
                rbMicrocontrolador);

        /*
         * final CheckBox chkFrequencia = new CheckBox("Programa todo dia?"); // 7 final
         * CheckBox chkGosto = new CheckBox("Gosta de programação?");
         * chkGosto.setAllowIndeterminate(true); // 8 chkGosto.setIndeterminate(true);
         */

        Button btnCadastrar = new Button("Cadastrar");

        btnCadastrar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent evt) {

                Placa placa = new Placa();
                ToggleButton tbSo = (ToggleButton) tgSo.getSelectedToggle(); // 9
                //ToggleButton tbTom = (ToggleButton) tgTom.getSelectedToggle(); // 9
                RadioButton rbSistema = (RadioButton) tgSistemaDeControle.getSelectedToggle();

                // boolean conexao = false;

                String nome = txtNome.getText();
                String cor = txtCor.getText();
                String conexao = tbSo.getText();
                int Data = Integer.parseInt(txtAnoDeLancamento.getText());
                String paisFabricacao = txtPaisFabricacao.getText();
                String estadoFabricacao = txtEstadoFabricacao.getText();
                int Gpio = Integer.parseInt(txtGPIO.getText());

                if (conexao == null){conexao = "Nenhuma";}

                //String Tom = tbTom.getText();

                placa.AdicionarPlaca(nome, conexao, rbSistema.getText(), cor, paisFabricacao, estadoFabricacao, Data, Gpio);

                // System.out.println("\t\tPlaca cadastrada \"" + txtNome.getText() + "\"\n");

                // Podemos não ter um SO selecionado

                System.out.print("\nTipo de conexão: ");

                System.out.println(tbSo == null ? "Não selecionado." : tbSo.getText());

                // Deve ter uma linguagem selecionada

                System.out.println("Sistema de controle: " + rbSistema.getText());
                // 10

               
                System.out.println("\n\n");
            }
        });

        Button btnListaPlaca = new Button("Lista de placas cadastradas");

        btnListaPlaca.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evt) {
                System.out.println(Placa.name + "\n");
            }
        });

       

        Button btnLocais = new Button("Locais de fabricação cadastrados");

        btnLocais.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evt) {
               Placa.ListarLocais();
            }
        });

      raiz.getChildren().addAll(lblTitulo, hbNome, hbCor, hbPaisFabricacao, hbEstadoFabricacao, hbAnoDeLancamento, hbGPIO, hbSo, hbSistemasDeControle, btnCadastrar, btnListaPlaca, btnLocais); // aqui eu
                                                                                                       // adiciono tudo
                                                                                                       // que preciso
                                                                                                       // para ser
                                                                                                       // mostrado na
                                                                                                       // interface

        Scene cena = new Scene(raiz, 650, 520); // aqui eu configuro o tamanho, com o primeiro numero eu defino a
                                                // largura e o segundo a altura
        palco.setTitle("JavaFX");
        palco.setScene(cena);
        palco.show();
    }
}
