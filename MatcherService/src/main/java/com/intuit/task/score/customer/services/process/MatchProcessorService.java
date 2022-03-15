package com.intuit.task.score.customer.services.process;

import org.springframework.web.multipart.MultipartFile;

import com.intuit.task.score.customer.services.data.MatchDataResult;

public interface MatchProcessorService {
	
	public MatchDataResult processFileMatch(final MultipartFile buyerFile, final MultipartFile supplierFile);

}
