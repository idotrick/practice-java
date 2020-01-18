/**
 * Java 13 introduced 2 main syntactical features
 * 1. Switch enhancements
 * 2. Text blocks
 */

package corejava;


public class Java13Features {
    public static void main(String[] args) {
        System.out.printf("Java <12: ");

    }

    String conventionalSwitchExample(int i) {
        String msg;
        switch (i) {
            case 1:
                msg = "Message for 1 to 3";
                break;
            case 2:
                msg = "Message for 1 to 3";
                break;
            case 3:
                msg = "Message for 1 to 3";
                break;
            case 4:
                msg = "Message for 4";
                break;
            default:
                msg = "Message Default";
        }

        return msg;
    }

    String java12SwitchExample(int i) {
        String msg;
        switch (i) {
            case 1, 2, 3 -> msg = "Message for 1 to 3";
            case 4 -> msg = "Message for 4";
            default -> msg = "Message Default";
        }

        return msg;
    }

    String java13SwitchExample(int i) {
        String msg;
        switch (i) {
            case 1, 2, 3:
                msg = "Message for 1 to 3";
            case 4:
                msg = "Message for 4";
            default:
                msg = "Message Default";
        }

        return msg;
    }
}
