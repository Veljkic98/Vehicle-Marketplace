package marketplace.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import marketplace.backend.dto.requestDTO.ModelRequestDTO;
import marketplace.backend.dto.responseDTO.ModelResponseDTO;
import marketplace.backend.model.Make;
import marketplace.backend.model.Model;

@Service
public class ModelMapper implements MyMapper<Model, ModelResponseDTO, ModelRequestDTO> {

    @Override
    public Model toEntity(ModelRequestDTO dto) {

        Make make = new Make();
        make.setId(dto.getMakeId());

        return new Model(dto.getName(), make);
    }

    @Override
    public ModelResponseDTO toDto(Model entity) {

        return new ModelResponseDTO(entity.getId(), entity.getName(), entity.getMake().getId());
    }

    @Override
    public List<ModelResponseDTO> toDtoList(List<Model> entityList) {

        List<ModelResponseDTO> responseDTOs = new ArrayList<>();

        for (Model model : entityList)
            responseDTOs.add(toDto(model));

        return responseDTOs;
    }

    /**
     * Convert Page of Model to Page of Model Response DTO.
     * 
     * @param entityPage is Model page
     * @return model response page
     */
    public Object toDtoPage(Page<Model> entityPage) {

        List<ModelResponseDTO> DTOs = toDtoList(entityPage.toList());

        Page<ModelResponseDTO> pageResponse = new PageImpl<>(DTOs, entityPage.getPageable(),
                entityPage.getTotalElements());

        return pageResponse;
    }

}
