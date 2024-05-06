package Learning.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public void getTsonData() throws IOException
	{
		//reading json to string
	String jsonContent=	FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//Learning//data//PurchaseOrderfile.json"), StandardCharsets.UTF_8);
		
		//string to hashmap using Jackson Datbind
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String, String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
	
	});
	
	}
	
	
	
	
}