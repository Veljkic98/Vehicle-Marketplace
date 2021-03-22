package marketplace.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import marketplace.backend.dto.requestDTO.AdminRequestDTO;
import marketplace.backend.dto.responseDTO.AdminResponseDTO;
import marketplace.backend.model.Admin;

public class AdminMapper implements MyMapper<Admin, AdminResponseDTO, AdminRequestDTO> {

    @Override
    public Admin toEntity(AdminRequestDTO dto) {

        return new Admin(dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getPassword());
    }

    @Override
    public AdminResponseDTO toDto(Admin entity) {

        return new AdminResponseDTO(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getEmail());
    }

    @Override
    public List<AdminResponseDTO> toDtoList(List<Admin> entityList) {
        
        List<AdminResponseDTO> adminDTOs = new ArrayList<>();

        for (Admin admin : entityList) {
            adminDTOs.add(toDto(admin));
        }

        return adminDTOs;
    }
    
}
