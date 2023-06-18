// bai 1
function repeat_string(str, n) {
    if (n < 0) {
        console.log("error");
    } else {
        let s = "";
        for (let i = 1; i < n; i++) {
            s = s + str + "-";
        }
        s += str;
        console.log(s);
    }
}

// bai 2
function tinh_tong_so_chia_het_cho_5() {
    let result = 0;
    for (let i = 0; i <= 100; i++) {
        if (i % 5 == 0) {
            result += i;
        }
    }
    return result;
}

// bai 3
function tinh_tong_cac_so_nguyen(a, b) {
    let min = a;
    let max = b;
    if (a > b) {
        min = b;
        max = a;
    }
    let result = 0;
    for (let i = min + 1; i < max; i++) {
        result = result + i;
    }
    return result;
}

// bai 4
function kiem_tra_so_nguyen_to(number) {
    if (n <= 1) {
        return false;
    }
    for (let i = 2; i <= Math.sqrt(n); i++) {
        if (n % i === 0) {
            return false;
        }
    }
    return true;
}

// bai 5
function tinh_tong_so_nguyen_to(number) {
    let sum = 0;
    if (number <= 1) {
        return result;
    }
    for (let i = 2; i <= number; i++) {
        if (kiem_tra_so_nguyen_to(i)) {
            sum += i;
        }
    }
    return sum;
}

// bai 6
function tinh_tong_uoc_so(n) {
    let sum = 0;
    for (let i = 1; i <= n / 2; i++) {
        if (n % i === 0) {
            sum += i;
        }
    }
    sum += n;
    return sum;
}
