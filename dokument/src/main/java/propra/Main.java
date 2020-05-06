package propra;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Gratulation g = null;
        if (args.length != 1) {
            g = Gratulation.create(null);
        }
        else {
            g = Gratulation.create(args[0]);
        }
        g.print();
    }

}
