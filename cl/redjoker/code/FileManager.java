package cl.redjoker.code;



import java.io.*;

public class FileManager {
	
	private RandomAccessFile file;
	private String iofilepath;
	public static String READONLY="r";
	public static String READWRITE="rw";
	
	
 public FileManager(){
 	}
 
 /**
  * Lee una de las lineas del archivo
  * */
 public String ReadFile(){
	try{
	
	
	String strTextRow=file.readLine();
	
	int cont=0;
	cont++;
	
	return strTextRow;
	}catch(Exception ex){
		
		System.out.println(ex);
		return null;
		}
 }
 
 /**
  * Abre el archivo de texto
  * */
 public boolean OpenFile(String filepath, String modeOpen ){
	try{
		
		 iofilepath=filepath;
	file = new RandomAccessFile(filepath, modeOpen);
	
	return true;
}catch(Exception ex){
		//System.out.println(ex);
		return  false;
		}
 }
 
 /**
  * Cierra el archivo de texto
  * */
 public boolean closeFile(){
	try{
		
		 
	this.file.close();
	
	return true;
}catch(Exception ex){
		//System.out.println(ex);
		return  false;
		}
 }
 
 
 /**
  * Cierra el archivo de texto
  * */
 public boolean appendTextFile(String text){
	try{
		
		 
	this.file.writeBytes(text.trim());
	
	return true;
}catch(Exception ex){
		//System.out.println(ex);
		return  false;
		}
 }
 

  /**
   * Extrae el nombre de usuario de una linea de texto del archivo
   * 
   * */
/*
 private String getUserName(String strTextRow){
 	
 	if (strTextRow!=null){
 	int len = strTextRow.length();
 	strTextRow= strTextRow.substring(77,len);
 	return strTextRow;}else{
 		return null;
 		}
 	
 	
 	
 	}
	
 */


 
}
