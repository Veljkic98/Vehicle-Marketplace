package marketplace.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import marketplace.backend.dto.requestDTO.OfferRequestDTO;
import marketplace.backend.dto.responseDTO.OfferResponseDTO;
import marketplace.backend.model.Location;
import marketplace.backend.model.Offer;
import marketplace.backend.model.Vehicle;

@Service
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

        String imageUri = "";

        try {
            imageUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("api/files/")
                    .path(entity.getImages().getId() + "").toUriString();
        } catch (NullPointerException e) {
            imageUri = "";
        }

        return new OfferResponseDTO(entity.getId(), entity.getDate(), entity.getDescription(), entity.getPrice(),
                entity.getLocation().getId(), entity.getVehicle().getId(), entity.getAuthenticatedUser().getId(), imageUri);
    }

    @Override
    public List<OfferResponseDTO> toDtoList(List<Offer> entityList) {

        List<OfferResponseDTO> responseDTOs = new ArrayList<>();

        for (Offer offer : entityList)
            responseDTOs.add(toDto(offer));

        return responseDTOs;
    }

    public Page<OfferResponseDTO> toDtoPage(Page<Offer> entityPage) {

        List<OfferResponseDTO> DTOs = toDtoList(entityPage.toList());
        
        Page<OfferResponseDTO> pageResponse = new PageImpl<>(DTOs, entityPage.getPageable(), entityPage.getTotalElements());

        return pageResponse;
    }

}
