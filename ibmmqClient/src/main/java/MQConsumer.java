import com.ibm.mq.*;
import com.ibm.mq.constants.MQConstants;
import com.ibm.mq.ese.util.SystemUtils;

public class MQConsumer {
    private static final String qManager = "mymgr";
    private static final String qName = "LocalQueue1";
    public static void main(String args[]) {
        try {
            MQEnvironment.hostname = "10.100.7.63";
            MQEnvironment.channel = "myChannel";
            MQEnvironment.port = 1414;
            MQEnvironment.userID="kirishanthy";
//            MQEnvironment.sslCipherSuite = "";
            MQQueueManager qMgr = new MQQueueManager(qManager);
            int openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF ;
            MQQueue queue = qMgr.accessQueue(qName, openOptions);

            MQMessage rcvMessage = new MQMessage();
            MQGetMessageOptions gmo = new MQGetMessageOptions();
            queue.get(rcvMessage, gmo);
            String msgText = rcvMessage.readUTF();
            System.out.print(msgText);

            queue.close();
            qMgr.disconnect();
        } catch (MQException ex) {
            ex.printStackTrace();
            System.out.println("A WebSphere MQ Error occurred : Completion Code " + ex.completionCode
                    + " Reason Code " + ex.reasonCode);


        } catch (java.io.IOException ex) {
            System.out.println("An IOException occurred whilst writing to the message buffer: " + ex);
        }
    }
}

