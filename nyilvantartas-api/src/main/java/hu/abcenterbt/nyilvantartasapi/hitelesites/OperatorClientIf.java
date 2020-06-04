package hu.abcenterbt.nyilvantartasapi.hitelesites;

import java.util.List;

import hu.abcenterbt.nyilvantartasapi.hitelesites.dto.OperatorDTO;
import hu.abcenterbt.nyilvantartasapi.hitelesites.entity.Operator;
import hu.abcenterbt.nyilvantartasapi.response.Result;

public interface OperatorClientIf {

    Result<Operator> getOperator(Long id);

    Result<Operator> getOperatorUserName(String username);

    Result<List<Operator>> getOperatorok();

    Result<Operator> saveOperator(OperatorDTO operatorDTO);

    Result<Operator> loginOperator(String username, String password);

}
