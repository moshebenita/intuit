package com.intuit.task.score.customer.services;

import java.io.File;
import java.util.List;

public interface CsvFileService {
	
	public <T> List<T> loadObjectFromByte(Class<T> type, byte [] bytes);
	public <T> List<T> loadObjectFromFile(Class<T> type, File file);

}
