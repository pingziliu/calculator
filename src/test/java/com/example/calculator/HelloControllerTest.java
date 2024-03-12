package com.example.calculator;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.calculator.constant.OpConstants;
import com.example.calculator.service.impl.CalculatorOperation;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Greetings from Spring Boot!")));

		CalculatorOperation calculatorOperation = new CalculatorOperation();
		calculatorOperation.calc(OpConstants.OpType.ADD, 55);
		calculatorOperation.calc(OpConstants.OpType.SUBTRACT, 31);
		calculatorOperation.calc(OpConstants.OpType.RIDE, 5);
		calculatorOperation.calc(OpConstants.OpType.DIVIDE, 0);
		calculatorOperation.calc(OpConstants.OpType.DIVIDE, 6);
		//撤销前三个步骤
		calculatorOperation.undo(3);
		//再次执行最近两个步骤
		calculatorOperation.redo(2);
	}
}