package hu.abcenterbt.nyilvantartascore.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/operator/{id}")
    public Optional<Operator> getOperator(@PathVariable(value = "id") final Long id) {
        return operatorService.getOperator(id);
    }

    @CrossOrigin
    @GetMapping("/operator/username/{username}")
    public Operator getOperatorUserName(@PathVariable(value = "username") final String username) {
            return operatorService.getOperatorUserName(username);
    }

    @CrossOrigin
    @PostMapping("/operator")
    public Operator saveOperator(@RequestBody final Operator operator) {
        return operatorService.ujOperator(operator);
    }

    @CrossOrigin
    @PutMapping("/operator/{id}")
    public Operator updateOperator(@RequestBody final Operator operator, @PathVariable Long id) {
        return operatorService.updateOperator(operator, id);
    }

    @CrossOrigin
    @DeleteMapping("/operator/{id}")
    public void deleteOperator(@PathVariable(value = "id") final Long id) {
        operatorService.deleteOperator(id);
    }

    @CrossOrigin
//    @GetMapping("/loginOperator/?username={username}&password={password}")
    @GetMapping("/loginOperator")
//    public Operator loginOperator(@PathVariable String username, @PathVariable String password) {
    public Operator loginOperator(@RequestParam Map<String, String> params) {
        String username = params.get("username");
        String password = params.get("password");
        return operatorService.loginOperator(username, password);
    }
}
