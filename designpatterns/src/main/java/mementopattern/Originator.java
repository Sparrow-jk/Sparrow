package mementopattern;

import mediatorpattern.Mediator;

/**
 * 原发器 Originator
 * 它是一个普通类，可以创建一个备忘录，并存储它的当前内部状态，也可以使用备忘录来恢复其内部状态，一般将需要保存内部状态的类设计为原发器。
 *
 * @author Sparrow
 * @version 1.0
 * @date 2019/4/8 10:32
 * @since JDK 1.8
 *
 * Copyright (c) 2019, Sparrow All Rights Reserved.
 */
public class Originator {

    private String label;
    private int x;
    private int y;

    public Originator(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    //保存当前状态
    public Memento save() {
        return new Memento(label, x, y);
    }

    //恢复到下一个状态
    public void restore(Memento memento) {
        this.label = memento.getLabel();
        this.x = memento.getX();
        this.y = memento.getY();
    }

    public void status(){
        System.out.println("当前 "+label+" 的位置为"+x+","+y);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
