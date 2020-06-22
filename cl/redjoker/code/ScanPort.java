package cl.redjoker.code;


import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.ServerSocket;


public class ScanPort {

	
	public ScanPort(){
		
		
	}
	

	public final boolean testPort(int port, String ip) {
	    try {
	    	
	    	
	    	

			InetAddress address = InetAddress.getByAddress(this.translateIPtobytecode(ip));
	   	
	      ServerSocket sock = new ServerSocket(port,0,address);
	      return false;
	    } catch (java.io.IOException e) {
		      System.out.println("Port " + port + " in use. en server "+ ip);
	    	e.printStackTrace();

	      return true;
	    }
	  }
    
	
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
	

	
}
