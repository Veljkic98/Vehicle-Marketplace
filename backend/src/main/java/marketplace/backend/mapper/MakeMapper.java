package marketplace.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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

    /**
     * Convert Page of Make to Page of Make Response DTO.
     * 
     * @param entityPage is Make page
     * @return Make response page
     */
    public Object toDtoPage(Page<Make> entityPage) {
        
        List<MakeResponseDTO> DTOs = toDtoList(entityPage.toList());

        Page<MakeResponseDTO> pageResponse = new PageImpl<>(DTOs, entityPage.getPageable(),
                entityPage.getTotalElements());

        return pageResponse;
    }
    
}
