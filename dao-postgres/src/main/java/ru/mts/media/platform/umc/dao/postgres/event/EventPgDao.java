package ru.mts.media.platform.umc.dao.postgres.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mts.media.platform.umc.dao.postgres.venue.VenuePgMapper;
import ru.mts.media.platform.umc.dao.postgres.venue.VenuePgRepository;
import ru.mts.media.platform.umc.domain.event.EventSot;
import ru.mts.media.platform.umc.domain.gql.types.Event;
import ru.mts.media.platform.umc.domain.gql.types.Venue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class EventPgDao implements EventSot {

    private final EventPgMapper eventPgMapper;
    private final VenuePgMapper venuePgMapper;
    private final EventPgRepository eventPgRepository;
    private final VenuePgRepository venuePgRepository;

    @Override
    public List<Event> findAllEvents() {
        return eventPgRepository.findAll().stream()
                .map(eventPgMapper::asModel)
                .toList();
    }

    @Override
    public List<Venue> findAllVenuesWithEvents() {
        return eventPgRepository.findAllVenuesWithEvents().stream()
                .map(venuePgMapper::asModel)
                .toList();
    }

    @Override
    public Event createEvent(String venueId, String name, String startTime, String endTime) {
        var venue = venuePgRepository.findByReferenceId(venueId);
        var event = new EventPgEntity();
        event.setName(name);
        event.setStartTime(LocalDateTime.parse(startTime));
        event.setEndTime(LocalDateTime.parse(endTime));
        event.setVenues(Set.of(venue));
        return eventPgMapper.asModel(eventPgRepository.save(event));
    }
}
