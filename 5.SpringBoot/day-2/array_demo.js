// lab 1
function sum1() {
  let arr = [1, 2, 3, 4, 5, 6];
  let result = 0;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] % 2 !== 0 && arr[i] % 3 === 0) {
      result += arr[i];
    }
  }
  return result;
}
console.log(sum1);

// lab 2
function kiem_tra_so_nguyen_to(n) {
  if (n <= 1) return false;
  for (let i = 2; i <= Math.sqrt(n); i++) if (n % i === 0) return false;
  return true;
}
let arr2 = [2, 3, 4, 5, 6, 12, 17];
function sum2(arr2) {
  let result2 = 0;
  for (let i = 0; i <= arr2.length; i++)
    if (kiem_tra_so_nguyen_to(arr2[i])) result2 += arr2[i];
  return result2;
}
console.log(sum2(arr2));

// lab 3
function lab3(arr2) {
  let new_arr3 = [];
  for (i = 0; i < arr2.length; i++) new_arr3.push(arr2[i] % 2);
  return new_arr3;
}

// lab 4
function check_value(arr2, value) {
  for (let i = 0; i < arr2.length; i++) if (arr2[i] === value) return true;
  return false;
}

// lab 5
function mang_chia_het(arr2) {
  let new_arr5 = [];
  for (i = 0; i < arr2.length; i++)
    if (arr2[i] % 15 === 0 && arr2[i] < 100) new_arr5.push(arr2[i]);
}

// lab 6
function mang_nguyen_to(arr2) {
  let new_arr6 = [];
  for (i = 0; i < arr2.length; i++)
    if (kiem_tra_so_nguyen_to(arr2[i])) new_arr6.push(arr2[i]);
  return new_arr6;
}

// lab 8: giong lab 3

// lab 9
function repeat_string(str9) {
  return str9.repeat(10);
}

// lab 10
function repeat_string10(str10) {
  let new_str10 = "";
  for (i = 0; i < 10; i++) new_str10 = new_str10.concat(str10, "-");
  return new_str10.slice(0, 19);
}

// 4. them phan tu vao 1 vi tri bat ki
function insert_element(arr, n, x, pos) {
  var i = n;
  for (i; i >= pos; i--) arr[i + 1] = arr[i];
  arr[pos] = x;
}
