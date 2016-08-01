package com.hand;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;

public class Manager {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(1234);
			Socket s = ss.accept();
			OutputStream os = s.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(os);
			FileInputStream fis = new FileInputStream(new File("../exam1/test.pdf"));
			
			byte[] a = new byte[50];
			int count = 0;
			while((count = fis.read(a))!=-1){
				bos.write(a);
				bos.flush();
			}
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
