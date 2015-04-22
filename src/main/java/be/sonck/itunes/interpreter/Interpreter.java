package be.sonck.itunes.interpreter;

public interface Interpreter<T> {

	T interpret(String string);
}
