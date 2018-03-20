package com.kaixuan.djstudy.other.simple2;

/**具体的命令*/

public class RightCommand implements Command{
    private TetrisMachine machine;

    public RightCommand(TetrisMachine machine){
        this.machine = machine;
    }


    @Override
    public void execute() {
        machine.toRight();
    }
}
