$(document).ready(function() {
    // Zeige Detailsfeld, wenn "Divers" ausgewählt wird
    $('#anrede').on('change', function() {
        if ($(this).val() === 'Divers') {
            $('#diversDetailsGroup').slideDown(200);
        } else {
            $('#diversDetailsGroup').slideUp(200);
            $('#diversDetails').val('');
        }
    });

    // Formular absenden
    $('#userForm').on('submit', function(e) {
        e.preventDefault();
        var formData = $(this).serializeArray();
        var jsonData = {};
        $.each(formData, function(_, field) {
            jsonData[field.name] = field.value;
        });
        console.log("Gespeicherte Benutzerdaten:", jsonData);
        $('#successMessage').fadeIn(300).delay(2000).fadeOut(300);
    });
});
