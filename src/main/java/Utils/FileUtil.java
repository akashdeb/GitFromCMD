package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
	
	public String fetchDataFromPropertyFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\Scripts\\eclipse-workspace_WeekendMay2023\\actitime\\src\\test\\resources\\propertyData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		return prop.getProperty(key);
	}

}
