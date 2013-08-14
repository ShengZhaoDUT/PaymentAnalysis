package com.degree.paymentAnalysisFinal;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class profileWritable implements Writable {
	
	

	private boolean catgory;
	private byte verifyType;
	private int fansNum;
	private int fansVNum;
	private float pc;
	private float mobiMed;
	private float mobiHig;
	
	public profileWritable() {}
	public profileWritable(byte verifyType, int fansNum, int fansVNum) {
		this.catgory = true;
		this.verifyType = verifyType;
		this.fansNum = fansNum;
		this.fansVNum = fansVNum;
	}
	public profileWritable(float pc, float mobiMed, float mobiHig) {
		this.catgory = false;
		this.pc = pc;
		this.mobiMed = mobiMed;
		this.mobiHig = mobiHig;
	}
	
	public boolean isCatgory() {
		return catgory;
	}
	public byte getVerifyType() {
		return verifyType;
	}
	public int getFansNum() {
		return fansNum;
	}
	public int getFansVNum() {
		return fansVNum;
	}
	public float getPc() {
		return pc;
	}
	public float getMobiMed() {
		return mobiMed;
	}
	public float getMobiHig() {
		return mobiHig;
	}
	public void setCatgory(boolean catgory) {
		this.catgory = catgory;
	}
	public void setVerifyType(byte verifyType) {
		this.verifyType = verifyType;
	}
	public void setFansNum(int fansNum) {
		this.fansNum = fansNum;
	}
	public void setFansVNum(int fansVNum) {
		this.fansVNum = fansVNum;
	}
	public void setPc(float pc) {
		this.pc = pc;
	}
	public void setMobiMed(float mobiMed) {
		this.mobiMed = mobiMed;
	}
	public void setMobiHig(float mobiHig) {
		this.mobiHig = mobiHig;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		catgory = in.readBoolean();
		verifyType = in.readByte();
		fansNum = in.readInt();
		fansVNum = in.readInt();
		pc = in.readFloat();
		mobiMed = in.readFloat();
		mobiHig = in.readFloat();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeBoolean(catgory);
		out.writeByte(verifyType);
		out.writeInt(fansNum);
		out.writeInt(fansVNum);
		out.writeFloat(pc);
		out.writeFloat(mobiMed);
		out.writeFloat(mobiHig);
	}
	
}
