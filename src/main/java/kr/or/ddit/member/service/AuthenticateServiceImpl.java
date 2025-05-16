package kr.or.ddit.member.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.mapper.MemberMapper;
import kr.or.ddit.mapper.impl.MemberMapperImpl;
import kr.or.ddit.vo.MemberVO;

/**
 * Layered Architecture : 하나의 명령이 처리되는 동안 순차적으로 객체들이 동작하는 구조
 * 		계층을 구성하고 있는 객체들간의 (의존)관계를 기반으로 한 설계 구조
 */
public class AuthenticateServiceImpl implements AuthenticateService {
	private MemberMapper dao = new MemberMapperImpl(); 
	
	@Override
	public boolean authenticate(MemberVO inputData) {
		MemberVO saved = dao.selectMember(inputData.getMemId());
		if(saved!=null) {
			String inputPass = inputData.getMemPassword();
			String savedPass = saved.getMemPassword();
			boolean result = savedPass.equals(inputPass);
			if(result) {
				try {
					BeanUtils.copyProperties(inputData, saved);
				} catch (IllegalAccessException | InvocationTargetException e) {
					throw new RuntimeException(e);
				}
			}
			return result;
		} else {
			return false;
		}
	}

}
