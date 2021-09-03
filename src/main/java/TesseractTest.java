import lombok.SneakyThrows;
import net.sourceforge.tess4j.Tesseract;

import java.io.File;

public class TesseractTest {
    @SneakyThrows
    public static void main(String[] args) {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("D://tessdata");
        tesseract.setLanguage("rus");
        System.out.println("Imported tessdata");
        System.out.println(tesseract.doOCR(new File("D://contents.jpg")));
    }
}
