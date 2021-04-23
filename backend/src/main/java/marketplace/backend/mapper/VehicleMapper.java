package marketplace.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import marketplace.backend.dto.requestDTO.VehicleRequestDTO;
import marketplace.backend.dto.responseDTO.VehicleResponseDTO;
import marketplace.backend.model.Make;
import marketplace.backend.model.Vehicle;

@Service
public class VehicleMapper implements MyMapper<Vehicle, VehicleResponseDTO, VehicleRequestDTO> {

    @Override
    public Vehicle toEntity(VehicleRequestDTO dto) {

        Make make = new Make();
        make.setId(dto.getMakeId());

        return new Vehicle(dto.getFirstRegistration(), dto.getKilometer(), dto.getPower(), dto.getCubicCapacity(),
                dto.getNumberOfDoors(), make);
    }

    @Override
    public VehicleResponseDTO toDto(Vehicle entity) {

        return new VehicleResponseDTO(entity.getId(), entity.getFirstRegistration(), entity.getKilometer(),
                entity.getPower(), entity.getCubicCapacity(), entity.getNumberOfDoors(), entity.getMake().getId());
    }

    @Override
    public List<VehicleResponseDTO> toDtoList(List<Vehicle> entityList) {
        
        List<VehicleResponseDTO> responseDTOs = new ArrayList<>();

        for (Vehicle vehicle : entityList) 
            responseDTOs.add(toDto(vehicle));

        return responseDTOs;
    }

}
