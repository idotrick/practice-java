package util.encode;

import java.math.BigInteger;

class Base16Encorder extends AbstractEncode {
    private static final char[] CHAR_SET = {
            '0','1','2','3','4','5','6','7',
            '8','9','A','B','C','D','E','F'
    };


    private Base16Encorder(){
        super.BASE = BigInteger.valueOf(16);
        super.CHAR_SET = CHAR_SET;
        super.loadValueMap();
    }

    private static class Holder {
        private static final Base16Encorder instance = new Base16Encorder();
    }

    public static IEncode getInstance() {
        return Holder.instance;
    }

}
