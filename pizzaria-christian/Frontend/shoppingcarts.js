function updateTotal() {
    let total = 0;
    document.querySelectorAll('.card').forEach(card => {
    const unitPrice = parseFloat(card.querySelector('.item-price').dataset.price);
    const quantity = parseInt(card.querySelector('span').innerText);
    total += unitPrice * quantity;
});
    document.getElementById('totalPrice').innerText = '€ ' + total.toFixed(2).replace('.', ',');
}

    function removeItem(button) {
    const card = button.closest('.card');
    card.remove();
    updateTotal();
}

    function decreaseQty(button) {
    const qtySpan = button.nextElementSibling;
    let qty = parseInt(qtySpan.innerText);
    if (qty > 1) qty--;
    qtySpan.innerText = qty;
    updateTotal();
}

    function increaseQty(button) {
    const qtySpan = button.previousElementSibling;
    let qty = parseInt(qtySpan.innerText);
    qty++;
    qtySpan.innerText = qty;
    updateTotal();
}

    // Initialer Aufruf
    document.addEventListener("DOMContentLoaded", updateTotal);
