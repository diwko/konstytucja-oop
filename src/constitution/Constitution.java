package constitution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Constitution implements IConstitution {
    private String path;
    private Preamble preamble;
    private List<Chapter> chapters;
    private List<Title> titles;
    private List<Article> articles;

    public Constitution(String path) throws IOException {
        this.path = path;
        preamble = new Preamble("");
        chapters = new ArrayList<>();
        titles = new ArrayList<>();
        articles = new ArrayList<>();

        ConstitutionParser parser = new ConstitutionParser(path);
        parser.parse(preamble, chapters, titles, articles);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(preamble + "\n");
        for (Chapter chapter : chapters)
            builder.append(chapter.toString());
        return builder.toString();
    }

    @Override
    public Preamble getPreamble() {
        return preamble;
    }

    @Override
    public Chapter getChapter(int number) {
        try {
            return chapters.get(number - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nie znaleziono rozdziału nr: " + number + ". Konstytucja posiada rozdziały z przedziału: 1-" + chapters.size());
        }
        return null;
    }

    @Override
    public Article getArticle(int number) {
        try {
            return articles.get(number - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nNie znaleziono artykułu nr: " + number + ". Konstytucja posiada artykuły z przedziału: 1-" + articles.size());
        }
        return null;
    }
}
