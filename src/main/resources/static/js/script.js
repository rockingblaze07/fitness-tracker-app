// Login Form Validation
document.getElementById('loginForm').addEventListener('submit', function (event) {
  event.preventDefault();
  
  const email = document.getElementById('email').value;
  const password = document.getElementById('password').value;
  
  // Show the loading spinner
  document.getElementById('loading-spinner').style.display = 'block';
  
  // Validate form fields
  if (email === '' || password === '') {
    document.getElementById('error-message').style.display = 'block';
    document.getElementById('error-message').textContent = 'Please fill in all fields!';
    document.getElementById('loading-spinner').style.display = 'none';  // Hide loading spinner
  } else {
    // Simulate a successful login (replace with actual backend API call)
    setTimeout(function () {
      document.getElementById('loading-spinner').style.display = 'none';  // Hide loading spinner
      document.getElementById('success-message').style.display = 'block';  // Show success message
      setTimeout(function () {
        window.location.href = 'dashboard.html';  // Redirect to dashboard
      }, 1500);
    }, 2000);  // Simulating network delay
  }
});

// Sign-Up Form Validation
document.getElementById('signupForm').addEventListener('submit', function (event) {
  event.preventDefault();
  
  const username = document.getElementById('username').value;
  const email = document.getElementById('email').value;
  const password = document.getElementById('password').value;
  const confirmPassword = document.getElementById('confirmPassword').value;
  
  // Show the loading spinner
  document.getElementById('loading-spinner').style.display = 'block';
  
  // Validate form fields
  if (username === '' || email === '' || password === '' || confirmPassword === '') {
    document.getElementById('error-message').style.display = 'block';
    document.getElementById('error-message').textContent = 'Please fill in all fields!';
    document.getElementById('loading-spinner').style.display = 'none';  // Hide loading spinner
    return;
  }
  
  if (password !== confirmPassword) {
    document.getElementById('error-message').style.display = 'block';
    document.getElementById('error-message').textContent = 'Passwords do not match!';
    document.getElementById('loading-spinner').style.display = 'none';  // Hide loading spinner
    return;
  }
  
  // Simulate a successful sign-up (replace with actual backend API call)
  setTimeout(function () {
    document.getElementById('loading-spinner').style.display = 'none';  // Hide loading spinner
    document.getElementById('success-message').style.display = 'block';  // Show success message
    setTimeout(function () {
      window.location.href = 'login.html';  // Redirect to login page
    }, 1500);
  }, 2000);  // Simulating network delay
});
