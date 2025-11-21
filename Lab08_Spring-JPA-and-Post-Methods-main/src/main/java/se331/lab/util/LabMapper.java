package se331.lab.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.lab.entity.Event;
import se331.lab.entity.EventDTO;
import se331.lab.entity.EventOrganizerDTO;
import se331.lab.entity.EventParticipantDTO;
import se331.lab.entity.Organizer;
import se331.lab.entity.OrganizerDTO;
import se331.lab.entity.Participant;
import se331.lab.entity.ParticipantDTO;
import se331.lab.entity.ParticipantEventDTO;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    @Mapping(target = "organizer", source = "organizer")
    @Mapping(target = "participants", source = "participants")
    EventDTO getEventDto(Event event);

    List<EventDTO> getEventDto(List<Event> events);
    EventOrganizerDTO getEventOrganizerDto(Organizer organizer);
    List<EventOrganizerDTO> getEventOrganizerDto(List<Organizer> organizers);
    @Mapping(target = "ownEvents", ignore = true)
    OrganizerDTO getOrganizerDTO(Organizer organizer);
    List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers);

    EventParticipantDTO getEventParticipantDto(Participant participant);
    List<EventParticipantDTO> getEventParticipantDto(List<Participant> participants);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "telNo", source = "telNo")
    @Mapping(target = "eventHistory", source = "eventHistory")
    ParticipantDTO getParticipantDTO(Participant participant);
    List<ParticipantDTO> getParticipantDTO(List<Participant> participants);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    ParticipantEventDTO getParticipantEventDTO(Event event);
    List<ParticipantEventDTO> getParticipantEventDTO(List<Event> events);
}