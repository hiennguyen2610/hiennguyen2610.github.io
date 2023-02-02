// Khai báo tài khoản, mật khẩu với biến ko đổi
const DEFAULT_USERNAME = "admin";
const DEFAULT_PASSWORD = "123456";

function login() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    if (username !== DEFAULT_USERNAME || password !== DEFAULT_PASSWORD) {
        alert("Login failed, please login again! ( id: admin, pass: 123456 )");
        return false;
    } else if(username === DEFAULT_USERNAME && password === DEFAULT_PASSWORD) {
        localStorage.setItem("username", DEFAULT_USERNAME)
        alert("Logged in successfully!");

    }
}

// Kiểm tra tình trạng
function checkAdmin() {
    let username = localStorage.getItem("username")
    if (username !== null) { 
        document.getElementById("user").innerHTML="<p>"+ username +"</p>"
    }
}

function logout() {
    localStorage.clear()
} 


//     data += "<div id='admin'><a href='login.html'><button>Đăng nhập</button></a></div>"
    //     document.getElementById("user").innerHTML = data
    //     return true;
    // } else {
    //     data += "<div id='admin'><p>Tài khoản: " + username + "</p>" +
    //         "<a onclick='logout()' href='pullman.html'>Đăng xuất</a></div>"
    //     document.getElementById("user").innerHTML = data
    //     return false;