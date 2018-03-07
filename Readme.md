# Konstytucja - OOP

Program wczytuje konstytucje z pliku i wypisuje podany roździał lub artukuł. 

### Argumenty programu:

* wypisywanie rozdziałów: **`plik_konstytucji` `r / roz / roz. / rozdział` `numer / zakres`**
* wypisywanie artykułów: **`plik_konstytucji` `a / art / art. / artykuł` `numer / zakres`**

przykład: `konstytucja.txt art. 1-5`

#### compile:
```
mkdir out
javac src/constitution/*.java -d out
```

#### run:
```
java -cp out consitution.Main konstytucja.txt roz. 1-2
```

## Treść zadania:

Zamiana tekstu na formę obiektową.

1. Zapoznaj się z plikiem konstytucja.txt dołączonym do niniejszego repozytorium.
2. Opracuj zestaw klas oraz zimplementuj odpowiednie algorytmy tak by opracowany program:
  * wczytywał plik konstytucja.txt,
  * zamieniał postać tekstową pliku na formę obiektową,
  * umożliwiał wyświetlanie treści artykułu o określonym numerze lub zakresu artykułów,
  * umożliwiał wyświetlanie treści rozdziału o określonym numerze (w tym treści wszystkich artykułów znajdujących się w tym rozdziale),
  * usuwał z końca linii znaki przeniesienia do nowej liniii (-) i łączył słowa w całość,
  * usuwał z tekstu zbęde elementy takie jak linie "Kancelaria Sejmu" oraz data,
  * zachowywał oryginalna strukturę tekstu, tzn. elementy takie jak punkty (patrz art. 10) nie powinny być wyświetlane w jednej linii.
3. Program powinien akceptować argumenty: lokalizację pliku konstytucja.txt oraz numer lub zakres artykułów, bądź numer rozdziału.
