package com.degree.paymentAnalysisImprove;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.io.LongWritable;

public class userProfileMapper extends TableMapper<LongWritable, userProfileWritable> {
	private static int beginIndex = 3;
	private static byte[] family = "d".getBytes();
	private static byte[] vt = "vt".getBytes();
	private static byte[] fn = "fn".getBytes();
	private static byte[] fui = "fui".getBytes();
	private int vertifyType;
	private int fansNum;
	private String attention;
	public void map(ImmutableBytesWritable row, Result value, Context context) throws IOException, InterruptedException {
		long uid = 0;
		try {
			uid = Long.parseLong(new String(row.get()).substring(beginIndex));
			String verify = new String(value.getValue(family, vt));
			if(verify.equals("")) 
				vertifyType = -1;
			else
				vertifyType = Integer.parseInt(verify);
			String fans = new String(value.getValue(family, fn));
			if(fans.equals(""))
				fansNum = 0;
			else
				fansNum = Integer.parseInt(fans);
			if(vertifyType == 0) {
				attention = new String(value.getValue(family, fui));
				String[] attList = attention.split(",");
				if(attList.length != 1 || (!attList[0].equals("")))
					for(int i = 0; i < attList.length; i++) {
						long att = Long.parseLong(attList[i]);
						userProfileWritable one = new userProfileWritable(1);
						context.write(new LongWritable(att), one);
					}
			}
			context.write(new LongWritable(uid), new userProfileWritable(fansNum, (byte)vertifyType));
		} catch(NullPointerException e) {
			System.out.println(String.valueOf("null:" + uid));
			e.printStackTrace();
		} catch(NumberFormatException e) {
			System.out.println(String.valueOf("number:" + uid));
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(String.valueOf("exception:" + uid));
			e.printStackTrace();
		}
	}
}
