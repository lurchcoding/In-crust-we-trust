const API_URL = 'http://localhost:8080/products'; // Backend URL anpassen
let products = [];

const productContainer = document.getElementById('productContainer');
const categoryFilter = document.getElementById('categoryFilter');
const subCategoryFilter = document.getElementById('subCategoryFilter');
const sortSelect = document.getElementById('sortSelect');

async function fetchProducts() {
  try {
    const response = await fetch(API_URL);
    products = await response.json();
    populateFilters();
    renderProducts(products);
  } catch (err) {
    console.error('Fehler beim Laden der Produkte:', err);
  }
}

function populateFilters() {
  const categories = Array.from(new Set(products.map(p => p.mainCategory)));
  const subCategories = Array.from(new Set(products.map(p => p.subCategory).filter(Boolean)));

  categories.forEach(cat => {
    const option = document.createElement('option');
    option.value = cat;
    option.textContent = cat;
    categoryFilter.appendChild(option);
  });

  subCategories.forEach(sub => {
    const option = document.createElement('option');
    option.value = sub;
    option.textContent = sub;
    subCategoryFilter.appendChild(option);
  });
}

function renderProducts(list) {
  productContainer.innerHTML = '';
  list.forEach(product => {
    if (!product.active) return; // Nur aktive Produkte

    const card = document.createElement('div');
    card.className = 'product-card';

    const img = document.createElement('img');
    img.src = product.productPicture || 'https://via.placeholder.com/220x150?text=Bild+fehlt';
    card.appendChild(img);

    const name = document.createElement('div');
    name.className = 'product-name';
    name.textContent = product.productName;
    card.appendChild(name);

    const desc = document.createElement('div');
    desc.textContent = product.productDescription;
    card.appendChild(desc);

    const price = document.createElement('div');
    price.className = 'product-price';
    price.textContent = product.price.toFixed(2) + ' €';
    card.appendChild(price);

    if (product.allergens.length) {
      const allergens = document.createElement('div');
      allergens.className = 'allergens';
      allergens.textContent = 'Allergene: ' + product.allergens.map(a => a.abbreviation).join(', ');
      card.appendChild(allergens);
    }

    productContainer.appendChild(card);
  });
}

function filterAndSort() {
  let filtered = [...products];
  
  const selectedCategory = categoryFilter.value;
  const selectedSubCategory = subCategoryFilter.value;
  const sortValue = sortSelect.value;

  if (selectedCategory !== 'ALL') {
    filtered = filtered.filter(p => p.mainCategory === selectedCategory);
  }

  if (selectedSubCategory !== 'ALL') {
    filtered = filtered.filter(p => p.subCategory === selectedSubCategory);
  }

  switch (sortValue) {
    case 'NAME_ASC':
      filtered.sort((a,b) => a.productName.localeCompare(b.productName));
      break;
    case 'NAME_DESC':
      filtered.sort((a,b) => b.productName.localeCompare(a.productName));
      break;
    case 'PRICE_ASC':
      filtered.sort((a,b) => a.price - b.price);
      break;
    case 'PRICE_DESC':
      filtered.sort((a,b) => b.price - a.price);
      break;
  }

  renderProducts(filtered);
}

categoryFilter.addEventListener('change', filterAndSort);
subCategoryFilter.addEventListener('change', filterAndSort);
sortSelect.addEventListener('change', filterAndSort);

fetchProducts();
