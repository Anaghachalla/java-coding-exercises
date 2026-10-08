## Observer Pattern

Defines a **one-to-many** relationship between objects — when one object (the subject) changes state, all its dependents (observers) are notified and updated automatically.

### The problem it solves
Imagine `WeatherStation` needs to share readings with a `TVStation` and a `MeteorologyDepartment`. The naive approach is to have `WeatherStation` call each one directly — but then it needs to know about every consumer, and adding a new one means modifying `WeatherStation`. The observer pattern inverts this: consumers register themselves, and `WeatherStation` just broadcasts without knowing who's listening.

### When to use
When a change in one object needs to automatically trigger updates in others, and you want the subject and its consumers to remain loosely coupled.

### Structure
1. **Observable interface** (`Observable`) — defines the contract for managing observers: `registerObserver`, `removeObserver`, `notifyObservers`.
2. **Concrete subject** (`WeatherStation`) — holds the list of registered observers and calls `notifyObservers()` whenever its state changes via `updateParameters()`.
3. **Observer interface** (`Observer`) — defines the `update(temp, humidity)` callback that the subject invokes.
4. **Concrete observers** (`TVStation`, `MeteorologyDepartment`) — implement `Observer`, register themselves in their constructor, and react to updates in their own way.

### How it works step by step
```
WeatherStation ws = new WeatherStation();
TVStation tv = new TVStation(ws);               // self-registers with ws
MeteorologyDepartment met = new MeteorologyDepartment(ws);  // self-registers with ws

ws.updateParameters(30, 15);
// → ws stores new temp/humidity
// → ws.notifyObservers() called
//   → tv.update(30, 15)  → displays current report
//   → met.update(30, 15) → appends to history, computes averages
```
Each observer reacts independently — `TVStation` shows the latest reading, `MeteorologyDepartment` accumulates history and reports averages.

### Key design decisions in this implementation
- **Observers self-register** — `TVStation(Observable o)` calls `o.registerObserver(this)` in the constructor, so the subject never needs to know about observers upfront.
- **Push model** — `update(int temp, int humidity)` pushes data directly to observers. The alternative (pull model) passes the subject itself and lets observers fetch what they need.
- **`Observable` is an interface** — `WeatherStation` could extend another class if needed; using an interface keeps it flexible.

### Key differences from a direct call approach
| Direct calls | Observer pattern |
|---|---|
| Subject knows every consumer | Subject only knows the `Observer` interface |
| Adding a consumer requires modifying subject | New consumers just self-register |
| Tightly coupled | Loosely coupled |

### Real-world examples
- Event listeners in UI frameworks (`ActionListener`, `EventListener`)
- `PropertyChangeListener` in JavaBeans
- Reactive streams (`RxJava`, `Flow` API introduced in Java 9)
- `java.util.Observable` / `java.util.Observer` (legacy, deprecated in Java 9 — superseded by the `Flow` API)
