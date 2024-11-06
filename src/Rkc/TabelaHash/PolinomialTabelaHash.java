package Rkc.TabelaHash;

public class PolinomialTabelaHash extends TabelaHash {

    public PolinomialTabelaHash(int length) {
        super(length);
    }

    @Override
    public int getHashCode(String value) {
        int hash = 0;
        int prime = 31;

        for (int i = 0; i < value.length(); i++) {
            hash = prime * hash + value.charAt(i);
        }

        return Math.abs(hash);
    }
}
