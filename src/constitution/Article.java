package constitution;

public class Article {
    private int number;
    private String text;

    public Article(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public Article(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Art. " + number + "\n" + text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
