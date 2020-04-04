package util.encode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Base64Encorder extends AbstractEncoder {
    private static final char[] CHAR_SET = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '+', '/'
    };

    private Base64Encorder() {
        super.BASE = BigInteger.valueOf(64);
        super.CHAR_SET = CHAR_SET;
        super.loadValueMap();
    }

    private static class Holder {
        private static final Base64Encorder instance = new Base64Encorder();
    }

    public static IEncoder getInstance() {
        return Holder.instance;
    }
}
