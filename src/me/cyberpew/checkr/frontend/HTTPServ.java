package me.cyberpew.checkr.frontend;

import java.net.InetSocketAddress;

import me.cyberpew.checkr.frontend.handlers.RootHandler;
import me.cyberpew.checkr.frontend.handlers.StatusHandler;

import com.sun.net.httpserver.HttpServer;

public class HTTPServ {
	public static void main(String[] args) throws Exception {
		HttpServer httpServ = HttpServer.create(new InetSocketAddress(8050), 0); //bind to port
		httpServ.createContext("/", new RootHandler()); //set URL
		httpServ.createContext("/status/", new StatusHandler()); //set URL
		httpServ.createContext("/status", new StatusHandler()); //set URL
		httpServ.setExecutor(null);
		httpServ.start(); //start listening
	}
}