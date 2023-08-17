async function searchAppointment(page) {
    var param = document.getElementById("param").value
    var start = document.getElementById("start").value
    var end = document.getElementById("end").value

    var url = 'http://localhost:8080/api/v1/appointment/admin/all?page='+page+"&size=3&param="+param;
    if(start != "" && start != null && end != null && end != ""){
        url += '&start='+start+'&end='+end;
    }
    const response = await fetch(url, {
        method: 'GET',
        headers: new Headers({
        })
    });
    var result = await response.json();
    console.log(result);
    var list = result.content;
    var totalPage = result.totalPages
    var main = '';


    var urls = 'http://localhost:8080/api/v1/appointment/admin/all-status';
    const res = await fetch(urls, {
        method: 'GET',
        headers: new Headers({
        })
    });
    var liststa = await res.json();
    console.log(liststatus)

    var liststatus = [];
    for(j=0; j<liststa.length; j++){
        liststatus.push(liststa[j])
    }
    for (i = 0; i < list.length; i++) {
        var st = '';
        for(j=0; j<liststatus.length; j++){
            st += `<a onclick="activeApoi(${list[i].id},'${liststatus[j]}')" class="dropdown-item" href="#">${liststatus[j]}</a>`
        }

        main += `<tr>
                    <td>${list[i].id}</td>
                    <td>${list[i].patient.name}</td>
                    <td></td>
                    <td>${list[i].doctor.user.name}</td>
                    <td>${list[i].speciality.name}</td>
                    <td>${list[i].appointmentDate}</td>
                    <td>${list[i].appointmentTime}</td>
                    <td>
                       ${list[i].appointmentStatus}
                    </td>
                    <td class="text-right">
                        <div class="dropdown dropdown-action">
                            <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-ellipsis-v"></i></a>
                            <div class="dropdown-menu dropdown-menu-right">
                               ${st}
                            </div>
                       </div>
                    </td>
                </tr>`
    }
    document.getElementById("listApp").innerHTML = main
    var mainpage = ''
    for(k=1; k<= totalPage; k++){
        mainpage += '<li onclick="searchAppointment('+(Number(k)-1)+')" class="page-item"><a class="page-link">'+k+'</a></li>'
    }
    document.getElementById("listpage").innerHTML = mainpage
}

async function activeApoi(id, status) {
    var con = confirm("Bạn chắc chắn muốn chuyển trạng thái lịch hẹn?");
    if(con){
        var urls = 'http://localhost:8080/api/v1/appointment/admin/accept?id='+id+"&status="+status;
        const response = await fetch(urls, {
            method: 'POST',
            headers: new Headers({
            })
        });
        if (response.status < 300) {
            window.location.reload();
        }
        else {
            alert("thất bại")
        }
    }
}