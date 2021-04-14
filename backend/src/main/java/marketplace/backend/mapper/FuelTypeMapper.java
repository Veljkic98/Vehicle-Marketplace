package marketplace.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import marketplace.backend.dto.requestDTO.FuelTypeRequestDTO;
import marketplace.backend.dto.responseDTO.FuelTypeResponseDTO;
import marketplace.backend.model.FuelType;

public class FuelTypeMapper implements MyMapper<FuelType, FuelTypeResponseDTO, FuelTypeRequestDTO> {

    @Override
    public FuelType toEntity(FuelTypeRequestDTO dto) {

        return new FuelType(dto.getName());
    }

    @Override
    public FuelTypeResponseDTO toDto(FuelType entity) {

        return new FuelTypeResponseDTO(entity.getId(), entity.getName());
    }

    @Override
    public List<FuelTypeResponseDTO> toDtoList(List<FuelType> entityList) {

        List<FuelTypeResponseDTO> responseDTOs = new ArrayList<>();

        for (FuelType vehicleType : entityList) {
            responseDTOs.add(toDto(vehicleType));
        }

        return responseDTOs;
    }

}
