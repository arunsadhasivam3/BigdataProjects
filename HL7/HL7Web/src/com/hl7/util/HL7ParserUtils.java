package com.hl7.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;

import com.hl7.domain.Mainroot;

/**
 * To parse Hl7 file 
 * 
 * @author Arun
 *
 */
public class HL7ParserUtils {
	
	/**
	 * variable instance to hold object instance of Parser Utils
	 */
	private static HL7ParserUtils hl7ParserUtils;
	
	private HL7ParserUtils(){
		
	}
	

   /**
    * To single instance Hl7ParserUtils to marshall
    * and unmarshall.	
    * @return
    */
   public static synchronized HL7ParserUtils getInstance(){
		if(hl7ParserUtils!=null){
			return hl7ParserUtils;
		}
		
		return new HL7ParserUtils();
	}
	
	/**
	 * To marshall pojo to xml file
	 * @param root
	 * @return
	 */
	public String marshall(Mainroot root){
		try {
			IBindingFactory bfact = BindingDirectory.getFactory(Mainroot.class);
			IMarshallingContext mctx = bfact.createMarshallingContext();
			mctx.setIndent(2);
			StringWriter stringWriter = new StringWriter();
			mctx.setOutput(stringWriter);
			mctx.marshalDocument(root, "UTF-8", null);
			String output = stringWriter.toString();
			return output;
		} catch (JiBXException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * To unmarshall xml to pojo object
	 * @param inputXml
	 * @return
	 */
	public Mainroot unMarshall(String inputXmlPath){
		Mainroot root= null;
		try {
			String inputXml= readXml(inputXmlPath);

			IBindingFactory bfact = BindingDirectory.getFactory(Mainroot.class);
			IUnmarshallingContext uctx = bfact.createUnmarshallingContext();
			StringReader stringReader = new StringReader(inputXml);
			root  = (Mainroot) uctx.unmarshalDocument(stringReader, null);
			//System.out.println("Employee ID:"+root.getClientInformation().getDatabaseId());
		} catch (JiBXException e) {
 			e.printStackTrace();
		}
		
		return root;
	}
	
	
	/**
	 * To unmarshall xml to pojo object
	 * @param inputXml
	 * @return
	 */
	public Mainroot unMarshall(InputStream is ){
		Mainroot root= null;
		try {
			String inputXml= readXml(is);

			IBindingFactory bfact = BindingDirectory.getFactory(Mainroot.class);
			IUnmarshallingContext uctx = bfact.createUnmarshallingContext();
			StringReader stringReader = new StringReader(inputXml);
			root  = (Mainroot) uctx.unmarshalDocument(stringReader, null);
			//System.out.println("Employee ID:"+root.getClientInformation().getDatabaseId());
		} catch (JiBXException e) {
 			e.printStackTrace();
		}
		
		return root;
	}
	

	/**
	 * To read xml
	 * @param is
	 * @return
	 */
	public static String readXml(InputStream is){
		BufferedReader br = null;
		StringBuffer result = new StringBuffer();
		try {
		  br = new BufferedReader(new InputStreamReader(is));
		  String line ="";
		  while((line = br.readLine())!=null){
			  result.append(line);
		  }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result.toString();
	}


	public static String readXml(String Path){
		FileInputStream fis = null;
		BufferedReader br = null;
		StringBuffer result = new StringBuffer();
		try {
		  fis = new FileInputStream(new File(Path));
		  br = new BufferedReader(new InputStreamReader(fis));
		  String line ="";
		  while((line = br.readLine())!=null){
			  result.append(line);
		  }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result.toString();
	}
	
	

}
