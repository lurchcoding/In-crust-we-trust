# 🧪 Git Workflow für "In-crust-we-trust"

## 🧭 Haupt-Branch

- `main` enthält **stabilen, getesteten Code**
- Änderungen dürfen **nur über Pull Requests (PRs)** in `main` gelangen
- Niemand arbeitet direkt auf `main`

---

## 🌱 Branch-Strategie

Jede neue Aufgabe (Feature, Bugfix, Refactoring) bekommt eine eigene Branch:

```bash
git checkout -b <branch-name>

| Zweck         | Prefix      | Beispiel                    |
| ------------- | ----------- | --------------------------- |
| Neue Funktion | `feature/`  | `feature/cart-system`       |
| Bugfix        | `bugfix/`   | `bugfix/login-error`        |
| Refactoring   | `refactor/` | `refactor/header-component` |
| Hotfix        | `hotfix/`   | `hotfix/critical-crash`     |

🔁 Pull Request Workflow (für GitHub)
Branch erstellen

bash
Copy
Edit
git checkout -b feature/mein-feature
Code schreiben, committen

bash
Copy
Edit
git add .
git commit -m "feat: add cart logic"
Branch pushen

bash
Copy
Edit
git push -u origin feature/mein-feature
Pull Request öffnen (auf GitHub)

Ziel-Branch: main

Beschreibung: Was wurde gemacht? Was ist noch offen?

Review & Merge

Mind. 1 Teammitglied reviewed

Bei Freigabe: Merge durch Maintainer oder Autor selbst (wenn erlaubt)

Lokale Branch löschen (optional)

bash
Copy
Edit
git branch -d feature/mein-feature
git push origin --delete feature/mein-feature
✅ Commit-Style (optional, empfohlen)
Verwende prägnante Commit Messages mit Type-Tag:

Tag	Bedeutung	Beispiel
feat	Neues Feature	feat: add payment system
fix	Bugfix	fix: correct login redirect
refactor	Code-Struktur verbessert	refactor: split product service
docs	Dokumentation	docs: update README
style	Formatierung, Linting, etc.	style: format all js files
test	Tests hinzugefügt/geändert	test: add checkout test case

📁 Verzeichnisse & Ignorieren
Stelle sicher, dass .gitignore folgende Dinge enthält:

gitignore
Copy
Edit
# Node
node_modules/
dist/
build/

# IDEs/Editoren
.idea/
.vscode/

# System
.DS_Store
Thumbs.db

# Umgebungsdateien
.env
.env.*.local
*.local

# Logs
*.log

# Test-/Build-Zwischenstände
coverage/
.cache/
👥 Teamregeln
Jeder arbeitet auf einem eigenen Branch

main bleibt stabil & produktionsbereit

Änderungen gehen nur über Pull Requests

Reviews vor dem Merge sind Pflicht

Konflikte müssen vor dem Merge gelöst sein

📚 Nützliches
Beispiel PR-Text:
markdown
Copy
Edit
### 🧩 Feature: Product Carousel

#### ✅ Was wurde gemacht?
- Karussell für Produktdarstellung erstellt
- Responsive angepasst

#### 🔍 To-Do
- [x] Produktdaten dynamisch laden
- [ ] Swipe-Funktion (folgt in PR #12)

#### 📌 Issue: #7
Let’s keep main clean and bugs unseen 🧹🐛🚫

yaml
Copy
Edit

---

Sobald du das gespeichert hast, kannst du es versionieren mit:

```bash
git add GIT_WORKFLOW.md
git commit -m "Add team Git workflow documentation"
git push
