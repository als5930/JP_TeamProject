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
public class ProductVO {

	public String p_code;
	public String p_name;
	public String p_item;
	public String p_menuf;
	public String p_dcode;
	public String p_vat;
	public int p_iprice;
	public int p_oprice;

}
