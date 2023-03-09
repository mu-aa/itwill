package bookreview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class AddLineNumberExample {
	public static void main(String[] args) throws IOException {
		
		String filePath="C:\\Users\\itwill\\Desktop\\muaa\\java\\workspace\\java-3\\src\\bookreview\\AddLineNumberExample.java";
		
		BufferedReader in=new BufferedReader(new FileReader(filePath));
		OutputStreamWriter out=new OutputStreamWriter(System.out);
		
		int readByte=0;
		while(true) {
			readByte=in.read();
			if(readByte==-1) break;
			
			String readLine;
			int num=0;
			while((readLine=in.readLine())!=null) {
				System.out.println(++num+": "+readLine);
			}
		}
		in.close();
		out.close();
	}
}
