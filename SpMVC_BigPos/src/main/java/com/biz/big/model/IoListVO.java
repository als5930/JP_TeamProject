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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IoListVO {

	public int io_seq; 
	public String io_date;
	public String io_time;
	public String io_dcode;
	public String io_inout;
	public String io_pcode;
	public String io_vat ;
	public int io_qty;
	public int io_price;
	public int io_amt;
	public int io_tax;
	public int io_total;

}
