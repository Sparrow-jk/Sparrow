package javaassit;
import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * @author chansiwan
 * @since 2021-11-10 16:55
 */
public class Attacher {
    public static void main(String[] args) throws AttachNotSupportedException, IOException, AgentLoadException, AgentInitializationException {
        // 传入目标 JVM pid
        VirtualMachine vm = VirtualMachine.attach("16736");
        vm.loadAgent("D:\\GitRepository\\Sparrow\\out\\artifacts\\testAgent\\testAgent.jar");
    }
}
