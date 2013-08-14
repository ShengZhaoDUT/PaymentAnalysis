package com.degree.paymentAnalysisFinal;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class readResultMapper extends Mapper<LongWritable, profileWritable, LongWritable, Text> {
	
	public void map(LongWritable key, profileWritable value, Context context) throws IOException, InterruptedException {
		String valcontent = null;
		valcontent = String.format("%s,", String.valueOf(value.isCatgory()));
		valcontent += String.format("%s,", String.valueOf(value.getFansNum()));
		valcontent += String.valueOf(value.getFansVNum());
		context.write(key, new Text(valcontent));
	}
}