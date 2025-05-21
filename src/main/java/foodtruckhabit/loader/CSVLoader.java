package foodtruckhabit.loader;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CSVLoader<T> {

	private final static Logger logger = Logger.getLogger(CSVLoader.class);
    private final Class<T> typeParameterClass;
	private final String fileName;
	private final String[] columnMapping;


	public CSVLoader(Class<T>typeParameterClass,  String fileName, String[] columnMapping) {
		
		this.typeParameterClass = typeParameterClass;
		this.fileName = fileName;
		this.columnMapping = columnMapping;
	}
	
	public List<T> loadFromCSV() {

		CSVReader csvReader = this.createCSVReader(this.fileName);
		
		ColumnPositionMappingStrategy<T> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(this.typeParameterClass);
		strategy.setColumnMapping(this.columnMapping);
        CsvToBean<T> csvToBean = new CsvToBean<>();
        List<T> beans = csvToBean.parse(strategy, csvReader);
        		
        this.closeCSVReader(csvReader);
        
		return beans;
	}

	private CSVReader createCSVReader(String fileName) {

		CSVReader reader;

		try {

			InputStream iStream = this.getClass().getClassLoader().getResourceAsStream(fileName);

			if (iStream == null) {
				throw new RuntimeException("Input stream is null!");
			}
			reader = new CSVReader(new InputStreamReader(iStream), ',', '"', 1);
		} catch (Exception e) {

			logger.error("Error creating reader!",e);
			throw new RuntimeException(e);
		}

		return reader;
	}
	
	private void closeCSVReader(CSVReader reader) {
		
		try {

			reader.close();
			
		} catch (Exception e) {

			logger.error("Error closing reader!",e);
			throw new RuntimeException(e);
		}
	}
}