package framgiavn.project01.web.ulti;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

import framgiavn.project01.web.ulti.WordAndAnswerCSV;

/**
 * @author nguyenanhvan
 *
 */
public class ReadingCSV {

	private String fileName;

	public ReadingCSV() {
	}

	public ReadingCSV(String filename) {
		this.setFileName(filename);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<WordAnswerObjectCSV> getCategoryWordAndAnswerList() {
		List<WordAnswerObjectCSV> wordAnswerCSVList = new ArrayList<WordAnswerObjectCSV>();
		List<WordAndAnswerCSV> list = null;
		try {
			CSVReader csvReader = new CSVReader(new FileReader(fileName));
			ColumnPositionMappingStrategy<WordAndAnswerCSV> strategy = new ColumnPositionMappingStrategy<>();
			strategy.setType(WordAndAnswerCSV.class);
			String[] columnMapping = new String[] { "categoryName", "wordContent", "wordAnswerOne",
					"wordAnswerOneResult", "wordAnswerTwo", "wordAnswerTwoResult", "wordAnswerThree",
					"wordAnswerThreeResult", "wordAnswerFour", "wordAnswerFourResult" };
			strategy.setColumnMapping(columnMapping);
			CsvToBean<WordAndAnswerCSV> csvToBean = new CsvToBean<>();
			list = csvToBean.parse(strategy, csvReader);
			for (WordAndAnswerCSV wa : list) {
				Map<String, Boolean> wordAnswerMap = new HashMap<String, Boolean>();
				wordAnswerMap.put(wa.getWordAnswerOne(), 
						(wa.getWordAnswerOneResult().equals("1")) ? (true) : (false));
				wordAnswerMap.put(wa.getWordAnswerTwo(), 
						(wa.getWordAnswerTwoResult().equals("1")) ? (true) : (false));
				wordAnswerMap.put(wa.getWordAnswerThree(),
						(wa.getWordAnswerThreeResult().equals("1")) ? (true) : (false));
				wordAnswerMap.put(wa.getWordAnswerFour(),
						(wa.getWordAnswerFourResult().equals("1")) ? (true) : (false));
				wordAnswerCSVList
						.add(new WordAnswerObjectCSV(wa.getCategoryName(), wa.getWordContent(), wordAnswerMap));
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return wordAnswerCSVList;
	}
}
