## Decorator Pattern

Adds behaviour to an object **at runtime** without changing its class or subclassing it. Decorators wrap the original object and delegate to it, layering on extra functionality.

### The problem it solves
Imagine you have `VeggieBurger` and `ZingerBurger`. Now you want to support add-ons: extra cheese, wheat bun, extra sauce. If you solve this with inheritance, you end up with a class for every combination:
- `ExtraCheeseVeggieBurger`
- `WheatBunVeggieBurger`
- `ExtraCheeseWheatBunVeggieBurger`
- ... and the same again for `ZingerBurger`

With 2 burgers and 3 add-ons, that's already 8 subclasses. Add one more add-on and it doubles. The decorator pattern solves this by making add-ons **wrappers** you compose at runtime instead of baking them into the class hierarchy.

### When to use
When you need optional, combinable features — and you don't want a subclass explosion for every possible combination.

### Structure
1. **Component** (`Burger`) — abstract base defining the interface all concrete and decorator classes share.
2. **Concrete components** (`VeggieBurger`, `ZingerBurger`) — the base objects being decorated. They know nothing about decorators.
3. **Abstract decorator** (`BurgerAddOn extends Burger`) — holds a reference to a `Burger` and passes calls through to it. Subclasses only override what they change.
4. **Concrete decorators** (`ExtraCheeseBurger`, `WheatBunBurger`) — extend `BurgerAddOn`, call `super(burger)` to store the wrapped object, then add their own behaviour on top.

### How wrapping works step by step
```
Burger b = new VeggieBurger();
// b is a plain VeggieBurger: cost=180, desc="Veggie Burger"

b = new ExtraCheeseBurger(b);
// b is now ExtraCheeseBurger wrapping VeggieBurger
// getCost()        → burger.getCost() + 20  → 180 + 20 = 200
// getDescription() → burger.getDescription() + " with extra cheese"

b = new WheatBunBurger(b);
// b is now WheatBunBurger wrapping ExtraCheeseBurger wrapping VeggieBurger
// getCost()        → burger.getCost() + 50  → 200 + 50 = 250
// getDescription() → "Veggie Burger with extra cheese with wheat bun"
```
Each decorator calls through to whatever it wraps — it doesn't care whether that's a base burger or another decorator. This is what makes them stackable in any order.

### Why decorators extend the same base they wrap
`ExtraCheeseBurger` holds a `Burger` reference AND extends `Burger`. This is intentional — it means a decorator is itself a `Burger`, so you can pass it to another decorator's constructor. Without this, you couldn't chain them.

### Key differences from inheritance
| Inheritance | Decorator |
|---|---|
| Behaviour fixed at compile time | Behaviour composed at runtime |
| Combinatorial subclass explosion | Mix and match wrappers freely |
| Tightly coupled to parent | Loosely coupled via composition |

### Real-world example
`java.io` streams use this pattern heavily:
```java
new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")))
```
`FileInputStream` is the base; `InputStreamReader` and `BufferedReader` are decorators adding character encoding and buffering respectively.
