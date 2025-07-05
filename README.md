# Design Patterns in Java

This repository is designed to teach software developers at Nuance (now Microsoft) the practical application of design patterns in Java. The codebase demonstrates real-world usage of various design patterns while adhering to **SOLID**, **DRY**, **KISS**, and **YAGNI** principles to ensure clean, maintainable, and efficient code.

## Design Patterns Covered

The following design patterns are implemented in this repository with their respective classes or interfaces:

- **Command**: `Command` interface for encapsulating requests as objects.
- **Chain of Responsibility**: `CommandExecutionChain` and `CommandExecutionStep` for passing requests along a chain of handlers.
- **Memento**: Used in Undo/Redo commands to capture and restore object states.
- **Interpreter**: `CommandInterpreter` for parsing and executing commands.
- **Observer**: `DrawingPresenter` observes `Shape` objects, which act as observables.
- **Composite**: `CompositeShape` for treating individual and composite shapes uniformly.
- **Decorator**: `TransparentShape` adds opacity functionality to shapes.
- **MVC (Model-View-Controller)**:
  - `View` and `Presenter` interfaces
  - `DrawingView` and `DrawingPresenter` for drawing-related MVC
  - `InfoView` and `InfoPresenter` for information display
- **Front Controller**: `FrontController` class to handle all incoming requests centrally.
- **Value Object**: `User` as an immutable value object.
- **Null Object**: `NullCommandExecutionStep` for providing a no-op command step.
- **Singleton**: `ShapeFactory` as a single instance for creating shapes.
- **Prototype**: `CopyCommand` uses the prototype pattern to create duplicate shapes.
- **Builder**: `Container.Builder` for constructing complex objects step-by-step.
- **Factory**: 
  - `CommandFactory` for creating command instances.
  - `ShapeFactory` for creating shape instances.
- **Delegate**: `CompositeCreateDelegate` for delegating composite shape creation.

## Purpose and Goals

This repository serves as an educational tool to help developers:
- Understand the practical application of design patterns in real-world scenarios.
- Learn how to write clean, modular, and maintainable code using best practices.
- Apply **SOLID**, **DRY**, **KISS**, and **YAGNI** principles effectively.

## Getting Started

To explore the code:
1. Clone the repository: `git clone <repo-url>`
2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Explore the source code in the `src` directory to see implementations of each design pattern.
4. Run the examples to see the patterns in action.

## Contributing

This repository is for educational purposes. Contributions are welcome to enhance the examples or add new design patterns. Please follow these steps:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
