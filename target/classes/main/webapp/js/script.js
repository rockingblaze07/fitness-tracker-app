// Login Form Validation
document.getElementById('loginForm').addEventListener('submit', function (event) {
  event.preventDefault();
  const email = document.getElementById('email').value;
  const password = document.getElementById('password').value;

  // Check if fields are empty
  if (email === '' || password === '') {
    alert('Please fill in all fields!');
    return;
  }

  // Validate email format
  const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailPattern.test(email)) {
    alert('Please enter a valid email address!');
    return;
  }

  alert('Login successful! Redirecting to your dashboard...');
  // Implement backend API call for login here
});

// Sign-Up Form Validation
document.getElementById('signupForm').addEventListener('submit', function (event) {
  event.preventDefault();
  const username = document.getElementById('username').value;
  const email = document.getElementById('email').value;
  const password = document.getElementById('password').value;
  const confirmPassword = document.getElementById('confirmPassword').value;

  // Check if any field is empty
  if (username === '' || email === '' || password === '' || confirmPassword === '') {
    alert('Please fill in all fields!');
    return;
  }

  // Validate email format
  const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailPattern.test(email)) {
    alert('Please enter a valid email address!');
    return;
  }

  // Check if passwords match
  if (password !== confirmPassword) {
    alert('Passwords do not match!');
    return;
  }

  alert('Sign-Up successful! Redirecting to login...');
  // Implement backend API call for user registration here
});
