let changeFuncButton = document.querySelector('.register a');
let formTitle = document.querySelector('.login-form__title');
let formSubmit = document.querySelector('.login-form__submit');
let usernameField = document.querySelector('.input-field input[name="username"]');
let passwordField = document.querySelector('.input-field input[name="password"]');
let forgetLink = document.querySelector('.forget');
let isLogin = true;

const registerUrl = '/api/auth/register';

changeFuncButton.addEventListener('click', function(event) {
    event.preventDefault(); 
    if (isLogin) {
        formTitle.textContent = 'Register';
        formSubmit.textContent = 'Register';
        changeFuncButton.textContent = 'Login';
        forgetLink.style.display = 'none'; 
        document.querySelector('.register p').textContent = "Already have an account? ";
        document.querySelector('.register p').appendChild(changeFuncButton);
  
        const confirmPasswordField = document.createElement('div');
        confirmPasswordField.classList.add('input-field');
        confirmPasswordField.innerHTML = `
            <input type="password" name="confirmPassword" required>
            <label>Confirm your password</label>
        `;
        formSubmit.parentNode.insertBefore(confirmPasswordField, formSubmit);

        isLogin = false;
    } else {

        formTitle.textContent = 'Login';
        formSubmit.textContent = 'Log In';
        changeFuncButton.textContent = 'Register';
        forgetLink.style.display = 'block'; 
        document.querySelector('.register p').textContent = "Don't have an account? ";
        document.querySelector('.register p').appendChild(changeFuncButton);
        
        const confirmPasswordField = document.querySelector('input[name="confirmPassword"]');
        if (confirmPasswordField) {
            confirmPasswordField.parentElement.remove();
        }

        isLogin = true;
    }
});

formSubmit.addEventListener('click', function(event) {
    event.preventDefault();
    if (!isLogin) {
        // Lấy dữ liệu từ các trường nhập liệu
        const username = document.forms['login_form']['username'].value;
        const password = document.forms['login_form']['password'].value;
        const confirmPassword = document.forms['login_form']['confirmPassword'] ? document.forms['login_form']['confirmPassword'].value : null;

        // Kiểm tra xem mật khẩu có khớp không
        if (password !== confirmPassword) {
            Toastify({
                text: "Passwords do not match!",
                duration: 3000, 
                close: true, 
                gravity: "top", 
                position: "right", 
                backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)", 
                stopOnFocus: true 
              }).showToast();
            return;
        }

        // Chuẩn bị dữ liệu để gửi
        const registerData = { username, password };

        // Gửi dữ liệu tới backend
        fetch(registerUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(registerData)
        })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                Toastify({
                    text: "Registration failed",
                    duration: 3000, 
                    close: true, 
                    gravity: "top", 
                    position: "right", 
                    backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)", 
                    stopOnFocus: true 
                  }).showToast();
                throw new Error("Registration failed");
            }
        })
        .then(data => {
            Toastify({
                text: "Registration successful!",
                duration: 3000, 
                close: true, 
                gravity: "top", 
                position: "right", 
                backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)", 
                stopOnFocus: true 
              }).showToast();
            formTitle.textContent = 'Login';
            formSubmit.textContent = 'Log In';
            changeFuncButton.textContent = 'Register';
            forgetLink.style.display = 'block';
            document.querySelector('.register p').textContent = "Don't have an account? ";
            document.querySelector('.register p').appendChild(changeFuncButton);

            const confirmPasswordField = document.querySelector('input[name="confirmPassword"]');
            if (confirmPasswordField) {
                confirmPasswordField.parentElement.remove();
            }

            isLogin = true;
        })
        .catch(error => {
            console.error("Lỗi:", error.message);
            Toastify({
                text: "Registration failed: " + error.message,
                duration: 3000, 
                close: true, 
                gravity: "top", 
                position: "right", 
                backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)", 
                stopOnFocus: true 
              }).showToast();
        });
    }
});

function login(event) {
    event.preventDefault(); 

    let username = document.forms['login_form']['username'].value;
    let password = document.forms['login_form']['password'].value;

    const loginUrl = '/api/auth/login';
    const loginData = { username, password };


    fetch(loginUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(loginData)
    })
    .then(response => {
        if (response.status === 200) {
            return response.json();
        } else {
            Toastify({
                text: "Invalid username or password",
                duration: 3000, 
                close: true, 
                gravity: "top", 
                position: "right", 
                backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)", 
                stopOnFocus: true 
              }).showToast();
              
            throw new Error("Invalid username or password");
        }
    })
    .then(data => {
        Toastify({
            text: "Login successful",
            duration: 3000, 
            close: true, 
            gravity: "top", 
            position: "right", 
            backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)", 
            stopOnFocus: true 
          }).showToast();
        console.log("Login successful:", data);
        
    })
    .catch(error => {
        console.error("Error:", error.message);
        
    });
}


