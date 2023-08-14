import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    // method for finding the ping statics of website
    static void commands(ArrayList<String> commandList)
            throws Exception
    {
        // creating the sub process, execute system command
        ProcessBuilder build = new ProcessBuilder(commandList);
        Process process = build.start();

        // to read the output
        BufferedReader input = new BufferedReader(new InputStreamReader
                (process.getInputStream()));
        BufferedReader Error = new BufferedReader(new InputStreamReader
                (process.getErrorStream()));
        String s = null;

        System.out.println("Standard output: ");
        while((s = input.readLine()) != null)
        {
            System.out.println(s);
        }
        System.out.println("error (if any): ");
        while((s = Error.readLine()) != null)
        {
            System.out.println(s);
        }
    }

    // Driver method
    public static void main(String args[]) throws Exception
    {

        Scanner entradaUsuario = new Scanner(System.in);
        // creating list for commands
        ArrayList<String> commandList = new ArrayList<String>();


        System.out.println("Digite um dos comandos listados abaixo:");
        System.out.println("> ping ");
        System.out.println("> tracert ");
        String comando = entradaUsuario.nextLine();

        System.out.println("Digite o ip ou endereço para um teste ICMP(ping)");
        String endereco = entradaUsuario.nextLine();


        commandList.add(comando);
        // can be replaced by IP
        commandList.add(endereco);

        Main PingWebsite = null;
        PingWebsite.commands(commandList);
    }
}