package com.example.calculator.dto;

import com.example.calculator.constant.OpConstants;

public class Calculator {

    private int total;

    public Calculator() {
        this.total = 0;
    }

    public void calc(char op, int num) {
        switch (op) {
            case OpConstants.OpType.ADD:
                total+= num;
                break;
            case OpConstants.OpType.SUBTRACT:
                total-= num;
                break;
            case OpConstants.OpType.RIDE:
                total*= num;
                break;
            case OpConstants.OpType.DIVIDE:
                divide(op, num);
                break;
        }
    }

    private void divide (char op, int num) {
        if (num == 0) {
            System.out.println("除数不能为0, 此次操作无效");
        } else {
            total /= num;
        }
    }

}
