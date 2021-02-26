package by.metelski.compositechain.entity;

public interface TextComponent {
	void add(TextComponent component);
	void remove(TextComponent component);
	int countSymbols();
}
