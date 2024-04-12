package com.Despair;

import com.Despair.Question.QuestionService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DespairApplicationTests {

	@Autowired
	private QuestionService questionService;

	@Test
	void testJpa() {
		for (int i = 1; i <= 300; i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용 무";
			this.questionService.create(subject, content, null);
		}
	}


	// JUnit 테스트 할때 서버 끄기,
	// 쿼리가 2이상 반환된다는 오류가 뜰 시 H2콘솔로 들어가 2개 이상 DB가 들어가있어 리스트를 형성하고 있진 않는지 확인한다.
	// 응답 결과가 여러 건일 경우 Question 이 아닌, List<Question>으로 작성 하도록 하자.
}
