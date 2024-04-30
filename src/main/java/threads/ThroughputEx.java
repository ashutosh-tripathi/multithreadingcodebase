package threads;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.server.ServerCloneException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.lang.model.element.NestingKind;

import org.w3c.dom.Text;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class ThroughputEx {
	
	
	public static String inputFile="src/main/resources/war_and_peace.txt";
	public static int nothreads=4;
	
	public static void main(String[] args) throws IOException {
		String text=new String(Files.readAllBytes(Paths.get(inputFile)));
		startServer(text);
		
		
		
	}
	public static void startServer(String text) throws IOException {
		HttpServer httpServer=HttpServer.create(new InetSocketAddress(8080), 0);
		
		httpServer.createContext("/search",new WorldCountHandler(text));
		
		Executor executor=Executors.newFixedThreadPool(nothreads);
		httpServer.setExecutor(executor);
		httpServer.start();
	}
	
	public static class WorldCountHandler implements HttpHandler{
		public String text;
		
		public WorldCountHandler(String _texrtString) {
			text=_texrtString;
		}
		
		

		@Override
		public void handle(HttpExchange exchange) throws IOException {
			// TODO Auto-generated method stub
			String queryString=exchange.getRequestURI().getQuery();
			String[] kvStrings=queryString.split("=");
			String actionString=kvStrings[0];
			String wordString=kvStrings[1];
			if(!actionString.equals("word")) {
				exchange.sendResponseHeaders(400,0);
				return;
			}
			
			
			long count=countWord(wordString);
			
			
			byte[] resp=Long.toString(count).getBytes();
			exchange.sendResponseHeaders(200,0);
			OutputStream os =exchange.getResponseBody();
			os.write(resp);
			os.close();
			
			
			
			
		}
		
		
		public  long countWord(String word) {
			long count=0;
			int index=0;
			while(index>=0) {
				index=this.text.indexOf(word,index);
				if(index>=0) {
					count++;
					index++;
				}
			}
			return count;
			
		}
		
	}
	
	

}
