package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ParseProperties {
	private Properties pro = new Properties() ;
	String value = null ;
	
	public ParseProperties(String propertiespach){
		this.loadProperties(propertiespach) ;
	}
	
	private void loadProperties(String propertiespach){
		try{
			InputStream in = new FileInputStream(propertiespach) ;
			InputStreamReader inr = new InputStreamReader(in) ;
			BufferedReader br = new BufferedReader(inr) ;
			pro.load(br);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String getValue(String keyname){
		value = pro.getProperty(keyname).trim();
		try {
			value = new String(value.getBytes("UTF-8"),"UTF-8") ;
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return value ;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
