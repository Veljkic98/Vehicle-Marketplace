package marketplace.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import marketplace.backend.dto.requestDTO.VehicleTypeRequestDTO;
import marketplace.backend.dto.responseDTO.VehicleTypeResponseDTO;
import marketplace.backend.model.VehicleType;

public class VehicleTypeMapper implements MyMapper<VehicleType, VehicleTypeResponseDTO, VehicleTypeRequestDTO> {

    @Override
    public VehicleType toEntity(VehicleTypeRequestDTO dto) {

        return new VehicleType(dto.getName());
    }

    @Override
    public VehicleTypeResponseDTO toDto(VehicleType entity) {

        return new VehicleTypeResponseDTO(entity.getId(), entity.getName());
    }

    @Override
    public List<VehicleTypeResponseDTO> toDtoList(List<VehicleType> entityList) {
        
        List<VehicleTypeResponseDTO> responseDTOs = new ArrayList<>();

        for (VehicleType vehicleType : entityList)
            responseDTOs.add(toDto(vehicleType));

        return responseDTOs;
    }

}
