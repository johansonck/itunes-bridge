package be.sonck.itunes.bridge.interpreter;

public interface Interpreter<T> {

	T interpret(String string);
}
