package util.encode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Base8Encorder extends AbstractEncoder {
    private static final char[] CHAR_SET = {'0', '1', '2', '3', '4', '5', '6', '7'};

    private Base8Encorder() {
        super.BASE = BigInteger.valueOf(8);
        super.CHAR_SET = CHAR_SET;
        super.loadValueMap();
    }

    private static class Holder {
        private static final Base8Encorder instance = new Base8Encorder();
    }

    public static IEncoder getInstance() {
        return Holder.instance;
    }
}
