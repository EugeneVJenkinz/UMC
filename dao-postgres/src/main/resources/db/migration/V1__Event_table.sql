CREATE TABLE IF NOT EXISTS events (
    id              UUID            PRIMARY KEY,
    name            VARCHAR(255)                    NOT NULL,
    start_time      TIMESTAMP                       NOT NULL,
    end_time        TIMESTAMP                       NOT NULL
);

CREATE TABLE IF NOT EXISTS event_venue (
    event_id        UUID REFERENCES events(id),
    venue_id        UUID REFERENCES venues(id),
    PRIMARY KEY (event_id, venue_id)
);