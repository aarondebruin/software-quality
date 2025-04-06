![](./JabberPoint.gif)

## Inhoud

- [Vereisten](#vereisten)
- [Opstarten van de applicatie](#opstarten-van-de-applicatie)
- [Tests uitvoeren](#tests-uitvoeren)

## Vereisten

Zorg dat je de volgende software geïnstalleerd hebt:

- Java 17
- Maven 3.6 of hoger
- Een IDE zoals IntelliJ IDEA (aanbevolen)

## Opstarten van de applicatie

Clone het project:

```bash
git clone git@github.com:aarondebruin/software-quality.git
cd jabberpoint
```
Build en run het project met Maven:
```bash
mvn clean compile exec:java -Dexec.mainClass="com.jabberpoint.JabberPoint"
```

Of run het project via je IDE (bijv. IntelliJ):
1. Open het project.
2. Navigeer naar JabberPoint.java.
3. Klik op "Run".

Tests uitvoeren
Om de unit tests uit te voeren (bijvoorbeeld voor PresentationMemento, SlideMemento, etc.), gebruik je:

```bash
mvn test
```


