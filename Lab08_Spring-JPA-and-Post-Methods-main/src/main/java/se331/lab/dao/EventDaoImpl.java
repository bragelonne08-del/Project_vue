package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Event;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class EventDaoImpl implements EventDao {
    List<Event> eventList;

    @PostConstruct
    public void init() {
        eventList = new ArrayList<>();

        eventList.add(Event.builder()
                .id(123L)
                .category("animal welfare")
                .title("Cat Adoption Day")
                .description("Find your new feline friend at this event.")
                .location("Meow Town")
                .date("January 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .build());

        eventList.add(Event.builder()
                .id(456L)
                .category("food")
                .title("Community Gardening")
                .description("Join us as we tend to the community edible plants.")
                .location("Flora City")
                .date("March 14, 2022")
                .time("10:00")
                .petAllowed(true)
                .build());

        eventList.add(Event.builder()
                .id(789L)
                .category("animal welfare")
                .title("Dog Health Clinic")
                .description("Free checkups and vaccinations for dogs.")
                .location("Puptown")
                .date("April 10, 2022")
                .time("09:00")
                .petAllowed(true)
                .build());

        eventList.add(Event.builder()
                .id(101L)
                .category("food")
                .title("Local Food Fair")
                .description("Taste the best dishes from local vendors.")
                .location("Market Square")
                .date("May 1, 2022")
                .time("11:00")
                .petAllowed(false)
                .build());

        eventList.add(Event.builder()
                .id(202L)
                .category("sports")
                .title("City Marathon")
                .description("Run through the city with thousands of participants.")
                .location("Downtown")
                .date("June 18, 2022")
                .time("06:00")
                .petAllowed(false)
                .build());

        eventList.add(Event.builder()
                .id(303L)
                .category("education")
                .title("Book Club Meetup")
                .description("Discuss this month's book with fellow readers.")
                .location("Central Library")
                .date("July 9, 2022")
                .time("17:00")
                .petAllowed(false)
                .build());
    }

    @Override
    public Integer getEventSize() {
        return eventList.size();
    }

    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? eventList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        List<Event> subList = eventList.subList(firstIndex, firstIndex + pageSize);
        return new PageImpl<>(subList, PageRequest.of(page, pageSize), eventList.size());
    }

    @Override
    public Event getEvent(Long id) {
        return eventList.stream()
                .filter(event -> event.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Event save(Event event) {
        if (event.getId() == null) {
            Long nextId = eventList.isEmpty() ? 1L : eventList.get(eventList.size() - 1).getId() + 1;
            event.setId(nextId);
        }
        eventList.add(event);
        return event;
    }
}
