# Codice di Condotta

## 1.  Lavoro di Squadra

- È fondamentale la cooperazione del team nella gestione del flusso
- Importante partecipare attivamente alle revisioni
- Migliorare la velocità complessiva del team è più importante di migliorare la propria
- Non fare ritardo ai meeting
- Chiedere aiuto quando necessario
- Essere disponibili ad aiutare quando richiesto
- Essere sempre onesti
- Se si crede che qualcosa sia impossibile, comunicarlo subito

## 2. Revisioni
- Mantenersi professionali ed essere rispettosi nei commenti di revisione
- Accettare i feedback sul proprio lavoro con professionalità
- Almeno due membri diversi dagli implementatori devono revisionare ed approvare il risultato

## 3. Stesura di Codice
- Il codice deve essere espressivo e facilmente comprensibile
- Si utilizzano i commenti solo se il codice non risulta espressivo
- Ci si accorda su una convenzione di stesura, stile e formattazione e la si segue
- Il codice sottoposto deve essere testato dall'implementatore 
- Il codice sottoposto non deve essere soggetto di "warning" dagli strumenti con i quali interagisce

## 4. Stile
### Formato Issues:

`{Sigla}{Numero}: (Titolo)`
> Esempio:
> DOC7: Aggiunta immagine...

###  Formato commit:
`{Prefisso}(Soggetto): {Predicato}` 

> Esempio:
> feat(img): Aggiunta immagine di Thompson


### Formato Branch:
` {Prefisso} / {Predicato}`
- **Prefissi**: 

    **1. feat**: Aggiunta di una funzionalità o di file

    **2. ref**: Refactoring, ovvero modifica di testo o funzionalità

    **3. fix**: Risoluzione di problemi o bug

- **Soggetto**: specifica il file o cartella di lavoro 
- **Predicato**: specifica l'azione commessa con breve descrizione

### Formato Javadoc:
#### Descrizione Classi: 

><< ECB Type >>
> 
> Se classe entity: **Class** representing the "class_name" entity. 
> 
> Se classe Boundary: **Class** to "funzionalità"
> 
> Se classe Control: **Class** to manage "funzionalità"
> 
> **Attributes** of the class "class_name"
> 
> **Constants* of the class "class_name"
> **Constructor** for the class "class_name"
#### Metodi:

> Method "method_name" 
> 
> Se override: Override of the "method_name" of the "class_type" "class_name"
> 
> @param: "param_name" (descrizione) Per ogni parametro
> 
> @return "attribute_name" (descrizione)

#### Enumerativi:

>  Enum representing "soggetto"
> 
> "enum_name" (descrizione)
