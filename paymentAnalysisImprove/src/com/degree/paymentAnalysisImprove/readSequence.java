package com.degree.paymentAnalysisImprove;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class readSequence extends Mapper<LongWritable, userProfileWritable, LongWritable, Text> {
	
	public void map(LongWritable key, userProfileWritable value, Context context) throws IOException, InterruptedException {
		String valcontent = String.format("%d,%d,%d", value.getVerify(), value.getFansNum(), value.getFansVSum());
		context.write(key, new Text(valcontent));
	}
}
