**Stream**
---

A project created as part of a mentoring program for learning and practicing Java Stream

---

Implement following models:

1. models.Life with fields:

* String country

* List<Animal> animals

* List<Plant> plants

2. Animal with fields:

* String species

* int numberOfLegs

* boolean venomous

3. Plant with fields:

* String species

* Double standardHigh

* String fruitName

Create data set of type models.Life. Data set should be filled with random values and consists of elements as expected below: 

* two identical

* at least two similar considering at least one parameter (for each parameter) 

* at least one unique


**Using stream complete the exercises below**

1. [tricky] Extract unique animal species contained in the data set to the String list (List of all animal species without repetitions).

2. [tricky] Extract unique plant species contained in the data set to the String list (List of all plant species without repetitions).

3. [easy] Find the first element in the list that meets the condition: "contains a country with a name starting with the letter 's'" (if there is none - add it to the list), map this element to the Plant List and sort the plants descending after the standardHigh value.

4. [difficult] Find the first element in the list that meets the condition "contains a country whose name consists of 5 letters" (if there is none - add it to the list), map this element to the animal list and Group animals by the number of legs (result final should be of type Map<Integer, List<Animal>> where the number of legs is the key).

5. [easy] Pull out all countries to a list and sort them ascending by name.

6. [difficulty up to 5] add all countries to the list and sort them ascending by the second letter of their name.

7. Get from the list all countries where at least one species of venomous animal occurs (the result should be only a list of countries)



---

**Streamy - Zadania**

---



**Zaimplementować następujące modele:**

1. models.Life zawierający pola:

* String country

* List<Animal> animals

* List<Plant> plants

2. Animal zawierający pola:

* String species

* int numberOfLegs

* boolean venomous

3. Plant zawierający pola:

* String species

* Double standardHigh

* String fruitName



Stworzyć zestaw danych typu models.Life (uzupełniony dowolnymi wartościami) spełniający warunek zawierania następujących elementów:

* 2 identycznych

* Po 2 podobne pod kątem przynajmniej jednego z parametrów (dla każdego parametru)

* Przynajmniej 1 unikalny



**Wykonać następujące zadania, korzystając ze streamów:**

1. [podchwytliwe] Wyciągnąć do listy Stringów unikalne gatunki zwierząt zawartych w zbiorze danych (Lista wszystkich gatunków zwierząt bez powtórzeń).

2. [podchwytliwe] Wyciągnąć do listy Stringów unikalne gatunki roślin zawartych w zbiorze danych (Lista wszystkich gatunków roślin bez powtórzeń).

3. [łatwe] znaleźć pierwszy element na liście, który spełnia warunek: „zawiera kraj o nazwie zaczynającej się na literę ‘s’” (jeśli takiego nie ma – dodać go do listy), zmapować ten element do Listy roślin i Posortować rośliny malejąco po wartości standardHigh.

4. [trudne] Znaleźć pierwszy element w liście, który spełnia warunek „zawiera kraj, które nazwa składa się z 5 liter” (jeśli takiego nie ma – dodać go do listy), zmapować ten element do listy zwierzą i Pogrupować zwierzęta po ilości nóg (rezultat końcowy powinien być typu Map<Integer, List<Animal>> gdzie ilość nóg jest kluczem).

5. [łatwe] wyciągnąć do listy wszystkie kraje i posortować je rosnąco po nazwie.

6. [utrudnienie do 5] wyciągnąć do listy wszystkie kraje i posortować je rosnąco po drugiej literze z nazwy.

7. Wyciągnąć z listy wszystkie kraje, w których występuje choć jeden gatunek jadowitego zwierzęcia (rezultatem powinna być tylko lista krajów).


