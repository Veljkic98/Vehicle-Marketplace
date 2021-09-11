package marketplace.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import marketplace.backend.dto.requestDTO.AuthenticatedUserRequestDTO;
import marketplace.backend.dto.responseDTO.AuthenticatedUserResponseDTO;
import marketplace.backend.model.AuthenticatedUser;

@Service
public class AuthenticatedUserMapper
        implements MyMapper<AuthenticatedUser, AuthenticatedUserResponseDTO, AuthenticatedUserRequestDTO> {

    @Override
    public AuthenticatedUser toEntity(AuthenticatedUserRequestDTO dto) {

        return new AuthenticatedUser(dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getPassword(),
                dto.getCompanyName(), null, dto.getPhoneNumber());
    }

    @Override
    public AuthenticatedUserResponseDTO toDto(AuthenticatedUser entity) {

        return new AuthenticatedUserResponseDTO(entity.getId(), entity.getFirstName(), entity.getLastName(),
                entity.getEmail(), entity.getCompanyName(), entity.getPhoneNumber());
    }

    @Override
    public List<AuthenticatedUserResponseDTO> toDtoList(List<AuthenticatedUser> entityList) {

        List<AuthenticatedUserResponseDTO> responseDTOs = new ArrayList<>();

        for (AuthenticatedUser authenticatedUser : entityList)
            responseDTOs.add(toDto(authenticatedUser));

        return responseDTOs;
    }

}
