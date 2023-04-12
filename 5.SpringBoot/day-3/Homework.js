function Grades(name, grade, sex) {
    this.name = name
    this.grade = grade
    this.sex = sex
}

const grades1 = new Grades("John", 8, "M")
const grades2 = new Grades("Sarah", 12, "F")
const grades3 = new Grades("Bob", 16, "M")
const grades4 = new Grades("Johnny", 2, "M")
const grades5 = new Grades("Ethan", 4, "M")
const grades6 = new Grades("Paula", 18, "F")
const grades7 = new Grades("Donald", 5, "M")
const grades8 = new Grades("Jennifer", 13, "F")
const grades9 = new Grades("Courtney", 15, "F")
const grades10 = new Grades("Jane", 9, "F")

let grades_arr = [grades1, grades2, grades3, grades4, grades5, grades6, grades7, grades8, grades9, grades10] 

// Bai 1. Tinh thu hang trung binh cua lop
function grade_average(grades) {
    let sum = 0
    for(let i = 0; i < grades.length; i++) 
    sum += grades[i].grade
    return average = sum / grades.length
}
console.log("1. Thu hang trung binh cua lop la: ")
console.log(grade_average(grades_arr))