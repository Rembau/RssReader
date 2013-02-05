package xml;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import org.dom4j.Element;

public class XMLChannel {
    private ArrayList<XMLChannelItem> items;
    /**
     * 必选
     */
    private String title;
    private String link;
    private String description;
    /**
     * 可选
     */
    private String language;
    private String copyright;
    private String managingEditor;
    private String webMaster;
    private String pubDate;
    private String lastBuildDate;
    private ArrayList<String> category;
    private String generator;
    private String docs;
    private XMLChannelCloud cloud;
    private String ttl;
    private XMLChannelImage image;
    private String rating;
    private XMLChannelTextInput textInput;
    private String skipHours;
    private String skipDays;
    private Hashtable<String,String> arrs = new Hashtable<String,String>();
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
			arrs.put(son.getName(), son.getText());
		}
    }
    /**
     * get,set 方法
     */
	public ArrayList<XMLChannelItem> getItems() {
		return items;
	}
	public void setItems(ArrayList<XMLChannelItem> items) {
		this.items = items;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getManagingEditor() {
		return managingEditor;
	}
	public void setManagingEditor(String managingEditor) {
		this.managingEditor = managingEditor;
	}
	public String getWebMaster() {
		return webMaster;
	}
	public void setWebMaster(String webMaster) {
		this.webMaster = webMaster;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getLastBuildDate() {
		return lastBuildDate;
	}
	public void setLastBuildDate(String lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}
	public ArrayList<String> getCategory() {
		return category;
	}
	public void setCategory(ArrayList<String> category) {
		this.category = category;
	}
	public String getGenerator() {
		return generator;
	}
	public void setGenerator(String generator) {
		this.generator = generator;
	}
	public String getDocs() {
		return docs;
	}
	public void setDocs(String docs) {
		this.docs = docs;
	}
	public XMLChannelCloud getCloud() {
		return cloud;
	}
	public void setCloud(XMLChannelCloud cloud) {
		this.cloud = cloud;
	}
	public String getTtl() {
		return ttl;
	}
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
	public XMLChannelImage getImage() {
		return image;
	}
	public void setImage(XMLChannelImage image) {
		this.image = image;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public XMLChannelTextInput getTextInput() {
		return textInput;
	}
	public void setTextInput(XMLChannelTextInput textInput) {
		this.textInput = textInput;
	}
	public String getSkipHours() {
		return skipHours;
	}
	public void setSkipHours(String skipHours) {
		this.skipHours = skipHours;
	}
	public String getSkipDays() {
		return skipDays;
	}
	public void setSkipDays(String skipDays) {
		this.skipDays = skipDays;
	}
}

