package com.biz.big.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DeptVO {
	
	private String d_code;
	private String d_name;
	private String d_sid;
	private String d_ceo;
	private String d_tel;
	private String d_addr;
	private String d_product;

}
