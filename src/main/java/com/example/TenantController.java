package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@ExecuteOn(TaskExecutors.IO)
@Controller
public class TenantController {

    private static final Logger LOG = LoggerFactory.getLogger(TenantController.class);

    private final OrdersRepository ordersRepository;

    public TenantController(
                            OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    /*@Get("/manual")
    public void listOrdersTenant(@Header("tenantId") String tenantId) {
        LOG.info("tenantId: {}", tenantId);

        var repository = switch (tenantId) {
            case "foo" -> ordersFooRepository;
            case "bar" -> ordersBarRepository;
            default -> null;
        };

        if (repository != null) {
            repository.findAll().forEach(
                    o -> LOG.info( o.toString() )
            );
        }
    }*/

    @Get("/auto")
    public List<Order> listOrders() {

        return ordersRepository.findAll();
    }
}
