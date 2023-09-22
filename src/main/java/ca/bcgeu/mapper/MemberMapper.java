package ca.bcgeu.mapper;

import java.util.Optional;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import ca.bcgeu.dto.request.MemberRequestDTO;
import ca.bcgeu.dto.response.MemberResponseDTO;
import ca.bcgeu.entity.Member;

@Mapper(uses = { MemberEmailMapper.class,
		MemberPhoneMapper.class }, componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {

	MemberResponseDTO toDTO(Member member);

	Member toEntity(MemberRequestDTO carDTO);

	@AfterMapping
	default void setMember(@MappingTarget Member member) {
		Optional.ofNullable(member.getEmails()).ifPresent(emails -> emails.forEach(email -> email.setMember(member)));
		Optional.ofNullable(member.getPhones()).ifPresent(phones -> phones.forEach(phone -> phone.setMember(member)));
	}

}
