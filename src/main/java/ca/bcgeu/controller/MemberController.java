package ca.bcgeu.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.bcgeu.dto.request.MemberEmailRequestDTO;
import ca.bcgeu.dto.request.MemberPhoneRequestDTO;
import ca.bcgeu.dto.request.MemberRequestDTO;
import ca.bcgeu.dto.response.MemberResponseDTO;
import ca.bcgeu.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
@Tag(name = "Member Resource")
public class MemberController {

	private final MemberService memberService;

	@Operation(summary = "List all members")
	@GetMapping
	public List<MemberResponseDTO> findAll() {
		return memberService.findAll();
	}

	@Operation(summary = "Retrieve member by member number")
	@GetMapping("/{number}")
	public MemberResponseDTO findByNumber(@PathVariable String number) {
		return memberService.findByNumber(number);
	}

	@Operation(summary = "Save member with emails and phones")
	@PostMapping
	public ResponseEntity<Object> save(@Validated @RequestBody MemberRequestDTO member) {
		this.memberService.save(member);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Operation(summary = "Save a specific email")
	@PostMapping("/{memberId}/emails")
	public ResponseEntity<Object> saveEmail(@PathVariable("memberId") Long memberId,
			@Validated @RequestBody MemberEmailRequestDTO email) {
		this.memberService.saveEmail(memberId, email);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Operation(summary = "Save a specific phone")
	@PostMapping("/{memberId}/phones")
	public ResponseEntity<Object> savePhone(@PathVariable("memberId") Long memberId,
			@Validated @RequestBody MemberPhoneRequestDTO phone) {
		this.memberService.savePhone(memberId, phone);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Operation(summary = "Update a specific email")
	@PutMapping("/{memberId}/emails/{emailId}")
	public ResponseEntity<Object> updateEmail(@PathVariable("memberId") Long memberId,
			@PathVariable("emailId") Long emailId, @Validated @RequestBody MemberEmailRequestDTO emailDTO) {
		this.memberService.updateEmail(memberId, emailId, emailDTO);
		return ResponseEntity.ok().build();
	}
	
	@Operation(summary = "Update a specific phone")
	@PutMapping("/{memberId}/phones/{phoneId}")
	public ResponseEntity<Object> updatePhone(@PathVariable("memberId") Long memberId,
			@PathVariable("phoneId") Long phoneId, @Validated @RequestBody MemberPhoneRequestDTO phoneDTO) {
		this.memberService.updatePhone(memberId, phoneId, phoneDTO);
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "Delete member with emails and phone")
	@DeleteMapping("{memberId}")
	public ResponseEntity<Void> delete(@PathVariable("memberId") Long memberId) {
		this.memberService.delete(memberId);
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "Delete a specific email")
	@DeleteMapping("/{memberId}/emails/{emailId}")
	public ResponseEntity<Void> deleteEmail(@PathVariable("memberId") Long memberId,
			@PathVariable("emailId") Long emailId) {
		this.memberService.deleteEmail(memberId, emailId);
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "Delete a specific phone")
	@DeleteMapping("/{memberId}/phones/{phoneId}")
	public ResponseEntity<Void> deletePhone(@PathVariable("memberId") Long memberId,
			@PathVariable("phoneId") Long emailId) {
		this.memberService.deletePhone(memberId, emailId);
		return ResponseEntity.ok().build();
	}

}
