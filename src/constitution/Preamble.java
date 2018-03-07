package constitution;

public class Preamble {
    String text;

    public Preamble(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
