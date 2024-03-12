package com.example.calculator.service;

import com.example.calculator.dto.Calculator;

public abstract class Command {

    protected Calculator calculator;
    protected char op;
    protected int num;

    public Command (Calculator calculator,char op,int num) {
        this.calculator = calculator;
        this.op = op;
        this.num = num;
    }

    abstract public void execute();
    abstract public void reverse();
}
