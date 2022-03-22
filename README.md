# The Multiple Traveling Salesman Problem

This project solves multiple traveling salesman problem using nearest neighbor algorithm.


The [Multiple Traveling Salesman Problem](https://neos-guide.org/content/multiple-traveling-salesman-problem-mtsp) (*m*TSP) in which more than one salesman is allowed is a generalization of the Traveling Salesman Problem (TSP).
Given a set of cities, one depot (where *m* salesmen are located), and a cost metric, the objective of the *m*TSP is to determine a set of routes for *m* salesmen so as to minimize the total cost of the *m* routes. 
The cost metric can represent cost, distance, or time. The requirements on the set of routes are:

* All of the routes must start and end at the (same) depot.
* There must be at least one city (except depot) in each route.
* Each city must be visited exactly once by only one salesman.

**Multiple depots**: Instead of one depot, the multi-depot *m*TSP has a set of depots, with m<sub>j</sub> salesmen at each depot *j*. 
In the *fixed destination* version, a salesman returns to the same depot from which he started.

This project uses [JewelCLI](http://jewelcli.lexicalscope.com) library to parse command line arguments.

Usage:
```
mvn clean package
java -jar target\mTSP.jar {args}
```

Example:
```
java -jar target\ mTSP.jar -d 12 -s 2 -v
(12 depots and each depot has 2 salesmen)
```
```
"-d" is number of depot parameter.
"-s" is number of salesman parameter.
"-v" is verbose parameter. (prints "ADANA" instead of "1")
```
Notice that the last line includes the cost metric: the total distance travelled by all salesmen.

Outputs:
It shows the current minimum cost value to the left of the values printed on the screen and the current iteration number to the right until the routes are displayed.
(in this example: ``0th iteration`` has ``23618 kilometers``, ``14th iteration`` has ``23537 kilometer``)<br>
```
java -jar target\ mTSP.jar -d 5 -s 2 -v
23618 0
23537 14
23484 31
23438 38
23298 43
...
...
...

14970 360656
14952 361479
14916 666848
14893 667193


Depotl:KAYSERİ
Routel: NİĞDE, NEVŞEHİR, AKSARAY, KIRŞEHİR, YOZGAT
Route2: MALATYA, ELAZIĞ, TUNCELİ, ERZİNCAN, GİRESUN, ORDU, SAMSUN,
ÇORUM, AMASYA, TOKAT, SİVAS
Depot2:DİYARBAKIR
Routel: BİNGÖL, MUŞ, BİTLİS, VAN, HAKKARİ, ŞIRNAK, SIIRT, BATMAN
Route2: ŞANLIURFA, GAZİANTEP, OSMANİYE, KAHRAMANMARAŞ, ADIYAMAN
Depot3:AĞRI
Routel: SİNOP, BOLU, TEKİRDAĞ, ÇANAKKALE, UŞAK, ISPARTA, BURDUR,
ANTALYA, İÇEL, ADANA, HATAY, KİLİS, MARDİN
Route2: IĞDIR, KARS, ARDAHAN, ARTVİN, RİZE, TRABZON, GÜMÜŞHANE,
BAYBURT, ERZURUM
Depotli:ESKİŞEHİR
Routel: KONYA, KARAMAN, AFYON, KÜTAHYA
Route2: BURSA, YALOVA, KOCAELİ, SAKARYA, DÜZCE, BİLECİK
Depot5:ANKARA
Routel: KIRIKKALE, ÇANKIRI, KASTAMONU, KARABÜK, BARTIN, ZONGULDAK
Route2: DENİZLİ, MUĞLA, AYDIN, İZMİR, MANİSA, BALIKESİR, EDİRNE,
KIRKLARELİ, İSTANBUL
**Total cost is 14893
```

