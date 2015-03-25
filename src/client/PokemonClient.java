package client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class PokemonClient implements Serializable{
	public final static String DEFAULT_SERVER
		= "http://pokemon-hoangle.rhcloud.com";
	private HttpURLConnection conn;
	
	private String id;
	private String name = "MissingNo";
	private String status = "No error.";
	
	public PokemonClient() {
		System.out.println("hi");
		connectToServer();
	}
	
	private void connectToServer() {
		try {
			URL u = new URL(DEFAULT_SERVER);
			URLConnection uc = u.openConnection();
			conn = (HttpURLConnection)uc;
			System.out.println("Connected to Server.");
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
			status = e.getMessage();
		}
		catch (IOException e) {
			e.printStackTrace();
			status = e.getMessage();
		}
	}
	
	public void findPokemon() {
		try {
			conn.setRequestMethod("GET");
			OutputStream out = conn.getOutputStream();
			Writer wr = new OutputStreamWriter(out);
		} 
		catch (ProtocolException e) {
			e.printStackTrace();
			status = e.getMessage();
		}
		catch (IOException e) {
			e.printStackTrace();
			status = e.getMessage();
		}
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getStatus() {
		return status;
	}
}
