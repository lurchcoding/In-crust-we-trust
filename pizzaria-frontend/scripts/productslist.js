let products = [];
let currentSort = { key: "", asc: true };

// Produkte vom Backend laden
async function loadProducts() {
    try {
        const response = await fetch("http://localhost:8080/products"); // dein Backend-Endpoint
        if (!response.ok) throw new Error("Fehler beim Laden der Produkte: " + response.status);
        products = await response.json();
        applyFilterAndSort();
    } catch (err) {
        console.error(err);
        alert("Konnte Produkte nicht laden.");
    }
}

// Produkte rendern (Tabelle + Cards)
function renderProducts(list) {
    const tbody = document.getElementById("table-body");
    const cards = document.getElementById("card-container");
    tbody.innerHTML = "";
    cards.innerHTML = "";

    list.forEach(p => {
        const statusBadge = `<span class="badge ${p.status ? 'bg-success' : 'bg-secondary'} toggle-status" data-name="${p.name}" role="button">${p.status ? 'aktiv' : 'inaktiv'}</span>`;
        
        // Tabelle
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${p.name}</td>
            <td>${p.kategorie}</td>
            <td>${p.unterkategorie || ''}</td>
            <td>€ ${p.preis.toFixed(2)}</td>
            <td class="text-center">${statusBadge}</td>
        `;
        tbody.appendChild(row);

        // Cards
        const col = document.createElement("div");
        col.className = "col-12 col-sm-6 col-md-4";
        col.innerHTML = `
            <div class="card h-100">
                <div class="card-body p-2">
                    <p class="mb-1">${p.name}</p>
                    <p class="mb-1">${p.kategorie} ${p.unterkategorie || ''}</p>
                    <p class="mb-1">€ ${p.preis.toFixed(2)}</p>
                    <p class="mb-0">${statusBadge}</p>
                </div>
            </div>
        `;
        cards.appendChild(col);
    });
}

// Produkte sortieren
function sortProducts(list, key, asc) {
    return [...list].sort((a, b) => {
        let va = a[key], vb = b[key];
        if (typeof va === "boolean") { va = va ? 1 : 0; vb = vb ? 1 : 0; }
        if (typeof va === "string") { va = va.toLowerCase(); vb = vb.toLowerCase(); }
        return (va > vb ? 1 : -1) * (asc ? 1 : -1);
    });
}

// Filter und Sortierung anwenden
function applyFilterAndSort() {
    const filter = document.getElementById("filter-all").value.toLowerCase();
    const filtered = products.filter(p =>
        Object.values(p).some(val => String(val).toLowerCase().includes(filter))
    );
    const sorted = currentSort.key
        ? sortProducts(filtered, currentSort.key, currentSort.asc)
        : filtered;
    renderProducts(sorted);
}

// Eventlistener für Filter
document.getElementById("filter-all").addEventListener("input", applyFilterAndSort);

// Eventlistener für Dropdown-Sortierung
document.getElementById("sort-dropdown").addEventListener("change", e => {
    currentSort.key = e.target.value;
    currentSort.asc = true;
    applyFilterAndSort();
});

// Eventlistener für Tabellen-Header-Sortierung
document.querySelectorAll("th.sortable").forEach(th => {
    th.addEventListener("click", () => {
        const key = th.dataset.key;
        if (currentSort.key === key) {
            currentSort.asc = !currentSort.asc;
        } else {
            currentSort = { key: key, asc: true };
        }
        applyFilterAndSort();
    });
});

// Status-Toggle
document.addEventListener("click", function(e) {
    if (e.target.classList.contains("toggle-status")) {
        const name = e.target.dataset.name;
        const product = products.find(p => p.name === name);
        if (product) product.status = !product.status;
        applyFilterAndSort();
    }
});

// Initiales Laden der Produkte
loadProducts();
