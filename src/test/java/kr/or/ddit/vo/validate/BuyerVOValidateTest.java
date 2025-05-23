package kr.or.ddit.vo.validate;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class BuyerVOValidateTest {
	static Validator validator;
	
	@BeforeAll
	static void beforeClass() {
		ValidatorFactory validatorFactory = 
				Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}
	
	@Test
	void testToMap() {
		BuyerVO target = new BuyerVO();
		
		Set<ConstraintViolation<BuyerVO>> constraintViolations 
				= validator.validate(target, UpdateGroup.class);
		boolean valid = constraintViolations.isEmpty();
		log.info("검증 통과 여부 : {}, {}", valid, constraintViolations.size());
		Map<String, String>errors = constraintViolations.stream()
										.collect(Collectors.toMap(
												(cv)->cv.getPropertyPath().toString(),
												(cv)->cv.getMessage(),
												(v1, v2)->v1 + "," + v2
										));
		errors.forEach((k,v) -> log.info("{} - {}", k, v));
	}
	
	@Test
	void testGroupHint() {
		BuyerVO target = new BuyerVO();
		
		Set<ConstraintViolation<BuyerVO>> constraintViolations 
			= validator.validate(target, UpdateGroup.class);
		boolean valid = constraintViolations.isEmpty();
		log.info("검증 통과 여부 : {}, {}", valid, constraintViolations.size());
		constraintViolations.stream()
			.forEach((cv) -> {
				String propName = cv.getPropertyPath().toString();
				String message = cv.getMessage();
				log.info("porperty: {} . - {}", propName, message);
			});
	}

	@Test
	@Disabled
	void test() {
		BuyerVO target = new BuyerVO();
		target.setBuyerName("제조사명");
		target.setBuyerId("P10101");
		target.setProdList(List.of(new ProdVO()));
		target.setBuyerMail("asdasd");
		
		Set<ConstraintViolation<BuyerVO>> constraintViolations 
			= validator.validate(target);
		boolean valid = constraintViolations.isEmpty();
		log.info("검증 통과 여부 : {}, {}", valid, constraintViolations.size());
		constraintViolations.stream()
			.forEach((cv) -> {
				String propName = cv.getPropertyPath().toString();
				String message = cv.getMessage();
				log.info("porperty: {} . - {}", propName, message);
			});
	}

}
