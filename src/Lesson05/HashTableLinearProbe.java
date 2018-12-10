package Lesson05;

public class HashTableLinearProbe<Key, Value> {

    private Key[] keys;
    private Value[] vals;
    private int size;
    private int M = 16;

    public HashTableLinearProbe(int capcity) {
        this.M = capcity;
        keys = (Key[]) (new Object[M]);
        vals = (Value[]) (new Object[M]);


    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int capcity) {
        HashTableLinearProbe<Key, Value> tmp = new HashTableLinearProbe<>(capcity;

        for (int i = 0; i < M; i++)
            if (keys[i] != null) tmp.put(keys[i], vals[i]);
        this.keys = tmp.keys;
        this.vals = tmp.vals;
        this.M = tmp.M;
    }


    public void put(Key key, Value value) {
        if (this.size >= M / 2) resize(M * 2);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = value;
                return;
            }
        }

        this.keys[i] = key;
        this.vals[i] = value;
        size++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void delete(Key key) {
        if (!contains(key)) return;

        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        vals[i] = null;


        i = (i + 1) % M;

        while (keys[i] != null) {
            Key keytoRedo = keys[i];
            Value valtoRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            size--;
            put(keytoRedo, valtoRedo);
            i = (i + 1) % M;
        }
        size--;
        if (size > 0 && size == M / 8) {
            resize(M / 2);
        }

    }
}
