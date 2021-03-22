package marketplace.backend.mapper;

import java.util.List;


public interface Mapper<T, U, Z> {

    T toEntity(Z dto);

    U toDto(T entity);

    List<U> toDtoList(List<T> entityList);
}
