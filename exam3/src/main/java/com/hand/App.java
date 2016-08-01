package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
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


				URL url = new URL("http://hq.sinajs.cn/list=sz300170");
				URLConnection connection = url.openConnection();
				InputStream is = connection.getInputStream();
			
				
				InputStreamReader br = new InputStreamReader(is);
				OutputStreamWriter bos = new OutputStreamWriter(new FileOutputStream("shuju.txt"));
				
				char[] input = new char[500];
				int count = 0;
				while ((count = br.read(input))!= -1) {
					
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
