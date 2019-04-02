package chainofresponsibilitypattern;

/**
 * 请假信息
 *
 * @author Sparrow
 * @version 1.0
 * @date 2019/4/2 10:09
 * @since JDK 1.8
 *
 * Copyright (c) 2019, Sparrow All Rights Reserved.
 */
public class LeaveRequest {

    /**
     * 请假人姓名
     */
    private String name;
    /**
     * 请假天数
     */
    private int leaveDays;
    /**
     * 请假原因
     */
    private  String reason;

    public LeaveRequest(String name, int leaveDays, String reason) {
        this.name = name;
        this.leaveDays = leaveDays;
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
