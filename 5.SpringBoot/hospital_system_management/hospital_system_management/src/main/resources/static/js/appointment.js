var listTime = ['08:00','08:30','09:00','09:30','10:00','10:30','11:00','11:30','13:00','13:30','14:00','14:30','15:00','15:30','16:00','16:30']

async function loadAllSpeciality(){
    var url = 'http://localhost:8080/api/v1/speciality/public/all';
    const response = await fetch(url, {
        method: 'GET',
        headers: new Headers({
        })
    });
    var list = await response.json();
    console.log(list)
    var main = '<option data-value="2" selected class="option" disabled>Speciality</option>';
    for (i = 0; i < list.length; i++) {
        main += `<option data-value="2" value="${list[i].id}" class="option">${list[i].name}</option>`
    }
    document.getElementById("listSpeciality").innerHTML = main
    time = null;
    document.getElementById("datecs").innerHTML = ""
    document.getElementById("chooseDate").value = ""
    document.getElementById("listTime").innerHTML = "please choose a doctor and date"
}


async function loadDoctorBySpecialy(e){
    var url = 'http://localhost:8080/api/v1/doctor/public/all?idSpecialy='+e.value;
    const response = await fetch(url, {
        method: 'GET',
        headers: new Headers({
        })
    });
    var list = await response.json();
    console.log(list)
    var main = '';
    for (i = 0; i < list.length; i++) {
        main += `<option value="${list[i].id}" class="option">${list[i].user.name}</option>`
    }
    document.getElementById("listDoctor").innerHTML = main
    document.getElementById("chooseDate").disabled = false
}

// xóa input date khi chọn bsi mới
function clearI(){
    time = null;
    document.getElementById("chooseDate").value = ""
    document.getElementById("datecs").innerHTML = ""
    document.getElementById("listTime").innerHTML = "please choose a doctor and date"
}


async function loadTime(){
    var doctorId = document.getElementById("listDoctor").value;
    var dates = document.getElementById("chooseDate").value;
    if(doctorId == null || doctorId == ""){
        document.getElementById("listTime").innerHTML = "please choose a doctor and date"
        return;
    }
    else{
        var url = 'http://localhost:8080/api/v1/appointment/public/appointmentByDoctor?doctorId='+doctorId+"&date="+dates;
        const response = await fetch(url, {
            method: 'GET',
            headers: new Headers({
            })
        });
        var list = await response.json();
        console.log(list)

        var main = ''
        for(i=0; i<listTime.length; i++){
            var check = false;
            for(j=0; j<list.length; j++){
                var t = list[j].appointmentTime.split(":")[0] +":"+list[j].appointmentTime.split(":")[1]
                if(t == listTime[i]){
                    check = true;
                }
            }
            if(check == false){
                main += `</span><span onclick="chooseTime(this,'${listTime[i]}')" class="time-item">${listTime[i]}</span>`
            }
            else{
                main += `</span><span class="time-item useds">${listTime[i]}</span>`
            }
        }
        document.getElementById("listTime").innerHTML = main
    }
}

function chooseTime(e, chooseTime){
    var list = document.getElementById("listTime");
    var le = list.getElementsByClassName("time-item").length;
    for(i=0; i<le; i++){
        list.getElementsByClassName("time-item")[i].classList.remove('active');
    }
    e.classList.add("active");
    time = chooseTime;
    document.getElementById("datecs").innerHTML = "date: "+ document.getElementById("chooseDate").value +", time: "+time
}


var time = null;
async function createAppointment(){
    var url = 'http://localhost:8080/api/v1/appointment/public/create';
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var phone = document.getElementById("phone").value;
    var gender = document.getElementById("gender").value;
    var address = document.getElementById("address").value;
    var speciality = document.getElementById("listSpeciality").value;
    var doctor = document.getElementById("listDoctor").value;
    var chooseDate = document.getElementById("chooseDate").value;
    var symptom = document.getElementById("message").value;
    checkInput(name,email,phone,gender,address,speciality,doctor,chooseDate,symptom);
    var req = {
        "doctor":{"id":doctor},
        "speciality":{"id":speciality},
        "appointmentDate":chooseDate,
        "appointmentTime":time,
        "symptom":symptom,
        "email":email,
        "name":name,
        "phone":phone,
        "address":address,
        "gender":gender
    }

    const response = await fetch(url, {
        method: 'POST',
        headers: new Headers({
            'Content-Type': 'application/json'
        }),
        body: JSON.stringify(req)
    });
    if(response.status < 300){
        var result = await response.json();
        window.location.reload()
    }
}


function checkInput(name,email,phone,gender,address,speciality,doctor,chooseDate,symptom){
    if(name == "" || name == null){
        document.getElementById("nameerror").style.display = 'block'; return;
    }
    if(email == "" || email == null){
        document.getElementById("emailerror").style.display = 'block'; return;
    }
    if(phone == "" || phone == null){
        document.getElementById("phoneerror").style.display = 'block';return;
    }
    if(address == "" || address == null){
        document.getElementById("addresserror").style.display = 'block'; return;
    }
    if(speciality == "" || speciality == null){
        document.getElementById("specialityerror").style.display = 'block'; return;
    }
    if(doctor == "" || doctor == null){
        document.getElementById("doctorerror").style.display = 'block'; return;
    }
    if(chooseDate == "" || chooseDate == null){
        document.getElementById("dateerror").style.display = 'block'; return;
    }
    if(time == null){
        document.getElementById("timeerror").style.display = 'block'; return;
    }
}


async function searchMyAppointment() {
    var param = document.getElementById("param").value

    var url = 'http://localhost:8080/api/v1/appointment/public/myAppointment?param='+param;
    const response = await fetch(url, {
        method: 'GET',
        headers: new Headers({
        })
    });
    var list = await response.json();
    console.log(list)
    var main = '';

    for (i = 0; i < list.length; i++) {
        main += `<tr>
                    <td>${list[i].id}</td>
                    <td>${list[i].patient.name}</td>
                    <td>${list[i].doctor.user.name}</td>
                    <td>${list[i].speciality.name}</td>
                    <td>${list[i].appointmentDate}</td>
                    <td>${list[i].appointmentTime}</td>
                    <td>
                       ${list[i].appointmentStatus}
                    </td>
                    <td class="text-right">
<!--                        <button class="btn btn-danger">Hủy</button>-->
                    </td>
                </tr>`
    }
    if(list.length < 1){
    main =  `<tr>
                <td colspan="9"><h3>Không có dữ liệu lịch hẹn nào</h3></td>
            </tr>`
    }
    document.getElementById("listApp").innerHTML = main
}

