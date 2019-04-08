package mementopattern;

import java.util.ArrayList;

/**
 * 负责人 Caretaker
 * 负责人又称为管理者，它负责保存备忘录，但是不能对备忘录的内容进行操作或检查。
 * 在负责人类中可以存储一个或多个备忘录对象，它只负责存储对象，而不能修改对象，也无须知道对象的实现细节。
 *
 * @author Sparrow
 * @version 1.0
 * @date 2019/4/8 10:41
 * @since JDK 1.8
 *
 * Copyright (c) 2019, Sparrow All Rights Reserved.
 */
public class Caretaker {

    private ArrayList<Memento> mementoList = new ArrayList<>();

    //获取指定位置的备忘
    public Memento getMemento(int index) {
        return mementoList.get(index);
    }

    //储存当前备忘
    public void addMemento(Memento memento) {
        mementoList.add(memento);
    }

}
