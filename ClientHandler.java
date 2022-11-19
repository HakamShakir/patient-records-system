package ClientAndServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.ParseException;
import java.util.Scanner;

import login_package.LogIn;

public class ClientHandler implements Runnable {

	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	
	public ClientHandler(Socket clientSocket ) throws IOException {
		this.client=clientSocket;
		in=new BufferedReader(new InputStreamReader(client.getInputStream()));
		out=new PrintWriter(client.getOutputStream(),true);
	}
	
	
	@Override
	public void run() {

        try {
        	
        	//Scanner input = new Scanner(System.in);    	

    		while(true) {
    			out.println(
    			"press depending on your position \n" +
    			"-------Enter 1 for management login---------- \n" +
    			"-------Enter 2 for Dr login------- \n"+
    			"-------Enter 3 for Receptionist login------- \n"+
    			"if you want to exit this program please enter 0: \n");
    			
				out.println("###");
    			int options = Integer.parseInt(in.readLine());
    	
    			switch(options){
    				
    			
    			case 1 :
    				LogIn.HospitalManagementsView(out,in);     
    				break;
    				
    			case 2:
    				LogIn.DrsLogin(out,in);     
    				break;
    				
    			case 3 :
    				LogIn.receptionistLogin(out,in);     
    				break;
    		       
    			case 0:
    				System.exit(0);
    				break;
    				
    			default:
    				out.println("please enter a valid option.");
            
    			}
    		}
    	
        } catch (IOException e) {
            System.out.println(e.getMessage());

        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
			e.printStackTrace();
		}

	}

}
