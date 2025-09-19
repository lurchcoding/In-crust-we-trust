$(function() {
      $('#footer').load('../views/footer.html');
    });

const orderItems = [
    { name: 'Product name', quantity: 1, price: 12 },
    { name: 'Second product', quantity: 1, price: 8 },
    { name: 'Third item', quantity: 1, price: 5 }
]

function formatEuro(value) {
    return '€' + value.toFixed(2).replace('.', ',')
}

function renderOrderSummary() {
    const tbody = $('#orderSummary')
    tbody.empty()
    let total = 0
    orderItems.forEach(item => {
        const itemTotal = item.price * item.quantity
        total += itemTotal
        const row = `
      <tr>
        <td>${item.name}</td>
        <td class="text-center">${item.quantity}</td>
        <td class="text-end">${formatEuro(item.price)}</td>
      </tr>
    `
        tbody.append(row)
    })
    const totalRow = `
    <tr>
      <th colspan="2">Gesamt (EURO)</th>
      <th class="text-end">${formatEuro(total)}</th>
    </tr>
  `
    tbody.append(totalRow)
}

$(document).ready(function () {
    renderOrderSummary()

    $('#checkoutSubmitForm').on('submit', function (event) {
        event.preventDefault()
        if ($('#deliveryForm')[0].checkValidity()) {
            alert('Bestellung erfolgreich abgeschickt!')
        } else {
            $('#deliveryForm')[0].classList.add('was-validated')
        }
    })
})
