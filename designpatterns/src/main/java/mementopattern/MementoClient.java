package mementopattern;

/**
 * 客户端
 *
 * @author Sparrow
 * @version 1.0
 * @date 2019/4/8 10:48
 * @since JDK 1.8
 *
 * Copyright (c) 2019, Sparrow All Rights Reserved.
 */
public class MementoClient {

    private static int index =-1;
    private static Caretaker caretaker = new Caretaker();

    public static void main(String[] args) {
        Originator originator = new Originator("坐标", 1, 2);
        play(originator);
        originator.setY(5);
        originator.setX(4);
        play(originator);
        originator.setY(7);
        originator.setX(9);
        play(originator);
        undo(originator, index);
        undo(originator, index);
        redo(originator, index);
        redo(originator, index);
    }

    public static void play(Originator originator) {
        System.out.println("执行");
        caretaker.addMemento(originator.save());
        index++;
        originator.status();
    }

    public static void undo(Originator originator, int i) {
        System.out.println("撤销");
        index--;
        originator.restore(caretaker.getMemento(i - 1));
        originator.status();
    }

    public static void redo(Originator originator, int i) {
        System.out.println("还原");
        index++;
        originator.restore(caretaker.getMemento(i+1));
        originator.status();
    }
}
