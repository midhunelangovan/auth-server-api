package com.kals.auth.Controller;


import com.kals.auth.DataModel.Role;
import com.kals.auth.EntityModel.RoleEntity;
import io.kals.core.controller.implementation.AbstractRestApiController;
import io.kals.core.service.AbstractCrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController extends AbstractRestApiController<RoleEntity, Role, Long> {

    protected RoleController(AbstractCrudService<RoleEntity, Role, Long> service) {
        super(service);
    }

}
