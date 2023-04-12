function funA(a,b) {
    return function funB(c) {
        return a + b + c
    }
}

// Gọi hàm function lần lượt
data = funA(3,4) // => data ở đây là 1 function được trả về từ funcA
console.log(data)
console.log(data(5))

// Gọi nối 2 lần 
console.log(funA(4, 5)(6))