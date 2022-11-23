// Khai báo tài khoản, mật khẩu với biến ko đổi
const DEFAULT_USERNAME = "admin";
const DEFAULT_PASSWORD = "123456";

function login() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    if (username !== DEFAULT_USERNAME || password !== DEFAULT_PASSWORD) {
        alert("Login failed, please login again!");
        return false;
    } else if(username === DEFAULT_USERNAME && password === DEFAULT_PASSWORD) {
        alert("Logged in successfully!");
    }
}
