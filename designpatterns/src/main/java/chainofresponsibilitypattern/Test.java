package chainofresponsibilitypattern;

/**
 * 测试
 *
 * @author Sparrow
 * @version 1.0
 * @date 2019/4/2 10:40
 * @since JDK 1.8
 *
 * Copyright (c) 2019, Sparrow All Rights Reserved.
 */
public class Test {

    public static void main(String[] args) {
        //审批人
        Approver director = new Director();
        Approver manager = new Manager();
        Approver partManager = new PartManager();
        //等级关系
        director.setNextApprover(manager);
        manager.setNextApprover(partManager);

        //开始请假
       // LeaveRequest requestA = new LeaveRequest("小翁", 3, "旅游");
       // director.handleRequest(requestA);
        LeaveRequest requestB = new LeaveRequest("小赵", 10, "休假");
        director.handleRequest(requestB);
      //  LeaveRequest requestC = new LeaveRequest("小李", 15, "学习");
       // director.handleRequest(requestC);
    }

}
