----------- bolnice -----------------------------------------------------

INSERT INTO "bolnica"("id", "naziv", "adresa", "budzet") VALUES(nextval('bolnica_seq'), 'Opsta bolnica Vrsac', 'Abraseviceva 13, Vrsac, Srbija', 3000000);
INSERT INTO "bolnica"("id", "naziv", "adresa", "budzet") VALUES(nextval('bolnica_seq'), 'Opsta bolnica Kovin', 'Cara Lazara 253, Kovin, Srbija', 5000000);
INSERT INTO "bolnica"("id", "naziv", "adresa", "budzet") VALUES(nextval('bolnica_seq'), 'Klinicki centar Vojvodine', 'Hajdok Veljkova 1-9, Novi Sad, Srbija', 70000000);
INSERT INTO "bolnica"("id", "naziv", "adresa", "budzet") VALUES(nextval('bolnica_seq'), 'Klinicki centar Srbije', 'Visegradska 26, Beograd, Srbija', 16000000);

----------- dijagnoze -----------------------------------------------------

INSERT INTO "dijagnoza"("id", "naziv", "opis", "oznaka") VALUES(nextval('dijagnoza_seq'), 'Bolest srca i krvnih sudova','pogađaju srce i krvne sudove, uključujući srčani udar i dr','I00-I99');
INSERT INTO "dijagnoza"("id", "naziv", "opis", "oznaka") VALUES(nextval('dijagnoza_seq'), 'Rak dojke','Maligni tumor koji se razvija u tkivu dojke, često povezan s formiranjem kvržica u dojci','C50');
INSERT INTO "dijagnoza"("id", "naziv", "opis", "oznaka") VALUES(nextval('dijagnoza_seq'), 'Gripa','Virusna infekcija respiratornog sistema koja može izazvati simptome poput groznice, kašlja, bolova u mišićima i umora','J09-J11');
INSERT INTO "dijagnoza"("id", "naziv", "opis", "oznaka") VALUES(nextval('dijagnoza_seq'), 'Artritis','Upalna bolest koja utječe na zglobove i može dovesti do boli.', 'M05-M06');
INSERT INTO "dijagnoza"("id", "naziv", "opis", "oznaka") VALUES(nextval('dijagnoza_seq'), 'Alzheimerova bolest','Progresivno neurodegenerativno stanje koje uzrokuje gubitak pamćenja.','G30');
INSERT INTO "dijagnoza"("id", "naziv", "opis", "oznaka") VALUES(nextval('dijagnoza_seq'), 'Depresija','Mentalni poremećaj koji karakteriziraju osjećaji tuge, gubitka interesa ili zadovoljstva.','F32-F33');
INSERT INTO "dijagnoza"("id", "naziv", "opis", "oznaka") VALUES(nextval('dijagnoza_seq'), 'Cistična fibroza','Nasljedna bolest koja utječe na pluća i probavni sistem','E84');
INSERT INTO "dijagnoza"("id", "naziv", "opis", "oznaka") VALUES(nextval('dijagnoza_seq'), 'Diabetes mellitus',' Metabolički poremećaj koji rezultira visokim nivoima šećera u krvi zbog problema s inzulinom ili njegovim djelovanjem','E10-E14');
INSERT INTO "dijagnoza"("id", "naziv", "opis", "oznaka") VALUES(nextval('dijagnoza_seq'), 'Astma','Upala i suženje disajnih puteva, što dovodi do problema s disanjem, kašlja i gušenja.','J45');
INSERT INTO "dijagnoza"("id", "naziv", "opis", "oznaka") VALUES(nextval('dijagnoza_seq'), 'Anksiozni poremećaji','Mentalni poremećaji koji uključuju osjećaje pretjerane brige','F41');
																
----------- odeljenja -----------------------------------------------------

INSERT INTO "odeljenje"("id", "naziv", "lokacija", "bolnica") VALUES (nextval('odeljenje_seq'), 'Hitni slucajevi', 'Sprat 2, Ordinacija 2', 2);
INSERT INTO "odeljenje"("id", "naziv", "lokacija", "bolnica") VALUES (nextval('odeljenje_seq'), 'Interna medicina', 'Sprat 1, Ordinacija 3', 4);
INSERT INTO "odeljenje"("id", "naziv", "lokacija", "bolnica") VALUES (nextval('odeljenje_seq'), 'Pedijatrija', 'Sprat 3, Ordinacija 5', 3);
INSERT INTO "odeljenje"("id", "naziv", "lokacija", "bolnica") VALUES (nextval('odeljenje_seq'), 'Neurologija', 'Sprat 2', 2);
INSERT INTO "odeljenje"("id", "naziv", "lokacija", "bolnica") VALUES (nextval('odeljenje_seq'), 'Ortopedija', 'Sprat 1, Ordinacija 6', 1);
INSERT INTO "odeljenje"("id", "naziv", "lokacija", "bolnica") VALUES (nextval('odeljenje_seq'), 'Radiologije', 'Sprat 4, Ordinacija 5', 2);
INSERT INTO "odeljenje"("id", "naziv", "lokacija", "bolnica") VALUES (nextval('odeljenje_seq'), 'Psihijatrije', 'Sprat 3', 3);
INSERT INTO "odeljenje"("id", "naziv", "lokacija", "bolnica") VALUES (nextval('odeljenje_seq'), 'Ginekologija i akusertva', 'Sprat 5, Ordinacija 7', 4);
INSERT INTO "odeljenje"("id", "naziv", "lokacija", "bolnica") VALUES (nextval('odeljenje_seq'), 'Dermatologije', 'Sprat 6, Ordinacija 1', 3);	
INSERT INTO "odeljenje"("id", "naziv", "lokacija", "bolnica") VALUES (nextval('odeljenje_seq'), 'Oftomalogije', 'Sprat 3, Ordinacija 5', 2);																
																
------------ pacijenti -----------------------------------------------------

INSERT INTO "pacijent"("id", "ime", "prezime", "zdr_osiguranje", "datum_rodjenja", "odeljenje", "dijagnoza") VALUES (nextval('pacijent_seq'), 'Ivana', 'Ivanovic', false, to_date('05.08.2009.', 'dd.mm.yyyy.'), 3, 5);
INSERT INTO "pacijent"("id", "ime", "prezime", "zdr_osiguranje", "datum_rodjenja", "odeljenje", "dijagnoza") VALUES (nextval('pacijent_seq'), 'Jovan', 'Gajic', true, to_date('02.02.2005.', 'dd.mm.yyyy.'), 6, 9);
INSERT INTO "pacijent"("id", "ime", "prezime", "zdr_osiguranje", "datum_rodjenja", "odeljenje", "dijagnoza") VALUES (nextval('pacijent_seq'), 'Bogdana', 'Ivosev', false, to_date('17.06.1991.', 'dd.mm.yyyy.'), 2, 3);
INSERT INTO "pacijent"("id", "ime", "prezime", "zdr_osiguranje", "datum_rodjenja", "odeljenje", "dijagnoza") VALUES (nextval('pacijent_seq'), 'Boban', 'Ilic', true, to_date('04.03.1986.', 'dd.mm.yyyy.'), 10, 4);
INSERT INTO "pacijent"("id", "ime", "prezime", "zdr_osiguranje", "datum_rodjenja", "odeljenje", "dijagnoza") VALUES (nextval('pacijent_seq'), 'Darko', 'Gajta', true, to_date('12.12.2000.', 'dd.mm.yyyy.'), 3, 6);
INSERT INTO "pacijent"("id", "ime", "prezime", "zdr_osiguranje", "datum_rodjenja", "odeljenje", "dijagnoza") VALUES (nextval('pacijent_seq'), 'Konstantin', 'Petrovic', true, to_date('18.10.1999.', 'dd.mm.yyyy.'), 4, 8);
INSERT INTO "pacijent"("id", "ime", "prezime", "zdr_osiguranje", "datum_rodjenja", "odeljenje", "dijagnoza") VALUES (nextval('pacijent_seq'), 'Ranko', 'Kostic', false, to_date('15.09.1995.', 'dd.mm.yyyy.'), 7, 2);
INSERT INTO "pacijent"("id", "ime", "prezime", "zdr_osiguranje", "datum_rodjenja", "odeljenje", "dijagnoza") VALUES (nextval('pacijent_seq'), 'Goran', 'Bogdan', false, to_date('01.02.2003.', 'dd.mm.yyyy.'), 1, 1);
INSERT INTO "pacijent"("id", "ime", "prezime", "zdr_osiguranje", "datum_rodjenja", "odeljenje", "dijagnoza") VALUES (nextval('pacijent_seq'), 'Selena', 'Opacic', true, to_date('17.06.1998.', 'dd.mm.yyyy.'), 7, 3);
INSERT INTO "pacijent"("id", "ime", "prezime", "zdr_osiguranje", "datum_rodjenja", "odeljenje", "dijagnoza") VALUES (nextval('pacijent_seq'), 'Kristijan', 'Cavic', false, to_date('13.03.1993.', 'dd.mm.yyyy.'), 5, 7);
INSERT INTO "pacijent"("id", "ime", "prezime", "zdr_osiguranje", "datum_rodjenja", "odeljenje", "dijagnoza") VALUES (nextval('pacijent_seq'), 'Gojko', 'Lopatic', true, to_date('19.02.2002.', 'dd.mm.yyyy.'), 9, 10);
INSERT INTO "pacijent"("id", "ime", "prezime", "zdr_osiguranje", "datum_rodjenja", "odeljenje", "dijagnoza") VALUES (nextval('pacijent_seq'), 'Ognjen', 'Jelovac', false, to_date('07.08.1999.', 'dd.mm.yyyy.'), 8, 5);		
