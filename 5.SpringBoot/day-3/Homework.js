function Grades(name, grade, sex) {
  this.name = name;
  this.grade = grade;
  this.sex = sex;
}

const grades1 = new Grades("John", 8, "M");
const grades2 = new Grades("Sarah", 12, "F");
const grades3 = new Grades("Bob", 16, "M");
const grades4 = new Grades("Johnny", 2, "M");
const grades5 = new Grades("Ethan", 4, "M");
const grades6 = new Grades("Paula", 18, "F");
const grades7 = new Grades("Donald", 5, "M");
const grades8 = new Grades("Jennifer", 13, "F");
const grades9 = new Grades("Courtney", 15, "F");
const grades10 = new Grades("Jane", 9, "F");

let grades_arr = [
  grades1,
  grades2,
  grades3,
  grades4,
  grades5,
  grades6,
  grades7,
  grades8,
  grades9,
  grades10,
];

// Bai 1. Tinh thu hang trung binh cua lop
function grade_average(grades) {
  let sum = 0;
  for (let i = 0; i < grades.length; i++) sum += grades[i].grade;
  return (average = sum / grades.length);
}
console.log("1. Thu hang trung binh cua lop la: ");
console.log(grade_average(grades_arr));

// Bai 2. Tinh thu hang trung binh cua nam trong lop
function grade_average_by_male(grades) {
  let sum = 0;
  let count = 0;
  for (let i = 0; i < grades.length; i++)
    if (grades[i].sex === "M") {
      sum += grades[i].grade;
      count++;
    }
  return (male_average = sum / count);
}
console.log("2. Thu hang trung binh cua nam gioi trong lop la: ");
console.log(grade_average_by_male(grades_arr));

// Bai 3. Tinh thu hang trung binh cua nu trong lop (lam tuong tu)

// Bai 4. Tim hoc vien nam co thu hang cao nhat trong lop
function find_highest_male_grade(grades) {
  let male_student = grades.filter((student) => student.sex === "M");
  let sort_male_student = male_student.sort((a, b) => a.grade - b.grade);
  return sort_male_student[0];
}
console.log("4. Hoc vien nam co thu hang cao nhat lop la: ");
console.log(find_highest_male_grade(grades_arr));

// Bai 5,6,7 (lam tuong tu)

// Bai 8. TIm thu hang cao nhat cua lop
function find_highest_grade(grades) {
  let sort_highest_grade = grades.sort((a, b) => a.grade - b.grade);
  return sort_highest_grade[0];
}
console.log("8. Hoc vien co thu hang cao nhat lop la: ");
console.log(find_highest_grade(grades_arr));

// Bai 9. Lay ra thu hang thap nhat cua lop (lam tuong tu)

// Bai 10. Lay ra danh sach tat ca hoc vien nu trong lop
function find_female(grades) {
  return (female_student = grades.filter((student) => student.sex === "F"));
}
console.log("10. Danh sach hoc sinh nu la: ");
console.log(find_female(grades_arr));

// Bai 11. Sap xep ten hoc vien theo alphabet
function sort_by_name(grades) {
  return grades.sort((a, b) => a.name.localeCompare(b.name));
}
console.log("11. Danh sach hoc vien theo alphabet:");
console.log(sort_by_name(grades_arr));

// Bai 12. Sap xep thu hang hoc vien theo chieu giam dan
function sort_by_grade(grades) {
  return (sort_grade = grades.slice().sort((a, b) => a.grade - b.grade));
}
console.log("12. Danh sach hoc sinh thu hang giam dan la: ");
console.log(sort_by_grade(grades_arr));

// Bai 13. Lay ra hoc vien nu co ten bat dau bang "J"
function find_female_start_with_J(grades) {
  return grades.filter(
    (student) => student.sex === "F" && student.name.charAt(0) === "J"
  );
}
console.log("13. Hoc vien nu co ten bat dau bang chu J la: ");
console.log(find_female_start_with_J(grades_arr));

// Bai 14. Lay ra top 5 nguoi co thu hang cao nhat lop
function find_top_5_grade(grades, count) {
  return grades.sort((a, b) => a.grade - b.grade).slice(0, count);
}
console.log("14. Top 5 nguoi co thu hang cao nhat lop la: ");
console.log(find_top_5_grade(grades_arr, 5));
