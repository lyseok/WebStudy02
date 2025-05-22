package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 하나의 제조사 정보
 * 하나의 제조사 분류 정보
 * N개의 거래품목 정보를 담기 위한 Domain
 * 
 * 제조사 관리용 Domain layer
 */
@Data
@EqualsAndHashCode(of="buyerId")
public class BuyerVO implements Serializable{
	private String buyerAdd1;
	private String buyerAdd2;
	private String buyerComtel;
	private String buyerFax;
	private String buyerMail;
	private String buyerCharger;
	private String buyerTelext;
	private String buyerId;
	private String buyerName;
	private String lprodGu;
	private String buyerBank;
	private String buyerBankno;
	private String buyerBankname;
	private String buyerZip;
	
	private LprodVO lprod;	// has a
	
	private List<ProdVO> prodList; // has Many
}

