
package controllers;


import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath("ApplicationConfig.properties")
public class ApplicationConfigReader 
{
	
	public ApplicationConfigReader()
	{
		PropertyLoader.newInstance().populate(this);
	}
	
	@Property(value = "Browser")
	private String Browser;
	
	@Property(value="Url")
	private String WebsiteUrl;
	
	@Property(value="userName")
	private String uname;
	
	@Property(value="password")
	private String pwd;
	
	@Property(value="MaxPageLoadTime")
	private int MaxPageLoadTime;
	
	@Property(value="ImplicitlyWait")
	private int ImplicitlyWait;
	
	@Property(value="VideoFeature")
	private String VideoFeature;

	public String getBrowser() {
		return Browser;
	}

	public String getWebsiteUrl() {
		return WebsiteUrl;
	}
	
	public String getUsername() {
		return uname;
	}
	
	public String getPasswordl() {
		return pwd;
	}

	public int getMaxPageLoadTime() {
		return MaxPageLoadTime;
	}

	public int getImplicitlyWait() {
		return ImplicitlyWait;
	}

	public String getVideoFeature() {
		return VideoFeature;
	}
	
	

}
