// Login Form Validation
document.getElementById('loginForm').addEventListener('submit', function (event) {
  event.preventDefault();
  const email = document.getElementById('email').value;
  const password = document.getElementById('password').value;

  if (email === '' || password === '') {
    alert('Please fill in all fields!');
  } else {
    alert('Login successful! Redirecting to your dashboard...');
    // Implement backend API call for login here
  }
});

// Sign-Up Form Validation
document.getElementById('signupForm').addEventListener('submit', function (event) {
  event.preventDefault();
  const username = document.getElementById('username').value;
  const email = document.getElementById('email').value;
  const password = document.getElementById('password').value;
  const confirmPassword = document.getElementById('confirmPassword').value;

  if (username === '' || email === '' || password === '' || confirmPassword === '') {
    alert('Please fill in all fields!');
    return;
  }

  if (password !== confirmPassword) {
    alert('Passwords do not match!');
    return;
  }

  alert('Sign-Up successful! Redirecting to login...');
  // Implement backend API call for user registration here
});
