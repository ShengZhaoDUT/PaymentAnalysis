package com.degree.paymentAnalysisFinal;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class paymentAnlaysisFinalDriver {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum","10.0.0.13");  
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
		Path inputPath = new Path(otherArgs[0]);
		Path userProfile = new Path(otherArgs[1]);
		Path sourceInputPath = new Path(otherArgs[2]);
		Path sourceProfile = new Path(otherArgs[3]);
		Path outputPath = new Path(otherArgs[4]);
//		Path readPath = new Path(otherArgs[2]);
		Job readUserProfile = Job.getInstance(conf, "readUserProfile");
		readUserProfile.setJarByClass(paymentAnlaysisFinalDriver.class);
		readUserProfile.setMapperClass(readUserProfileMapper.class);
		readUserProfile.setMapOutputKeyClass(LongWritable.class);
		readUserProfile.setMapOutputValueClass(profileWritable.class);
		readUserProfile.setReducerClass(Reducer.class);
		readUserProfile.setOutputKeyClass(LongWritable.class);
		readUserProfile.setOutputValueClass(profileWritable.class);
		readUserProfile.setInputFormatClass(TextInputFormat.class);
		readUserProfile.setOutputFormatClass(SequenceFileOutputFormat.class);
		
		FileInputFormat.addInputPath(readUserProfile, inputPath);
		FileOutputFormat.setOutputPath(readUserProfile, userProfile);
	    readUserProfile.setNumReduceTasks(5);
	    readUserProfile.waitForCompletion(true);
	    
	    
	    Job readSourceProfile = Job.getInstance(conf, "readSourceProfile");
	    readSourceProfile.setJarByClass(paymentAnlaysisFinalDriver.class);
	    readSourceProfile.setMapperClass(readSourceProfileMapper.class);
	    readSourceProfile.setMapOutputKeyClass(LongWritable.class);
	    readSourceProfile.setMapOutputValueClass(profileWritable.class);
	    readSourceProfile.setReducerClass(Reducer.class);
	    readSourceProfile.setOutputKeyClass(LongWritable.class);
	    readSourceProfile.setOutputValueClass(profileWritable.class);
	    readSourceProfile.setInputFormatClass(TextInputFormat.class);
	    readSourceProfile.setOutputFormatClass(SequenceFileOutputFormat.class);
		
		FileInputFormat.addInputPath(readSourceProfile, sourceInputPath);
		FileOutputFormat.setOutputPath(readSourceProfile, sourceProfile);
		readSourceProfile.setNumReduceTasks(5);
		readSourceProfile.waitForCompletion(true);
//		Job readResult = Job.getInstance(conf, "readResult");
//		readResult.setJarByClass(paymentAnlaysisFinalDriver.class);
//		readResult.setMapperClass(readResultMapper.class);
//		readResult.setMapOutputKeyClass(LongWritable.class);
//		readResult.setMapOutputValueClass(Text.class);
//		readResult.setReducerClass(Reducer.class);
//		readResult.setOutputKeyClass(LongWritable.class);
//		readResult.setOutputValueClass(Text.class);
//		readResult.setInputFormatClass(SequenceFileInputFormat.class);
//		readResult.setOutputFormatClass(TextOutputFormat.class);
//		
//		FileInputFormat.addInputPath(readResult, outPath);
//		FileOutputFormat.setOutputPath(readResult, readPath);
//		readResult.setNumReduceTasks(5);
//		readResult.waitForCompletion(true);
		
//		Job paymentCal = Job.getInstance(conf, "paymentCal");
//		paymentCal.setJarByClass(paymentAnlaysisFinalDriver.class);
//		paymentCal.setMapperClass(Mapper.class);
//		paymentCal.setMapOutputKeyClass(LongWritable.class);
//		paymentCal.setMapOutputValueClass(profileWritable.class);
//	    paymentCal.setInputFormatClass(SequenceFileInputFormat.class);
//		TableMapReduceUtil.initTableReducerJob(
//				"payment", 
//				paymentAnalysisFinalReducer.class, 
//				paymentCal);
//		paymentCal.setNumReduceTasks(1);
//		
//		FileInputFormat.addInputPath(paymentCal, userProfile);
//		FileInputFormat.addInputPath(paymentCal, sourceProfile);
//		FileOutputFormat.setOutputPath(paymentCal, );
//		readResult.setNumReduceTasks(5);
//		paymentCal.waitForCompletion(true);
	    
		Job paymentCal = Job.getInstance(conf, "paymentCal");
		paymentCal.setJarByClass(paymentAnlaysisFinalDriver.class);
		paymentCal.setMapperClass(Mapper.class);
		paymentCal.setMapOutputKeyClass(LongWritable.class);
		paymentCal.setMapOutputValueClass(profileWritable.class);
		paymentCal.setReducerClass(paymentFileReducer.class);
		paymentCal.setOutputKeyClass(LongWritable.class);
		paymentCal.setOutputValueClass(Text.class);
		paymentCal.setInputFormatClass(SequenceFileInputFormat.class);
		paymentCal.setOutputFormatClass(TextOutputFormat.class);
		
		FileInputFormat.addInputPath(paymentCal, userProfile);
		FileInputFormat.addInputPath(paymentCal, sourceProfile);
		FileOutputFormat.setOutputPath(paymentCal, outputPath);
		
		paymentCal.setNumReduceTasks(5);
//		FileOutputFormat.setOutputPath(paymentCal, );
//		readResult.setNumReduceTasks(5);
		paymentCal.waitForCompletion(true);
	}
}
