package propra;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class Gratulation {

    private String name;

    private Gratulation(String name) {
        this.name = name;
    }

    public static Gratulation create(String name) {
        if (name == null || name.isBlank()) {
            return new Gratulation("Unbekannter Nummer 1");
        }
        return new Gratulation(name);
    }

    String getAnrede() {
        return "Hallo " + name +",";
    }

    String[] getText() {
        return new String[] {
                "schön, dass Sie es geschafft haben das Gradle File zu reparieren.",
                "Wir hoffen, Sie schaffen auch den Rest der Aufgabe."
        };
    }

    void print() {
        PDDocument document = new PDDocument();
        PDPage my_page = new PDPage();
        document.addPage(my_page);

        try {
            PDPageContentStream contentStream = new PDPageContentStream(document, my_page);
            contentStream.setFont(PDType1Font.TIMES_ROMAN, (float) 35.0);
            contentStream.beginText();
            contentStream.setLeading(20f);
            contentStream.newLineAtOffset(25, 725);
            contentStream.showText(getAnrede());
            contentStream.setFont(PDType1Font.TIMES_ROMAN, (float) 16.0);
            contentStream.newLine();
            for (String line : getText()) {
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
