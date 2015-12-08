package Utils.MyUtils

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

import org.w3c.dom.Element

import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.stream.events.ProcessingInstruction
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerException
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

/**
 * Created by subrahmanayamv on 5/27/14.
 * This Util parses all the index.htmls of all builds ran on a particular JOB
 * Get the Data of Failed Test cases along with other details
 * Creates an XML
 */
class HtmlParserUtil{

    public static File folder = new File("C:/Users/subrahmanayamv/Desktop/Misc/builds/")
    public static HashMap<String, Object> mapper = new HashMap<String, Object>()
    public static Document document
    public static int number = 0


/****** MAIN FUNCTION CALLING ******/
    public static void main(String[] args) throws IOException {
        System.out.println("Reading files under the folder " + folder.getAbsolutePath());
        listFilesForFolder(folder)
        createXML()
        //getData()
    }


/********  FUNCTION TO GET THE LIST OF INDEX.HTMLS FROM A JOB PATH *********/
    public static void listFilesForFolder(final File folder) {

        int i = 0;
        for (File f : folder.listFiles()) {

            if (f.isFile() && f.getName().equalsIgnoreCase("index.html")) {
                parseHTML(f)
                i++;
            } else if (f.isDirectory()) {
                listFilesForFolder(f)
            }
        }
    }


/****** FUNCTION TO PARSE THE HTML AND GET THE TEST, CLASS AND PACKAGE NAME AND PUT THEM IN A MAP *****/
    public static parseHTML(File f) {

        int htmlIndex, testsIndex
        String packageName, testName, className
        document = Jsoup.parse(f, "UTF-8")
        Elements e = document.select(".linkList>li")
        mapper.put("Test Case Name", new ParseGetSet(0, "ClassName", "PackageName"))


/*** GETTING THE TESTCASE,CLASS AND PACKAGE NAME FROM EACH INDEX.HTML ****/
        for (int i = 0; i < e.size(); i++) {
            testName = e.get(i).getElementsByAttribute("href")[1].text()
            className = e.get(i).getElementsByAttribute("href")[0].text()
            String[] n = e.get(i).getElementsByAttribute("href")[0].toString().find(/test.*?html/).split("\\.")

            (0..n.size() - 1).each { if (n[it] == "tests") testsIndex = it }
            (0..n.size() - 1).each { if (n[it] == "html") htmlIndex = it }

            if ((htmlIndex - testsIndex) == 3)
                packageName = n[testsIndex + 1]
            else if ((htmlIndex - testsIndex) == 2) {
                packageName = n[testsIndex - 1]
            }


/*** CREATING A MAP WHICH CONTAINS THE TESTCASE,CLASS AND PACKAGE NAME ALONG WITH A COUNTER WHICH TELLS HOW MANY TIMES THE TEST CASE FAILED  ***/
            if (mapper.containsKey(testName)) {
                int x = (mapper.get(testName).getA()) + 1
                mapper.put(testName, new ParseGetSet(x, className, packageName))
            } else {
                mapper.put(testName, new ParseGetSet(1, className, packageName))
            }
        }
    }


/**** CREATE AN XML USING JAXB*****/
    public static void createXML() {

        try {
            int count = 0
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();


            org.w3c.dom.Document doc
            doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("FailedTestCases");
            doc.appendChild(rootElement);

            org.w3c.dom.Node pi = doc.createProcessingInstruction("xml-stylesheet","type=\"text/xsl\" href=\"failedtestcase.xsl\"");
            doc.insertBefore(pi,rootElement)

            for (Map.Entry<String, Object> map1 : mapper.entrySet()) {

                count++
                Element tcase = doc.createElement("TESTCASE");
                rootElement.appendChild(tcase);
                tcase.setAttribute("id", "1")

                Element tName = doc.createElement("TestCaseName");
                tName.appendChild(doc.createTextNode(map1.getKey()));
                tcase.appendChild(tName);


                Element counter = doc.createElement("Count");
                counter.appendChild(doc.createTextNode(map1.getValue().getA().toString()));
                tcase.appendChild(counter);

                Element cName = doc.createElement("ClassName");
                cName.appendChild(doc.createTextNode(map1.getValue().getClassName()));
                tcase.appendChild(cName);

                Element pName = doc.createElement("PackageName");
                pName.appendChild(doc.createTextNode(map1.getValue().getPackageName()));
                tcase.appendChild(pName);

                /***** WRITE THE CONTENT TO XML FILE *******/
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("C:/RV/pramati/pramati/Projects/RVPro/src/test/resources/SubuFailedTestCasesXML.xml"));
                transformer.transform(source, result);

                /***** Output to console for testing ****/
                /***** StreamResult result = new StreamResult(System.out); *****/
            }
            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

/**** FUNCTION TO PRINT THE MAP *****/
    public static void printDataOnConsole() {
        for (Map.Entry<String, Object> map1 : mapper.entrySet()) {
            println(map1.getKey() + "-----" + map1.getValue().getA())
        }
    }
}