package com.jabberpoint;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * XMLAccessor, reads and writes XML files using the SlideBuilder.
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.7 2024/03/31 Aaron de Bruin
 */
public class XMLAccessor extends Accessor
{
    protected static final String DEFAULT_API_TO_USE = "dom";
    protected static final String SHOWTITLE = "showtitle";
    protected static final String SLIDETITLE = "title";
    protected static final String SLIDE = "slide";
    protected static final String ITEM = "item";
    protected static final String LEVEL = "level";
    protected static final String KIND = "kind";
    protected static final String TEXT = "text";
    protected static final String IMAGE = "image";
    protected static final String PCE = "Parser Configuration Exception";
    protected static final String UNKNOWNTYPE = "Unknown Element type";
    protected static final String NFE = "Number Format Exception";

    private String getTextContent(Element element, String tagName)
    {
        NodeList nodes = element.getElementsByTagName(tagName);
        if (nodes != null && nodes.getLength() > 0 && nodes.item(0) != null)
        {
            return nodes.item(0).getTextContent();
        }
        return "";
    }

    @Override
    public void loadFile(Presentation presentation, String filename) throws IOException
    {
        // presentation.clear(); // Optional: Clear existing slides
        int slideNumber, itemNumber, maxSlides, maxItems;
        SlideBuilder slideBuilder = null;
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filename));
            Element doc = document.getDocumentElement();
            presentation.setTitle(getTextContent(doc, SHOWTITLE));
            NodeList slides = doc.getElementsByTagName(SLIDE);
            maxSlides = slides.getLength();
            for (slideNumber = 0; slideNumber < maxSlides; slideNumber++)
            {
                Element xmlSlide = (Element) slides.item(slideNumber);
                // Start a new builder for each slide
                slideBuilder = new SlideBuilder();
                slideBuilder.withTitle(getTextContent(xmlSlide, SLIDETITLE));
                NodeList slideItems = xmlSlide.getElementsByTagName(ITEM);
                maxItems = slideItems.getLength();
                for (itemNumber = 0; itemNumber < maxItems; itemNumber++)
                {
                    Element item = (Element) slideItems.item(itemNumber);
                    // Load item using the builder
                    loadSlideItem(slideBuilder, item);
                }
                // Build the slide and add it to the presentation
                presentation.append(slideBuilder.build());
            }
        } catch (ParserConfigurationException pcx)
        {
            // Wrap standard exceptions in IOException or a custom exception
            throw new IOException(PCE + ": " + pcx.getMessage(), pcx);
        } catch (SAXException sax)
        {
            throw new IOException("XML Parsing Error: " + sax.getMessage(), sax);
        } catch (IOException iox)
        {
            // Re-throw IOExceptions (e.g., file not found)
            throw iox;
        } catch (Exception e)
        {
            // Catch unexpected errors
            throw new IOException("Unexpected error loading file: " + e.getMessage(), e);
        }
    }

    /**
     * Loads a single slide item from an XML element and adds it to the
     * SlideBuilder currently in progress.
     *
     * @param builder The SlideBuilder constructing the current slide.
     * @param item    The XML Element representing the slide item.
     */
    protected void loadSlideItem(SlideBuilder builder, Element item)
    {
        int level = 1; // Default level
        String type = null;
        String content = item.getTextContent(); // Get content early
        NamedNodeMap attributes = item.getAttributes();
        Node levelAttr = attributes.getNamedItem(LEVEL);
        Node kindAttr = attributes.getNamedItem(KIND);
        if (levelAttr != null)
        {
            try
            {
                level = Integer.parseInt(levelAttr.getTextContent());
            } catch (NumberFormatException x)
            {
                System.err.println(NFE + " for level attribute: " + levelAttr.getTextContent());
                // Keep default level 1
            }
        }
        else
        {
            System.err.println("Warning: Missing 'level' attribute for item. Using default level 1.");
        }
        if (kindAttr != null)
        {
            type = kindAttr.getTextContent();
        }
        else
        {
            System.err.println("Error: Missing 'kind' attribute for item. Cannot determine item type.");
            return; // Skip this item if kind is missing
        }
        if (TEXT.equals(type))
        {
            builder.addTextItem(level, content);
        }
        else if (IMAGE.equals(type))
        {
            builder.addBitmapItem(level, content); // Content is the filename
        }
        else
        {
            System.err.println(UNKNOWNTYPE + ": " + type);
        }
    }

    @Override
    public void saveFile(Presentation presentation, String filename) throws IOException
    {
        // Saving logic remains the same, as it reads from the completed
        // Presentation object, which is unaffected by how slides were built.
        PrintWriter out = new PrintWriter(new FileWriter(filename));
        out.println("<?xml version=\"1.0\"?>");
        out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
        out.println("<presentation>");
        out.print("<showtitle>");
        out.print(presentation.getTitle());
        out.println("</showtitle>");
        for (int slideNumber = 0; slideNumber < presentation.getSize(); slideNumber++)
        {
            Slide slide = presentation.getSlide(slideNumber); // Assumes Presentation has getSlide(int)
            out.println("<slide>");
            out.println("<title>" + slide.getTitle() + "</title>");
            Vector<SlideItem> slideItems = slide.getSlideItems();
            for (int itemNumber = 0; itemNumber < slideItems.size(); itemNumber++)
            {
                SlideItem slideItem = slideItems.elementAt(itemNumber);
                out.print("<item kind=");
                if (slideItem instanceof TextItem)
                {
                    out.print("\"" + TEXT + "\" level=\"" + slideItem.getLevel() + "\">");
                    out.print(((TextItem) slideItem).getText());
                }
                else if (slideItem instanceof BitmapItem)
                {
                    out.print("\"" + IMAGE + "\" level=\"" + slideItem.getLevel() + "\">");
                    out.print(((BitmapItem) slideItem).getName());
                }
                else
                {
                    System.err.println("Ignoring unknown SlideItem type during save: " + slideItem);
                    continue; // Skip unknown items
                }
                out.println("</item>");
            }
            out.println("</slide>");
        }
        out.println("</presentation>");
        out.close();
    }
}
