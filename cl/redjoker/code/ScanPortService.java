package cl.redjoker.code;


import PortScannerDomino;
import cl.ciisa.smc.base_datos.MonitoreoCfg;
import cl.ciisa.smc.base_datos.MonitoreoCfgCollection;
import cl.ciisa.smc.base_datos.Servidor;
import cl.ciisa.smc.base_datos.ServidorCollection;




public class ScanPortService {

	
	public static int main(String[] args) {
	try{
		
		
		ServidorCollection tmpSCol=new ServidorCollection();
		tmpSCol.fillCollectionServer();
		Servidor server= tmpSCol.getFirst();
		String ServerName, ServerIP, ServerID;
		
		
		
		while(server!=null){
			
			ServerName = server.getNombre();
			ServerIP   = server.getIP(); 
			
			
			MonitoreoCfgCollection monitor= new MonitoreoCfgCollection();
			 monitor.fillCollectionMonitoreoCfg();
			 MonitoreoCfg moni=monitor.getFirst();
			 String monidservidor, monidservicio;
			while(moni!=null){
				
			monidservidor = moni.getNombrea();
			if(ServerName.equalsIgnoreCase(monidservidor)){ 
				

				PortScannerDomino scan= new PortScannerDomino();
				
				
				//System.out.println("192.168.0.102:"+scan.testPort(8080, "192.168.0.102"));
				boolean statusService=scan.testPort(Integer.parseInt(moni.getPort()), server.getIP());
				//this.verStatus(statusService);
				
				
				
				
				String base="c:\\LogSMC";
				java.util.Calendar cal = java.util.Calendar.getInstance(java.util.TimeZone.getDefault());

			java.util.Date jdt=cal.getTime();
			
			    String Stringfecha=String.valueOf(jdt.getYear()+1900)+String.valueOf(jdt.getMonth()+1)+String.valueOf(jdt.getDate())+String.valueOf(jdt.getHours())+String.valueOf(jdt.getMinutes())+String.valueOf(jdt.getSeconds());
			    String DATE_FORMAT = "yyyy_MM_dd HHmmss";
			    java.text.SimpleDateFormat sdf = 
			          new java.text.SimpleDateFormat(DATE_FORMAT);

			    FileManager oFile=new FileManager();
				
				//oFile.OpenFile(System.getenv("TEMP")+"\\"+IDAutorizacion+".txt", FileManager.READWRITE);
				
				String filename = base+"\\SMCService"+Stringfecha+".log";
				oFile.OpenFile(filename, FileManager.READWRITE);
				
				
				
				if(statusService) {
					
					
					//System.out.print("strRequest:#"+strRequest+"#");
					
					
				
					
					oFile.appendTextFile(Stringfecha+":Servicio arriba.");
					oFile.closeFile();
				
					
				}else{
				
					oFile.appendTextFile(Stringfecha+":Servicio abajo.");
					oFile.closeFile();
					MailSender ms = new MailSender(); 
					System.out.print("**********Envio de Mail*******************");

					boolean result = ms.send("www.integralcarehome.cl","smc@integralcarehome.cl", 
							"smc@integralcarehome.cl","", "" , 
							"Monitor Servicio SMC", false, new StringBuffer("El Servicio se encuentra abajo."),true); 

					System.out.print("Resultado del envío del mensaje : " + result);
					
					
				
				}
				
				
				
			}
			
			
				moni=monitor.getNext();
				
			
			}
			monitor.close();
			
			
			
			
			
			
			server=tmpSCol.getNext();
		}
		
		
		
		
		//System.out.println("192.168.0.102:"+scan.testPort(8080, "192.168.0.102"));
		
		//System.out.print("192.168.0.102:"+scan.testPort(80, "127.0.0.1"));
		//System.out.print("192.168.0.101:"+scan.testPort(80, "192.168.0.101"));
		
		
		
		/*
		 
		 boolean result = ms.send("mail.idcsi.cl","tuhermanalochuparico@chupalo.cl", 
		"gabrielcalderon.a@gmail.com","", "" , 
		"mail de prueba de SMC", false, new StringBuffer("chupalo"),true); 
		*/
		
		 

		
		
		return 1;
	}catch(Exception ex){
		ex.printStackTrace();
		return 0;
	}
	
}

	
	public static boolean verStatus(boolean statusService){
		
		String base="c:\\LogSMC";
		java.util.Calendar cal = java.util.Calendar.getInstance(java.util.TimeZone.getDefault());

	java.util.Date jdt=cal.getTime();
	
	    String Stringfecha=String.valueOf(jdt.getYear()+1900)+String.valueOf(jdt.getMonth()+1)+String.valueOf(jdt.getDate())+String.valueOf(jdt.getHours())+String.valueOf(jdt.getMinutes())+String.valueOf(jdt.getSeconds());
	    String DATE_FORMAT = "yyyy_MM_dd HHmmss";
	    java.text.SimpleDateFormat sdf = 
	          new java.text.SimpleDateFormat(DATE_FORMAT);

	    FileManager oFile=new FileManager();
		
		//oFile.OpenFile(System.getenv("TEMP")+"\\"+IDAutorizacion+".txt", FileManager.READWRITE);
		
		String filename = base+"\\SMCService"+Stringfecha+".log";
		oFile.OpenFile(filename, FileManager.READWRITE);
		
		
		
		if(statusService) {
			
			
			//System.out.print("strRequest:#"+strRequest+"#");
			
			
		
			
			oFile.appendTextFile(Stringfecha+":Servicio arriba.");
			oFile.closeFile();
		
			
		}else{
		
			oFile.appendTextFile(Stringfecha+":Servicio abajo.");
			oFile.closeFile();
			MailSender ms = new MailSender(); 
			System.out.print("**********Envio de Mail*******************");

			boolean result = ms.send("www.integralcarehome.cl","smc@integralcarehome.cl", 
					"smc@integralcarehome.cl","", "" , 
					"Monitor Servicio SMC", false, new StringBuffer("El Servicio se encuentra abajo."),true); 

			System.out.print("Resultado del envío del mensaje : " + result);
			
			
		
		}
		
		
		return true;
	}
	
}