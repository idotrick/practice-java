package util.encode;

import java.math.BigInteger;

class Base32Encorder extends AbstractEncode {
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

    public static IEncode getInstance() {
        return Holder.instance;
    }
}
