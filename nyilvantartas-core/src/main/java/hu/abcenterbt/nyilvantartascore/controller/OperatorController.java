package hu.abcenterbt.nyilvantartascore.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.abcenterbt.nyilvantartasapi.domain.Operator;
import hu.abcenterbt.nyilvantartasapi.operator.OperatorClientIF;
import hu.abcenterbt.nyilvantartascore.service.OperatorService;

@RestController
public class OperatorController implements OperatorClientIF {

    @Autowired
    private OperatorService operatorService;

    @CrossOrigin
    @GetMapping("/operator")
    public List<Operator> getOperatorok() {
        return operatorService.getOperatorok();
    }

    @CrossOrigin
    @GetMapping("/operator")
    public Optional<Operator> getOperator(@RequestParam(value = "id") final Long id) {
        return operatorService.getOperator(id);
    }

    @CrossOrigin
    @GetMapping("/operator/username")
    public Operator getOperatorUserName(@RequestParam(value = "username") final String username) {
            return operatorService.getOperatorUserName(username);
    }

    @CrossOrigin
    @PostMapping("/operator")
    public Operator saveOperator(@RequestBody final Operator operator) {
        return operatorService.ujOperator(operator);
    }

    @CrossOrigin
    @PutMapping("/operator/{id}")
    public Operator updateOperator(@RequestBody final Operator operator, @RequestParam final Long id) {
        return operatorService.updateOperator(operator, id);
    }

    @CrossOrigin
    @DeleteMapping("/operator")
    public void deleteOperator(@RequestParam(value = "id") final Long id) {
        operatorService.deleteOperator(id);
    }

    @CrossOrigin
    @GetMapping("/loginOperator")
    public Operator loginOperator(@RequestParam final Map<String, String> params) {
        final String username = params.get("username");
        final String password = params.get("password");
        return operatorService.loginOperator(username, password);
    }
}
