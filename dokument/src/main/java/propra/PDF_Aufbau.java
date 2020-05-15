package propra;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class PDF_Aufbau {
	PDDocument document = new PDDocument();
	PDPage my_page = new PDPage();


	void erstellePDF(Gratulation g) {
		document.addPage(my_page);

		try {
			PDPageContentStream contentStream = new PDPageContentStream(document, my_page);
			contentStream.setFont(PDType1Font.TIMES_ROMAN, (float) 35.0);
			contentStream.beginText();
			contentStream.setLeading(20f);
			contentStream.newLineAtOffset(25, 725);
			contentStream.showText(g.getAnrede());
			contentStream.setFont(PDType1Font.TIMES_ROMAN, (float) 16.0);
			contentStream.newLine();
			for (String line : g.getText()) {
				contentStream.showText(line);
				contentStream.newLine();
			}
			contentStream.endText();
			contentStream.close();
			document.save("dokument.pdf");
			document.close();
		} catch (IOException e) {
			System.err.println("Beim Erzeugen des Dokuments ist etwas fehlgeschlagen: "+ e.getMessage());
		}
	}
}
