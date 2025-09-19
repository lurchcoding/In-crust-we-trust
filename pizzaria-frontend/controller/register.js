// Erfolgsanzeige + Weiterleitung
document.getElementById('registrationForm').addEventListener('submit', function(event) {
    event.preventDefault();
    document.getElementById('successMessage').style.display = 'block';
    setTimeout(function() {
        window.location.href = 'login.html';
    }, 2500);
});

// Anzeigen/Verstecken von "Details Divers"
document.getElementById('anrede').addEventListener('change', function() {
    const detailsGroup = document.getElementById('diversDetailsGroup');
    if (this.value === 'Divers') {
        detailsGroup.style.display = 'block';
    } else {
        detailsGroup.style.display = 'none';
        document.getElementById('diversDetails').value = '';
    }
});

$(function() {
      $('#footer').load('../views/footer.html');
    });
