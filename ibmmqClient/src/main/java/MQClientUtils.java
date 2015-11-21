import netscape.javascript.JSObject;

public class MQClientUtils {

    public final static String DEFAULT_PLACEORDER_PAYLOAD =
            "<m:placeOrder xmlns:m=\"http://services.samples\">\n" +
                    "\t<m:order>\n" +
                    "\t\t<m:price>1</m:price>\n" +
                    "\t\t<m:quantity>200</m:quantity>\n" +
                    "\t\t<m:symbol>IBM MQ run in mymgr</m:symbol>\n" +
                    "\t</m:order>\n" +
                    "</m:placeOrder>";
}
