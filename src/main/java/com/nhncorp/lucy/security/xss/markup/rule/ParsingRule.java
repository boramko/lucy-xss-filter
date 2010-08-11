/*
 * @(#) ParsingRule.java 2010. 8. 11 
 *
 * Copyright 2010 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.nhncorp.lucy.security.xss.markup.rule;

/**
 * 이 클래스는 패키지 외부에서 참조 되지 않는다.
 * 
 * @author Web Platform Development Team
 * 
 */
abstract class ParsingRule {

	public enum UNARY {
		OPTION,	REPEAT0, REPEAT1, ONE;

		public static UNARY getValue(char ch) {
			switch (ch) {
			case '?':
				return OPTION;
			case '*':
				return REPEAT0;
			case '+':
				return REPEAT1;
			}
			return ONE;
		}
	}


	protected UNARY unary = UNARY.ONE;


	public UNARY getUnary() {
		return this.unary;
	}

	public void setUnary(UNARY unary) {
		this.unary = unary;
	}

	public boolean isOptional() {
		switch (unary) {
		case OPTION :
		case REPEAT0 :
			return true;
		}
		return false;
	}

	public boolean isRepeat() {
		switch (this.getUnary()) {
			case REPEAT0 :
			case REPEAT1 :
				return true;
		}
		return false;
	}
}