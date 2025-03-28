# Report
# Indice

- ### [# 1 - Introduzione](#1---introduzione)
  - [**Partecipanti al progetto**](#partecipanti-al-progetto)
  - [**Descrizione progetto**](#descrizione-progetto)
- ### [# 2 - Modello di Dominio](#2---modello-di-dominio)
- ### [# 3 - Requisiti Specifici](#3---requisiti-specifici)
  - [**3.1 - Requisiti Sprint 1**](#31---requisiti-sprint-1)
    - [**3.1.1 - Funzionali**](#311---funzionali)
    - [**3.1.2 - Non Funzionali**](#312---non-funzionali)
  - [**3.2 - Requisiti Funzionali Sprint 2**](#32---requisiti-funzionali-sprint-2)
- ### [# 4 - System Design](#4---system-design)
  - [**4.1 - Diagramma dei Pacchetti**](#41---diagramma-dei-pacchetti)
  - [**4.2 Architettura dell'Applicazione**](#42-architettura-dellapplicazione)
  - [**4.3 Commenti sulle decisioni**](#43-commenti-sulle-decisioni)
- ### [# 5 - Object Oriented Design](#5---object-oriented-design)
  - [**5.1 - Diagrammi di Classi e Sequenza**](#51---diagrammi-di-classi-e-sequenza)
  - [**5.2 - Design Pattern**](#52---design-pattern)
- ### [# 6 - Riepilogo dei Test](#6---riepilogo-dei-test)
    - [**6.1 - Strumenti di analisi/testing del codice utilizzati**](#61-strumenti-di-analisitesting-del-codice-utilizzati)
    - [**6.2 - Presentazione esiti dei test e considerazioni**](#62-presentazione-esiti-dei-test-e-considerazioni)
    - [**6.3 - Descrizione dei test effettuati**](#63-descrizione-dei-test-effettuati)
- ### [# 7 - Manuale Utente](#7---manuale-utente)
  - [**7.1 - Procedura Preliminare**](#71---procedura-preliminare)

    <ul>
    <li><h4><a href="#github"> 7.1.1 - Creazione Token Github </a></h4></li>

    <li><h4><a href="#docker"> 7.1.2 - Autenticazione Docker </a></h4></li>
    </ul>

  - [**7.2 - Regole di Gioco**](#72---regole-di-gioco)
    - [**7.2.1 - Varianti**](#721---varianti)
  - [**7.3 - Guida All'Utilizzo**](#73---guida-allutilizzo)
- ### [# 8 - Processo di sviluppo e organizzazione del lavoro](#8---processo-di-sviluppo-e-organizzazione-del-lavoro)
  - [**8.1 - Introduzione al processo di sviluppo**](#81---introduzione-al-processo-di-sviluppo)
  - [**8.2 - Roadmap degli sprint**](#82---roadmap-degli-sprint)
  - [**8.3 - Gestione degli Sprint**](#83---gestione-degli-sprint)
  - [**8.4 - Software utilizzati**](#84---software-utilizzati)
  - [**8.5 - Comunicazione interna al team**](#85---comunicazione-interna-al-team)
- ### [# 9 - Analisi Retrospettiva](#9---analisi-retrospettiva)
  - [**9.1 - Sprint 0**](#91---sprint-0)
  - [**9.2 - Sprint 1**](#92---sprint-1)

# 1 - Introduzione

## Partecipanti al progetto

Il team di sviluppatori è composto da:
+ **Michele Pontrelli ([MikiMik88](https://github.com/MikiMik88))**
+ **Francesco Sgaramella ([FraSga03](https://github.com/FraSga03))**
+ **Andrea Porcelli ([f1r3k3rn](https://github.com/f1r3k3rn))**
+ **Nicolo' Pacucci ([Pascoooo](https://github.com/Pascoooo))**
+ **Fabio Zippo ([IXRyu](https://github.com/IXRyu))**
## Descrizione progetto

Di seguito viene riportata la documentazione riguardante il progetto di "Ingegneria del Software" anno 2023/24 che implementa il gioco **Ataxx**.

Il progetto consiste nella realizzazione del videogioco di strategia per cabinati  **Ataxx** interfacciabile attraverso linea di comando.

<p align="center "><img src="img/ataxx_game.jpeg" alt="drawing" width="450"  /></p>

L'implementazione offre solo la possibilità di effettuare una partita, assieme ad un altro giocatore, in multiplayer.

All'avvio, il gioco partirà impostato sulla variante _Default_ e su una griglia 7x7, tuttavia il giocatore avrà la possibilità di selezionare la variante che vuole giocare fra le seguenti:

- **Default**
- **Variante a Perdere**: Vince il giocatore che ha meno pedine del proprio colore
- **Thomas**: Movimento ortogonale
- **Assimilation/Infection**: Movimento ortognale e diagonale(non prevede movimenti a L)

Ogni variante diversa dalla _Default_  cambia le regole o impone limitazioni sullo spostamento delle pedine.

Il giocatore può modificare la dimensione della griglia partendo da una 4x4, con la possibilità di scegliere anche di rendere inaccessibili determinate caselle.

#### [Ritorna all'Indice](#indice)

# 2 - Modello di Dominio
- Il seguente diagramma rappresenta il modello di dominio dell'applicazione Ataxx, realizzata utilizzando il web software [Lucidchart](https://www.lucidchart.com/)
  ![img_Modello_di_dominio](../drawings/Modello_di_dominio.png)

#### [Ritorna all'Indice](#indice)

# 3 - Requisiti Specifici
Di seguito vengono riportati i requisiti funzionali e non funzionali del progetto con stile di descrizione di tipo user story.
## 3.1 - Requisiti Sprint 1:
**Obiettivo: piccoli comandi**
### 3.1.1 - Funzionali

- **[RF1](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/19): Come giocatore voglio mostrare l'help con elenco comandi**

  #### Criteri di accettazione

  Al comando `/help` o invocando l'app con flag `--help` o `-h` il risultato è una descrizione concisa, che normalmente appare all'avvio del programma, seguita dalla lista di comandi disponibili, uno per riga, come da esempio successivo:
  - gioca
  - esci
  - ...
    <br></br>
- **[RF2](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/25): Come giocatore voglio iniziare una nuova partita**

  #### Criteri di accettazione

  Al comando `/gioca` se nessuna partita è in corso l'app mostra il tavoliere con le pedine in posizione iniziale e si predispone a ricevere la prima mossa di gioco dal giocatore con le pedine nere o altri comandi.
  <br></br>
- **[RF3](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/20): Come giocatore voglio mostrare il tavoliere vuoto con la numerazione**

  #### Criteri di accettazione
  Al comando `/vuoto` l'app mostra il tavoliere vuoto di 49 caselle quadrate (_7 per lato_) con le righe numerate da 1 a 7 e le colonne numerate da ‘A’ a ‘G’.
  <br></br>
- **[RF4](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/21): Come giocatore voglio mostrare il tavoliere con le pedine e la numerazione**

  #### Criteri di accettazione
  Al comando `/tavoliere`:
  - se il gioco non è iniziato l'app suggerisce il comando `/gioca`;
  - se il gioco è iniziato l'app mostra la posizione di tutte   
    le pedine sul tavoliere. Le pedine sono mostrate in formato Unicode https://en.wikipedia.org/wiki/English_draughts#Unicode.
    <br></br>
- **[RF5](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/22): Come giocatore voglio visualizzare le mosse possibili di una pedina**

  #### Criteri di accettazione
  Al comando `/qualimosse`:
  - se il gioco non è iniziato l'app suggerisce il comando gioca;
  - se il gioco è iniziato l'app mostra quali mosse sono disponibili per il giocatore di turno, evidenziando:
    - in giallo le caselle raggiungibili con mosse che
      generano una nuova pedina;
    - in arancione le caselle raggiungibili con mosse che consentono un salto;
    - in rosa le caselle raggiungibili con mosse di entrambi i tipi precedenti.
      <br></br>
- **[RF6](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/23): Come giocatore voglio abbandonare la partita**

  #### Criteri di accettazione
  Al comando `/abbandona` l'applicazione chiede conferma dell'azione:
  - se la conferma è positiva, l'app comunica che il Bianco (_o Nero_) ha vinto per abbandono e dichiara come vincitore l’avversario per x a 0 dove x è il numero di pedine rimaste dell’avversario;
  - se la conferma è negativa, l'app si predispone a ricevere nuovi tentativi o comandi.
    <br></br>
- **[RF7](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/24): Come giocatore voglio chiudere il gioco**

  #### Criteri di accettazione
  Al comando `/esci` l'applicazione chiede conferma:
  - se la conferma è positiva, l'app si chiude restituendo il controllo al sistema operativo;
  - se la conferma è negativa, l'app si predispone a ricevere nuovi tentativi o comandi.

### 3.1.2 - Non Funzionali
- **RNF1**: Il container docker dell'app deve essere eseguito da terminali che supportano Unicode con encoding UTF-8 o UTF-16. A seguito un elenco di terminali adeguati divisi per sistema operativo:
  - **Linux:** terminal;
  - **Windows:** Powershell, Git Bash;
  - **MacOS:** terminal (_a seguito della modifica delle impostazioni di encoding_).

## 3.2 - Requisiti Funzionali Sprint 2
**Obiettivo: completare il gioco assicurando la qualità del software**
- **[RF8](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/62): Come giocatore voglio giocare una nuova pedina in una casella adiacente a una propria pedina**

  #### Criteri di accettazione
  A partita in corso di gioco, l'applicazione deve accettare che il giocatore di turno giochi sul tavoliere una nuova pedina (_bianca o nera_) in una casella adiacente (_in senso ortogonale e diagonale_) ad un'altra in cui vi sia già una propria pedina, utilizzando una notazione algebrica del tipo: `a1-a2`, dove `a1` è la casella di partenza e `a2` è la casella adiacente.
  <br></br>
- **[RF9](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/63): Come giocatore voglio spostare una propria pedina saltando una casella adiacente**

  #### Criteri di accettazione
  A partita in corso di gioco, l'applicazione deve accettare che il giocatore di turno sposti sul tavoliere una propria pedina (_bianca o nera_) con il salto di una casella adiacente, utilizzando una notazione algebrica del tipo: `a1-a3`, dove `a1` è la casella di partenza e `a3` è la casella di arrivo.
  La casella di arrivo deve essere libera e non deve essere adiacente alla casella originaria.
  La casella saltata può anche essere occupata da una propria pedina o da una pedina avversaria.
  <br></br>
- **[RF10](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/64): Come giocatore voglio catturare una pedina avversaria come effetto di una mossa**

  #### Criteri di accettazione
  Se al termine di una mossa vi sono pedine avversarie adiacenti alla casella di arrivo, sia per la mossa di espansione che di spostamento, queste vengono catturate cambiando di colore.
  <br></br>
- **[RF11](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/59): Come giocatore voglio mostrare le mosse giocate**

  #### Criteri di accettazione
  Al comando `/mosse`, l'app mostra la storia delle mosse con notazione algebrica.
  Per esempio:
  - 1 a1-a2 (N);
  - 2 g7-g6 (B);
    <br></br>
- **[RF12](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/65): Come giocatore voglio passare il turno per impossibilità di movimento**

  #### Criteri di accettazione
  Se il giocatore non può muovere nessuna pedina del proprio colore, l’app avvisa che il turno passa all’altro colore.
  <br></br>
- **[RF13](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/66): Come giocatore voglio visualizzare il fine partita con il vincitore e i punti segnati**

  #### Criteri di accettazione
  Se nessuna pedina può essere mossa perché le caselle del tavoliere sono state tutte riempite, allora l’app dichiara il vincitore (_bianco o nero_) e riporta i punti del bianco e bero contando le rispettive pedine.
  <br></br>
  L'app si predispone a ricevere nuovi comandi.
  <br></br>
- **[RF14](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/60): Come giocatore voglio mostrare il tempo di gioco**

  #### Criteri di accettazione

  Al comando `/tempo`, l'app mostra il tempo trascorso dall’inizio partita nel formato `ore:minuti:secondi`.
  <br></br>
  L'app si predispone a ricevere nuovi comandi
  <br></br>
- **[RF15](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/61): Come giocatore voglio impostare caselle non accessibili**

  #### Criteri di accettazione
  A partita non in corso, al comando `/blocca xn`, dove `xn` sono le coordinate di una casella,
  la casella `xn` non è accessibile per le pedine ed è mostrata sul tavoliere con uno sfondo grigio.
  <br></br>
  **Non è possibile bloccare:**

  - Le caselle di partenza del gioco;
  - Tutte le caselle adiacenti a una casella di partenza del gioco, rendendo impossibile la mossa di espansione di una pedina a inizio gioco
  - Tutte le caselle a distanza 2 da una casella di partenza del gioco, rendendo impossibile la mossa di salto di una pedina a inizio gioco
    <br>
  - Inoltre non è possibile bloccare più di 9 caselle oppure bloccare completamente i movimenti di una pedina.
#### [Ritorna all'Indice](#indice)

# 4 - System Design

## 4.1 - Diagramma dei Pacchetti
Il seguente diagramma rappresenta la struttura dei pacchetti utilizzati per implementare il progetto, realizzato utilizzando il software [StarUML](https://staruml.io/)
<p align="center"><img src="../drawings/System_Design.png" alt="System_Design" width="95%"/></p>

## 4.2 Architettura dell'Applicazione

Il progetto è stato suddiviso in modo da renderlo il più modulare e scalabile possibile, per raggiungere questo obiettivo
è stato utilizzato il pattern architetturale dell'**Entity Control Boundary**
(ECB) che prevede la classificazione delle classi in tre categorie:
- **ENTITY:** Classi che rappresentano le entità del dominio del problema. In particolare si occupano di rappresentare le entità del gioco e di gestire le loro interazioni.
- **CONTROL:** Classi che si occupano della logica del software. In particolare si occupano di gestire le interazioni tra le entità e di indirizzare l'input delle boundary.
- **BOUNDARY:** Classi che si occupano di interfacciarsi con l'utente e di gestire le logiche di presentazione.
  In particolare si occupano di ricevere i comandi dell'utente e di mostrare i risultati delle operazioni.

I package del progetto finale sono i seguenti:

- Il package ***it.uniba.app*** contiene la classe *App* che si occupa dell'inizializzazione e avvio del software, come definito dal *workflow* utilizzato.


- Il package ***Thompson.game*** contiene tutti i package e le classi create dal team di sviluppo:
  - **boundary**
  - **control**
  - **entity**
  - **error:** Per la corretta gestione di eccezioni ed errori
  - **util:** Per la gestione delle costanti di utilità


- Il package **boundary** contiene:

  - **CommunicateErrorB:** Classe che emette i messaggi di errori
  - **CommunicateInteractionMessageB:** Classe che emette i messaggi di interazione con l'utente
  - **HelpB:** Classe che emette il messaggio generato dal comando `/help`
  - **PrintBoardB:** Classe che si occupa di stampare il tavoliere nelle varie versioni in base al momento di gioco
  - **UserInputB:** Classe che si occupa di gestire l'interazione dell'utente
  - **WelcomeBannerB:** Classe che fa visualizzare il banner di benvenuto


- Package **control:** contiene:

  - **MainControl:** Classe che fa da entry point per `app` e si occupa di gestire il flusso principale
  - **CommandC:** Classe astratta che rappresenta un comando generico
  - **AvailableMovesCommandC:** Classe che si occupa di gestire il comando `/qualimosse`
  - **BlockCommandC:** Classe che si occupa di gestire il comando `/blocca`
  - **BoardCommandC:** Classe che si occupa di gestire il comando `/tavoliere`
  - **ExitCommandC:** Classe che si occupa di gestire il comando `/esci`
  - **HelpCommandC:** Classe che si occupa di gestire il comando `/help`
  - **MovesCommandC:** Classe che si occupa di gestire il comando `/mosse`
  - **PlayCommandC:** Classe che si occupa di gestire il comando `/gioca`
  - **QuitCommandC:** Classe che si occupa di gestire il comando `/abbandona`
  - **TimeCommandC:** Classe che si occupa di gestire il comando `/tempo`
  - **VerifyMovesC:** Classe che si occupa di verificare che un determinato movimento sia lecito
  - **VerifyCommandC:** Classe che si occupa di verificare che un determinato comando sia lecito


Questo package contiene dunque tutte le classi di tipo **Control** previste dallo standard ECB, per questo presentano il suffisso **C**.

- Package **entity**:

  - **BoardE:** Classe che rappresenta il tavoliere di gioco
  - **MatchE:** Classe che rappresenta la partita
  - **MoveE:** Classe che rappresenta la singola mossa
  - **PawnE:** Classe che rappresenta la pedina
  - **PlayerE:** Classe che rappresenta il giocatore
  - **TileE:** Classe che rappresenta la casella del tavoliere

Questo package contiene dunque tutte le classi di tipo **Entity** previste dallo standard ECB, per questo presentano il suffisso **E**.

- Package ***error*** contiene:

  - **CommandNotFound:** Classe che rappresenta l'eccezione lanciata quando il comando non è valido
  - **ExcessBlockedTile:** Classe che rappresenta l'eccezione lanciata quando si tenta di bloccare più di 9 caselle
  - **InvalidArguments:** Classe che rappresenta l'eccezione lanciata quando gli argomenti passati al comando non sono validi
  - **InvalidMove:** Classe che rappresenta l'eccezione lanciata quando il movimento non è valido
  - **MatchNull:** Classe che rappresenta l'eccezione lanciata quando si prova a fare un comando
    legato al gioco senza una partita in corso
  - **TileAlreadyBlocked:** Classe che rappresenta l'eccezione lanciata quando si tenta di bloccare una casella già bloccata
  - **PawnBlocked:** Classe che rappresenta l'eccezione lanciata quando si tenta di bloccare una casella che impedirebbe il movimento di una pedina
  - **NegativeTime:** Classe che rappresenta l'eccezione lanciata quando il tempo passato al metodo format-millis è negativo(si tratta di casi forzati)
  - **TileIsOccupied:** Classe che rappresenta l'eccezione lanciata quando si tenta di bloccare una casella occupata da una pedina

Questo package contiene dunque tutte le classi che servono a gestire le eccezioni ed errori.


- Package ***util*** contiene:

  - **Color:** Classe che rappresenta i colori delle pedine
  - **CommandStatus:** Classe che rappresenta lo stato dei comandi
  - **Coordinate:** Classe che rappresenta le coordinate di una casella
  - **ErrorMessage:** Classe che contiene i messaggi di errore
  - **GameType:** Classe che rappresenta le varianti di gioco
  - **MoveType:** Classe che rappresenta i tipi di movimento
  - **PawnFigure:** Classe che rappresenta le pedine dei due giocatori
  - **Style:** Classe che rappresenta i font di stampa di messaggi
  - **UnicodeColor:** Classe che associa l'enumerativo dei colori al codice unicode utilizzato per rappresentarli
  - **UnicodePawn:** Classe che associa l'enumerativo delle pedine al codice unicode utilizzato per rappresentarle
  - **UnicodeStyle:** Classe che associa l'enumerativo deli font al codice unicode utilizzato per rappresentarli
  - **UserInteractionMessage:** Classe che contiene i messaggi di interazione con l'utente
  - **VariantMove:** Classe che rappresenta i tipi di movimento disponibili per le varianti di gioco



Questo package contiene tutte le classi contenenti le costanti di utilità, suddivise per categorie.

## 4.3 Commenti sulle decisioni

Il team di sviluppo ha deciso di utilizzare il pattern architetturale ECB per la sua efficienza nonostante la sua semplicità.

In particolare, il pattern ECB è stato scelto per la sua capacità di separare le classi in base alle loro
responsabilità, prendendoci però la libertà di aggiungere due categorie per facilitare la gestione di oggetti
esterni alla rappresentazione principale del funzionamento dell'applicazione quali **util** e **error**.

Inoltre rende possibile rispettare gli **OO Design**, e rende il codice scalabile, manutenibile e modulare in caso di futuri sviluppi.

#### [Ritorna all'Indice](#indice)

# 5 - Object Oriented Design

## 5.1 - Diagrammi di Classi e Sequenza

In questo paragrafo vengono riportati i diagrammi UML delle classi e di sequenza relativi alle ***User Story*** più significative
### NOTA IMPORTANTE: 
Ciò che viene rappresentato nei seguenti diagrammi non è la mappatura 1:1 delle classi nel codice, infatti le classi
potrebbero risultare incoerenti le loro versioni in diagrammi diversi, questo perché in ogni diagramma vengono riportati
gli attributi e metodi rilevanti al fine della user story protagonista del diagramma, per rendere il tutto il più
leggibile e comprensibile possibile.
- **[RF2](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/25):** Come giocatore voglio iniziare una nuova partita
  - **Diagramma delle Classi**
  <p align="center"><img src="../drawings/Play_Class_Design.png" alt="" width="95%"/></p>
  <br></br>

  - **Diagramma di Sequenza**
  <p align="center"><img src="../drawings/PlayCommand_Sequence_Design.png" alt="" width="95%"/></p>
    <br></br>

- **[RF5](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/22):** Come giocatore voglio visualizzare le mosse possibili di una pedina
  - **Diagramma delle Classi**
  <p align="center"><img src="../drawings/AvailableMoves_Class_Design.png" alt="" width="95%"/></p>
    <br></br>

  - **Diagramma di Sequenza**
  <p align="center"><img src="../drawings/AvailableMovesCommand_Sequence_Design.png" alt="" width="95%"/></p>
  <br></br>

- **[RF6](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/23):** Come giocatore voglio abbandonare la partita
  - **Diagramma delle Classi**
  <p align="center"><img src="../drawings/QuitCommand_Class_Design.png" alt="" width="95%"/></p>
  <br></br>
  
  - **Diagramma di Sequenza**
  <p align="center"><img src="../drawings/QuitCommand_Sequence_Design.png" alt="" width="95%"/></p>
  <br></br>

- **[RF8](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/62)-[RF9](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/63)-[RF10](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/64)-[RF13](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/66):** 
  - Come giocatore voglio giocare una nuova pedina in una casella adiacente a una propria pedina
  - Come giocatore voglio spostare una propria pedina saltando una casella adiacente
  - Come giocatore voglio catturare una pedina avversaria come effetto di una mossa
  - Come giocatore voglio visualizzare il fine partita con il vincitore e i punti segnati
  <br></br>
  - **Diagramma delle Classi**
  <p align="center"><img src="../drawings/Actions_Class_Design.png" alt="" width="95%"/></p>
  <br></br>

    - **Diagramma di Sequenza**
    <p align="center"><img src="../drawings/Actions_Sequence_Design.png" alt="" width="95%"/></p>
        <br></br>
  
- **[RF15](https://github.com/softeng2324-inf-uniba/progetto-thompson/issues/61):** Come giocatore voglio impostare caselle non accessibili
  - **Diagramma delle Classi**
  <p align="center"><img src="../drawings/BlockCommand_Class_Design.png" alt="" width="95%"/></p>
  <br></br>
  
  - **Diagramma di Sequenza**
  <p align="center"><img src="../drawings/BlockCommand_Sequence_Design.png" alt="" width="95%"/></p>
  <br></br>

### Spiegazione Scelta RF8-9-10-13
Abbiamo ritenuto consono inglobare le user story legate alla generazione, spostamento, attacco e fine partita in un unico
diagramma poiché il flusso del programma è esattamente lo stesso, con piccole differenze sulle diramazioni 
nelle condizioni che portano ad azioni diverse. Abbiamo pensato appropriato quindi, rappresentarle
tutte poiché centrali nell'applicazione, ma allo stesso tempo preservare la chiarezza del paragrafo
evitando ripetizioni che potrebbero risultare confusionarie per il lettore.

#### [Ritorna all'Indice](#indice)


## 5.2 - Design Pattern
Tutte le classi ***Control*** che gestiscono i comandi dell'applicazione sono state implementate utilizzando il design pattern [**Singleton**](https://refactoring.guru/design-patterns/singleton),
un pattern della categoria dei ***Creational design pattern*** che assicura che una classe abbia una sola istanza, mettendo a disposizione un punto globale di accesso a tale istanza della classe.

Inoltre, le classi ***Control*** sono state modellate secondo il design pattern [**Command**](https://refactoring.guru/design-patterns/command),
che sposa il ***principio di presentazione separata*** e permette di demandare la gestione e l'esecuzione dei comandi a una classe apposita
che si occupa di invocare il metodo corretto della classe destinataria del comando. Questo design pattern permette di rendere il codice
più flessibile e manutenibile, in quanto è possibile aggiungere nuovi comandi senza dover modificare il codice già esistente, ma soltanto
creando una nuova classe che estende la classe astratta ***Command***, implementando il metodo ***executeCommand()***.

Di seguito viene riportato un diagramma che spiega nel dettaglio come i design pattern sopra citati sono stati implementati nel progetto,
riportando l'esempio di un singolo comando per comodità di rappresentazione:


<p align="center"><img src="../drawings/Design_Pattern.png" alt="" width="95%"/></p>
  <br></br>


## 5.3 Principi di OO Design

Data la realizzazione del progetto in Java, un linguaggio inerentemente ***Object-Oriented***, l'architettura dell'applicazione doveva attenersi ai seguenti principi:

- **Information Hiding**

  Gli attributi di tutte le classi sono privati e sono stati messi a disposizione dei getters/setters per potervi accedere in maniera controllata e corretta.
  Laddove un metodo utilizzasse un altro metodo di servizio, questo è stato reso privato.


- **Alta coesione**

  Le classi hanno una ben definita responsabilità, grazie alla tassonomia ECB e ai design pattern utilizzati


- **Basso accoppiamento**

  Poichè il progetto rispetta il principio dell'*information hiding*, non ci sono forti dipendenze tra componenti,
  questo permette di non propagare i cambiamenti.


- **Presentazione separata**

  Dato l'utilizzo della tassonomia ECB, le classi *Boundary* si occupano esclusivamente della logica di presentazione
  e di interfacciarsi con l'utente, mentre le classi *Control* implementano la logica di dominio

### Principi SOLID

I principi **SOLID** sono intesi come linee guida per lo sviluppo di software leggibile, estendibile e manutenibile:

- **Single Responsibility**: ogni classe ha una sola responsabilità
- **Open-Closed**: le classi sono aperte all'estensione e chiuse alle modifiche mediante i modificatori di accesso giusti
  e alla modularità fornita dall'architettura
- **Liskov Substitution**: le classi che implementano dei comandi sono le uniche che estendono un'altra classe, e vengono utilizzate al posto del padre correttamente, essendo vitali per il funzionamento dell'intera applicazione
- **Interface Segregation**: non sono state utilizzate interfacce
- **Dependency Inversion**: le classi che implementano dei comandi dipendono esclusivamente dalla classe astratta ***Command***


#### [Ritorna all'Indice](#indice)


# 6 - Riepilogo dei Test


## 6.1 Strumenti di analisi/testing del codice utilizzati


- [JUnit 5](https://junit.org/junit5/)


- [Checkstyle](https://checkstyle.sourceforge.io/)


- [Spotbugs](https://spotbugs.github.io/)


- [PMD](https://pmd.github.io/)


## 6.2 Presentazione esiti dei test e considerazioni

Nello Sprint 2, il gruppo "Thompson" si è adoperato per effettuare l'attività di Verification&Validation (V&V) che si
suddivide in un processo statico (finalizzato all'analisi del codice con Checkstyle, Spotbugs e PMD) e un processo
dinamico (finalizzato alla creazione di casi di test con JUnit 5 e verifica del funzionamento dei metodi).

Di seguito vengono presentati gli esiti delle fasi di test.

Sono stati implementati un totale di **108** casi di test per verificare il corretto funzionamento dei metodi delle classi del package **control** , **entity** e **util**.

Le classi testate sono le seguenti:

![Casi di test](img/RiepilogoDeiTest.png)

- **Esito CheckStyle: Generale**

![CheckStyle main](img/CheckStyle.png)


- **Esito SpotBugs: Main**

![SpotBugs main](img/SpostBugs_Main.png)

- **Esito SpotBugs: Test**

![SpotBugs test](img/SpotBugs_Tests.png)

- **Esito PMD: Main**

![PMD Main](img/PMD_Main.png)

- **Esito PMD: Test**

![PMD Test](img/PMD_Test.png)

- **Esito Build (GitHub Actions)**

![Build](img/Gradle_build.png)


## 6.3 Descrizione dei test effettuati


Seguendo l'organizzazione canonica della test suite è stata redatta una classe di test per ogni classe del software a
eccezione delle classi Boundary, in quanto è stato applicato il principio di presentazione separata, e Error, in
quanto non presentano metodi da testare.
Tutte le classi di test sono state raggruppate in un unica directory denominata "test" separata dal resto del codice e la
struttura delle classi in essa contenuta rispecchia la struttura delle classi nella directory principale.
Inoltre tutte le classi di test presentano il suffisso "Test" per facilitare la loro individuazione.

I test sono stati effettuati utilizzando dei criteri **black-box** (o funzionali), ovvero selezionando i casi di test
esclusivamente a partire dalle specifiche e senza conoscere la struttura interna del software.
I criteri adottati sono:

- **Suddivisione in classi di equivalenza**: i casi di test sono stati selezionati in modo da coprire tutti i possibili
  casi d'input, raggruppando i valori in classi di equivalenza.
- **State-based testing**: i casi di test sono stati selezionati in modo da coprire tutti i possibili stati in cui può
  trovarsi il sistema (prima e dopo l'esecuzione del test).


Alcuni test sono stati ripetuti più volte con parametri od oggetti diversi, in modo da coprire tutti i casi possibili.


Come criterio di terminazione del testing è stato adottato il criterio di copertura delle classi di equivalenza, ovvero
si è deciso di terminare il testing quando tutti i casi di test relativi a tutte le classi di equivalenza sono stati
eseguiti.


#### [Ritorna all'Indice](#indice)


# 7 - Manuale Utente

## 7.1 - Procedura Preliminare
Prima di poter avviare il gioco bisogna essere sicuri di trovarsi in un ambiente che permette la
sua esecuzione, per questo lasciamo una guida completa di tutti i passaggi preparatori:

- Come prima cosa bisogna installare l'applicazione [Docker Desktop](https://www.docker.com/products/docker-desktop/) e verificarne la corretta installazione
- Autenticarsi su Docker con github access token tramite CLI come segue:



<img src="img/Github-logo.png" align="left" width="5%"/>
<h2 id="docker"> Creazione Token per il Docker login</h2>

<br clear="left"/>
Verificare di utilizzare uno dei terminali supportati riportati in 


- [Requisiti non funzionali](#312---non-funzionali)

Per ottenere un token per l'accesso alle risorse di GitHub, segui i passaggi descritti di seguito:

1. **Registrazione**: Se non hai già un account, [registrati su GitHub](https://github.com/join) per ottenere un account.

2. **Accesso**: Accedi al tuo account GitHub utilizzando le tue [credenziali di accesso](https://github.com/login).


3. **Generazione del token**: Una volta effettuato l'accesso, vai alle impostazioni del tuo account. Puoi accedervi cliccando sulla tua immagine del profilo e selezionando `Settings`.
   Nella sezione `Developer settings`, seleziona `Personal access tokens` dal menu a sinistra.


4. **Generazione**: Fai clic sul pulsante `Generate new token`


5. **Autorizzazioni**: Seleziona le autorizzazioni necessarie per il token.


6. **Copia il token**: Una volta generato, copia il token. GitHub mostrerà il token solo una volta, quindi assicurati di copiarlo e conservarlo in un luogo sicuro.

A questo punto si è pronti per accedere a Docker tramite Github PAT

<img src="img/Docker-logo.png" align="left" width="10%"/>
<h2 id="docker"> Docker Login con GitHub Access Token</h2>

<br clear="left"/>

1. **Copia del token su un file `.txt`**:

   Copia il token generato in precedenza in un file di testo, ad esempio, `token.txt`


2. **Ottenere il percorso del file**:

   Dopo aver creato il file, copia il percorso completo


3. **Login a GitHub Container Registry (GHCR) tramite Docker**:

   Apri il terminale come amministratore ed esegui il seguente comando, sostituendo `PATH_DEL_TOKEN` con il percorso copiato e `USERNAME` con il tuo nome utente GitHub:

```bash
cat "PATH_DEL_TOKEN/token.txt" | docker login ghcr.io -u "USERNAME" --password-stdin
```
4. **Scaricare l'immagine tramite Docker Pull**:

   Una volta effettuato l'accesso con successo, puoi scaricare l'immagine Docker desiderata con il seguente comando:

```shell
docker pull ghcr.io/softeng2223-inf-uniba/battleship-thompson:latest
```
5. **Esecuzione del container Docker**:
   Una volta eseguito l'accesso e scaricata l'immagine con successo, puoi eseguire l'immagine Docker desiderata con
   il seguente comando:
```shell
docker run --rm -it ghcr.io/softeng2324-inf-uniba/ataxx-thompson:latest
```
Questo comando avvierà il gioco Ataxx


## 7.2 - Regole di Gioco
#### **Regole Base(Default)**
- Il gioco è composto da un tavoliere di 49 caselle quadrat e da 49 pedine bicolori
- Le pedine si posizionano nelle caselle
- Si gioca in due persone
- Inizia il nero ed i giocatori giocano a turno
- Una mossa può essere di due tipi:
  - Il giocatore gioca una nuova pedina sul tavoliere in una casella adiacente a un'altra in cui vi sia già una propria pedina
  - Il giocatore sposta una propria pedina di due caselle, solo se la casella di arrivo è libera e non adiacente alla casella d'origine
- Se al termine della mossa vi sono pedine avversarie adiacenti alla casella di arrivo, queste vengono catturate e devono essere girate
- Non è possibile rinunciare a girare le pedine catturate
- Vince il giocatore che ha più pedine del proprio colore al termine della partita
- Il punteggio di una vittoria è dato dalla differenza delle pedine
- Per trascrivere una partita si utilizzano le lettere per le colonne e i numeri per le righe, indicando le caselle di partenza e di arrivo delle pedine.
## **7.2.1 - Varianti**
- Esistono inoltre varianti che modificano elementi del gioco base, offrendo diverse strategie e novità ai giocatori:
#### **Variante A Perdere**:
- In questa variante, vince il giocatore che al termine della partita ha meno pedine del proprio colore, mantenendo le regole base del gioco.
#### **Variante Thomas (o Nutsy Ataxx)**:
- In questa variante ideata da Louis K. Thomas, il posizionamento di una nuova pedina, il salto e la cattura avvengono solo in senso ortogonale. Le altre regole rimangono le stesse.

- **Variante Assimilation (o Infection)**:
  - In questa variante, gli spostamenti possono essere effettuati solo in maniera ortogonale o diagonale, escludendo i salti a "L".
  - Le regole base del gioco restano invariate.
  -


## 7.3 - Guida All'Utilizzo

- ### All'avvio:
    <details open>Visualizzazione banner di benvenuto 
        <p align="center"><img src="img/Game_Banner.png" alt="Game_Banner"/></p>
      <summary>Visualizza Dettagli</summary>
    </details>

- ### All'avvio con Parametri `-h` o `--help`:
    <details open> Visualizzazione banner con i comandi disponibili.
        <p align="center"><img src="img/Parameterized_Run.png" alt="Parameterized" width="450"/></p>
        <h5>Nell'immagine è riportato anche il caso in cui viene passato un parametro non valido.</h5>
      <summary>Visualizza Dettagli</summary>
    </details>

- ### Al Comando `/help`:
    <details open>Mostra la lista di comandi disponibili.
        <p align="center"><img src="img/Help.png" alt="help"/></p>
      <summary>Visualizza Dettagli</summary>
    </details>

- ### Al Comando `/gioca`:
    <details open>Mostra il tavoliere con le pedine in posizione iniziale
        <p align="center"><img src="img/Gioca_Tavoliere.png" alt="gioca" height="380"/></p>
      <summary>Visualizza Dettagli</summary>
    </details>

- ### Al comando `/vuoto`:
    <details open>Mostra il tavoliere vuoto enumerato. 
        <p align="center"><img src="img/Vuoto.png" alt="vuoto" height="380"/></p>
      <summary>Visualizza Dettagli</summary>
    </details>

- ### Al comando `/tavoliere`:
    <details open>
        <h4>Scenario 1:</h4> Corretta chiama del comando, mostra il tavoliere con pedine ed enumerazione
        <p align="center"><img src="img/Tavoliere_Attuale.png" alt="tavoliereiniziale" height="380"/></p>
    <h4>Scenario 2:</h4>
        Nel caso si provi a mostrare il tavoliere senza una partita avviata, suggerirà il comando <code>/gioca</code>.
        <p align="center"><img src="img/Tavoliere_Error.png" alt="tavoliere"/></p>
    <summary>Visualizza Dettagli</summary>
    </details>

- ### Al comando `/qualimosse`:
    <details open> Mostra le mosse possibili colorando le caselle diversamente in base al tipo di mossa disponibile in essa.
      <h4>Scenario 1:</h4>Il giocatore può effettuare mosse di tipo 1 e 2:
          <p align="center"><img src="img/Tavoliere_QualiMosse.png" alt="qualimosse" height="380"/></p>
      <h4>Scenario 2:</h4>
          Nel caso in cui non ci sia nessuna partita in atto, suggerirà il comando <code>/gioca</code>.
          <p align="center"><img src="img/QualiMosse_Error.png" alt="qualimosse"/></p>
      <summary>Visualizza Dettagli</summary>
    </details>

- ### Al comando `/abbandona`:
    <details open> Chiede conferma per l'abbandono della partita, se confermato dichiara il vincitore per x a 0 dove x è il numero di pedine rimaste dell'avversario.
      <h4>Scenario 1:</h4>
        Esempio di corretta esecuzione del comando:
        <p align="center"><img src="img/Abbandona_Si.png" alt="abbandona"/></p>
      <h4>Scenario 2:</h4>
        Esempio di esecuzione del comando con conferma negativa:
        <p align="center"><img src="img/Abbandona_No.png" alt="abbandona"/></p>
      <h4>Scenario 3:</h4>
        Esempio di esecuzione con partita non in corso:
        <p align="center"><img src="img/Abbandona_Error.png" alt="abbandona"/></p>
      <h4>Scenario 4:</h4> 
        Esempio di errore nell'input del giocatore che abbandona:
        <p align="center"><img src="img/Abbandona_Player_Non_Valido.png" alt="abbandona"/></p>
      <h4>Scenario 5:</h4>
        Esempio di scelta non valida:
        <p align="center"><img src="img/Abbandona_Scelta_Non_Valida.png" alt="abbandona"/></p>
      <summary>Visualizza Dettagli</summary>
    </details>

- ### Al comando `/mosse`:
    <details open>
        Permette di mostrare tutte le mosse eseguite durante il corso di una partita.
        <p align="center">
          <img src="img/move_list.jpeg" alt="lista delle mosse"/>
        </p>
        <summary>Visualizza Dettagli</summary>
    </details>

- ### Al comando `/blocca`:
    <details open>
        Permette di bloccare fino ad un massimo di 9 caselle, non è possibile bloccare ogni mossa possibile di una delle 4 pedine iniziali. 
        <h4>Scenario 1:</h4>
        Esempio di esecuzione corretta del comando:
        <p align="center">
          <img src="img/block.jpeg" alt="blocco di una casella"/>
        </p>
        <h4>Scenario 2:</h4>
        Esempio di esecuzione del comando su caselle non esistenti all'interno del tavoliere:
        <p align="center">
          <img src="img/block_failed.jpeg" alt="blocco di una casella invalida"/>
        </p> 
        <h4>Scenario 3:</h4>
        Esempio di esecuzione del comando quando si prova a bloccare tutte le mosse possibili di una pedina iniziale:
        <p align="center">
          <img src="img/block_adjacent.png" alt="blocco di una casella invalida" width="95%"/>
        </p> 
        <h4>Scenario 4:</h4>
        Esempio di esecuzione del comando dopo aver già bloccato 9 caselle:
        <p align="center">
          <img src="img/block_failed_1.jpeg" height="350" alt="blocco di più di nove caselle"/>
        </p> 
        <summary>Visualizza Dettagli</summary>
    </details>

- ### Al comando `/tempo`:
    <details open>
        Mostra all'utente il tempo di gioco qunado è in corso una partita.
        <h4>Scenario 1:</h4>
            Esempio di esecuzione corretta del comando 
        <p align="center">
          <img src="img/gameTime.jpeg" alt="tempo di gioco"/>
        </p>
        <h4>Scenario 2:</h4>
            Esempio di esecuzione del comando quando non è in corso nessuna partita:
        <p align="center">
          <img src="img/gameTimeError.jpeg" alt="tempo di gioco"/>
        </p>
        <summary>Visualizza Dettagli</summary>
    </details>

- ### Esecuzione di una mossa:
    <details open>
        Una mossa può essere effettuata senza l'utilizzo di un prefisso di un comando attraverso la digitazione della casella di partenza
        dove è situata una pedina di proprietà e la casella di arrivo, il comando sarà ad esempio a1-a2 per spostare la pedina presente in 
        a1 sulla casella a2. Una volta spostata avviene l'eventuale cattura delle pedine circostanti
        <h4>Scenario 1:</h4>
            Spostamento di una pedina
        <p align="center">
          <img src="img/move_example_1.jpeg" alt="esempio di una mossa 1" height="500"/>
        </p>
        <h4>Scenario 2:</h4>
            Spostamento di una pedina seguito da una cattura
        <p align="center">
          <img src="img/move_example_2.jpeg" alt="esempio di una mossa 2" height="500"/>
        </p>
        <h4>Scenario 3:</h4>
            Spostamento di una pedina da una posizione di partenza errata:
        <p align="center">
          <img src="img/move_error_example.png" alt="esempio di una mossa 1" width="70%"/>
        </p>
        <h4>Scenario 4:</h4>
            Spostamento di una pedina su una posizione di arrivo errata o non presente sul tavoliere:
        <p align="center">
          <img src="img/move_error_example1.png" alt="esempio di una mossa 1" width="70%"/>
        </p>
        <h4>Scenario 5:</h4>
            Dopo una mossa di un giocatore, se l'avversario non ha mosse disponibili, viene mostrato il seguente messaggio:
        <p align="center">
          <img src="img/move_switchturn.png" alt="esempio di una mossa 1" width="70%"/>
        <summary>Visualizza Dettagli</summary>
        <h4>Scenario 6:</h4>
        Pareggio di una partita dopo una mossa:
        <p align="center">
          <img src="img/draw.png" alt="esempio di una mossa 1" width="95%"/>
        <summary>Visualizza Dettagli</summary>
        <h4>Scenario 7:</h4>
        Vittoria di una partita dopo una mossa:
        <p align="center">
          <img src="img/win.png" alt="esempio di una mossa 1" width="95%"/>
        <summary>Visualizza Dettagli</summary>
    </details>

- ### Al comando `/esci`:
    <details open>Chiude il gioco e restituisce il controllo al sistema operativo.<p align="center"><img src="img/Esci.png" alt="esci"/></p>
      <h5>In output un messaggio di arrivederci.</h5>
      <summary>Visualizza Dettagli</summary>
    </details>

#### [Ritorna all'Indice](#indice)

# 8 - Processo di Sviluppo e Organizzazione del lavoro
## 8.1 - Introduzione al processo di sviluppo
Durante l'intero periodo di sviluppo del progetto, il gruppo ha adoperato il metodo dello sviluppo software [
***Agile***](https://agilemanifesto.org/iso/it/manifesto.html). Lo sviluppo Agile consiste in una fase iniziale di *analisi
dei requisiti* con progressivi *miglioramenti* e *aggiornamenti* del prodotto software svolti dai membri del team di
sviluppo.

Seguendo i principi cardine dello sviluppo Agile, il team è stato in grado di pianificare e organizzare i task assegnati
in maniera efficiente, con l'obbiettivo di ottenere un prodotto software stabile e robusto.

Il processo di sviluppo è stato strutturato seguendo un approccio [***simil-Scrum***](https://www.scrum.org/). La
metodologia Scrum offre delle iterazioni time-boxed, dette anche **Sprint**. In questo modo si è potuto suddividere
l'intero sviluppo del progetto in 3 Sprint, ciascuno dei quali avente durata di 2 settimane.

Il professore ha interpretato il ruolo di ***Product Owner***. Per ogni Sprint, in aula e via [_Microsoft
Teams_](https://www.microsoft.com/en-us/microsoft-teams/group-chat-software), ci sono stati comunicati i requisiti,
sotto forma di ***Definition of Done*** e ***User Story***. Il team ha provveduto a realizzare una Board per ogni Sprint e dallo
Sprint 1 è stato anche realizzato il Product Backlog, per contenere le User Story degli Sprint successivi.

È stata definita un'organizzazione in stile Kanban per una Board avente 5 sezioni:

- **To Do**: Task da risolvere;
- **In Progress**: Task prese in carico dall'assignee;
- **Review**: Task risolte, in fase di revisione;
- **Ready**: Task risolte e revisionate dai reviewers;
- **Done**: Task risolte, revisionate dai reviewers e approvate dal *Product Owner*.

La Board è stata gestita utilizzando la sezione Project messa a disposizione da Github. Tale organizzazione, per la
gestione dei task, è stata imposta per lo Sprint 0 per mostrare al team un modo per dividere il lavoro e tracciare i
progressi dei vari task.
È stato concesso al team la libertà di autogestirsi, avendo valutato come
ottimale questa struttura, è stato deciso di mantenere lo stesso approccio utilizzato nello Sprint 0.

Per la gestione dello sviluppo dei task è stato utilizzato il [_Github
Flow_](https://docs.github.com/en/get-started/quickstart/github-flow): per ogni issue, identificata progressivamente
con `#n`, è stato creato un branch, identificato come concordato ad inizio progetto `/[feat | fix | ref][nome_issue]/`, da parte del componente a cui è stata assegnata la
issue. Una volta che il componente, ha concluso
il suo lavoro, veniva sottoposto a un minimo di 2 reviewers, attraverso una **Pull Request**, in cui si discutevano
eventuali problemi e/o migliorie per portare a termine la issue, una volta approvata la Pull Request, il suo
branch viene unito al branch principale e, una volta unito, il branch della Pull Request viene cancellato.

A ogni Sprint, svolto all'interno del progetto, è stato dedicato una **Milestone** e un **Project** dove, all'interno
di ogni Project, sono state inserite le issue da svolgere per lo Sprint corrente.
In questo modo, è stato possibile avere un quadro generale dei task dei progressi fatto dal team, tenendo così traccia
di quali erano le issue da iniziare, quali in corso, quali in revisione e quali pronte alla revisione del *Product Owner*.

Ogni qualvolta una issue veniva conclusa, i progressi di completamento della Milestone venivano aggiornati e, il suo
completamento, significava il completamento delle issue assegnate per lo Sprint corrente.


## 8.2 - Roadmap degli sprint

| Sprint No. | Descrizione                                                | Data Inizio | Data Fine  | Durata    | Data Feedback |
|------------|------------------------------------------------------------|-------------|------------|-----------|---------------|
| 0          | Dimostrare familiarità con GitHub e il processo agile      | 31/03/2024  | 12/04/2024 | 13 giorni | 15-19/04/2024 |
| 1          | Piccoli comandi                                            | 06/05/2024  | 21/06/2024 | 15 giorni | 30-31/05/2024 |
| 2          | Completare il gioco, assicurando la qualità del software   | 29/05/2024  | 12/06/2024 | 15 giorni | 13-27/06/2024 | 

## 8.3 - Gestione degli Sprint

Dato l'utilizzo del framework Scrum, gli Sprint si compongono di quattro fasi principali: analisi, progettazione,
implementazione e testing

Il team fin da subito ha deciso di non puntare tutto sulle capacità individuali, ma di lavorare in sinergia, condividendo
le conoscenze e le competenze, per ottenere un prodotto di qualità, per questo motivo, è stato deciso di assegnare
gli issue tutti assieme e di ciclare i ruoli di reviewer e assignee per ogni issue, per evitare creazioni di sottogruppi ed aumentare la sinergia complessiva.

Il team è cosciente che ogni persona ha dei punti forti e dei punti deboli, ma proprio per questo abbiamo deciso nel primo meeting di adottare questo approccio,
per poter migliorare le nostre competenze e conoscenze, e per poter lavorare in un ambiente collaborativo e di crescita continua.

1. ### **Fase di analisi:**

  - Il team si è sempre riunito in un meeting iniziale per discutere e analizzare i requisiti del progetto, in modo da poterli suddividere in issue e assegnarli ai membri del team.

2. ### **Fase di progettazione:**

  - Il team utilizzando il framework Scrum per la gestione degli Sprint, ha potuto dividere il lavoro in maniera equa e trasparente.

3. ### **Fase di implementazione:**

  - Il team lavora in maniera sinergica per risolvere gli issues, condividendo le conoscenze e le competenze, per ottenere un prodotto di qualità.

4. ### **Fase di testing:**

  - Il team svolge un testing per verificare che ad ogni issue risolta, non ci fossero errori e che il codice fosse conforme alle regole di sviluppo imposte dal team.


## Sprint 0

Lo *Sprint Goal* era quello di mostrare familiarità con [_Git_](https://git-scm.com/), [_Github_](https://github.com/) e
il processo Agile.
- Per questo Sprint si sono decise tutte le regole di sviluppo e di condotta da seguire per il progetto, in modo da
  garantire un ambiente di lavoro sano e collaborativo. Abbiamo scelto una durata di circa 30m-1h per il daily scrum,
  in modo da poter discutere i problemi e le soluzioni trovate.


- Nella **fase di analisi** si sono risolti i primi issue, in modo da poter prendere confidenza con il processo di
  sviluppo e con gli strumenti utilizzati.


- In questo Sprint, i task riguardavano per lo più documentazione in modo da permettere ai componenti del team di
  prendere confidenza con gli strumenti e i processi senza aggiungere complicazione dovute all'analisi, alla
  progettazione e alla stesura di codice. Data quindi la natura delle attività, la **fase di progettazione** non è stata
  inclusa.


- Nella **fase di implementazione** si sono risolti gli issue assegnati, in modo da poter prendere confidenza con il
  processo di sviluppo e con gli strumenti utilizzati.


- Nella **fase di testing** si sono verificati che gli issue risolti non presentassero errori e che il codice fosse
  conforme alle regole di sviluppo imposte dal team.

## Sprint 1

Lo *Sprint Goal* era quello di preparare il gioco.
- Questo sprint è stato dedicato alla realizzazione dei primi comandi del gioco, in modo da poter iniziare a sviluppare
  il gioco vero e proprio.


- Nella **fase di analisi** abbiamo deciso di assegnare a ciascuna coppia del team un issue, cercando di calibrare
  chi avesse più esperienza a scrive codice e chi avesse più esperienza a scrivere documentazione, in modo da poter equilibrare le coppie. Ci sono stati però issue che sono state assegnate a singoli membri, poichè
  troppo semplici e quindi non abbiamo avuto bisogno di dividere il lavoro.
  Il team fin da subito ha voluto puntare sulla massima modularità del codice creando un diagramma di classi con prospettiva concettuale ricco di dettagli.
  Le classi sono state divise in package in modo da poter avere una visione più chiara del codice e per poterlo dividere in maniera più efficiente, risutando in un implementazione più pulita e ordinata.


- Nella **fase di progettazione** si sono discusse le soluzioni da adottare per risolvere gli issue assegnati, ogni gruppo da due presentava la propria soluzione e i restanti membri ponevano domande e critiche,
  in modo da poter migliorare la soluzione proposta.


- Nella **fase di implementazione** si sono risolti gli issue assegnati come descritto nella fase di progettazione,
  seguendo le regole di sviluppo imposte dal team.


- Nella **fase di testing** si sono verificati che gli issue risolti non presentassero errori e che il codice fosse
  conforme alle regole di sviluppo imposte dal team.

## Sprint 2

Lo *Sprint Goal* era quello di completare il gioco, assicurando la qualità del software.

- Nella **fase di analisi** abbiamo deciso di assegnare a ciascuna coppia del team un issue come nello sprint precedente,
  In particolare. si è scelto di dedicare del tempo alla **manutenzione evolutiva** del codice scritto,
  così da ridurre il più possibile _codice ridondante_ però grazie alla visione avuta durante lo sprint precedente queste modifiche sono state ridotte al minimo.


- Nella **fase di progettazione** sono stati sviluppati il **diagramma dei package**, relativo al System Design, insieme
  ai **diagrammi delle classi** e i **diagrammi di sequenza** delle user story principali


- Nella **fase di implementazione** si sono risolti gli issue assegnati come descritto nella fase di progettazione,
  seguendo le regole di sviluppo imposte dal team come negli sprint precedenti, Una volta terminate le user story del codice, il team si è dedicato alla successiva fase di
  manutenzione evolutiva, richiedendo attivamente feedback agli altri membri del gruppo di lavoro, sfruttando i canali
  comunicativi interni al gruppo.


- Nella **fase di testing** si sono verificati che gli issue risolti non presentassero errori e che il codice fosse
  conforme alle regole di sviluppo imposte dal team, inoltre si è svolto un testing con [Junit](https://junit.org/junit5/) per verificare che il gioco fosse conforme ai requisiti richiesti.

## 8.4 - Software utilizzati

- **Organizzazione e Review del lavoro**
  - [*Microsoft Teams*](https://www.microsoft.com/en-us/microsoft-teams/group-chat-software), in cui venivano definiti
    i compiti per ogni Sprint;
  - [*Discord*](https://discord.com/), per le riunioni interne al team;
  - [*Whatsapp*](https://www.whatsapp.com/), per organizzare le riunioni sincrone.
- **Ambienti di sviluppo**
  - [*IntelliJ IDEA*](https://www.jetbrains.com/idea/) il team ha concordato di usare un IDE omogeneo per tutti i membri, è stato scelto IntelliJ per la sua versatilità e per la sua facilità d'uso.
    - *Plugin aggiuntivi*
      - [*CheckStyle IDEA*](https://plugins.jetbrains.com/plugin/1065-checkstyle-idea), per controllare eventuali
        problemi di CheckStyle evitando così di eseguire sempre il comando `./gradlew build`;
      - [*Gradle*](https://gradle.org/), utilizzato per l'esecuzione del programma all'interno d'IntelliJ;
      - [*Code With Me*](https://www.jetbrains.com/code-with-me/) è un tool d'IntelliJ che permette di lavorare
        in maniera collaborativa su un progetto, permettendo di
        condividere il proprio IDE con altri utenti, in modo da poter lavorare in maniera sincrona sullo stesso
        progetto.
- **Software per la creazione di diagrammi**
  - [*StarUML*](https://staruml.io/), dato il precedente utilizzo di alcuni membri del team.
## 8.5 - Comunicazione interna al team

*Esempio di comunicazione asincrona tramite gruppo Whatsapp.*
![img.png](img/whatsapp.png)

*In questa foto è possibile vedere come Discord sia stato utile per lo svolgimento del lavoro, grazie all'uso di canali vocali, testuali e la possibilità di condividere il proprio schermo.*
![img.png](img/discord1.png)

*In questa foto è possibile vedere l'uso della chat testuale di Discord, in cui condividere immagini e file, in particolare i due link sono per sfruttare il Code with me di IntelliJ !*
![img.png](img/discord2.png)

#### [Ritorna all'Indice](#indice)

# 9 - Analisi Retrospettiva
- In questa sezione andremo ad analizzare i nostri comportamenti durante lo sviluppo del software
  ed il rispetto delle regole di sviluppo imposte dal team, dal codice di condotta e dal manifesto dello sviluppo agile.
  Si riporteranno i punti forza e debolezza emersi durante lo sviluppo del progetto tramite tabelle ed infine
  verranno suggeriti i miglioramenti proposti per evitare errori simili in futuro.



## 9.1 - Sprint 0

### Analisi retrospettiva effettuata il 20/04/2024

L'analisi retrospettiva è iniziata con la creazione di una lavagna Mad-Glad-Sad per raccogliere le sensazioni e le emozioni del team
dopo  aver chiuso lo Sprint 0.

Di seguito riportiamo la tabella creata:

![img_retrospective](img/retrospettiva_sprint_0.png)

Dalla tabella si evince che:
<ul>
    <li>Il team è contento di:
        <ul>
            <li>Essere riuscito ad organizzarsi al meglio</li>
            <li>Aver diviso equamente il lavoro assegnato</li>
            <li>Aver consegnato in orario il lavoro</li>
            <li>Esser riusciti s coordinarci anche attraverso meeting a distanza</li>
        </ul>
    </li>
    <li>Il team è triste per:
        <ul>
            <li>Non aver creato uno standard per la scrittura degli issue come ad esempio il titolo</li>
            <li>Non aver sempre rispettato lo stile delle commit imposto dal CODE OF CONDUCT</li>
        </ul>
    </li>
    <li>Il team è arrabbiato per:
        <ul>
            <li>Non aver creato review idonee per alcune pull request</li>
        </ul>
    </li>
</ul>

## Miglioramenti proposti

Dopo aver analizzato le problematiche il team ha sancito i seguenti suggerimenti:
- Riguardo alla fretta nelle revisioni, i membri convengono nel porre più attenzione nel controllare il lavoro svolto
- Riguardo al mancato rispetto dello stile dei commit, ognuno si assume la responsabilità di eventuali errori commessi e si impegna a controllare il codice di condotta se incerto
- Riguardo alla scrittura degli issue il team decide di stabilire uno stile per la scrittura degli stessi

## Conclusioni
In generale conveniamo nell'avere una responsabilità individuale oltre a quella di team, ognuno si impegnerà a svolgere correttamente il proprio lavoro evitando errori dovuti a distrazione o fretta.


## 9.2 - Sprint 1

### Analisi retrospettiva effettuata il 30/05/2024

L'analisi retrospettiva è partita discutendo insieme del lavoro svolto nello sprint 1 riflettendo su punti di forza e
debolezza davanti ad una tabella Mad-Sad-Glad

Di seguito riportiamo la tabella creata:

![img_retrospective](img/Retrospettiva_sprint_1.png)

Dalla tabella si evince che:
<ul>
    <li>Il team è contento di:
        <ul>
            <li>Aver mantenuto un alto grado di organizzazione come nel precedente sprint</li>
            <li>Aver minimizzato i conflitti nei merge avendo usato un IDE che permette di programmare in contemporanea sullo stesso file</li>
            <li>Aver risolto le discussioni sulla progettazione concettuale in maniera adulta e arrivando alla miglior soluzione possibile</li>
            <li>Non aver mai fatto pesare gli errori ai membri, aiutandosi quando ce n'è stato bisogno</li>
            <li>Essere rimasti saldi davanti ad un carico di lavoro elevato senza esser presi dal panico</li>
            <li>Essere stati pronti ad apprendere nuove cose di fronte ad argomenti mai affrontati prima</li>
        </ul>
    </li>
    <li>Il team è triste per:
        <ul>
            <li>Aver effettuato pause che hanno ritardato di molto il lavoro e rovinato il flusso</li>
            <li>Non aver avuto un livello di parallelizzazione sufficientemente alto</li>
            <li>Esser stati indecisi di fronte alla realizzazione della user interface in CLI</li>
            <li>Non aver stabilito un orario fisso per i daily scrum, nonostante siano stati eseguiti efficacemente</li>
</ul>
    </li>
    <li>Il team è arrabbiato per:
        <ul>
            <li>La mancata definizione per tempo di uno standard per la stesura della Javadoc, il che ha portato a frequenti modifiche ad essa</li>
            <li>Eccessive revisioni dovute ad incertezze ed ambiguità che sarebbero state risolte se definite una unica volta</li>
            <li>Non aver testato l'eseguibile remoto abbastanza frequentemente, affidandoci troppo all'esecuzione in locale</li>
        </ul>
    </li>
</ul>

## Miglioramenti proposti

Dopo aver analizzato i punti riportati nella tabella, il team ha deciso di:
- Stabilire uno standard per ogni evenienza della Javadoc(effettuato a fine sprint1), che ci si impegna ora a riportare nel code of conduct
- Deciso di programmare i meeting con più anticipo in modo da tener conto di tutte le necessità
- Testare l'eseguibile remoto più spesso, soprattutto dopo modifiche importanti o aggiunta di funzionalità
- Stabilire il contenuto di una revisione ed effettuarlo in maniera efficiente oltre che efficace
- Non interrompere il flusso di lavoro in modo forzato e problematico
- Parallelizzare di più il lavoro, pur continuando a revisionare il lavoro a vicenda

## Conclusioni
Il team conviene nel dire che il lavoro è stato svolto in maniera corretta ma che ci sia sempre un margine di miglioramento,
infatti, per esempio, sicuramente programmando prima dell'esecuzione e parallelizzando di più il lavoro si può svolgere il tutto in maniera molto più efficiente.

#### [Ritorna all'Indice](#indice)