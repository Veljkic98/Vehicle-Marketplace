package marketplace.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import marketplace.backend.dto.requestDTO.MakeRequestDTO;
import marketplace.backend.dto.responseDTO.MakeResponseDTO;
import marketplace.backend.model.Make;
import marketplace.backend.model.Model;

public class MakeMapper implements MyMapper<Make, MakeResponseDTO, MakeRequestDTO> {

    @Override
    public Make toEntity(MakeRequestDTO dto) {
        
        Model model = new Model();
        model.setId(dto.getModelId());

        return new Make(dto.getName(), model);
    }

    @Override
    public MakeResponseDTO toDto(Make entity) {
        
        return new MakeResponseDTO(entity.getId(), entity.getName(), entity.getModel().getId());
    }

    @Override
    public List<MakeResponseDTO> toDtoList(List<Make> entityList) {
        
        List<MakeResponseDTO> responseDTOs = new ArrayList<>();

        for (Make make : entityList) {
            responseDTOs.add(toDto(make));
        }

        return responseDTOs;
    }
    
}
