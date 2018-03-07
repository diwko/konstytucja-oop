package constitution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ConstitutionParser {
    private String path;

    public ConstitutionParser(String path) {
        this.path = path;
    }

    public boolean parse(Preamble preamble, List<Chapter> chapters, List<Title> titles, List<Article> articles) throws IOException {
        Chapter chapter = null;
        Title title = null;
        Article article = null;

        String chapterNumber;
        String titleNumber;
        int articleNumber;

        StringBuilder textBuilder = new StringBuilder();
        String currentLine;


        BufferedReader br = new BufferedReader(new FileReader(path));

        //Read preamble (from the beginning to first chapter)
        for (currentLine = br.readLine(); currentLine != null && (chapterNumber = isChapter(currentLine)) == null; currentLine = br.readLine()) {
            if (isDate(currentLine) || isPlace(currentLine))
                continue;
            textBuilder.append(prepareLine(currentLine));
        }
        preamble.setText(textBuilder.toString());

        //Read chapters, titles, articles
        do {
            //Skip lines start with "©" and lines = "xxxx-xx-xx"
            if (isDate(currentLine) || isPlace(currentLine))
                continue;
                //Create chapter if line = "Rozdział x"
            else if ((chapterNumber = isChapter(currentLine)) != null) {
                chapter = new Chapter(chapterNumber);
                chapters.add(chapter);
            }
            //Create title if line = UPPERCASE_TEXT
            else if ((titleNumber = isTitle(currentLine)) != null) {
                title = new Title(titleNumber);
                titles.add(title);
                chapter.addTitle(title);
            }
            //Create aricle if line = "Art. x."
            else if ((articleNumber = isArticle(currentLine)) != -1) {
                if (article != null) {
                    article.setText(textBuilder.toString());
                }
                textBuilder = new StringBuilder();
                article = new Article(articleNumber);
                articles.add(article);
                title.addArticle(article);
            }
            //Append text point
            else {
                textBuilder.append(prepareLine(currentLine));
            }
        } while ((currentLine = br.readLine()) != null);

        if (article != null)
            article.setText(textBuilder.toString());

        return true;
    }


    //Return chapter number (roman) if line begin chapter else null
    private String isChapter(String line) {
        if (line == null || !line.startsWith("Rozdział"))
            return null;
        else
            return line.replace("Rozdział ", "");
    }

    //Return title text if line begin title else null
    private String isTitle(String line) {
        if (line == null || isDate(line) || !line.equals(line.toUpperCase()))
            return null;
        else
            return line;
    }

    //Return article number if line begin article else -1
    private int isArticle(String line) {
        if (line == null || !line.startsWith("Art."))
            return -1;
        else
            return Integer.parseInt(line.replace("Art. ", "").replace(".", ""));
    }

    //If line begin with "©" return true, else false
    private boolean isPlace(String line) {
        if (line == null || !line.startsWith("©"))
            return false;
        else
            return true;
    }

    //Return true if line id date like "XXXX-XX-XX", otherwise false
    private boolean isDate(String line) {
        if (line == null || !line.matches("[0-9]{4}[-][0-9]{2}[-][0-9]{2}"))
            return false;
        else
            return true;
    }

    //Delete "-" at the end of line and add new line for new points
    private String prepareLine(String line) {
        if (line.matches("[2-9]{1}[0-9]*[.]{1}.+") || line.matches("[0-9]+[)]{1}.+"))
            line = "\n" + line;
        if (line.endsWith("-"))
            return line.substring(0, line.length() - 1);
        return line + " ";
    }
}
