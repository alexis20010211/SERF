document.getElementById("loginForm").addEventListener("submit", async function(e) {
    e.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const errorMsg = document.getElementById("errorMsg");

    if (username === "admin" && password === "1234") {
        // Simular inicio de sesión correcto
        window.location.href = "dashboard.html";
    } else {
        errorMsg.textContent = "Usuario o contraseña incorrectos.";
    }
});
