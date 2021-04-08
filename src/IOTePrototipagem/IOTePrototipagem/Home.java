package IOTePrototipagem;

public class Home extends JavaFXClass  
{
    
    public static void main(String[] args)  
    {
        String[] Placas = new String [4];

        Placa PrimeiraPlaca = new Placa();
        PrimeiraPlaca.setNome("ArduinoUno");
        PrimeiraPlaca.Cor = "Azul";
        PrimeiraPlaca.GetNome();
        PrimeiraPlaca.GetCor();
        
        PrimeiraPlaca.GetGPIO();

        Placas[0] = PrimeiraPlaca.Nome;

        PrimeiraPlaca.Divisao();

        Placa SegundaPlaca = new Placa();
        SegundaPlaca.setNome("RaspberryPi3");
        SegundaPlaca.Cor = "Verde";
        SegundaPlaca.GetNome();
        SegundaPlaca.GetCor();
       
        Placas[1] = SegundaPlaca.Nome;

        Placa TerceiraPlaca = new Placa();
        TerceiraPlaca.setNome("SipeedMaixBit");
        TerceiraPlaca.Cor = "Preto";
        TerceiraPlaca.GetNome();
        TerceiraPlaca.GetCor();
        TerceiraPlaca.GetGPIO();
        TerceiraPlaca.Divisao();

        Placas[2] = TerceiraPlaca.Nome;

        Placa QuartaPlaca = new Placa();

        QuartaPlaca.setNome("Esp32");
        QuartaPlaca.Cor = "Preto";
        QuartaPlaca.GetNome();
        QuartaPlaca.GetCor();
        QuartaPlaca.GetGPIO();
        QuartaPlaca.Divisao();

        Placas[3] = QuartaPlaca.Nome;

        System.out.println("\nForam inseridas as placas: \n");

        for (String i : Placas) 
        {
            System.out.println(i + "\n");
        }

        JavaFXClass.launch();    
    }  
}
