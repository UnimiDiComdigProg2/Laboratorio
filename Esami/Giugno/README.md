# Campagne Pubblicitarie

Un oggetto di tipo `AdCampaign` definisce una campagna pubblicitaria, identificata da un nome:
* Due campagne sono considerate uguali se hanno lo stesso nome
* Una campagna può restituire un valore di performance (numero decimale tra `0` e `1` inclusi)
* Le campagne possono essere naturalmente ordinate per il loro valore di performance
* Una campagna pubblicitaria viene creata `aperta`, e finchè è aperta permette di aggiornare i dati di andamento con un apposito metodo
* Dopo che viene `chiusa`, se si tenta di aggiornare i dati di andamento della campagna, viene lanciata un'eccezione `CampaignClosedException` (checked)

`AdCampaignSocial` è una campagna pubblicitaria mediante post su social network:
* Tiene traccia del numero di visualizzazioni (`nVis`) e del numero di like (`nLike`) che saranno chiaramente meno di quelli che hanno visualizzato
* Se la campagna è aperta, i conteggi delle visualizzazioni e dei like possono essere incrementati, con il numero dei nuovi like (`nLikeNew`) e visualizzazioni (`nVisNew`), da aggiungere a quelli già inseriti precedentemente
* Il valore di performance è definito come: `nLike/nVis`

`AdCampaignWebRestyling` è una campagna pubblicitaria basata sul redesign del sito web:
* Tiene traccia del numero dei visitatori (`nVis`) e del tempo di visita medio (`tVis`) in minuti
* Inoltre, alla creazione deve ricevere il tempo di visita medio per visitatore riferito al periodo prima dell'inizio della campagna (`tVisOld`) in minuti
* Se la campagna è aperta, il conteggio dei visitatori può essere incrementato con il numero dei nuovi visitatori (`nVisNew`). Inoltre sarà indicato il tempo di visita medio per visitatore (`tVisNew`), riferito a questi nuovi visitatori. Il tempo di visita medio sarà aggiornato con la formula: `((nVis * tVis)+(nVisNew * tVisNew))/(nVis+nVisNew)`
* Il valore di performance è definito come: `tVis/(tVis+tVisOld)`

Il tipo `CompanyAds` indica un'azienda, identificata dal nome, e le sue campagne pubblicitarie
* Permette di inserire una nuova campagna pubblicitaria. Se tale campagna è già stata inserita, viene lanciata un'eccezione `CampaignExistsException` (unchecked)
* Può restituire un iteratore alle campagne inserite, ordinate in base alla performance

Progettare, specificare ed implementare le classi descritte sopra ed i loro metodi. Quando opportuno, le classi devono avere uno o più costruttori, delle Abstraction Function e Representation Invariant, ed eventuali altri metodi utili.

Scrivere una classe Test e nel `main()` leggere da **riga di comando** il nome dell'azienda e poi, da **standard input**, una serie di righe nel formato `NomeCampagna TipoCampagna parametri`. `tipoCampagna` può essere `Social` o `WebRestyle`, e i `parametri` possono essere:
* `open` per creare una nuova campagna.
	* e nel caso di `WebRestyle` vi sarà un ulteriore parametro `tVisOld`
* `close` per chiudere la campagna
* `update` per aggiornare la campagna, e in questo caso ci saranno anche:
	* `nVis` `nLike` per una campagna `Social` già aperta
	* `nVis` `tVis` per una campagna `WebRestyle` già aperta

La lettura delle campagne termina quando viene inserito, con la combinazione `Ctrl+D` il comando `End-Of-File`.
Infine, se non ci sono state eccezioni, stampare su **standard output** le campagne dell'azienda con il loro tipo, nome, e valore di performance.

#### Esempio d'esecuzione:

```text
$ java Test ParadisoDellaBrugola
Inserisci o aggiorna campagne:
FaceBookSpam Social open
FontBluSfondoGiallo WebRestyle open 5.12
FaceBookSpam Social update 100 35      
FaceBookSpam Social update 40 28    
FontBluSfondoGiallo WebRestyle update 20 7.24
FaceBookSpam Social update 60 45
FaceBookSpam Social close
FontBluSfondoGiallo WebRestyle update 6 4.8

Campagne di ParadisoDellaBrugola:
	WebRestyle name: FontBluSfondoGiallo performance: 0.5659885237350026
	Social name: FaceBookSpam performance: 0.54

$ java Test ACME
Inserisci o aggiorna campagne:
WillyCoyoteTwitter Social open
WillyCoyoteTwitter Social open
WillyCoyoteTwitter already exists

$ java Test Taffo
Inserisci o aggiorna campagne:
MagariVivi Social open    
MagariVivi Social close
MagariVivi Social update 100 100
MagariVivi is closed
```