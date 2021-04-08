package IOTePrototipagem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Date;
import java.text.Normalizer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Placa {
    public String Nome;
    public String Conexao;
    public String Cor;
    public int AnoDeLancamento;
    public int GPIO; // General Purpose Input/Output
    public String Sistema;
    public String PaisFabricacao;
    public String EstadoFabricacao;

    static HashSet<String> name = new HashSet<String>(); // se tentar adicionar duas vezes o mesmo nome, nao vai dar
                                                         // porque cada item deve ser unico no conjunto
    static HashMap<String, String> LocalFrabricacao = new HashMap<String, String>(); // setei como static para poder acessar onde
                                                                          // quiser
    static ArrayList<Object> ListaDePlaca = new ArrayList<Object>(); // adicionei static para quando quiser acessar
    // atributos e métodos
    // diretamente da definição da classe, sem precisar
    // instanciar nenhum objeto.

    public Placa() {}

    public void ExecutarConsole(String texto) {
        System.out.println(texto);
    }

    public String GetNome() {
        System.out.println("\nO nome da placa é " + this.Nome);
        return Nome;
    }

    public String GetCor() {
        System.out.println("\nA Cor da placa é " + this.Cor);
        return Cor;
    }

    public int GetGPIO() {
        System.out.println("\nA placa possui " + this.GPIO + " GPIO's");
        return GPIO;
    }

    public void Divisao() {
        System.out.println("_________________________________________________________________________________________");
    }

    public void setGPIO(int gPIO) {
        GPIO = gPIO;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    String json = "";

    public void TransformarEmJson(Object placa) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(placa);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void AdicionarPlaca(String nome, String conexao, String sistema, String cor, String paisFabricacao, String estadoFabricacao, int date, int gpio ) {

        Placa novaPlaca = new Placa();
        novaPlaca.Nome = nome;
        novaPlaca.Conexao = conexao;
        novaPlaca.Sistema = sistema;
        novaPlaca.Cor = cor;
        novaPlaca.PaisFabricacao = paisFabricacao;
        novaPlaca.EstadoFabricacao = estadoFabricacao;
        novaPlaca.PaisFabricacao = paisFabricacao;
        novaPlaca.AnoDeLancamento = date;
        novaPlaca.GPIO = gpio;

        ListaDePlaca.add(novaPlaca);
        name.add(nome);
        LocalFrabricacao.put(paisFabricacao, estadoFabricacao);

        try {
            novaPlaca.TransformarEmJson(novaPlaca);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void ListarLocais() {
        System.out.println("\n" + LocalFrabricacao);
    }

    public static String RemoverAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    public static String RemoverWhiteSpace(String str) {
        return str.replaceAll(" ", "");
    }

}
