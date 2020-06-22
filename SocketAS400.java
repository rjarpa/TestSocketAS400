




public class SocketAS400 {

	
	public SocketAS400(){
		
	}
	public final boolean testODBC(String ip) {
	    try {	    	
	    	
	    //	System.out.println("testODBC String ip:"+ip);
	    	
	    	PortScannerDomino oPS= new PortScannerDomino();
	    	

	    	if (oPS.testPort(8471, ip)){

	    		if(oPS.testPort(8476, ip)){
	    			
	    			return true;
	    		}else{
	    			System.out.println("Problema puerto 8476 server ");
	    			return false;
	    		}
	    	
	    	}else{
	    		System.out.println("Problema puerto 8471 server ");
	    		return false;
	    	}
			
			
	 
	    } catch (Exception ex) {
	       
	        return false;
	      }
	  }
	


}

