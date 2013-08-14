package com.degree.paymentAnalysisFinal;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.TreeMap;

import org.apache.hadoop.io.Writable;



public class TweetAggregateWritable implements Serializable,Writable
{
	

	private static final long serialVersionUID = 4655482796857109944L;

	public TweetAggregateWritable(){};
	
	private float tweetSeriesAverage;
	private TreeMap<Short, Byte> tweetSeries;
	private TreeMap<Short, Byte> originalSeries;
	private TreeMap<Short, Byte> repostSeries;
	private HashMap<Byte, Byte> dailyPostStat;
	private HashMap<Byte, Byte> type;
	private long sinceID;
	private long maximalRepost;
	private float originalSeriesAverage;
	private float repostSeriesAverage;
	private float originalRatio;
	private float repostRatio;
	private HashMap<String, Float> brands;
	private HashMap<String , Float> interests;
	private HashMap<String, Integer> atList;
	private HashMap<String,Integer> source;
	private HashMap<Long, Integer> repost;

	
	@Override
	public void readFields(DataInput in) throws IOException 
	{
		tweetSeriesAverage = in.readFloat();
		tweetSeries = HadoopIOUtils.shortByteMapRead(in);
		originalSeries = HadoopIOUtils.shortByteMapRead(in);
		repostSeries = HadoopIOUtils.shortByteMapRead(in);
		dailyPostStat = HadoopIOUtils.byteMapRead(in);
		type = HadoopIOUtils.byteMapRead(in);
		sinceID = in.readLong();
		maximalRepost = in.readLong();
		originalSeriesAverage = in.readFloat();
		repostSeriesAverage = in.readFloat();
		originalRatio = in.readFloat();
		repostRatio = in.readFloat();
		brands = HadoopIOUtils.stringFloatMapRead(in);
		interests = HadoopIOUtils.stringFloatMapRead(in);
		atList = HadoopIOUtils.stringIntegerMapRead(in);
		source = HadoopIOUtils.stringIntegerMapRead(in);
		repost = HadoopIOUtils.longIntegerMapRead(in);
	}

	@Override
	public void write(DataOutput out) throws IOException 
	{
		
		out.writeFloat(tweetSeriesAverage);
		HadoopIOUtils.shortByteMapWrite(tweetSeries, out);
		HadoopIOUtils.shortByteMapWrite(originalSeries, out);
		HadoopIOUtils.shortByteMapWrite(repostSeries, out);
		HadoopIOUtils.byteMapWrite(dailyPostStat, out);
		HadoopIOUtils.byteMapWrite(type, out);
		out.writeLong(sinceID);
		out.writeLong(maximalRepost);
		out.writeFloat(originalSeriesAverage);
		out.writeFloat(repostSeriesAverage);
		out.writeFloat(originalRatio);
		out.writeFloat(repostRatio);
		HadoopIOUtils.stringFloatMapWrite(brands, out);
		HadoopIOUtils.stringFloatMapWrite(interests, out);
		HadoopIOUtils.stringIntegerMapWrite(atList, out);
		HadoopIOUtils.stringIntegerMapWrite(source, out);
		HadoopIOUtils.longIntegerMapWrite(repost, out);
	}
	
	
	
	
	
	public float getTweetSeriesAverage() {
		return tweetSeriesAverage;
	}

	public void setTweetSeriesAverage(float tweetSeriesAverage) {
		this.tweetSeriesAverage = tweetSeriesAverage;
	}

	public TreeMap<Short, Byte> getTweetSeries() {
		return tweetSeries;
	}

	public void setTweetSeries(TreeMap<Short, Byte> tweetSeries) {
		this.tweetSeries = tweetSeries;
	}

	public TreeMap<Short, Byte> getOriginalSeries() {
		return originalSeries;
	}

	public void setOriginalSeries(TreeMap<Short, Byte> originalSeries) {
		this.originalSeries = originalSeries;
	}

	public TreeMap<Short, Byte> getRepostSeries() {
		return repostSeries;
	}

	public void setRepostSeries(TreeMap<Short, Byte> repostSeries) {
		this.repostSeries = repostSeries;
	}

	public HashMap<Byte, Byte> getDailyPostStat() {
		return dailyPostStat;
	}

	public void setDailyPostStat(HashMap<Byte, Byte> dailyPostStat) {
		this.dailyPostStat = dailyPostStat;
	}

	public HashMap<Byte, Byte> getType() {
		return type;
	}

	public void setType(HashMap<Byte, Byte> type) {
		this.type = type;
	}

	public long getSinceID() {
		return sinceID;
	}

	public void setSinceID(long sinceID) {
		this.sinceID = sinceID;
	}

	public long getMaximalRepost() {
		return maximalRepost;
	}

	public void setMaximalRepost(long maximalRepost) {
		this.maximalRepost = maximalRepost;
	}

	public float getOriginalSeriesAverage() {
		return originalSeriesAverage;
	}

	public void setOriginalSeriesAverage(float originalSeriesAverage) {
		this.originalSeriesAverage = originalSeriesAverage;
	}

	public float getRepostSeriesAverage() {
		return repostSeriesAverage;
	}

	public void setRepostSeriesAverage(float repostSeriesAverage) {
		this.repostSeriesAverage = repostSeriesAverage;
	}

	public float getOriginalRatio() {
		return originalRatio;
	}

	public void setOriginalRatio(float originalRatio) {
		this.originalRatio = originalRatio;
	}

	public float getRepostRatio() {
		return repostRatio;
	}

	public void setRepostRatio(float repostRatio) {
		this.repostRatio = repostRatio;
	}

	public HashMap<String, Float> getBrands() {
		return brands;
	}

	public void setBrands(HashMap<String, Float> brands) {
		this.brands = brands;
	}

	public HashMap<String, Float> getInterests() {
		return interests;
	}

	public void setInterests(HashMap<String, Float> interests) {
		this.interests = interests;
	}

	public HashMap<String, Integer> getAtList() {
		return atList;
	}

	public void setAtList(HashMap<String, Integer> atList) {
		this.atList = atList;
	}

	public HashMap<Long, Integer> getRepost() {
		return repost;
	}

	public void setRepost(HashMap<Long, Integer> repost) {
		this.repost = repost;
	}

	public HashMap<String, Integer> getSource() {
		return source;
	}

	public void setSource(HashMap<String, Integer> source) {
		this.source = source;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString()
	{
		return null;
//		return JSON.toJSONString(this);
	}
	
	
//	public static void main(String[] args)
//	{
//		
//		TweetAggregateWritable tw = new TweetAggregateWritable();
//		TreeMap<Short,Byte> tweetSeries = new TreeMap<>();
//		tweetSeries.put((short)11, (byte)200);
//		HashMap<String, Integer> atList = new HashMap<>();
//		atList.put("fuck", 1);
//		tw.setAtList(atList);
//		tw.setTweetSeries(tweetSeries );
//		System.out.println(tw.toString() );
//	}
}
