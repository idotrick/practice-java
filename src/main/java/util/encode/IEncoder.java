package util.encode;

import java.math.BigInteger;

interface IEncoder {
    BigInteger getBase();
    int getVal(char c);
    char getChar(int v);
}
