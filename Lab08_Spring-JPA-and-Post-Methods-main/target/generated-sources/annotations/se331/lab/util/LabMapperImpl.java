package se331.lab.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import se331.lab.entity.Event;
import se331.lab.entity.EventDTO;
import se331.lab.entity.EventOrganizerDTO;
import se331.lab.entity.EventParticipantDTO;
import se331.lab.entity.Organizer;
import se331.lab.entity.OrganizerDTO;
import se331.lab.entity.Participant;
import se331.lab.entity.ParticipantDTO;
import se331.lab.entity.ParticipantEventDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-21T14:43:23+0800",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
public class LabMapperImpl implements LabMapper {

    @Override
    public EventDTO getEventDto(Event event) {
        if ( event == null ) {
            return null;
        }

        EventDTO.EventDTOBuilder eventDTO = EventDTO.builder();

        eventDTO.organizer( getEventOrganizerDto( event.getOrganizer() ) );
        eventDTO.participants( getEventParticipantDto( event.getParticipants() ) );
        eventDTO.id( event.getId() );
        eventDTO.category( event.getCategory() );
        eventDTO.title( event.getTitle() );
        eventDTO.description( event.getDescription() );
        eventDTO.location( event.getLocation() );
        eventDTO.date( event.getDate() );
        eventDTO.time( event.getTime() );
        eventDTO.petAllowed( event.getPetAllowed() );

        return eventDTO.build();
    }

    @Override
    public List<EventDTO> getEventDto(List<Event> events) {
        if ( events == null ) {
            return null;
        }

        List<EventDTO> list = new ArrayList<EventDTO>( events.size() );
        for ( Event event : events ) {
            list.add( getEventDto( event ) );
        }

        return list;
    }

    @Override
    public EventOrganizerDTO getEventOrganizerDto(Organizer organizer) {
        if ( organizer == null ) {
            return null;
        }

        EventOrganizerDTO.EventOrganizerDTOBuilder eventOrganizerDTO = EventOrganizerDTO.builder();

        eventOrganizerDTO.id( organizer.getId() );
        eventOrganizerDTO.name( organizer.getName() );

        return eventOrganizerDTO.build();
    }

    @Override
    public List<EventOrganizerDTO> getEventOrganizerDto(List<Organizer> organizers) {
        if ( organizers == null ) {
            return null;
        }

        List<EventOrganizerDTO> list = new ArrayList<EventOrganizerDTO>( organizers.size() );
        for ( Organizer organizer : organizers ) {
            list.add( getEventOrganizerDto( organizer ) );
        }

        return list;
    }

    @Override
    public OrganizerDTO getOrganizerDTO(Organizer organizer) {
        if ( organizer == null ) {
            return null;
        }

        OrganizerDTO.OrganizerDTOBuilder organizerDTO = OrganizerDTO.builder();

        organizerDTO.id( organizer.getId() );
        organizerDTO.name( organizer.getName() );

        return organizerDTO.build();
    }

    @Override
    public List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers) {
        if ( organizers == null ) {
            return null;
        }

        List<OrganizerDTO> list = new ArrayList<OrganizerDTO>( organizers.size() );
        for ( Organizer organizer : organizers ) {
            list.add( getOrganizerDTO( organizer ) );
        }

        return list;
    }

    @Override
    public EventParticipantDTO getEventParticipantDto(Participant participant) {
        if ( participant == null ) {
            return null;
        }

        EventParticipantDTO.EventParticipantDTOBuilder eventParticipantDTO = EventParticipantDTO.builder();

        eventParticipantDTO.id( participant.getId() );
        eventParticipantDTO.name( participant.getName() );

        return eventParticipantDTO.build();
    }

    @Override
    public List<EventParticipantDTO> getEventParticipantDto(List<Participant> participants) {
        if ( participants == null ) {
            return null;
        }

        List<EventParticipantDTO> list = new ArrayList<EventParticipantDTO>( participants.size() );
        for ( Participant participant : participants ) {
            list.add( getEventParticipantDto( participant ) );
        }

        return list;
    }

    @Override
    public ParticipantDTO getParticipantDTO(Participant participant) {
        if ( participant == null ) {
            return null;
        }

        ParticipantDTO.ParticipantDTOBuilder participantDTO = ParticipantDTO.builder();

        participantDTO.id( participant.getId() );
        participantDTO.name( participant.getName() );
        participantDTO.telNo( participant.getTelNo() );
        participantDTO.eventHistory( getParticipantEventDTO( participant.getEventHistory() ) );

        return participantDTO.build();
    }

    @Override
    public List<ParticipantDTO> getParticipantDTO(List<Participant> participants) {
        if ( participants == null ) {
            return null;
        }

        List<ParticipantDTO> list = new ArrayList<ParticipantDTO>( participants.size() );
        for ( Participant participant : participants ) {
            list.add( getParticipantDTO( participant ) );
        }

        return list;
    }

    @Override
    public ParticipantEventDTO getParticipantEventDTO(Event event) {
        if ( event == null ) {
            return null;
        }

        ParticipantEventDTO.ParticipantEventDTOBuilder participantEventDTO = ParticipantEventDTO.builder();

        participantEventDTO.id( event.getId() );
        participantEventDTO.title( event.getTitle() );

        return participantEventDTO.build();
    }

    @Override
    public List<ParticipantEventDTO> getParticipantEventDTO(List<Event> events) {
        if ( events == null ) {
            return null;
        }

        List<ParticipantEventDTO> list = new ArrayList<ParticipantEventDTO>( events.size() );
        for ( Event event : events ) {
            list.add( getParticipantEventDTO( event ) );
        }

        return list;
    }
}
