package util.encode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Base32Encorder extends AbstractEncoder {
    private static final char[] CHAR_SET = {
            'A','B','C','D','E','F','G','H',
            'I','J','K','L','M','N','O','P',
            'Q','R','S','T','U','V','W','X',
            'Y','Z','2','3','4','5','6','7'
    };

    private Base32Encorder(){
        super.BASE = BigInteger.valueOf(32);
        super.CHAR_SET = CHAR_SET;
        super.loadValueMap();
    }

    private static class Holder {
        private static final Base32Encorder instance = new Base32Encorder();
    }

    public static IEncoder getInstance() {
        return Holder.instance;
    }
}
