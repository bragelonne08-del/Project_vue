package se331.lab.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.entity.Organizer;

import java.util.List;
import java.util.Optional;

public interface OrganizerDao {
    List<Organizer> getAllOrganizer();
    Page<Organizer> getOrganizer(Pageable pageRequest);
    Organizer save(Organizer organizer);
    Optional<Organizer> findById(Long id);
}