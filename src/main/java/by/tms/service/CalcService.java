package by.tms.service;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.storage.OperationStorage;

import java.util.List;

public class CalcService {

    private static final OperationStorage operationStorage = new OperationStorage();

    public Double calc(double a, double b, String operand, User user) {
        switch (operand) {
            case "sum": {
            return     getOperation(a, b, operand, a + b, user);
            }
            case "minus": {
            return     getOperation(a, b, operand, a - b, user);
            }
            case "divide":{
            return     getOperation(a, b, operand, a / b, user);
            }
            case "multiply": {
              return   getOperation(a, b, operand, a * b, user);
            }
        }
        return null;
    }

    public List<Operation> findAll() {
        return operationStorage.getAll();
    }

    public Double getOperation (double a, double b, String operand, double result ,User user){
        Operation operation= new Operation( a,  b, operand, result, user);
        operationStorage.save(operation);
        return result;
    }
}
