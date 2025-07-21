package ru.mts.media.platform.umc.api.gql.event;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;
import ru.mts.media.platform.umc.domain.event.EventSot;
import ru.mts.media.platform.umc.domain.gql.types.Event;
import ru.mts.media.platform.umc.domain.gql.types.Venue;

import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class EventDgsQuery {

    private final EventSot eventSot;

    @DgsQuery
    public List<Event> events() {
        return eventSot.findAllEvents();
    }

    @DgsQuery
    public List<Venue> venuesWithLatestEvents() {
        return eventSot.findAllVenuesWithEvents();
    }

    @DgsMutation
    public Event createEvent(
            @InputArgument String venueId,
            @InputArgument String name,
            @InputArgument String startTime,
            @InputArgument String endTime) {
        return eventSot.createEvent(venueId, name, startTime, endTime);
    }
}
