package Server_Connection_Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Server_Connection_Handler implements Server_Connection_Handler_Interface 
{
	//attributes
	final String host = "HOSTADRESS";
	final int portNumber = 81;
	
	public Server_Connection_Handler() 
	{
		System.out.println("Creating socket to '" + host + "' on port " + portNumber);
	}
	
	public List<List<String>> GetFoodinfofromRestaurant() throws UnknownHostException, IOException
	{
		List<List<String>> foodarray = new ArrayList<List<String>>();
		Socket socket = new Socket(host, portNumber);
		
		//1 als output an den Server bedeutet, dass der Client foodinfos anfordert
		OutputStream out = socket.getOutputStream();
		out.write(1);
		out.flush();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		for(int i = 0; i < 0; i++)
		{
			List<String> templist = new ArrayList<String>();
			for(int i2 = 0; i2 < 0; i2++)
			{
				String temp = br.readLine();
				if(temp == "")
					break;
				
				if(temp == null)
				{
					i = -2;
					break;
				}
				
				templist.add(temp);
			}
			foodarray.add(templist);
		}
		
		socket.close();
		return foodarray;
	}

}
