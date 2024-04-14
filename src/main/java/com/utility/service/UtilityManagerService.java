package com.utility.service;

import java.util.List;

import com.utility.model.BmiInfo;
import com.utility.model.BmrInfo;

public interface UtilityManagerService {
	
	public String convertDigitToWord(int digit);

	public String getBmiResult(BmiInfo bmiInfo);
	
	public List<String> getBMRResult(BmrInfo bmrinfo);

	List<String> getidealWeightResult(BmrInfo bmrInfo);

}
