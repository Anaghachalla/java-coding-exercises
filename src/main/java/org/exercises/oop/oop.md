### Properties of an Immutable class
* Immutable classes cannot be extended (final class)
* Contents of such class will be set once and cannot be modified by any means (final attributes)
* Note: final on a field doesn't mean the object is immutable — it means the reference can't be reassigned. We should not allow electives = new HashSet<>(electives) again after initialization in the constructor.
* Setter methods should not be exposed outside (can be omitted, and setting should be done once via the parameterized constructor)
* Create and return deep copies of references of objects. For primitives and strings this is not required as they are immutable by default.