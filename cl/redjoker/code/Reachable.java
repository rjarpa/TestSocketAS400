package cl.redjoker.code;


import java.io.*;
import java.net.*;
/**
 * Permite Detectar si existe conexion con servidores remotos
 * 
 *   Reachable oReachable=new Reachable();
 *   boolean status=oReachable.getByIP("127.0.0.1");
 *   if (status){
 *   Conectado..
 *   }else{
 *   Desconectado...
 *   }
 * @author rjarpa
 *
 */
public class Reachable {

	/**
	 * Constructor publico de la clase
	 *
	 */
	public Reachable(){
		
		
	}
	/**
	 * Permite obtener la conexion con un servidor remoto mediante una ip
	 * @param ip String que recibe una ip del servidor que se desea conectar
	 * @return	true si existe comunicacion false de no ser posible
	 */
	public boolean getByIP(String ip){
	
		try {
		
		
		InetAddress address = InetAddress.getByAddress(this.translateIPtobytecode(ip));
		/*
			address.getHostName();
	      address.getHostAddress();
	      address.isReachable(3000);
	      */
	      /*System.out.println("Name: " + address.getHostName());
	       System.out.println("Addr: " + address.getHostAddress());
	         System.out.println("Reach: " + address.isReachable(6000));
	       */
	       return address.isReachable(3000);
	      
	       
		 }
	     catch (UnknownHostException e) {
	       System.err.println("Unable to lookup"+ip);
	       return false;
	     }
	     catch (IOException e) {
	         System.err.println("Unable to reach "+ip);
	         return false;
	       }
	}
	
	
	/**
	 * Permite obtener la conexion con un servidor remoto mediante una ip
	 * @param name String que recibe el nombre del servidor que se desea conectar 
	 * @return	true si existe comunicacion false de no ser posible
	 */
	public boolean getByName(String name){
		
		try {
		
		
		InetAddress address = InetAddress.getByName(name);
		
		return address.isReachable(3000);
		     
		 }
	     catch (UnknownHostException e) {
	       System.err.println("Unable to lookup "+name);
	       return false;
	     }
	     catch (IOException e) {
	         System.err.println("Unable to reach "+name);
	         return false;
	       }
	}
	/**
	 * Permite traducir una direccion ip standar en formato de byte utilizada por el objeto
	 * InetAddress
	 * @param ip direccion ip standar que se solicita traducir
	 * @return	 un arreglo de tipo byte con la direccion ip traducida.
	 */
	private final byte[] translateIPtobytecode(String ip){
		try{
			
			String [] arrayValues=ip.split("[.]");
			
			byte [] uBytes= new byte[arrayValues.length];
			uBytes[0]=(byte)Integer.parseInt(arrayValues[0]);
			uBytes[1]=(byte)Integer.parseInt(arrayValues[1]);
			uBytes[2]=(byte)Integer.parseInt(arrayValues[2]);
			uBytes[3]=(byte)Integer.parseInt(arrayValues[3]);
			return uBytes;
			
			
		}catch(Exception ex){
			ex.printStackTrace();
			return  null;
		}
		
	}

	
	private final void oldcode(){
	try{
		/*
		 System.out.println("Name: " + address.getHostName());
	       System.out.println("Addr: " + address.getHostAddress());
	       System.out.println("Reach: " + address.isReachable(3000));
	       
		System.out.print("InetAddress.getLocalHost():"+InetAddress.getLocalHost());
		*/
		InetAddress iAddr = InetAddress.getLocalHost(); 
		StringBuffer addrStr = new StringBuffer(); 
		 byte[] bytes = iAddr.getAddress();
		
		 for(int cnt = 0; cnt < bytes.length; cnt++){ 
		   int uByte = bytes[cnt] < 0 ? bytes[cnt] + 256 : bytes[cnt]; 
		   addrStr.append(uByte); 
		   if(cnt < 3) 
		     addrStr.append('.'); 
		 } 
		System.out.println("Local Machine IP : "+addrStr.toString());
 		System.out.print("bytes :"+bytes);
		this.translateIPtobytecode(addrStr.toString());
		
	}	catch(Exception ex){
		ex.printStackTrace();
		
	}
	}
}

