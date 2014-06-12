package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePDFZeb {


		 private static  BaseFont bf;
		  private static Font catFont;
		  private static Font redFont;
		  private static Font subFont;
		  private static Font smallBold;
		  public GeneratePDFZeb()
		  {
			try {
				bf  = BaseFont.createFont(BaseFont.TIMES_ROMAN,BaseFont.CP1250, BaseFont.EMBEDDED);
				catFont = new Font(bf, 18,
					      Font.BOLD);
				redFont = new Font(bf, 14,
					      Font.BOLD, BaseColor.RED);
				subFont = new Font(bf, 16,
					      Font.BOLD);
				smallBold = new Font(bf, 12,
					      Font.BOLD);	  
			} catch (DocumentException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		  }
		  
		  public void GeneratePDFZebranie(String msg)
		  {			  
			 
			  try {
				
				  final Calendar calendarDate = Calendar.getInstance();
				  
				  Date data = new Date();

				   String today = "";
				  final SimpleDateFormat format = new SimpleDateFormat("DD-MMM-yyyy");

				today=format.format(data);
				  
			      Document document = new Document();
			      PdfWriter.getInstance(document, new FileOutputStream("Zebranie_" + today+".pdf"));
			      document.open();		 
			      addTitlePage(document);
			     addContent(document,msg);
			      document.close();
			    } catch (Exception e) {
			      e.printStackTrace();
			      }
			    			  
		  }
		  private static void addTitlePage(Document document)
			      throws DocumentException {
			    Paragraph preface = new Paragraph();
			    addEmptyLine(preface, 1);	
			    preface.add(new Paragraph("Przebieg Wirtualnego Zebrania", catFont));

			    addEmptyLine(preface, 1);

			    preface.add(new Paragraph("Wygenerowano: " + new Date().toLocaleString(),
			        smallBold));	   
			    document.add(preface);
		
			    document.newPage();
			  }

			  private static void addContent(Document document,String msg) throws DocumentException {
			  
			    Paragraph preface = new Paragraph("Przebieg: ",smallBold);

			    Chapter catPart = new Chapter(preface, 1);
			    addEmptyLine(preface, 1);
	
			    preface.add(msg);
			
			    document.add(catPart);    
			

		

			  }

			 
			  private static void addEmptyLine(Paragraph paragraph, int number) {
			    for (int i = 0; i < number; i++) {
			      paragraph.add(new Paragraph(" "));
			    }
			  }


	

}
