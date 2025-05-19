package kr.or.ddit.mbti.service;

import java.util.List;

import kr.or.ddit.mbti.MbtiNotFoundException;
import kr.or.ddit.vo.MbtiVO;

public interface MbtiService {
	public boolean createMbti(MbtiVO mbti);
	public List<MbtiVO> readMbtiList();
	/**
	 * @param mtType
	 * @return
	 * @throws MbtiNotFoundException mtType이 존재하지 않는 경우, 발생할 예외
	 */
	public MbtiVO readMbti(String mtType) throws MbtiNotFoundException;
	public boolean modify(MbtiVO mbti);
	public boolean remove(String mtType);
}
