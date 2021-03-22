package marketplace.backend.mapper;

import java.util.List;


public interface MyMapper<T, U, Z> {

    /**
     * Create and return Entity from DTO.
     * 
     * @param dto is DTO Object
     * @return Entity
     */
    T toEntity(Z dto);

    /**
     * Create and return DTO from Entity.
     * 
     * @param entity is Entity.
     * @return DTO.
     */
    U toDto(T entity);

    /**
     * Create and return list of DTO from list of Entities.
     * 
     * @param entityList is list of Entities.
     * @return List of DTOs.
     */
    List<U> toDtoList(List<T> entityList);
}
