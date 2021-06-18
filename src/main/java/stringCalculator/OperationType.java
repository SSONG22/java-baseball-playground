package stringCalculator;

import java.util.HashMap;
import java.util.Map;

public enum OperationType {
    PLUS("+", Operation.PLUS),
    MINUS("-", Operation.MINUS),
    MULTIPLY("*", Operation.MULTIPLY),
    DIVIDE("/", Operation.DIVIDE);

    private String op;
    private Operation operation;
    private static final Map<String, OperationType> mapByString;

    static {
        mapByString = new HashMap<>();
        for (OperationType type : values()) {
            mapByString.put(type.getOp(), type);
        }
    }

    public String getOp() {
        return op;
    }

    public Operation getOperation() {
        return operation;
    }

    OperationType(String op, Operation operation) {
        this.op = op;
        this.operation = operation;
    }

    public static OperationType getOperation(String op) {
        return mapByString.get(op);
    }

}
