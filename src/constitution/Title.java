package constitution;

import java.util.ArrayList;
import java.util.List;

public class Title {
    private String text;
    private List<Article> articles;

    public Title(String text, List<Article> articles) {
        this.text = text;
        this.articles = articles;
    }

    public Title(String text) {
        this.text = text;
        articles = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(text + "\n");
        for (Article article : articles)
            builder.append(article.toString() + "\n");
        return builder.toString();
    }

    public Article getArticle(int number) {
        return articles.get(number - 1);
    }

    public void addArticle(Article article) {
        articles.add(article);
    }
}
