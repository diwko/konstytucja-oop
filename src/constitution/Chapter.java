package constitution;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
    private String number;
    private List<Title> titles;

    public Chapter(String number, List<Title> titles) {
        this.number = number;
        this.titles = titles;
    }

    public Chapter(String number) {
        this.number = number;
        titles = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Rozdział " + number + "\n");
        for (Title title : titles)
            builder.append(title.toString());
        return builder.toString();
    }


    public Title getTitle(int number) {
        return titles.get(number - 1);
    }

    public void addTitle(Title title) {
        titles.add(title);
    }
}
