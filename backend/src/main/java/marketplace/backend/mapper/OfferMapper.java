package marketplace.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import marketplace.backend.dto.requestDTO.OfferRequestDTO;
import marketplace.backend.dto.responseDTO.OfferResponseDTO;
import marketplace.backend.model.Location;
import marketplace.backend.model.Offer;
import marketplace.backend.model.Vehicle;

public class OfferMapper implements MyMapper<Offer, OfferResponseDTO, OfferRequestDTO> {

    @Override
    public Offer toEntity(OfferRequestDTO dto) {

        Location location = new Location();
        location.setId(dto.getLocationId());

        Vehicle vehicle = new Vehicle();
        vehicle.setId(dto.getVehicleId());

        return new Offer(dto.getDate(), dto.getDescription(), location, vehicle, dto.getPrice(), null);
    }

    @Override
    public OfferResponseDTO toDto(Offer entity) {

        return new OfferResponseDTO(entity.getId(), entity.getDate(), entity.getDescription(), entity.getPrice(),
                entity.getLocation().getId(), entity.getVehicle().getId(), entity.getAuthenticatedUser().getId());
    }

    @Override
    public List<OfferResponseDTO> toDtoList(List<Offer> entityList) {

        List<OfferResponseDTO> responseDTOs = new ArrayList<>();

        for (Offer offer : entityList)
            responseDTOs.add(toDto(offer));

        return responseDTOs;
    }

}
