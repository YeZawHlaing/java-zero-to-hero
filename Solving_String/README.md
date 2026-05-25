# Longest Substring Without Repeating Characters — DummyRoom Logic

An intuitive, room-allocation tracking algorithm implemented in Java to solve the classic "Longest Substring Without Repeating Characters" problem.

---

## 📝 Problem Statement
Given a string `s`, find the length of the **longest substring** without repeating characters.

**Example:**
* **Input:** `s = "abcabcbb"`
* **Output:** `3`
* **Explanation:** The answer is `"abc"`, with a length of 3.

---

## 💡 The "DummyRoom" Algorithm Logic

This solution uses a custom simulation strategy called **DummyRoom Logic**. Instead of abstract mathematical pointers, it visualizes data movement into physical "rooms":

1. **Array Conversion:** The input string `s` is unpacked and pushed into a character array (`arr`).
2. **The DummyRoom:** We open a temporary workspace called `dummyRoom` (implemented as a list) to store the history of our current unique character streak.
3. **The NextRoom Check:** As we iterate through the array, the upcoming character is staged in `nextRoom`.
4. **The Gatekeeper Condition:**
    * 🛑 **If `nextRoom` matches any character already inside the `dummyRoom` history:** The current streak is broken. The loop instantly **quits (breaks)**, and we clear the room to start fresh from the next starting position.
    * 🟢 **If `nextRoom` is unique:** It safely enters the `dummyRoom`. We increment our current count and update our global `maxCount` record.

---

