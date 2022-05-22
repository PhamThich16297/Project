

// var nhap = document.getElementById("input").value;
// var searchApi = `https://gnews.io/api/v4/search?q=${nhap}&token=64a61fb901bae6f8eb8cd9df809ddca1`


// function start() {
//     getCourses(renderCourses);
//     search();
// }

// start()

// function getCourses(callback) {
//     fetch(searchApi)
//         .then(function(reponse) {
//             return reponse.json();
//         })
//         .then(callback)
// }

// function renderCourses(courses) {
//     var search = document.querySelector("#one");
//     var htmls = courses.map(function(course) {

//         return `
//             <p>${course.title}</p>

//         `;
        
//     });
//     search.innerHTML = htmls.join("");
// }

// /////////////////
// function searchInput(data, callback) {
//     var options = {
//         method: 'POST'
//         // body: JSON.stringify(data)
//     };

//     fetch(searchApi, options)
//         .then(function(reponse) {
//             reponse.json();
//         })
//         .then(callback);
// }

// //search
// function search() {
//     var searchBtn = document.querySelector("#search")
//     searchBtn.onclick = function() {
//         //var formData = ${course.title};
//         searchInput(formData,function() {
//             getCourses(renderCourses);
//         });
//     }
// }