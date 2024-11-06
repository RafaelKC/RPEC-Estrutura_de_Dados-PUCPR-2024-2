package Rkc.TabelaHash;

public class LoseLoseTabelaHash extends TabelaHash {

    public LoseLoseTabelaHash(int length) {
        super(length);
    }

    @Override
    public int getHashCode(String value) {
        var hash = 0;
        for (int i = 0; i < value.length(); i++) {
            hash += value.charAt(i);
        }
        return hash;
    }
}
