package com.degree.paymentAnalysisFinal;

public class configuration {
	// 先验
	public static float paymentHigh = (float) 0.166246851385;
	public static float paymentMedium = (float) 0.324937027708;
	public static float paymentLow = (float) 0.508816120907;
	// 地域
	public static float firstLevelHigh = (float) 0.3;
	public static float firstLevelMedium = (float) 0.3;
	public static float firstLevelLow = (float) 0.4;
	public static float secondLevelHigh = (float) 0.3;
	public static float secondLevelMedium = (float) 0.3;
	public static float secondLevelLow = (float) 0.4;
	public static float thirdLevelHigh = (float) 0.3;
	public static float thirdLevelMedium = (float) 0.3;
	public static float thirdLevelLow = (float) 0.4;
	// VIP
	public static float vHigh = (float) 0.939393939394;
	public static float vMedium = (float) 0.589147286822;
	public static float vLow = (float) 0.0990099009901;
	public static float nvHigh = (float) 0.0606060606061;
	public static float nvMedium = (float) 0.410852713178;
	public static float nvLow = (float) 0.90099009901;
	// fans
	// 0-50
	public static float fLevel1High = (float) 0.00657894736842;
	public static float fLevel1Medium = (float) 0.0345911949686;
	public static float fLevel1Low = (float) 0.19801980198;
	// 50-1000
	public static float fLevel2High = (float) 0.127631578947;
	public static float fLevel2Medium = (float) 0.459119496855;
	public static float fLevel2Low = (float) 0.559405940594;
	// 1000+
	public static float fLevel3High = (float) 0.865789473684;
	public static float fLevel3Medium = (float) 0.506289308176;
	public static float fLevel3Low = (float) 0.242574257426;
//	// 800+
//	public static float fLevel4High;
//	public static float fLevel4Medium;
//	public static float fLevel4Low;
	// 粉丝黄v
	// 0-5
	public static float qLevel1High = (float) 0.106060606061;
	public static float qLevel1Medium = (float) 0.279069767442;
	public static float qLevel1Low = (float) 0.668316831683;
	// 5-50
	public static float qLevel2High = (float) 0.378787878788;
	public static float qLevel2Medium = (float) 0.480620155039;
	public static float qLevel2Low = (float) 0.311881188119;
	// 50+
	public static float qLevel3High = (float) 0.5;
	public static float qLevel3Medium = (float) 0.22480620155;
	public static float qLevel3Low = (float) 0.019801980198;
	// SinaPc
	// 0-0.4
	public static float spLevel1High = (float) 0.379310344828;
	public static float splevel1Medium = (float) 0.393939393939;
	public static float splevel1Low = (float) 0.23417721519;
	// 0.4-1
	public static float spLevel2High = (float) 0.551724137931;
	public static float splevel2Medium = (float) 0.590909090909;
	public static float splevel2Low = (float) 0.753164556962;
	// MobileHigh
	// 0-0.4
	public static float mhLevel1High = (float) 0.51724137931;
	public static float mhlevel1Medium = (float) 0.598484848485;
	public static float mhlevel1Low = (float) 0.835443037975;
	// 0.4-1
	public static float mhLevel2High = (float) 0.413793103448;
	public static float mhlevel2Medium = (float) 0.386363636364;
	public static float mhlevel2Low = (float) 0.151898734177;	
	// MobileMedium
	// 0-0.3
	public static float mmLevel1High = (float) 0.793103448276;
	public static float mmlevel1Medium = (float) 0.886363636364;
	public static float mmlevel1Low = (float) 0.835443037975;
	// 0.3-1
	public static float mmLevel2High = (float) 0.137931034483;
	public static float mmlevel2Medium = (float) 0.0984848484848;
	public static float mmlevel2Low = (float) 0.151898734177;
	// PageRank influence
	// 0-10
	public static float prLevel1High = (float) 0.206896551724;
	public static float prlevel1Medium = (float) 0.257575757576;
	public static float prlevel1Low = (float) 0.772151898734;
	// 10-30
	public static float prLevel2High = (float) 0.275862068966;
	public static float prlevel2Medium = (float) 0.424242424242;
	public static float prlevel2Low = (float) 0.208860759494;
	// 30-100
	public static float prLevel3High = (float) 0.51724137931;
	public static float prlevel3Medium = (float) 0.318181818182;
	public static float prlevel3Low = (float) 0.0189873417722;
}
