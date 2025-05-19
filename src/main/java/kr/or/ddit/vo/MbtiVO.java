package kr.or.ddit.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * Domain Layer : 테이블의 스키마(엔터티 구조)를 반영함
 * JavaBean 규약에 따라 개발되어야 함 -> lombok 활용중 
 */
@Data
@EqualsAndHashCode(of = "mtType")
@NoArgsConstructor
@AllArgsConstructor
public class MbtiVO {
	public MbtiVO(String mtType) {
		super();
		this.mtType = mtType;
	}
	private Integer mtSort;
	private String mtType;
	private String mtTitle;
	private String mtContent;
	
}
