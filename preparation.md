# JUG Vortrag

Titel: advanced BDD-Tests

Abstract: Hattest du auch schon mal das Problem, dass du dein eigenen komplizierten und unleserlichen Testfälle nicht mehr verstanden hast?
Wir kennen das Problem und zeigen euch mögliche Lösungen.


## Vortragspunkte

1. Einleitung
  - Person
  - Themenüberblick
    - Was sind Tests?
      - BDD
      - Pyramide
2. Frameworks
  - JBehave
    - Sprache
  - Selenium
    - Page Object Pattern
3. Erklärung Beispielanwendung
  - Was kann es?
  - Wie funktioniert es?
  - Live Demo
4. advanced JBehave
  - Problem -> Lösung
  - Exampletable
  - Parametervariants
  - Mock von Dritt-Systemen!!!
    - Mock/Simulator
    - Test-Story als Beispiel (vorher/nachher)

## Vorbereitungen
- Maik: E-Mail an JUG
- Use-Cases, Probleme spezifizieren
- zu testende Applikation implementieren
- Tests implementieren
- Vortrag (PPT)
  - Tallence-CI
- Terence: Fotos von Vortrag + Gebäude (Frank)
- Terence: Code für Vortrag - licence? (Frank)
- Jonas: Das ins Github

## Was wollen wir zeigen?
- Priority
  - Priority von einzelnen Steps
- Exampletable
  - mehr als eine Eingabe
  - Eingaben und Resultate stehen in der Tabelle
- Web-Site
  - 3 Felder mit 1 Button
  - Button --> funktion (Primitives [Addition, String-Concat, String-Reverse])
  - weitere Seite representiert das Ergebnis
- Parametervariants
  - Optionale Parameter
  - Gleiches Beispiel nur mit einem Parameter (research, ob gut representiert)
- Given Stories
  - research
  - andere Stories nutzen für andere Stories
- Composites
  - Matching zu Exampletables
  - Step, Step, Step --> Composite
- Converter
  - JsonMap
  - JsonList
- UserInteraction
  - Cache für Variablen
  - Seitenelemente
- MetaFilter
  - Properties
  - Ausführen von speziellen Tests
- Mock (optional)
  - REST-Service
  - Steps setzen Werte im Mock
  - Anwendung speichert Ergebnis in Mock

## Code-View
- Live Program 
  - first Steps mit autocompletion
  - Vorbereitete Advanced Steps

## Service
- Namenseingabe --> weiter --> Name auf der nächsten Seite
- Eingabe 3 Werte --> Berechnung Summe --> Summe wird angezeigt
