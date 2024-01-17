import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;


public class readDocx {

	public static void main(String[] args) throws IOException {
		FileInputStream inputStream = new FileInputStream("example.docx");
		XWPFDocument docx=new XWPFDocument(inputStream);
		List<XWPFParagraph> paragraphList = docx.getParagraphs();
		String data="";
		
		for(XWPFParagraph paragraph : paragraphList ) {
			data+=paragraph.getText();
		}
		
		String encData="";
		String decData="";
		
		for(int i=0;i<data.length();i++) {
			encData+=(char) (data.charAt(i)+5);
		}
		
		for(int i=0;i<encData.length();i++) {
			decData+=(char) (encData.charAt(i)-5);
		}
		
		BufferedWriter out=new BufferedWriter(new FileWriter("docxEncrypted.txt"));
		out.write(encData);
		
		BufferedWriter out2=new BufferedWriter(new FileWriter("docxDecrypted.txt"));
		out2.write(decData);
		
		out.close();
		out2.close();
		docx.close();
	}

}
