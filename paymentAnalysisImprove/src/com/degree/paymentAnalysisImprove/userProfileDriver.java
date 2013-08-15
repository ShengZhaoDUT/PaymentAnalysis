package com.degree.paymentAnalysisImprove;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;


public class userProfileDriver {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum","10.0.0.13");  
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        
        Job getUserProfile = Job.getInstance(conf, "getUserProfile");
        getUserProfile.setJarByClass(userProfileDriver.class);
        Scan scan = new Scan();
//        scan.setStartRow((otherArgs[1]).getBytes());
//        scan.setStopRow((otherArgs[2]).getBytes());
        scan.setCaching(Integer.parseInt(otherArgs[1]));
//        scan.setBatch(Integer.parseInt(otherArgs[4]));
        scan.setCacheBlocks(false);
        
        TableMapReduceUtil.initTableMapperJob(
        		"userprofilescheme", 
        		scan,
        		userProfileMapper.class, 
        		LongWritable.class, 
        		userProfileWritable.class, 
        		getUserProfile);
        getUserProfile.setNumReduceTasks(5);
        getUserProfile.setReducerClass(userProfileReducer.class);
        getUserProfile.setOutputKeyClass(LongWritable.class);
        getUserProfile.setOutputValueClass(userProfileWritable.class);
        Path outputPath = new Path(otherArgs[0]);
        getUserProfile.setOutputFormatClass(SequenceFileOutputFormat.class);
//        getUserProfile.setOutputFormatClass(TextOutputFormat.class);
//        getUserProfile.setOutputFormatClass(SequenceFileAsBinaryOutputFormat.class);
        FileOutputFormat.setOutputPath(getUserProfile, outputPath);
        long start = System.currentTimeMillis();
		getUserProfile.waitForCompletion(true);
		long range = System.currentTimeMillis() - start;
		System.out.println(range);
	
//        Job readSequence = Job.getInstance(conf, "readSequence");
//        readSequence.setJarByClass(userProfileDriver.class);
//        readSequence.setMapperClass(readSequence.class);
//        readSequence.setMapOutputKeyClass(LongWritable.class);
//        readSequence.setMapOutputValueClass(Text.class);
//        readSequence.setReducerClass(Reducer.class);
//        readSequence.setOutputKeyClass(LongWritable.class);
//        readSequence.setOutputValueClass(Text.class);
//        readSequence.setInputFormatClass(SequenceFileInputFormat.class);
//        readSequence.setOutputFormatClass(TextOutputFormat.class);
//        Path readSePath = new Path(otherArgs[4]);
//		FileInputFormat.addInputPath(readSequence, outputPath);
//		FileOutputFormat.setOutputPath(readSequence, readSePath);
//	    readSequence.setNumReduceTasks(1);
//	    readSequence.waitForCompletion(true);
	}
}