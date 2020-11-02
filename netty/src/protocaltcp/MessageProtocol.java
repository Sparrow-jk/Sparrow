package protocaltcp;

/**
 * TODO
 *
 * @author Sparrow
 * @version 1.0
 * @date 2020/8/18 0:18
 * @since JDK 1.8
 * <p>
 * Copyright (c) 2020, Sparrow All Rights Reserved.
 */
public class MessageProtocol {

    private int lenth;

    private byte[] content;

    public int getLenth() {
        return lenth;
    }

    public void setLenth(int lenth) {
        this.lenth = lenth;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
