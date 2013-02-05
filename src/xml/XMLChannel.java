package xml;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.dom4j.Element;

public class XMLChannel {
	Logger  log = Logger.getLogger(XMLChannel.class.getName());
    private ArrayList<XMLChannelItem> items;
    /**
     * 必选
     */
    public final static String title="title";
    public final static String link="link";
    public final static String description="description";
    /**
     * 可选
     */
    private ArrayList<String> category;
    private XMLChannelTextInput textInput;
    private XMLChannelCloud cloud;
    private XMLChannelImage image;
    
    private Hashtable<String,String> arrs = new Hashtable<String,String>();
    
    public final static String language="language";
    public final static String copyright="copyright";
    public final static String managingEditor="managingEditor";
    public final static String webMaster="webMaster";
    public final static String pubDate="pubDate";
    public final static String lastBuildDate="lastBuildDate";
    public final static String generator="generator";
    public final static String docs="docs";
    public final static String ttl="ttl";
    public final static String rating="rating";
    public final static String skipHours="skipHours";
    public final static String skipDays="skipDays";
    /**
     * 文章操作。
     */
    public void addItem(XMLChannelItem item){
    	items.add(item);
    }
    public  Iterator<XMLChannelItem> iterator(){
    	return items.iterator();
    }
    
    /**
     * 初始化Channel
     */
    public void init(Element cha){
    	Iterator<?> channelSon= cha.elementIterator();
    	while (channelSon.hasNext()) {
    		Element son = (Element) channelSon.next();
    		if(!son.getName().equals("item")){
    			arrs.put(son.getNamespace().getURI()+":"+son.getName(), son.getText());
 //    			System.out.println(son.getName()+"="+son.getText());
    		}
		}
    }
    /**
     * get,set 方法
     */
	public Hashtable<String,String> getArrs(){
		return this.arrs;
	}
	public void setArrs(Hashtable<String,String> arrs){
		this.arrs = arrs;
	}
	public ArrayList<String> getCategory() {
		return category;
	}
	public void setCategory(ArrayList<String> category) {
		this.category = category;
	}
	
	public XMLChannelCloud getCloud() {
		return cloud;
	}
	public void setCloud(XMLChannelCloud cloud) {
		this.cloud = cloud;
	}
	
	public XMLChannelImage getImage() {
		return image;
	}
	public void setImage(XMLChannelImage image) {
		this.image = image;
	}
	
	public XMLChannelTextInput getTextInput() {
		return textInput;
	}
	public void setTextInput(XMLChannelTextInput textInput) {
		this.textInput = textInput;
	}
}

