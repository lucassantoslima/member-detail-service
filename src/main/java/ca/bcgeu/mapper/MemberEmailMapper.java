package ca.bcgeu.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import ca.bcgeu.dto.request.MemberEmailRequestDTO;
import ca.bcgeu.dto.response.MemberEmailResponseDTO;
import ca.bcgeu.entity.MemberEmail;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberEmailMapper {
	
	@Mapping(source = "memberId", target = "member.id") 
	MemberEmail toEntity(MemberEmailRequestDTO memberEmailDTO);
	
	MemberEmailResponseDTO toDTO(MemberEmail memberEmail);
	
}