package marketplace.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import marketplace.backend.dto.requestDTO.VehicleRequestDTO;
import marketplace.backend.dto.responseDTO.VehicleResponseDTO;
import marketplace.backend.model.FuelType;
import marketplace.backend.model.Model;
import marketplace.backend.model.Vehicle;
import marketplace.backend.model.VehicleType;

@Service
public class VehicleMapper implements MyMapper<Vehicle, VehicleResponseDTO, VehicleRequestDTO> {

    @Override
    public Vehicle toEntity(VehicleRequestDTO dto) {

        Model model = new Model();
        model.setId(dto.getModelId());

        VehicleType vehicleType = new VehicleType();
        vehicleType.setId(dto.getVehicleTypeId());

        FuelType fuelType = new FuelType();
        fuelType.setId(dto.getFuelTypeId());

        return new Vehicle(dto.getFirstRegistration(), dto.getKilometer(), dto.getPower(), dto.getCubicCapacity(),
                dto.getNumberOfDoors(), model, vehicleType, fuelType);
    }

    @Override
    public VehicleResponseDTO toDto(Vehicle entity) {

        return new VehicleResponseDTO(entity.getId(), entity.getFirstRegistration(), entity.getKilometer(),
                entity.getPower(), entity.getCubicCapacity(), entity.getNumberOfDoors(), entity.getModel().getId(),
                entity.getVehicleType().getId(), entity.getFuelType().getId());
    }

    @Override
    public List<VehicleResponseDTO> toDtoList(List<Vehicle> entityList) {

        List<VehicleResponseDTO> responseDTOs = new ArrayList<>();

        for (Vehicle vehicle : entityList)
            responseDTOs.add(toDto(vehicle));

        return responseDTOs;
    }

}
