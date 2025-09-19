// Erfolgsanzeige + Weiterleitung

document.getElementById('registrationForm').addEventListener('submit', function(event) {
    event.preventDefault();
  /*  document.getElementById('successMessage').style.display = 'block';
    setTimeout(function() {
        window.location.href = 'login.html';
    }, 2500);*/
});
/*

// Anzeigen/Verstecken von "Details Divers"
document.getElementById('anrede').addEventListener('change', function() {
    const detailsGroup = document.getElementById('diversDetailsGroup');
    if (this.value === 'Divers') {
        detailsGroup.style.display = 'block';
    } else {
        detailsGroup.style.display = 'none';
        document.getElementById('diversDetails').value = '';
    }
});*/

activateValidation()

function activateValidation() {
    const forms = document.querySelectorAll('.needs-validation');
    Array.from(forms).forEach(form => {
        form.addEventListener('submit', handleFormSubmit);
    });
}

function validateForm(form) {
     const isValid = form.checkValidity();


     validateStringInput('vorname', 3, 30, false, false, false,false);
     validateStringInput('nachname', 2, 100, false, false, false,false);
     validateStringInput('username', 5, 30, false, false, false, false);
     validateStringInput('email', 5, 100, false, false, false, true);
     validateStringInput('telefon', 7, 30, false, false, false, false);
     validateStringInput('passwort', 8, 100, true, true, true, false);
     validateStringInput('passwortWdh', 8, 100, true, true, true, false);

    /*
    isValid = isValid && validateStringInput('vorname', 3, 30, false, false, false,false);
    isValid = isValid && validateStringInput('nachname', 2, 100, false, false, false,false);
    isValid = isValid && validateStringInput('username', 5, 30, false, false, false, false);
    isValid = isValid && validateStringInput('email', 5, 100, false, false, false, true);
    isValid = isValid && validateStringInput('telefon', 7, 30, false, false, false, false);
    isValid = isValid && validateStringInput('passwort', 8, 100, true, true, true, false);
    isValid = isValid && validateStringInput('passwortWdh', 8, 100, true, true, true, false);
*/
    form.classList.add('was-validated');
    return isValid;
}

function handleFormSubmit(event) {
    const form = event.target; // gets the current form
    if (!validateForm(form)) {
        event.preventDefault();
        event.stopPropagation();
        return;
    }
}

