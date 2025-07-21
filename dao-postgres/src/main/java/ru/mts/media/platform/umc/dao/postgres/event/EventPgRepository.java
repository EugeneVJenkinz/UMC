package ru.mts.media.platform.umc.dao.postgres.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mts.media.platform.umc.dao.postgres.venue.VenuePgEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface EventPgRepository extends JpaRepository<EventPgEntity, UUID> {

    List<VenuePgEntity> findAllVenuesWithEvents();
}
