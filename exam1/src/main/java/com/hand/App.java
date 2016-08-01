package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		new ReadByGet().start();
	}
	static class ReadByGet extends Thread{

		public void run() {
			try {


				URL url = new URL("http://files.saas.hand-china.com/java/target.pdf");
				URLConnection connection = url.openConnection();
				InputStream is = connection.getInputStream();
				
				BufferedInputStream br = new BufferedInputStream(is);
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test.pdf"));
				
				byte[] a = new byte[50];
				int count = 0;
				while ((count = br.read(a))!= -1) {
					bos.write(a);
					bos.flush();
				}
				bos.close();
				br.close();
				is.close();


			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			super.run();
		}

	}
}
