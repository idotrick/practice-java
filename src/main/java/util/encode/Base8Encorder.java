package util.encode;

import java.math.BigInteger;

class Base8Encorder extends AbstractEncode {
    private static final char[] CHAR_SET = {'0', '1', '2', '3', '4', '5', '6', '7'};

    private Base8Encorder() {
        super.BASE = BigInteger.valueOf(8);
        super.CHAR_SET = CHAR_SET;
        super.loadValueMap();
    }

    private static class Holder {
        private static final Base8Encorder instance = new Base8Encorder();
    }

    public static IEncode getInstance() {
        return Holder.instance;
    }
}
