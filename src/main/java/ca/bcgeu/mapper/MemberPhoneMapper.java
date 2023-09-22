package ca.bcgeu.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import ca.bcgeu.dto.request.MemberPhoneRequestDTO;
import ca.bcgeu.dto.response.MemberPhoneResponseDTO;
import ca.bcgeu.entity.MemberPhone;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberPhoneMapper {
	
	@Mapping(source = "memberId", target = "member.id") 
	MemberPhone toEntity(MemberPhoneRequestDTO memberPhoneDTO);
	
	MemberPhoneResponseDTO toDTO(MemberPhone memberPhone);

}

