package ClientAndServer;


import java.net.UnknownHostException;
import java.net.Socket;
import java.io.*;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("127.0.0.1", 5000);
            System.out.println("connected to: "+echoSocket);
            
        } catch (UnknownHostException e) {
            System.err.println("Don't know host:.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for ");
            System.exit(1);
        }

        out = new PrintWriter(echoSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        System.out.println("connected");

        while ((userInput = in.readLine()) != null) {

            boolean isServerAskForInput = userInput.equals("###");
            if (isServerAskForInput) {    
                System.out.print("user> ");
                out.println(stdIn.readLine());
            }
            if(!isServerAskForInput)
                System.out.println( userInput);
        }


        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}