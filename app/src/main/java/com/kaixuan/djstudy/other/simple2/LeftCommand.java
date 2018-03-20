package com.kaixuan.djstudy.other.simple2;

/**具体的命令*/
public class LeftCommand implements Command{
    private TetrisMachine machine;

    public LeftCommand(TetrisMachine machine){
        this.machine = machine;
    }


    @Override
    public void execute() {
        machine.toLeft();
    }
}
