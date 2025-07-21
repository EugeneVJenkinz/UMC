package ru.mts.media.platform.umc.dao.postgres.event;

import org.mapstruct.Mapper;
import ru.mts.media.platform.umc.domain.gql.types.Event;
import ru.mts.media.platform.umc.domain.gql.types.EventInput;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface EventPgMapper {

    Event asModel(EventPgEntity eventPgEntity);

    EventPgEntity toEntity(EventInput eventInput);
}
