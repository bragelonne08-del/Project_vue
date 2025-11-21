package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("manual")
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(1L)
                .name("CAMT")
                .build());
        organizerList.add(Organizer.builder()
                .id(2L)
                .name("CMU")
                .build());
        organizerList.add(Organizer.builder()
                .id(3L)
                .name("ChiangMai")
                .build());
    }

    @Override
    public List<Organizer> getAllOrganizer() {
        return organizerList;
    }

    @Override
    public Page<Organizer> getOrganizer(Pageable pageRequest) {
        return new PageImpl<>(organizerList, pageRequest, organizerList.size());
    }

    @Override
    public Organizer save(Organizer organizer) {
        organizer.setId(organizerList.get(organizerList.size() - 1).getId() + 1);
        organizerList.add(organizer);
        return organizer;
    }

    @Override
    public Optional<Organizer> findById(Long id) {
        return organizerList.stream().filter(o -> o.getId().equals(id)).findFirst();
    }
}
