package com.degree.paymentAnalysisImprove;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class userProfileReducer extends Reducer<LongWritable, userProfileWritable, LongWritable, userProfileWritable>{
	public void reduce(LongWritable key, Iterable<userProfileWritable> value, Context context) throws IOException, InterruptedException {
		int sum = 0;
		byte verifyType = -1;
		int fansNum = 0;
		boolean flag = false;
		for(userProfileWritable userProfile : value) {
			if(!userProfile.getFlag()) {
//				System.out.println(userProfile.getFansVSum());
				sum += userProfile.getFansVSum();
			}
			else {
				verifyType = (byte) userProfile.getVerify();
				fansNum = userProfile.getFansNum();
				flag = true;
			}
		}
		context.write(key, new userProfileWritable(flag, fansNum, verifyType, sum));
	}
}