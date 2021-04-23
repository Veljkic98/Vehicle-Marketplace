package marketplace.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import marketplace.backend.dto.requestDTO.ModelRequestDTO;
import marketplace.backend.dto.responseDTO.ModelResponseDTO;
import marketplace.backend.model.FuelType;
import marketplace.backend.model.Model;
import marketplace.backend.model.VehicleType;


@Service
public class ModelMapper implements MyMapper<Model, ModelResponseDTO, ModelRequestDTO> {

    @Override
    public Model toEntity(ModelRequestDTO dto) {

        VehicleType vehicleType = new VehicleType();
        vehicleType.setId(dto.getVehicleTypeId());

        FuelType fuelType = new FuelType();
        fuelType.setId(dto.getFuelTypeId());

        return new Model(dto.getName(), vehicleType, fuelType);
    }

    @Override
    public ModelResponseDTO toDto(Model entity) {

        return new ModelResponseDTO(entity.getId(), entity.getName(), entity.getVehicleType().getId(),
                entity.getFuelType().getId());
    }

    @Override
    public List<ModelResponseDTO> toDtoList(List<Model> entityList) {

        List<ModelResponseDTO> responseDTOs = new ArrayList<>();

        for (Model model : entityList)
            responseDTOs.add(toDto(model));

        return responseDTOs;
    }

}
