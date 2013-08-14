package com.degree.paymentAnalysisFinal;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class readUserProfileMapper extends Mapper<LongWritable, Text, LongWritable, profileWritable>{
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		byte verifyType;
		int fansNum;
		int fansVNum;
		String record = value.toString();
		String[] keyValue = record.split("\t");
		long uid = Long.parseLong(keyValue[0]);
		String[] para = keyValue[1].split(",");
		fansNum = Integer.parseInt(para[0]);
		fansVNum = Integer.parseInt(para[1]);
		verifyType = (byte) Integer.parseInt(para[2]);
		context.write(new LongWritable(uid), new profileWritable(verifyType, fansNum, fansVNum));
	}
}