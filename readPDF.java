import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class readPDF {

	public static void main(String[] args) throws IOException {

		
		PDDocument doc=PDDocument.load(new File("example.pdf"));
		PDFTextStripper text=new PDFTextStripper();
		String data=text.getText(doc);
		String encData="";
		String decData="";
		
		for(int i=0;i<data.length();i++) {
			encData+=(char) (data.charAt(i)+5);
		}
		
		for(int i=0;i<encData.length();i++) {
			decData+=(char) (encData.charAt(i)-5);
		}
		
		BufferedWriter out=new BufferedWriter(new FileWriter("exampleEncrypted.txt"));
		out.write(encData);
		
		BufferedWriter out2=new BufferedWriter(new FileWriter("exampleDecrypted.txt"));
		out2.write(decData);
		
		out.close();
		out2.close();
		
		
		
	}
	
}
