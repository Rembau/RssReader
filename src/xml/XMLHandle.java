package xml;

import java.net.MalformedURLException;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import exception.VersionNonsupperException;

public class XMLHandle {
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
		Document doc = read(url);
		Element root = doc.getRootElement();
		setVersion(root.attributeValue("version"));
		if(getVersion().equals("2.0")){
			System.out.println("good");
			channel.init(root.element("channel"));
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

