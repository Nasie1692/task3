package xmlProcessing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import domain.Facets;
import domain.Gem;
import domain.GemColour;
import domain.Transparency;

public class GemXmlReader {
    public List<Gem> read(String fileName) throws FileNotFoundException {
        XMLStreamReader reader = null;
        try {
            List<Gem> gems = new ArrayList<>();
            Gem gem = null;
            XMLInputFactory factory = XMLInputFactory.newFactory();
            reader = factory.createXMLStreamReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                case XMLStreamConstants.START_ELEMENT: {
                    String tagName = reader.getLocalName();
                    if ("gem".equals(tagName)) {
                        gem = new Gem();
                        gem.setIdentity(reader.getAttributeValue(null, "id"));
                    } else if ("name".equals(tagName)) {
                        gem.setName(reader.getElementText());
                    } else if ("preciousness".equals(tagName)) {
                        gem.setPreciousness(reader.getElementText());
                    } else if ("origin".equals(tagName)) {
                        gem.setOrigin(reader.getElementText());
                    } else if ("color".equals(tagName)) {
                        GemColour gemColor = new GemColour();
                        gemColor.setValue(reader.getElementText());
                        gem.getParameters().add(gemColor);
                    } else if ("transparency".equals(tagName)) {
                        Transparency gemTransparency = new Transparency();
                        gemTransparency.setValue(reader.getElementText());
                        gem.getParameters().add(gemTransparency);
                    } else if ("facets".equals(tagName)) {
                        Facets gemFacets = new Facets();
                        gemFacets.setValue(reader.getElementText());
                        gem.getParameters().add(gemFacets);
                    } else if ("value".equals(tagName)) {
                        gem.setValue(Double.parseDouble(reader.getElementText()));
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    String tagName = reader.getLocalName();
                    if ("gem".equals(tagName)) {
                        gems.add(gem);
                    }
                    break;
                }
                }
            }
            return gems;
        } catch (XMLStreamException e) {
            return null;
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
            }
        }
    }
}