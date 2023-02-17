package com.ty.springboot_hospitalproject.util;

import lombok.Data;

@Data
public class RespnseStructure<X> {

	
	private String message;
	private int status;
	private X data;
}
