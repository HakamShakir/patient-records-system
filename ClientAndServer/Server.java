package ClientAndServer;

import creating_views.*;
import login_package.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;




public class Server {
	private static int PORT=5000;
	//private static ArrayList<ClientHandler> cleints=new ArrayList<>();
	private static ExecutorService pool=Executors.newFixedThreadPool(4); //honest moment i dont fully understand this
	
    public void startConnection() throws Exception{
    	
    	try {
    	ServerSocket listener=new ServerSocket(PORT);
    	while(true) {
    		System.out.println("[SERVER] waiting for client connection....");
    		Socket client=listener.accept();
    		System.out.println("[SERVER] connected to client!!.");
    		ClientHandler clientThread= new ClientHandler(client);
    		//cleints.add(clientThread);
    		pool.execute(clientThread);
    		
    	}
    	
    	}catch (IOException e) {
            System.out.println(e.getMessage());

        }


    }

}