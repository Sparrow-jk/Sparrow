package chainofresponsibilitypattern;

/**
 * 审批人：项目经理 ConcreteHandler
 *
 * @author Sparrow
 * @version 1.0
 * @date 2019/4/2 10:35
 * @since JDK 1.8
 *
 * Copyright (c) 2019, Sparrow All Rights Reserved.
 */
public class Manager extends Approver{
    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays()<=10){
            System.out.println("请假人："+request.getName()+",天数："+request.getLeaveDays()+",理由："+request.getReason());
            System.out.println("审批人：项目经理，审批通过！");
        }else {
            if (super.nextApprover != null) {
                super.nextApprover.handleRequest(request);
            }
        }
    }

}
