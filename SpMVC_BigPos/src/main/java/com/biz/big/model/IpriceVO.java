package com.biz.big.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IpriceVO {

	private String io_date;
	private int io_qty;
	private int io_price;
	private String p_name;
	private int p_iprice;
	private String d_name;
	private String d_ceo;

	
	
	
	
}
