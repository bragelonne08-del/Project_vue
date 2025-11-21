package se331.lab.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;
import se331.lab.entity.Participant;
import se331.lab.repository.EventRepository;
import se331.lab.repository.OrganizerRepository;
import se331.lab.repository.ParticipantRepository;
import jakarta.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1, org2, org3;
        org1 = organizerRepository.save(Organizer.builder()
                .name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder()
                .name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder()
                .name("ChiangMai").build());

        Event event1, event2, event3, event4;
        event1 = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        event1.setOrganizer(org1);
        org1.getOwnEvents().add(event1);

        event2 = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .build());
        event2.setOrganizer(org1);
        org1.getOwnEvents().add(event2);

        event3 = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
        event3.setOrganizer(org2);
        org2.getOwnEvents().add(event3);

        event4 = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());
        event4.setOrganizer(org3);
        org3.getOwnEvents().add(event4);

        Participant p1 = participantRepository.save(Participant.builder().name("Alice").telNo("090-000-0001").build());
        Participant p2 = participantRepository.save(Participant.builder().name("Bob").telNo("090-000-0002").build());
        Participant p3 = participantRepository.save(Participant.builder().name("Carol").telNo("090-000-0003").build());
        Participant p4 = participantRepository.save(Participant.builder().name("Dave").telNo("090-000-0004").build());
        Participant p5 = participantRepository.save(Participant.builder().name("Eve").telNo("090-000-0005").build());

        p1.getEventHistory().add(event1);
        p1.getEventHistory().add(event2);
        p1.getEventHistory().add(event3);
        p1.getEventHistory().add(event4);
        event1.getParticipants().add(p1);
        event2.getParticipants().add(p1);
        event3.getParticipants().add(p1);
        event4.getParticipants().add(p1);

        p2.getEventHistory().add(event1);
        p2.getEventHistory().add(event2);
        p2.getEventHistory().add(event3);
        event1.getParticipants().add(p2);
        event2.getParticipants().add(p2);
        event3.getParticipants().add(p2);

        p3.getEventHistory().add(event1);
        p3.getEventHistory().add(event2);
        p3.getEventHistory().add(event3);
        event1.getParticipants().add(p3);
        event2.getParticipants().add(p3);
        event3.getParticipants().add(p3);

        p4.getEventHistory().add(event1);
        p4.getEventHistory().add(event2);
        p4.getEventHistory().add(event4);
        event1.getParticipants().add(p4);
        event2.getParticipants().add(p4);
        event4.getParticipants().add(p4);

        p5.getEventHistory().add(event4);
        event4.getParticipants().add(p5);

        participantRepository.save(p1);
        participantRepository.save(p2);
        participantRepository.save(p3);
        participantRepository.save(p4);
        participantRepository.save(p5);
    }
}