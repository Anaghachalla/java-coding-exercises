## Notes
* Custom exceptions should extend the `Exception` class for checked exceptions and `RuntimeException` class for unchecked exceptions.
* `Exception` class sits above both checked and runtime exceptions (both are subclasses of it)
* `Error` class is never extended (although possible). It is only for modeling truly unrecoverable JVM-level failures.
* `Throwable` class is also never extended (although possible). Only `Exception` and `Error` are considered as its subclasses. Many frameworks and catch blocks won't handle it properly. 
* It signals intent poorly: `Exception` = recoverable, `Error` = JVM-level catastrophic. A custom `Throwable` subclass has no clear meaning. So it is a bad practice.
* Put throws in the method signature for checked exceptions (i.e. when a method throws a subclass of Exception class). Can be omitted for runtime exceptions (i.e. when a method throws a subclass of `RuntimeException`).
* Exceptions hierarchy - `CustomException` (class) ---extends---> `RuntimeException` (class) ---extends---> `Exception` (class) ---extends---> `Throwable` (class) ---implements---> `Serializable` (interface)