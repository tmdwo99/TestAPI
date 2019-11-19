package org.dsu.dc.capston.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MapVO {
	private String name;
	private String addr;
	private double dmX;
	private double dmY;
}
