package com.example.calculator.service.impl;

import com.example.calculator.constant.OpConstants;
import com.example.calculator.dto.Calculator;
import com.example.calculator.service.Command;


public class CalculatorCommand extends Command {

    public CalculatorCommand (Calculator calculator, char op, int num) {
        super(calculator, op, num);
    }

    @Override
    public void execute() {
        calculator.calc(op, num);
    }

    @Override
    public void reverse() {
        calculator.calc(undo(op), num);
    }

    private char undo(char op) {
        char undo = ' ';
        switch (op) {
            case OpConstants.OpType.ADD:
                undo = OpConstants.OpType.SUBTRACT;
                break;
            case OpConstants.OpType.SUBTRACT:
                undo = OpConstants.OpType.ADD;
                break;
            case OpConstants.OpType.RIDE:
                undo = OpConstants.OpType.DIVIDE;
                break;
            case OpConstants.OpType.DIVIDE:
                undo = OpConstants.OpType.RIDE;
                break;
        }
        return undo;
    }
}
