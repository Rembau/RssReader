package xml;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import exception.VersionNonsupperException;

public class XMLHandle {
	Logger  log = Logger.getLogger(XMLHandle.class.getName());
    private XMLChannel channel;
    private String version;
    
    public Document read(String url) throws MalformedURLException, DocumentException{
    	SAXReader reader = new SAXReader();
    	return reader.read(new URL(url));
    }
	public XMLChannel getChannel() {
		return channel;
	}
	public void generateChannel(String url) throws MalformedURLException, DocumentException, VersionNonsupperException {
		log.info("=");
		Document doc = read(url);
		log.info("==");
		Element root = doc.getRootElement();
		setVersion(root.attributeValue("version"));
		if(getVersion().equals("2.0")){
			Element channelElement = (Element) root.elementIterator().next();
			System.out.println(channelElement);
			channel = new XMLChannel();
			channel.init(channelElement);
		} else {
			throw new VersionNonsupperException();
		}
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	} 
	public static void main(String args[]){
		try {
			new XMLHandle().generateChannel("http://blog.jobbole.com/feed/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (VersionNonsupperException e) {
			e.printStackTrace();
		}
	}
}

