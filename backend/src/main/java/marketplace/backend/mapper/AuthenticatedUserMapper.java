package marketplace.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import marketplace.backend.dto.requestDTO.AuthenticatedUserRequestDTO;
import marketplace.backend.dto.responseDTO.AuthenticatedUserResponseDTO;
import marketplace.backend.model.AuthenticatedUser;

public class AuthenticatedUserMapper
        implements MyMapper<AuthenticatedUser, AuthenticatedUserResponseDTO, AuthenticatedUserRequestDTO> {

    @Override
    public AuthenticatedUser toEntity(AuthenticatedUserRequestDTO dto) {

        return new AuthenticatedUser(dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getPassword(),
                dto.getCompanyName(), null);
    }

    @Override
    public AuthenticatedUserResponseDTO toDto(AuthenticatedUser entity) {

        return new AuthenticatedUserResponseDTO(entity.getId(), entity.getFirstName(), entity.getLastName(),
                entity.getEmail(), entity.getCompanyName());
    }

    @Override
    public List<AuthenticatedUserResponseDTO> toDtoList(List<AuthenticatedUser> entityList) {

        List<AuthenticatedUserResponseDTO> responseDTOs = new ArrayList<>();

        for (AuthenticatedUser authenticatedUser : entityList)
            responseDTOs.add(toDto(authenticatedUser));

        return responseDTOs;
    }

}
