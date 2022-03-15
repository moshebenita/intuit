package com.intuit.task.score.customer.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CsvFileServiceImpl implements CsvFileService {

	public <T> List<T> loadObjectFromByte(Class<T> type, byte[] bytes) {
		try {
		MappingIterator<T> readValues = null;
		CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
		readValues = new CsvMapper().readerFor(type).with(bootstrapSchema).readValues(bytes);
		return readValues.readAll();
		} catch (IOException e) {
			log.error("Error occurred while loading  bytes" , e);
		}
		return null;
	}

	public <T> List<T> loadObjectFromFile(Class<T> type, File file) {
		MappingIterator<T> readValues = null;
		try {
			CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
			readValues = new CsvMapper().readerFor(type).with(bootstrapSchema).readValues(file);
			
			return readValues.readAll();
		} catch (IOException e) {
			log.error("Error occurred while loading  " + file.getName(), e);
			tryCloseMappingIterator(file, readValues);
		}
		return null;
	}
	
	private <T> void tryCloseMappingIterator(File file, MappingIterator<T> readValues) {
		try {
			readValues.close();
		} catch (IOException e) {
			log.error("cant close file " + file.getName() , e);
		}
	}

}
