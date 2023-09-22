package ca.bcgeu.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import ca.bcgeu.dto.response.MemberResponseDTO;
import ca.bcgeu.service.MemberService;

@WebMvcTest(MemberController.class)
public class MemberControllerIntTest {

	@MockBean
	MemberService memberService;

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	MemberController memberController;

	@Test
	public void contextLoads() {
		Assertions.assertNotNull(memberController);
	}

	@Test
	@WithMockUser(username = "ravi", password = "password", roles = "USER")
	public void shouldfindAllMembers() throws Exception {
		
		List<MemberResponseDTO> listOfMembers = Arrays
				.asList(MemberResponseDTO.builder().id(1l).name("Ravi").number("BC12345").build());

		Mockito.when(memberService.findAll()).thenReturn(listOfMembers);

		mockMvc.perform(get("/members")).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.hasSize(1))).andExpect(jsonPath("$[0].name", Matchers.is("Ravi")));
	}
	
	@Test
	@WithMockUser(username = "ravi", password = "password", roles = "USER")
	public void shouldfindByNumber() throws Exception {
		
		String memberNumber = "BC12345";
		
		MemberResponseDTO memberRespDTO = MemberResponseDTO.builder().id(1l).name("Ravi").number(memberNumber).build();

		Mockito.when(memberService.findByNumber(memberNumber)).thenReturn(memberRespDTO);

		mockMvc.perform(get("/members/" + memberNumber)).andExpect(status().isOk())
				.andExpect(jsonPath("$.name", Matchers.is("Ravi")));
	}

}
