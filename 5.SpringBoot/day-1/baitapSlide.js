// Bai 6.1 

//Lab1
function find_max(a, b) {
    if (a > b) {
        console.log(a);
    } else {
        console.log(b);
    }
}

//Lab2
function kiem_tra_chan_le(n) {
    if (n % 2 === 0) {
        console.log(`${n} là số chẵn`);
    } else {
        console.log(`${n} là số lẻ`);
    }
}

//Lab4
function check_sum(a, b, c) {
    if (c === a + b) {
        console.log(`${c} bằng tổng của ${a} và ${b}`);
    } else {
        console.log(`${c} không bằng tổng của ${a} và ${b}`);
    }
}

// Bai 6.3

//Lab1
let day = 1;
switch (day) {
    case 0:
        console.log("Hôm nay là Chủ nhật");
        break;
    case 1:
        console.log("Hôm nay là Thứ 2");
        break;
    case 2:
        console.log("Hôm nay là Thứ 3");
        break;
    case 3:
        console.log("Hôm nay là Thứ 4");
        break;
    case 4:
        console.log("Hôm nay là Thứ 5");
        break;
    case 5:
        console.log("Hôm nay là Thứ 6");
        break;
    case 6:
        console.log("Hôm nay là Thứ 7");
        break;
    default:
        console.log("ko hop le");
        break;
}
//Lab2
let month = 1;
switch (month) {
    case 1:
    case 2:
    case 3:
        console.log("xuân");
        break;
    case 4:
    case 5:
    case 6:
        console.log("hạ");
        break;
    case 7:
    case 8:
    case 9:
        console.log("thu");
        break;
    case 10:
    case 11:
    case 12:
        console.log("đông");
        break;
    default:
        console.log("ko hop le");
        break;
}


