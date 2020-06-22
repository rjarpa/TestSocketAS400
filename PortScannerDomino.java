


import java.net.*;
import java.io.IOException;


public class PortScannerDomino {

	
	public PortScannerDomino(){
		
	}
	
	
	
	public final boolean testPort(int port, String ip) {
	    try {	    	
	    	
	    	System.out.println("Test ip: " + ip);
	    	
	    	InetAddress address;
	    	if (this.isIPCode(ip)==true){
			address = InetAddress.getByAddress(this.translateIPtobytecode(ip));
	    }else{
	    	address = InetAddress.getByName(ip);
	    } 	
	    	System.out.println("Host Address:"+address.getHostAddress());
			return this.scan(port,address);
	 
	    } catch (UnknownHostException ex) {
	        System.err.println(ip + " is not a valid host name.");
	        return false;
	      }
	  }
    
	public final boolean testPortName(int port, String name) {
	    try {	    	
	    	

			InetAddress address = InetAddress.getByName(name);
	   	
			return this.scan(port,address);
	 
	    } catch (UnknownHostException ex) {
	        System.err.println(name + " is not a valid host name.");
	        return false;
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
	
	private final boolean isIPCode(String ip){
		try{
			
			String [] arrayValues=ip.split("[.]");
			
			byte [] uBytes= new byte[arrayValues.length];
			uBytes[0]=(byte)Integer.parseInt(arrayValues[0]);
			uBytes[1]=(byte)Integer.parseInt(arrayValues[1]);
			uBytes[2]=(byte)Integer.parseInt(arrayValues[2]);
			uBytes[3]=(byte)Integer.parseInt(arrayValues[3]);
			return true;
			
			
		}catch(Exception ex){
			//ex.printStackTrace();
			return  false;
		}
		
	}
	
	/*
  public static void main(String[] args) {

    for (int i = 0; i < args.length; i++) {
      try {
        InetAddress ia = InetAddress.getByName(args[i]);
        scan(ia);
      }
      catch (UnknownHostException ex) {
        System.err.println(args[i] + " is not a valid host name.");
      }
    }

  }
*/
  public  void scan(InetAddress remote) {

    // Do I need to synchronize remote?
    // What happens if someone changes it while this method
    // is running?

    String hostname = remote.getHostName();
    System.out.print("hostname:"+hostname);
    for (int port = 0; port < 65536; port++) {
      try {
    	  System.out.println("Scaneado el puerto " + port);
    		         
        Socket s = new Socket(remote, port); 
        System.out.println("A server is listening on port " + port
         + " of " + hostname);
        s.close();
      }
      catch (IOException ex) {
        // The remote host is not listening on this port
      }
    }

  }

  
  public  boolean scan(int port,InetAddress remote) {

	    // Do I need to synchronize remote?
	    // What happens if someone changes it while this method
	    // is running?

	    String hostname = remote.getHostName();
	    System.out.println("hostname:"+hostname);
	   
	      try {
	    	  System.out.println("Scaneado el puerto " + port);
	    		         
	        Socket s = new Socket(remote, port); 
	        System.out.println("A server is listening on port " + port
	         + " of " + hostname);
	        
	        s.close();
	        return true;
	      }
	      catch (IOException ex) {
	    	  return false;
	        // The remote host is not listening on this port
	      }
	    

	  }
  public void scan(String remote) throws UnknownHostException {

    // Why throw the UnknownHostException? Why not catch it like I did
    // in the main() method?
    InetAddress ia = InetAddress.getByName(remote);
    scan(ia);

  }

}

