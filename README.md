---

# 🧠 MoreMobHeads Extension

An extension for the **More Mob Heads** datapack that restores **vanilla Minecraft mechanics**, where mob heads only drop when a mob is killed by a **charged creeper**.

This project is designed for **Paper servers** and works alongside the original datapack to control how mob heads are obtained.

---

## ✨ Features

* ✅ Follows **vanilla game behavior**
* 💥 Mob heads only drop from **charged creeper kills**
* 🧍 Player heads drop with a configurable chance
* 📦 Uses **More Mob Heads datapack loot tables**
* ⚙️ Lightweight, no commands or config required

---

## 📦 Requirements

* **Paper** server
* **Minecraft 1.21+**
* **Java 17+**
* **More Mob Heads datapack** (required)

---

## 🛠️ Installation

### 1️⃣ Download

Download **both**:

* 🧩 **MoreMobHeads Extension datapack**
* 🔌 **MoreMobHeads Extension (.jar)**

---

### 2️⃣ Install the Datapack

1. Open your server folder
2. Go to:

   ```
   world/datapacks
   ```
3. Place the datapack folder or `.zip` file inside
4. Restart the server or run:

   ```
   /reload
   ```

---

### 3️⃣ Install the Plugin

1. Open your server folder
2. Go to:

   ```
   plugins
   ```
3. Place `MoreMobHeadsExtension-<version>.jar` into the folder
4. Restart the server

---

## ✅ Verification

### 🔹 Check the plugin

Run in-game:

```
/plugins
```

or

```
/pl
```

You should see:

```
MoreMobHeadsExtension
```

---

### 🔹 Check the datapack

Run:

```
/datapack list
```

You should see **More Mob Heads** listed as **enabled**.

---

## 🎮 How It Works

* Mobs **do not drop heads** on normal kills
* Heads only drop when the mob is killed by a **charged creeper**
* Loot is generated using the **More Mob Heads datapack loot tables**
* Player heads have a chance-based drop when killed by a charged creeper

This keeps gameplay consistent with **original Minecraft mechanics**.

---

## 🧪 Compatibility

* Designed for **Paper**
* Should work across **minor versions** of Minecraft 1.21
* No NMS or reflection used

---

## 📁 Project Structure

* **Plugin**: Handles event detection and loot triggering
* **Datapack**: Defines mob head loot tables

Both are required for full functionality.

---

## 📜 License

This project is open-source.
You are free to use, modify, and distribute it.

---

## 🔗 Links

* 🔧 Plugin Repository:
  [https://github.com/JustinPhong/MoreMobHeads-Extension](https://github.com/JustinPhong/MoreMobHeads-Extension)

---
