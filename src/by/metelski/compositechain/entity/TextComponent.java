package by.metelski.compositechain.entity;

public interface TextComponent {
	void operation();
	void add(TextComponent component);
	void remove(TextComponent component);
	int countLeaf();
}
