package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import model.SchoolClass;
import model.Student;
import model.StudentNote;
import model.SubjectMark;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePDF {

	 private static  BaseFont bf;
	  private static Font catFont;
	  private static Font redFont;
	  private static Font subFont;
	  private static Font smallBold;
	  public GeneratePDF()
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
	  public void GeneratePDFClass(SchoolClass schoolClass)
	  {
		  Iterator it = schoolClass.getStudents().iterator();
		 while(it.hasNext())
		 {
			  Student student = (Student) it.next();
		 
		  try {
		      Document document = new Document();
		      boolean success = ( new File( student.getSchoolClass().getName())).mkdir(); 
		      PdfWriter.getInstance(document, new FileOutputStream(student.getSchoolClass().getName()+"/"+student.getLastName()+"_"+student.getFirstName()+".pdf"));
		      document.open();		 
		      addTitlePage(document,student,schoolClass);
		     addContent(document,student);
		      document.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		  }
	  }
	  private static void addTitlePage(Document document,Student student,SchoolClass schoolClass)
		      throws DocumentException {
		    Paragraph preface = new Paragraph();
		    addEmptyLine(preface, 1);	
		    preface.add(new Paragraph("Oceny ucznia "+student.getFirstName()+" "+student.getLastName(), catFont));

		    addEmptyLine(preface, 1);

		    preface.add(new Paragraph("Wygenerowano przez:  " + schoolClass.getTeacher().getLastName() + " " + schoolClass.getTeacher().getFirstName() + ", " + new Date().toLocaleString(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		        smallBold));	   
		    document.add(preface);
	
		    document.newPage();
		  }

		  private static void addContent(Document document,Student student) throws DocumentException {
		    Anchor anchor = new Anchor("Oceny", catFont);
		    anchor.setName("Oceny");
		    Paragraph preface = new Paragraph(anchor);

		    Chapter catPart = new Chapter(preface, 1);
		    addEmptyLine(preface, 1);
		    createTable(catPart,student);
		    document.add(catPart);
		    
		 // Next section
		    anchor = new Anchor("Uwagi", catFont);
		    anchor.setName("Uwagi");
		    preface = new Paragraph(anchor);
		    catPart = new Chapter(preface, 2);
		    addEmptyLine(preface, 1);
		    createTableNotes(catPart,student);
		    document.add(catPart);

	

		  }

		  private static void createTable(Section subCatPart,Student student)
		      throws BadElementException {
		    PdfPTable table = new PdfPTable(5);

		    
		    PdfPCell c1 = new PdfPCell(new Phrase("Przedmiot"));
		    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    table.addCell(c1);

		    c1 = new PdfPCell(new Phrase("Ocena"));
		    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    table.addCell(c1);

		    c1 = new PdfPCell(new Phrase("Waga"));
		    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    table.addCell(c1);
		    
		    c1 = new PdfPCell(new Phrase("Data"));
		    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    table.addCell(c1);
		    
		    c1 = new PdfPCell(new Phrase("Opis"));
		    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    table.addCell(c1);
		    
		    Iterator it = student.getSubjectMarks().iterator();		   
		    while(it.hasNext())
	
		    {		
		    	SubjectMark temp = (SubjectMark)it.next();
		    table.addCell(temp.getSubject().getName());
		    
		    if(temp.getValue() != 1.0)
		    {
		    c1 = new PdfPCell(new Phrase(temp.getValue()+""));
		    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		    table.addCell(c1);
		    }
		    else
		    {
		    	  c1 = new PdfPCell(new Phrase(temp.getValue()+"",redFont));
				    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				    table.addCell(c1);
		    }
		 
		    table.addCell(temp.getWeight()+"");
		    table.addCell(temp.getTimeStamp().toLocaleString()+"");
		    table.addCell(temp.getDescription()+"");
		    }
		    subCatPart.add(table);

		  }
		  private static void createTableNotes(Section subCatPart,Student student)
			      throws BadElementException {
			    PdfPTable table = new PdfPTable(2);

	
			    PdfPCell c1 = new PdfPCell(new Phrase("Treœæ",subFont));
			    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			    table.addCell(c1);

			    c1 = new PdfPCell(new Phrase("Od kogo",subFont));
			    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			    table.addCell(c1);
			    
			    Iterator it = student.getStudentNotes().iterator();		   
			    while(it.hasNext())
		
			    {		
			    	StudentNote temp = (StudentNote)it.next();
			
			    c1 = new PdfPCell(new Phrase(temp.getNoteContents()+""));
			    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			    table.addCell(c1);			  
			    
			    c1 = new PdfPCell(new Phrase(temp.getTeacher().getLastName()+" " +temp.getTeacher().getFirstName()));
			    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			    table.addCell(c1);    
			 
			    }
			    subCatPart.add(table);

			  }

		  private static void addEmptyLine(Paragraph paragraph, int number) {
		    for (int i = 0; i < number; i++) {
		      paragraph.add(new Paragraph(" "));
		    }
		  }


}
