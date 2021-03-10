package dev.qwett.controllers.rest;

import dev.qwett.entities.Consumer;
import dev.qwett.service.ConsumerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/consumers")
public class RestConsumerController {

    private final ConsumerService consumerService;

    RestConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping
    @Operation(summary = "Список покупателей",
            tags = {"Покупатели"},
            description = "Возвращает список покупателей",
            responses = @ApiResponse(responseCode = "200", description = "Список покупателей"))
    public List<Consumer> getAll(
            @Parameter(description = "Имя покупателя для поиска", example = "Danil")
            @RequestParam(value = "name", required = false) String name,

            @Parameter(description = "Фамилия покупателя для поиска", example = "Petrov")
            @RequestParam(value = "lastName", required = false) String lastName,

            @Parameter(description = "Номер телефона покупателя для поиска", example = "5436")
            @RequestParam(value = "phone", required = false) String phone) {
        if (name == null & lastName == null & phone == null)
            return consumerService.findAll();
        else
            return consumerService.searchFilter(name, lastName, phone);
    }

    @PostMapping("{id}")
    public Consumer editConsumer(@PathVariable int id, @RequestBody Consumer consumer) {
        return consumerService.updateConsumer(id, consumer);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole(T(dev.qwett.security.model.Role).ADMIN.name())")
    @Operation(summary = "Удалить запись о покупателе",
            tags = {"Покупатели"},
            description = "Удаляет запись о покупателе",
            responses = {@ApiResponse(responseCode = "200", description = "Покупатель удален"), @ApiResponse(responseCode = "403", description = "Доступ запрещен")})
    public void deleteConsumer(@PathVariable int id) {
        consumerService.delete(id);
    }

    @PutMapping
    public Consumer addConsumer(@RequestBody Consumer consumer) {
        return consumerService.saveConsumerJPA(consumer);
    }
}
