package com.degree.paymentAnalysisImprove;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class userProfileWritable implements Writable{
	
	private boolean flag;
	private int fansVSum;
	private int fansNum;
	private byte vertifyType;
	
	public userProfileWritable() {}

	public userProfileWritable(int fansNum, byte vertifyType) {
		this.fansNum = fansNum;
		this.vertifyType = vertifyType;
		this.flag = true;
		this.fansVSum = 0;
	}
	
	public userProfileWritable(int fansVSum) {
		this.fansVSum = fansVSum;
		this.flag = false;
		this.fansNum = 0;
		this.vertifyType = (byte)-1;
	}
	
	public String toString() {
		String valcontent = "";
//		valcontent = (String.valueOf(flag) + ",");
		valcontent += (String.valueOf(fansNum) + ",");
		valcontent += (String.valueOf(fansVSum) + ",");
		valcontent += (String.valueOf(vertifyType));
		return valcontent;
	}
	
	public userProfileWritable(boolean flag, int fansNum, byte vertifyType, int fansVSum) {
		this.flag = flag;
		this.fansNum = fansNum;
		this.vertifyType = vertifyType;
		this.fansVSum = fansVSum;
	}
	
	public boolean getFlag() {
		return flag;
	}
	
	public int getFansVSum() {
		return fansVSum;
	}
	
	public int getFansNum() {
		return fansNum;
	}
	
	public byte getVerify() {
		return vertifyType;
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		flag = in.readBoolean();
		vertifyType = in.readByte();
		fansVSum = in.readInt();
		fansNum = in.readInt();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeBoolean(flag);
		out.writeByte(vertifyType);
		out.writeInt(fansVSum);
		out.writeInt(fansNum);
	}
}