package kr.or.ddit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "mtType")
public class MbtiVO {
	private Integer mtSort;
	private String mtType;
	private String mtTitle;
	private String mtContent;
	
}
