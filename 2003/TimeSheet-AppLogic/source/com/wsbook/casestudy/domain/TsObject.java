package com.wsbook.casestudy.domain;

import java.io.Serializable;

import com.wsbook.casestudy.mapping.Mapper;
import com.wsbook.casestudy.mapping.MapperFactory;
/**
 * Superclass that all Time Sheet system domain classes extend from.
 * Also, delegates persistent request to mapper class.
 * 
 * Creation date: (2/2/00 3:04:35 PM)
 * @author: Administrator
 */
public class TsObject implements java.io.Serializable {
	private transient Mapper mapper = null;
	/**
	 * TsObject constructor.
	 */
	public TsObject() {
		super();
	}

	public Mapper getMapper() {
		if (mapper == null) {
			mapper = MapperFactory.getSystemMapperFactory().getMapper(this.getClass());
			;
		}
		return mapper;
	}

}