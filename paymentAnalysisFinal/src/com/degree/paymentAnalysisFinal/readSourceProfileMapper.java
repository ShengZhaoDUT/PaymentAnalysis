package com.degree.paymentAnalysisFinal;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class readSourceProfileMapper extends Mapper<LongWritable, TweetAggregateWritable, LongWritable, profileWritable>{
	// read source profile
	private static Map<String, Integer> deviceForGlo = new HashMap<String, Integer>();
	private Map<Integer, Float> deviceForPeople = new HashMap<Integer, Float>();

	private int sum;
	public void setup(Context context) {
		getDeviceForGlo();
	}
	public void map(LongWritable key, TweetAggregateWritable value, Context context) throws IOException, InterruptedException {
		HashMap<String, Integer> device = value.getSource();
		deviceForPeople.clear();
		sum = 0;
		for(Map.Entry<String, Integer> entry : device.entrySet()) {
			String brandName = entry.getKey();
			int times = entry.getValue();
			sum += times;
			if(deviceForGlo.containsKey(value)) {
				int deviceCat = deviceForGlo.get(value);
				try {
					deviceForPeople.put(deviceCat, deviceForPeople.get(deviceCat) + times);
				} catch(Exception e) {
					deviceForPeople.put(deviceCat, (float) times);
				}
			}
			else if(brandName.contains("iPhone") || brandName.contains("iphone")) {
				try {
					deviceForPeople.put(2,  deviceForPeople.get(2) + times);
				} catch(Exception e) {
					deviceForPeople.put(2, (float) times);
				}
			}
			else if(brandName.contains("手机")) {
				try {
					deviceForPeople.put(3, deviceForPeople.get(3) + times);
				} catch(Exception e) {
					deviceForPeople.put(3, (float) times);
				}
			}
			else {
				try{
					deviceForPeople.put(1, deviceForPeople.get(1) + times);
				} catch(Exception e) {
					deviceForPeople.put(1, (float) times);
				}
			}
		}

		for(Map.Entry<Integer, Float> entry : deviceForPeople.entrySet()) {
			int mapkey = entry.getKey();
			float mapvalue = (float) (entry.getValue() * 1.0 / sum);
			deviceForPeople.put(mapkey, mapvalue);
		}

		if(!deviceForPeople.containsKey(1)) {
			deviceForPeople.put(1, (float) 0.0);
		}
		if(!deviceForPeople.containsKey(2)) {
			deviceForPeople.put(2, (float) 0.0);
		}
		if(!deviceForPeople.containsKey(3)) {
			deviceForPeople.put(3, (float) 0.0);
		}
		context.write(key, new profileWritable(deviceForPeople.get(1), deviceForPeople.get(3), deviceForPeople.get(2)));
	}
	private void getDeviceForGlo() {
		deviceForGlo.put("iPhone客户端", 2);
		deviceForGlo.put("新浪微博", 1);
		deviceForGlo.put("Android客户端", 3);
		deviceForGlo.put("专业版微博", 1);
		deviceForGlo.put("360浏览器超速版", 1);
		deviceForGlo.put("Weico.iPhone", 2);
		deviceForGlo.put("三星Galaxy Note II", 2);
		deviceForGlo.put("360安全浏览器", 1);
		deviceForGlo.put("微博桌面", 1);
		deviceForGlo.put("WeicoPro", 2);
		deviceForGlo.put("新浪博客", 1);
		deviceForGlo.put("三星Galaxy SIII", 2);
		deviceForGlo.put("新浪微博手机版", 3);
		deviceForGlo.put("三星android智能手机", 3);
		deviceForGlo.put("Weico.Android", 3);
		deviceForGlo.put("微话题", 1);
		deviceForGlo.put("微博搜索", 1);
		deviceForGlo.put("分享按钮", 1);
		deviceForGlo.put("新浪微博G3版", 1);
		deviceForGlo.put("三星GALAXY S4", 2);
		deviceForGlo.put("小米手机", 3);
		deviceForGlo.put("小米手机1S", 3);
		deviceForGlo.put("S60客户端", 3);
	}
}

