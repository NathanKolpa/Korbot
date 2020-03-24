package headless.config;

import lib.core.commands.router.CommandRouter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Config
{
	private String token;
	private String presence;

	public Config(String file) throws ParserConfigurationException, IOException, SAXException
	{
		read(file);
	}

	private void read(String file) throws ParserConfigurationException, IOException, SAXException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document doc = builder.parse(new File(file));

		Element root = doc.getDocumentElement();
		readRoot(root);
	}

	private void readRoot(Element root)
	{
		token = root.getElementsByTagName("token").item(0).getTextContent();
		presence = root.getElementsByTagName("presence").item(0).getTextContent();
	}



	public String getToken()
	{
		return token;
	}

	public String getPresence()
	{
		return presence;
	}
}
