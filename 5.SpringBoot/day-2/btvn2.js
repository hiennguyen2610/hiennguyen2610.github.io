// lab 1
function sum(arr1) {
  let result_sum = 0;
  for (i = 0; i < arr1.length; i++) result_sum += arr1[i];
  return result_sum;
}

function multiple(arr1) {
  let result_multiple = 0;
  for (i = 0; i < arr1.length; i++) result_multiple = result_multiple * arr1[i];
  return result_multiple;
}

function average(arr1) {
  return result_sum / arr1.length;
}

function bigger_key(arr1, key) {
  let new_arr1 = [];
  for (i = 0; i < arr1.length; i++)
    if (arr1[i] > key) return new_arr1.push(arr1[i]);
}

// lab 2
function insert_element(arr2, pos) {
  let num;
  arr2.splice(pos, 0, num);
  return arr2;
}

// lab 3
function filter_square_number(arr3) {
  let new_arr3 = [];
  for (i = 0; i < arr3.length; i++)
    if (arr3[i] > 0 && Math.sqrt(arr3[i]) === Math.floor(Math.sqrt(arr3[i])))
      return new_arr3.push(arr3[i]);
}

// lab 4
function replace(arr4) {
  for (i = 0; i < arr4.length; i++) if (arr4[i] < 0) arr4[i] = 0;
  return arr4;
}

// lab 5
function kiem_tra_so_nguyen_to(n) {
  if (n <= 1) return false;
  for (let i = 2; i <= Math.sqrt(n); i++) if (n % i === 0) return false;
  return true;
}
function delete_prime_num(arr5) {
  let new_arr5 = [];
  for (i = 0; i < arr5.length; i++)
    if (!kiem_tra_so_nguyen_to(arr5[i])) new_arr5.push(arr5[i]);
  return new_arr5;
}
