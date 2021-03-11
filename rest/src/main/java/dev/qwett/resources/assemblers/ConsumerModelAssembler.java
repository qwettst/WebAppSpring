package dev.qwett.resources.assemblers;

import dev.qwett.controllers.rest.RestConsumerController;
import dev.qwett.entities.Consumer;
import dev.qwett.resources.ConsumerRepresentation;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Преобразование Consumer -> ConsumerRepresentation
 */
@Component
public class ConsumerModelAssembler extends RepresentationModelAssemblerSupport<Consumer, ConsumerRepresentation> {

    public ConsumerModelAssembler() {
        super(RestConsumerController.class, ConsumerRepresentation.class);
    }

    @Override
    public ConsumerRepresentation toModel(Consumer entity) {
        ConsumerRepresentation consumerRepresentation = new ConsumerRepresentation();
        consumerRepresentation.setIdConsumer(entity.getIdConsumer());
        consumerRepresentation.setFirstName(entity.getFirstName());
        consumerRepresentation.setLastName(entity.getLastName());
        consumerRepresentation.setPhone(entity.getPhone());

        int idConsumer = entity.getIdConsumer();
        Link selfLink = linkTo(methodOn(RestConsumerController.class)
                .editConsumer(idConsumer, entity)).withSelfRel();
        Link deleteLink = linkTo(methodOn(RestConsumerController.class)
                .deleteConsumer(idConsumer)).withRel("delete consumer");
        consumerRepresentation.add(selfLink, deleteLink);

        return consumerRepresentation;
    }
}
