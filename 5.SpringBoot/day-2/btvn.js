// bai 1
// Viết function để kiểm tra 1 giá trị có nằm trong mảng hay không?
// checkElementExist([1,2,3,4,5], 5) => true
// checkElementExist([1,2,3,4,5], 6) => false

function check_element_exist(arr1, value) {
    return arr1.includes(value);
}

// bai 2
// Viết function truyền vào 1 mảng các số, và 1 giá trị bất kỳ. Trả về mảng mới với các giá trị lớn
// hơn giá trị truyền vào
// getElementGreater([1,2,3,4,5], 3) => [4,5]
// getElementGreater([1,2,3,4,5], 5) => []

function get_element_greater(arr2, value) {
    let new_arr2 = [];
    for (i = 0; i < arr2.length; i++) if (arr2[i] > value) new_arr2.push(arr2[i]);
    return new_arr2;
}

// bai 3
// Viết function để tạo mã màu HEX ngẫu nhiên.
// randomHexCode() => #728a98
// randomHexCode() => #a72938

let hex_numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, "A", "B", "C", "D", "E", "F"];
let hex_code = "#";

function random_hex_code(arr3) {
    for (i = 0; i < 6; i++) {
        random = Math.floor(Math.random() * hex_numbers.length);
        hex_code += hex_numbers[random];
    }
    return hex_code;
}
