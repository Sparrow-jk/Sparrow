package testXmlSpring;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/9/13 21:30
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class Apple {

    private int id;

    public Apple(int id) {
        this.id = id;
    }

    public void eat() {
        System.out.println("eat apple, id: " + id);
    }

}
