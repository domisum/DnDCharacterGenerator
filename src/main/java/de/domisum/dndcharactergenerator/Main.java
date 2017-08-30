package de.domisum.dndcharactergenerator;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main
{

	public static void main(String[] args) throws DocumentException, IOException
	{
		String filePath = "C:\\Users\\domisum\\testChamber\\dndChars/test-"+System.currentTimeMillis()+".pdf";
		createPdf(filePath);

		Desktop.getDesktop().open(new File(filePath));
	}


	private static void createPdf(String filename) throws DocumentException, IOException
	{
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
		document.open();

		Paragraph paragraph = new Paragraph("Hello World!");
		document.add(paragraph);

		PdfContentByte over = writer.getDirectContent();
		over.saveState();
		BaseFont bf = BaseFont.createFont("C:/Windows/Fonts/cour.ttf", BaseFont.WINANSI, false);

		over.beginText();
		over.setTextRenderingMode(PdfContentByte.TEXT_RENDER_MODE_FILL);
		over.setLineWidth(1.5f);
		over.setRGBColorFill(0x00, 0x00, 0x00);
		over.setFontAndSize(bf, 36);
		over.setTextMatrix(50, 324);
		over.showText("SOLD OUT");
		over.endText();
		over.restoreState();

		document.close();
	}

}
