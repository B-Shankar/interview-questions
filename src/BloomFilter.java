import java.util.BitSet;

// username already taken
public class BloomFilter {
    private BitSet bitSet;
    private int size;
    private int hashCount;

    public BloomFilter(int size, int hashCount) {
        this.size = size;
        this.hashCount = hashCount;
        this.bitSet = new BitSet(size);
    }

    // Simple hash functions
    private int hash(String value, int seed) {
        int hash = 0;
        for (char c : value.toCharArray()) {
            System.out.println("c: " + c);
            hash = seed * hash + c;
            System.out.println("hash : " + hash);
        }
        System.out.println("Math.abs(hash) % size:" + Math.abs(hash) % size);
        return Math.abs(hash) % size;
    }

    // Insert
    public void add(String value) {
        for (int i = 1; i <= hashCount; i++) {
            int index = hash(value, i);
            bitSet.set(index);
        }
    }

    // Search
    public boolean mightContain(String value) {
        for (int i = 1; i <= hashCount; i++) {
            int index = hash(value, i);
            if (!bitSet.get(index)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BloomFilter bf = new BloomFilter(100, 3);

        bf.add("apple");
//        bf.add("banana");

//        System.out.println(bf.mightContain("apple"));   // true
//        System.out.println(bf.mightContain("grapes"));  // false (probably)
    }
}

/*
A **Bloom Filter** is a **space-efficient probabilistic data structure** used to test whether an element is a member of a set.

        👉 It can tell:

        * ✅ **Definitely NOT present**
        * ⚠️ **Possibly present** (false positives possible)
        * ❌ Never gives false negatives

Used heavily in databases, caches, networking, search engines, etc.

Since you work mostly in **Java / backend systems**, this fits nicely with caching, deduplication, and fast lookups.


# 🌸 Bloom Filter – How It Works

### 🔹 Data Structure

* A **bit array** of size `m` → initially all bits = 0
        * `k` different **hash functions**

        ### 🔹 Insert Element

For element `x`:

        1. Apply `k` hash functions:

        h1(x), h2(x), h3(x)... hk(x)

        2. Each hash gives an index in `[0, m-1]`
        3. Set those bit positions to `1`

### 🔹 Search Element

For element `x`:

    1. Compute same `k` hash values
    2. Check the corresponding bits
    3. If **any bit is 0 → definitely not present**
    4. If **all bits are 1 → probably present**

# 🧠 Example

Assume:

    Bit array size m = 10
    Hash functions = 3


Insert `"apple"`:

    h1("apple") → 2
    h2("apple") → 5
    h3("apple") → 8
        

Set bits at positions:

    [0 0 1 0 0 1 0 0 1 0]


Search `"apple"` → all bits are 1 → possibly present ✔️
Search `"banana"` → one bit is 0 → definitely not present ❌

        ---

# ⚡ Time & Space Complexity

| Operation | Complexity |
        | --------- | ---------- |
        | Insert    | O(k)       |
        | Search    | O(k)       |
        | Space     | O(m)       |

Very memory efficient.

---

        # ⚠️ Limitation

* ❌ Cannot delete elements (unless using Counting Bloom Filter)
* ⚠️ False positives possible
* ✅ No false negatives


# 🚀 Real-World Uses (Backend)

Since you work on APIs and systems:

* ✔️ Check if user already exists before DB hit
* ✔️ Prevent duplicate processing (Kafka consumers)
* ✔️ Cache filtering
* ✔️ URL deduplication
* ✔️ Large dataset membership checking

---
*/