package constitution;

import java.io.IOException;

public class ConstitutionPrinter {
    private String path;
    private ConstitutionPart constitutionPart;
    private int first;
    private int last;


    public ConstitutionPrinter(String[] args) throws IllegalArgumentException {
        if (args.length == 3) {
            path = args[0];
            constitutionPart = constitutionPartParser(args[1]);
            setNumbers(args[2]);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private ConstitutionPart constitutionPartParser(String part) {
        part = part.toLowerCase();
        switch (part) {
            case "a":
                return ConstitutionPart.Article;
            case "art":
                return ConstitutionPart.Article;
            case "art.":
                return ConstitutionPart.Article;
            case "artukuł":
                return ConstitutionPart.Article;
            case "r":
                return ConstitutionPart.Chapter;
            case "roz":
                return ConstitutionPart.Chapter;
            case "roz.":
                return ConstitutionPart.Chapter;
            case "rozdział":
                return ConstitutionPart.Chapter;
            default:
                return null;
        }
    }

    private void setNumbers(String numbers) {
        if (numbers.matches("[0-9]+"))
            first = last = Integer.parseInt(numbers);
        else if (numbers.matches("[0-9]+[-]{1}[0-9]+")) {
            String[] nums = numbers.split("-");
            first = Integer.parseInt(nums[0]);
            last = Integer.parseInt(nums[1]);
            if (first > last)
                last = first;
        } else
            first = last = 0;
    }

    public void print() {
        try {
            Constitution constitution = new Constitution(path);

            if (constitutionPart == ConstitutionPart.Article) {
                for (int i = first; i <= last; i++) {
                    Article article = constitution.getArticle(i);
                    if (article == null)
                        break;
                    System.out.println(article);
                }
            } else if (constitutionPart == ConstitutionPart.Chapter) {
                for (int i = first; i <= last; i++) {
                    Chapter chapter = constitution.getChapter(i);
                    if (chapter == null)
                        break;
                    System.out.println(chapter);
                }
            }

        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku");
        }
    }

}
