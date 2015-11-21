import com.ibm.mq.*;
import com.ibm.mq.constants.MQConstants;

public class MQProducer {
    private static final String qManager = "mymgr";
    private static final String qName = "LocalQueue1";

//    private static final String qManager = "ESBQManager";
//    private static final String qName = "LocalQueue1";

    public static void main(String args[]) {
        try {
            MQEnvironment.hostname = "192.168.43.187";
            MQEnvironment.port = 1414;
            MQEnvironment.channel = "mymgrChannel";

//            MQEnvironment.hostname = "10.10.10.93";
//            MQEnvironment.port = 1415;
//            MQEnvironment.channel = "ESBQManagerChannel";


            MQEnvironment.userID="kirishanthy";
            MQEnvironment.password = "123456";
            MQQueueManager qMgr = new MQQueueManager(qManager);
            int openOptions = MQConstants.MQOO_OUTPUT;
            MQQueue queue = qMgr.accessQueue(qName, openOptions);
            for (int i=0;i<1000;i++){
                MQMessage msg = new MQMessage();
//                String message = "this message from mymgr";
                String message = MQClientUtils.DEFAULT_PLACEORDER_PAYLOAD;
                msg.writeUTF(message);
                MQPutMessageOptions pmo = new MQPutMessageOptions();
                queue.put(msg, pmo);
            }
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

