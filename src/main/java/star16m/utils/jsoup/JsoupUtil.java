package star16m.utils.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupUtil {

    
    public static Document getDocument(String urlString) throws IOException {
        return Jsoup.connect(urlString).get();
    }
    public static Elements getElements(String urlString, String cssQuery) throws IOException {
        return getElements(getDocument(urlString), cssQuery);
    }
    public static Elements getElements(Document document, String cssQuery) {
        return document.select(cssQuery);
    }
    public static String[] getElementsStringArray(String urlString, String cssQuery) throws IOException {
        return getElementsStringArray(getDocument(urlString), cssQuery);
    }
    public static String[] getElementsStringArray(Document document, String cssQuery) {
        return getElementsStringArray(getElements(document, cssQuery));
    }
    public static String[] getElementsStringArray(Elements elements) {
        String[] stringArray = new String[elements.size()];
        for (int i=0; i<elements.size(); i++) {
            stringArray[i] = elements.get(i).text().trim();
        }
        return stringArray;
    }
    public static Element getElement(Document document, String cssQuery) {
        return document.select(cssQuery).first();
    }
    public static String getElementString(Document document, String cssQuery) {
        return getElement(document, cssQuery).text();
    }
}
