package runner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import comparator.ValueComparator;
import domain.Gem;
import xmlProcessing.GemXmlReader;
import xmlProcessing.XmlValidator;

public class Main {

    public static void main(String[] args) {
        XmlValidator validator = new XmlValidator("gems.xml", "gems.xsd");
        try {
            if (validator.validate()) {
                GemXmlReader gemReader = new GemXmlReader();
                List<Gem> gems = gemReader.read("gems.xml");
                Collections.sort(gems, new ValueComparator());
                for (Gem gem : gems) {
                    System.out.println(gem);
                }
            } else {
                System.out.println(validator.getError());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
