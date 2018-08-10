package com.guessingGame.interfaces;

import com.guessingGame.resultTypes.MathType;
import com.guessingGame.resultTypes.PracticeType;

public interface BuildMathTypes {
	public PracticeType buildPracticeType(int a, int b);
	
	public MathType buildMathType(int a, int b, boolean c);
}
