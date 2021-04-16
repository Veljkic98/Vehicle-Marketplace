package marketplace.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import marketplace.backend.dto.requestDTO.LocationRequestDTO;
import marketplace.backend.dto.responseDTO.LocationResponseDTO;
import marketplace.backend.model.Location;

public class LocationMapper implements MyMapper<Location, LocationResponseDTO, LocationRequestDTO> {

    @Override
    public Location toEntity(LocationRequestDTO dto) {
        
        return new Location(dto.getCountry(), dto.getCity());
    }

    @Override
    public LocationResponseDTO toDto(Location entity) {
        
        return new LocationResponseDTO(entity.getId(), entity.getCountry(), entity.getCity());
    }

    @Override
    public List<LocationResponseDTO> toDtoList(List<Location> entityList) {
        
        List<LocationResponseDTO> responseDTOs = new ArrayList<>();

        for (Location location : entityList)
            responseDTOs.add(toDto(location));

        return responseDTOs;
    }
    
}
