import { fetchData } from './api-utils.js';

let users = [];
let currentSort = { key: "", asc: true };


function renderUsers(list) {
    const tbody = document.getElementById("table-body");
    const cards = document.getElementById("card-container");
    tbody.innerHTML = "";
    cards.innerHTML = "";

    list.forEach(user => {
        const statusBadge = `<span class="badge ${user.active ? "bg-success" : "bg-secondary"} toggle-status" data-username="${user.username}" role="button">${user.active ? "Aktiv" : "Inaktiv"}</span>`;
        const adminBadge = `<span class="badge ${user.admin ? "bg-success" : "bg-secondary"} toggle-admin" data-username="${user.username}" role="button">${user.admin ? "Ja" : "Nein"}</span>`;

        // Tabelle
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${user.username}</td>
            <td>${user.firstname}</td>
            <td>${user.surname}</td>
            <td>${user.email}</td>
            <td>${user.zipcode}</td>
            <td class="text-center">${statusBadge}</td>
            <td class="text-center">${adminBadge}</td>
        `;
        tbody.appendChild(row);

        // Card-Ansicht
        const col = document.createElement("div");
        col.className = "col-12 col-sm-6 col-md-4";
        col.innerHTML = `
            <div class="card h-100">
                <div class="card-body p-2">
                    <p class="mb-1">${user.username}</p>
                    <p class="mb-1">${user.firstname} ${user.surname}</p>
                    <p class="mb-1">${user.email}</p>
                    <p class="mb-1">PLZ: ${user.zipcode}</p>
                    <p class="mb-0">
                        ${statusBadge}
                        ${adminBadge}
                    </p>
                </div>
            </div>
        `;
        cards.appendChild(col);
    });

    // EventListener für Badges
    document.querySelectorAll(".toggle-status").forEach(el =>
        el.addEventListener("click", e => {
            const uname = e.target.dataset.username;
            const user = users.find(u => u.username === uname);
            if (user) user.active = !user.active;
            applyFilterAndSort();
        })
    );

    document.querySelectorAll(".toggle-admin").forEach(el =>
        el.addEventListener("click", e => {
            const uname = e.target.dataset.username;
            const user = users.find(u => u.username === uname);
            if (user) user.admin = !user.admin;
            applyFilterAndSort();
        })
    );
}

function sortUsers(users, key, asc) {
    return [...users].sort((a, b) => {
        let va = a[key], vb = b[key];
        if (typeof va === "boolean") {
            va = va ? 1 : 0;
            vb = vb ? 1 : 0;
        }
        if (typeof va === "string") {
            va = va.toLowerCase();
            vb = vb.toLowerCase();
        }
        return (va > vb ? 1 : -1) * (asc ? 1 : -1);
    });
}

function applyFilterAndSort() {
    const filter = document.getElementById("filter-all").value.toLowerCase();
    const filtered = users.filter(u =>
        Object.values(u).some(val =>
            String(val).toLowerCase().includes(filter)
        )
    );
    const sorted = currentSort.key
        ? sortUsers(filtered, currentSort.key, currentSort.asc)
        : filtered;
    renderUsers(sorted);
}

// Events initialisieren
document.getElementById("filter-all").addEventListener("input", applyFilterAndSort);
document.getElementById("sort-dropdown").addEventListener("change", e => {
    currentSort.key = e.target.value;
    currentSort.asc = true;
    applyFilterAndSort();
});

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

// Initialisierung
async function init() {
    users = await fetchData("users");
    applyFilterAndSort();
}

init();
