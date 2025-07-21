package ru.mts.media.platform.umc.domain.event;

import ru.mts.media.platform.umc.domain.gql.types.Event;
import ru.mts.media.platform.umc.domain.gql.types.Venue;

import java.util.List;

public interface EventSot {

    List<Event> findAllEvents();

    List<Venue> findAllVenuesWithEvents();

    Event createEvent(String venueId, String name, String startTime, String endTime);
}
