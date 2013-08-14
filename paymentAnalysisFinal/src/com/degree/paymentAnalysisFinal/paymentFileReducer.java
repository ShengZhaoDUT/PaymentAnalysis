package com.degree.paymentAnalysisFinal;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class paymentFileReducer extends
		Reducer<LongWritable, profileWritable, LongWritable, Text> {
	private byte verifyType;
	private int fansNum;
	private int fansVNum;
	private float pc;
	private float mobiMed;
	private float mobiHig;

	public void reduce(LongWritable key, Iterable<profileWritable> values, Context context) throws IOException, InterruptedException {
		boolean userProfile = false;
		boolean sourceProfile = false;
		for(profileWritable profile : values) {
			// userProfile
			if(profile.isCatgory()) {
				userProfile = true;
				verifyType = profile.getVerifyType();
				fansNum = profile.getFansNum();
				fansVNum = profile.getFansVNum();
			}
			else {
				sourceProfile = true;
				pc = profile.getPc();
				mobiMed = profile.getMobiMed();
				mobiHig = profile.getMobiHig();
			}
		}
		if(userProfile && sourceProfile) {
			int result = getPayment();
			context.write(key, new Text(String.valueOf(result)));
		}
	}
	private int getPayment() {
		float isHigh = configuration.paymentHigh;
		float isMedium = configuration.paymentMedium;
		float isLow = configuration.paymentLow;
		if(verifyType == 0) {
			isHigh *= configuration.vHigh;
			isMedium *= configuration.vMedium;
			isLow *= configuration.vLow;
		}
		else {
			isHigh *= configuration.nvHigh;
			isMedium *= configuration.nvMedium;
			isLow *= configuration.nvLow;
//		System.out.println("h2");
		}
		if(fansNum <= 50) {
			isHigh *= configuration.fLevel1High;
			isMedium *= configuration.fLevel1Medium;
			isLow *= configuration.fLevel1Low;
//			System.out.println("h3");
		}
		else if(fansNum > 50 && fansNum <= 1000) {
			isHigh *= configuration.fLevel2High;
			isMedium *= configuration.fLevel2Medium;
			isLow *= configuration.fLevel2Low;
//				System.out.println("h4");
		}
		else {
			isHigh *= configuration.fLevel3High;
			isMedium *= configuration.fLevel3Medium;
			isLow *= configuration.fLevel3Low;
//			System.out.println("h5");
		}
			
		if(fansVNum <= 5) {
			isHigh *= configuration.qLevel1High;
			isMedium *= configuration.qLevel1Medium;
			isLow *= configuration.qLevel1Low;
//				System.out.println("h6");
		}
		else if(fansVNum > 5 && fansVNum <= 50) {
			isHigh *= configuration.qLevel2High;
			isMedium *= configuration.qLevel2Medium;
			isLow *= configuration.qLevel2Low;
//			System.out.println("h7");
		}
		else {
			isHigh *= configuration.qLevel3High;
			isMedium *= configuration.qLevel3Medium;
			isLow *= configuration.qLevel3Low;
//			System.out.println("h8");
		}
			
		if(pc < 0.45) {
//						System.out.println("h9");
			isHigh *= configuration.spLevel1High;
			isMedium *= configuration.splevel1Medium;
			isLow *= configuration.splevel1Low;
		}
		else {
			isHigh *= configuration.spLevel2High;
			isMedium *= configuration.splevel2Medium;
			isLow *= configuration.splevel2Low;
//					System.out.println("h10");
		}
		if(mobiHig < 0.4) {
//				System.out.println("h11");
			isHigh *= configuration.mhLevel1High;
			isMedium *= configuration.mhlevel1Medium;
			isLow *= configuration.mhlevel1Low;
		}
		else {
			isHigh *= configuration.mhLevel2High;
			isMedium *= configuration.mhlevel2Medium;
			isLow *= configuration.mhlevel2Low;
//						System.out.println("h12");
		}
		if(mobiMed < 0.35) {
			isHigh *= configuration.mmLevel1High;
			isMedium *= configuration.mmlevel1Medium;
			isLow *= configuration.mmlevel1Low;
//					System.out.println("h13");
		}
		else {
			isHigh *= configuration.mmLevel2High;
			isMedium *= configuration.mmlevel2Medium;
			isLow *= configuration.mmlevel2Low;
//						System.out.println("h14");
		}
		int result = 0;
		float tmp = isLow;
		if(tmp < isMedium) {
			tmp = isMedium;
			if(tmp < isHigh)
				tmp = isHigh;
		}
		else {
			if(tmp < isHigh)
				tmp = isHigh;
		}
		if(tmp == isLow)
			result = 3;
		else if(tmp == isMedium)
			result = 2;
		else
			result = 1;
		return result;
	}
}
