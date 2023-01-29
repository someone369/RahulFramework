package MallulaAcadamy.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
		
	public static void readData() throws IOException {
		String jsonData = FileUtils.readFileToString
				(new File(System.getProperty("user.dir")+"\\src\\test\\java\\MallulaAcadamy\\data\\testdata.json"),
						StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonData, new TypeReference<List<HashMap<String,String>>>(){});
		System.out.println(jsonData);
	}
	/*
	 * public static void main(String[] args) throws IOException { readData(); }
	 */
}
