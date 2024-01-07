# Jocul Hangman

Jocul "Hangman" este implementat pe platforma web, având un Front-End construit în Angular și un Back-End în Java, oferind o experiență captivantă și interactivă pentru utilizatori. În esență, jocul implică ghicirea unui cuvânt, literă cu literă, într-un număr limitat de încercări, cu fiecare răspuns incorect contribuind la desenarea unui om atârnat (hanged man) pe ecran.

## Caracteristici principale:
### Interfață Utilizator Prietenoasă:
- Front-End-ul Angular oferă o interfață modernă și prietenoasă pentru utilizatori.
- Design responsiv pentru o experiență de utilizare plăcută pe diverse dispozitive.

### Generare Cuvinte Aleatoare:
- Back-End-ul Java generează cuvinte aleatoare pentru ghicit, având diferite nivele de dificultate.

### Joc Interactiv:
- Utilizatorii pot începe un joc nou selectând nivelul de dificultate și începând să ghicească litere.
- Fiecare literă corect ghicită este afișată, în timp ce literele incorecte contribuie la desenarea unui om atârnat.

### Feedback și Stare Joc:
- Utilizatorii primesc feedback instant pentru fiecare ghicire sau greșeală.
- Starea jocului (cuvântul ghicit, încercările rămase) este actualizată în timp real.

### Final de Joc:
- Jocul se încheie atunci când utilizatorul ghicește cuvântul sau când numărul de încercări este epuizat.
- Se afișează un rezumat al rezultatului, indicând dacă utilizatorul a câștigat sau pierdut.

### Persistența Datelor:

⦁	Back-End-ul gestionează persistența datelor jocului, permițând reluarea sau încheierea jocurilor începute.
