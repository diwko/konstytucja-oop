package constitution;

public interface IConstitution {
    Preamble getPreamble();

    Chapter getChapter(int number);

    Article getArticle(int number);
}
