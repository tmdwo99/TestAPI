package org.dsu.dc.capston.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ApiVO {
	private String name;
	private String pm10Value;
}