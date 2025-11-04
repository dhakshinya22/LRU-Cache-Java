# LRU Cache Implementation in Java

This repository contains a PRODUCTION-STYLE IMPLEMENTATION of an "LRU (Least Recently Used) Cache" in Java, designed from scratch without relying on `LinkedHashMap`.  

The cache guarantees **O(1) time complexity** for both `get()` and `put()` operations using a combination of:

- **HashMap** → Constant-time key lookups  
- **Custom Circular Doubly Linked List (CDLL)** → Efficient node movement and eviction  

> This implementation reflects low-level cache mechanism logic similar to system-level caching, browser cache eviction, and memory paging algorithms.


## 📌 Features

- ⚡ **O(1) `get()` & `put()` operations**
- 🧠 Custom **Doubly Linked List + HashMap** approach
- 🔄 Automatic eviction of least recently used entry
- 🧹 Efficient pointer manipulation (no extra structures)
- 🧪 Includes runnable test driver (`LRUCacheMain.java`)



## 🧠 Architecture Overview

### Internal Components
| Component | Responsibility |
|----------|----------------|
| `HashMap<Integer, CDLLNode>` | Fast access to existing cache entries |
| `CDLLNode` | Represents a key–value node in the list |
| `Circular Doubly Linked List` | Maintains usage order |
| `LRUCache` | Orchestrates cache operations |

### LRU Strategy
- Recent accesses are moved to **front**
- When capacity is full, the **tail node** gets removed (least recently used)
- Insertions always happen at the **front**


## 🧩 Time & Space Complexity

| Operation | Time | Space |
|----------|------|-------|
| `get()`  | O(1) | O(capacity) |
| `put()`  | O(1) | O(capacity) |


## 📁 Project Structure

