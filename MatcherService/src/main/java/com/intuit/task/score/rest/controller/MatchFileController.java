package com.intuit.task.score.rest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.intuit.task.score.customer.services.MatchService;
import com.intuit.task.score.customer.services.data.MatchData;
import com.intuit.task.score.customer.services.data.MatchDataResult;
import com.intuit.task.score.customer.services.process.MatchProcessorService;
import com.intuit.task.score.rest.controller.object.BuyerSupplierFileData;

@RestController
@RequestMapping("/api/match/")
public class MatchFileController {
	
	@Autowired
	private MatchProcessorService matchProcessorService;
	
	
	@PostMapping(value = "/fileCsvMatch", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public MatchDataResult executeFileCsvMatch(
			@RequestPart(value ="buyerCsv") final MultipartFile buyerFile
			,@RequestPart(value ="supplierCsv") final MultipartFile supplierFile) throws Exception {
		return matchProcessorService.processFileMatch(buyerFile, supplierFile);
	}
	

}
