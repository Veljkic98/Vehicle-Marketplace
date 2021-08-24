package marketplace.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import marketplace.backend.dto.requestDTO.MakeRequestDTO;
import marketplace.backend.dto.responseDTO.MakeResponseDTO;
import marketplace.backend.model.Make;

@Service
public class MakeMapper implements MyMapper<Make, MakeResponseDTO, MakeRequestDTO> {

    @Override
    public Make toEntity(MakeRequestDTO dto) {
        
        return new Make(dto.getName());
    }

    @Override
    public MakeResponseDTO toDto(Make entity) {
        
        return new MakeResponseDTO(entity.getId(), entity.getName());
    }

    @Override
    public List<MakeResponseDTO> toDtoList(List<Make> entityList) {
        
        List<MakeResponseDTO> responseDTOs = new ArrayList<>();

        for (Make make : entityList)
            responseDTOs.add(toDto(make));

        return responseDTOs;
    }
    
}
