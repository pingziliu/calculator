package com.example.calculator.service.impl;

import com.example.calculator.service.Command;
import com.example.calculator.dto.Calculator;


import java.util.ArrayList;
import java.util.List;

public class CalculatorOperation {

    private Calculator calculator = new Calculator();
    private List<Command> commands = new ArrayList<>();
    private int currentIndex = 0;

    /**
     * 计算
     *
     * @param op 操作
     * @param num 操作数
     */
    public void calc(char op, int num) {
        Command command = new CalculatorCommand(calculator, op, num);
        command.execute();
        commands.add(command);
        currentIndex++;
    }

    /**
     * 再次执行
     *
     * @param levels 再次执行步骤数
     */
    public void redo(int levels) {
        System.out.println("Redo" + levels);
        for (int i = 0; i < levels; i++)
            if (currentIndex < commands.size() - 1) {
                ((Command) commands.get(currentIndex++)).execute();
            }else {
                System.out.println("没有可redo的数据!");
            }
    }

    /**
     * 撤回操作
     *
     * @param levels 撤回步骤数
     */
    public void undo(int levels) {
        System.out.println("Undo" + levels);
        for (int i = 0; i < levels; i++)
            if (currentIndex > 0) {
                int index = --currentIndex;
                Command command= (Command)commands.get(index);
                command.reverse();
            }else {
                System.out.println("没有可undo的数据!");
            }
    }
}
