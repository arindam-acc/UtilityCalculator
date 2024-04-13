package com.utility.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.utility.model.BmiInfo;
import com.utility.model.BmrInfo;
import com.utility.service.UtilityManagerService;

@Service
public class UtilityManagerServiceImpl implements UtilityManagerService{
	
	private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    private static final String[] teens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

	@Override
	public String convertDigitToWord(int number) {
		if (number == 0) {
            return "Zero";
        } else if (number < 0 || number > 9999999) {
            return "Number out of range for conversion";
        }

        return convert(number);
	}

	private String convert(int number) {
        if (number <= 10) {
            return units[number];
        } else if (number < 20) {
            return teens[number - 10];
        } else if (number < 100) {
            return tens[number / 10] + convert(number % 10);
        } else if (number < 1000) {
            return units[number / 100] + " Hundred " + convert(number % 100);
        } else if (number < 100000) {
            return convert(number / 1000) + " Thousand " + convert(number % 1000);
        } else {
            return convert(number / 100000) + " Lakh " + convert(number % 100000);
        }
	}

	@Override
	public String getBmiResult(BmiInfo bmiInfo) {
		final DecimalFormat decfor = new DecimalFormat("0.00");
		double meter = bmiInfo.getHeight() * 0.0254;
		double sqrtHeght = Math.pow(meter, 2);
		double bmi = bmiInfo.getWeight() / sqrtHeght;
		return decfor.format(bmi);
	}

	@Override
	public List<String> getBMRResult(BmrInfo bmrInfo) {
		
		String mifflinStJeorEquation = this.mifflinStJeorEquation(bmrInfo);
		String revisedHarrisBenedictEquation = this.revisedHarrisBenedictEquation(bmrInfo);
		List<String> bmrList = new ArrayList<String>();
		bmrList.add(revisedHarrisBenedictEquation);
		bmrList.add(mifflinStJeorEquation);
		return bmrList;
	}
	
	private double inchToCms(BmrInfo bmrInfo) {
		
		return bmrInfo.getHeight() * 2.54;
		
	}
	
	private String mifflinStJeorEquation(BmrInfo bmrInfo){
		final DecimalFormat decfor = new DecimalFormat("0.00");
		double bmrWeightCalc = 0.0;
		double bmrHightCalc = 0.0;
		double bmrAgeCalc = 0.0;
		double bmrCalc = 0.0;
		String bmrResult = null;
		double heightInCm = this.inchToCms(bmrInfo);
		if(StringUtils.isNotBlank(bmrInfo.getGender()) && bmrInfo.getGender().equalsIgnoreCase("M")) {
			 bmrWeightCalc = 10 * bmrInfo.getWeight();
			 bmrHightCalc = 6.25 * heightInCm;
			 bmrAgeCalc = 5 * bmrInfo.getAge();
			 bmrCalc = bmrWeightCalc + bmrHightCalc - bmrAgeCalc + 5;
			 bmrResult =  decfor.format(bmrCalc);
		}else {
			bmrWeightCalc = 10 * bmrInfo.getWeight();
			 bmrHightCalc = 6.25 * heightInCm;
			 bmrAgeCalc = 5 * bmrInfo.getAge();
			 bmrCalc = bmrWeightCalc + bmrHightCalc - bmrAgeCalc + 161;
			 bmrResult =  decfor.format(bmrCalc);
		}
		return bmrResult;
	}
	
	private String revisedHarrisBenedictEquation(BmrInfo bmrInfo) {
		final DecimalFormat decfor = new DecimalFormat("0.00");
		double bmrWeightCalc = 0.0;
		double bmrHightCalc = 0.0;
		double bmrAgeCalc = 0.0;
		double bmrCalc = 0.0;
		String bmrResult = null;
		double heightInCm = this.inchToCms(bmrInfo);
		if(StringUtils.isNotBlank(bmrInfo.getGender()) && bmrInfo.getGender().equalsIgnoreCase("M")) {
			 bmrWeightCalc = 13.397 * bmrInfo.getWeight();
			 bmrHightCalc = 4.799 * heightInCm;
			 bmrAgeCalc = 5.667 * bmrInfo.getAge();
			 bmrCalc = bmrWeightCalc + bmrHightCalc - bmrAgeCalc + 88.362;
			 bmrResult =  decfor.format(bmrCalc);
		}else {
			bmrWeightCalc = 9.247 * bmrInfo.getWeight();
			 bmrHightCalc = 3.098 * heightInCm;
			 bmrAgeCalc = 4.330 * bmrInfo.getAge();
			 bmrCalc = bmrWeightCalc + bmrHightCalc - bmrAgeCalc + 447.593;
			 bmrResult =  decfor.format(bmrCalc);
		}
		return bmrResult;
	}
}
