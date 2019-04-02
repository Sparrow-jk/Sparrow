package chainofresponsibilitypattern;

/**
 * 请教审批人 Handler
 *
 * @author Sparrow
 * @version 1.0
 * @date 2019/4/2 10:12
 * @since JDK 1.8
 *
 * Copyright (c) 2019, Sparrow All Rights Reserved.
 */
public abstract class Approver {

    /**
     * 上一级审批人
     */
    protected Approver nextApprover;

    /**
     * 给上一级审批人审批
     * @param approver 上一级审批人
     */
    public void setNextApprover(Approver approver) {
        this.nextApprover = approver;
    }

    /**
     * 审批人处理请求
     * @param request 请假
     */
    public abstract void handleRequest(LeaveRequest request);
}
