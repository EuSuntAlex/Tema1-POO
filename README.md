# Tema1-POO
Tema1 POO
Clasa Actor are in plus:
* Un array list unde tin numele tuturor videourilor pe care le-a vazut
In Actordb imi voi tine toti actorii dati la input

Command este o clasa facuta pentru a apela mai usor primele comenzi.

Film_db reprezinta clasa unde primim informatiile de la input despre Filme. Acesta 
este alcatuit dintr-un hasmap cu cheile numele filmului si informatia filmul in sine.


Query este folosit pentru a apela fucntia nr_ratings. Acolo, iau un auxiliar unde copiez 
toti userii si iterez prin ei si ii sortez in functie de actiunile sale dupa care iau doar primii N.

In Seasons avem in plus, un ArrayList de ce users au revizuit videoul respectiv.
 
La Serial_db functia de addRating adauga ratingul in HashMap si actualizeaza lista de username
care au revizuit-o.

La Username:

-History este un hasmap cu cheia videouri si cu elemente numarul de vizionari
-favorites este un arraylist cu toate numele vidurilor favorite

*addFavorite :
verifica initial daca videoul respetiv este in lista lui de history, daca da atunci se verifica daca userul respectiv
are deja vidu in favorite cautand in campul favorites. Daca nu, adaug in favorite si updatez ArrayListurile.

*vizionare:
verific in history daca userul s-a mai uitat la videoclip. Daca da, adaug unu in history la cheia cu valoarea numelui videoclipului, daca nu, atunci adaug ca si element cu valoarea 1.

*rateFilm
verific daca campul history are numele filmului si daca nu a fost inca gradat atunci adaug 1 la actiuni(numarul de gradari ale user-ului) si adaug in database ratingul.
*rateSerial
similar cu filmul doar ca se updateaza database ul de seriale.
