package me.cyberpew.checkr.frontend;

import java.net.InetSocketAddress;
import java.util.Scanner;

import me.cyberpew.checkr.frontend.handlers.RootHandler;
import me.cyberpew.checkr.frontend.handlers.StatusHandler;

import com.sun.net.httpserver.HttpServer;

public class HTTPServ {
	
    public static void main(String[] args) throws Exception {
    	
    	//console scanner
        Scanner reader = new Scanner(System.in);
        String command = "";
        HttpServer httpServ = null;
        Boolean listen = true;
        
        while(listen != false)
        {
            command = reader.nextLine();
	        
            if (command.equals("http start")) {
	        	System.out.println("Starting HTTP server...");
	
	        	httpServ = HttpServer.create(new InetSocketAddress(8050), 0); //bind to port
	    		httpServ.createContext("/", new RootHandler()); //set URL
	    		httpServ.createContext("/status/", new StatusHandler()); //set URL
	    		httpServ.createContext("/status", new StatusHandler()); //set URL
	    		httpServ.createContext("/status", new StatusHandler()); //set URL
	    		httpServ.setExecutor(null);
	    		httpServ.start(); //start listening
	        } else if (command.equals("http stop")) {
		    	System.out.println("Stopping HTTP server...");
		        httpServ.stop(5);
		        
		        listen = false;
		        reader.close();
		        System.exit(0);
	        }
        }
	}
	
}