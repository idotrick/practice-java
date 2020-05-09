package util.encode;

import java.math.BigInteger;

interface IEncode {
    BigInteger getBase();
    int getVal(char c);
    char getChar(int v);
}
