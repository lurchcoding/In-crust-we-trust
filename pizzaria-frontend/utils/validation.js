'use strict';


function validateStringInput(fieldId, min, max, needsSpecial, needsCapLetter, needsSmallLetter, isEmail) {
    const element = document.getElementById(fieldId);
    const value = element.value.trim();
    let messages = [];

    if (min !== undefined && value.length < min) {
        messages.push(`Mindestens ${min} Zeichen erforderlich.`);
    }

    if (max !== undefined && value.length > max) {
        messages.push(`Maximal ${max} Zeichen erlaubt.`);
    }

    if (needsSpecial) {
        const specialRegex = /[!@#$%^&*(),.?":{}|<>]/;
        if (!specialRegex.test(value)) {
            messages.push("Mindestens ein Sonderzeichen erforderlich.");
        }
    }

    if (needsCapLetter) {
        const capRegex = /[A-Z]/;
        if (!capRegex.test(value)) {
            messages.push("Mindestens ein Großbuchstabe erforderlich.");
        }
    }

    if (needsSmallLetter) {
        const smallRegex = /[a-z]/;
        if (!smallRegex.test(value)) {
            messages.push("Mindestens ein Kleinbuchstabe erforderlich.");
        }
    }
    if (isEmail) {
        const emailRegex = /[@]/;
        if (!emailRegex.test(value)) {
            messages.push("Keine gültige Email-Adresse");
        }
    }

    if (messages.length > 0) {
        showInvalidFeedback(element, messages.join("\n"));
        console.log("Validation false", element , messages)
        return false;
    } else {
        element.classList.remove('is-invalid');
        const feedback = element.parentElement.querySelector('.validation-feedback-ok, .validation-feedback-nok');
        feedback.classList.remove('validation-feedback-nok');
        feedback.classList.add('validation-feedback-ok');
        console.log("Validation true")
        return true;
    }
}


function showInvalidFeedback(field, message) {
    field.classList.add('is-invalid');
    const feedback = field.parentElement.querySelector('.validation-feedback-ok, .validation-feedback-nok');
    console.log ("howInvalidFeedback")
    console.log (feedback)
    console.log (feedback.classList)
    if (feedback &&
        (feedback.classList.contains('validation-feedback-ok')
       || (feedback.classList.contains('validation-feedback-nok'))))
    {
        feedback.textContent = message;
        console.log (feedback)
        console.log (feedback.textContent)
        console.log (feedback.classList)
        if (feedback.classList.contains('validation-feedback-ok')){
            feedback.classList.remove('validation-feedback-ok');
            feedback.classList.add('validation-feedback-nok');
        }
        console.log (feedback.classList)
    }
}

