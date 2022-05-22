var postApi = 'https://gnews.io/api/v4/search?q=example&token=64a61fb901bae6f8eb8cd9df809ddca1'
fetch(postApi)
    //chuyển json -> js (thay JSON.parse)
    .then(function(response) {
        return response.json();
    })
    // nhận kết quả dưới dạng js
    .then(function(data) {
        console.log(data);  //in kiểm tra
        
            var myArray = data.articles;
            var htmls = myArray.map(function(post) {
                return `    
                <div class="main-content row">
                    <img class="col-sm-4" src=${post.image}>
                    <div class="col-sm-8">
                        <a href=${post.url} target="_blank">${post.title}</a>
                        <p>${post.publishedAt}</p>
                        <p>${post.content}</p>
                    </div>
                </div>    
                `;
            })
            var html = htmls.join("");
            document.getElementById("one").innerHTML = html;
    });

// Function tìm kiếm
function timkiem() {
    var nhap = document.getElementById("input").value;
    console.log(nhap);
    var postSearch = `https://gnews.io/api/v4/search?q=${nhap}&token=64a61fb901bae6f8eb8cd9df809ddca1`
    console.log(postSearch)
    fetch(postSearch)

        .then(function(response) {
            return response.json();
        })
        .then(function(data) {
            console.log(data);
            
                var myArray = data.articles;
                var htmls = myArray.map(function(posts) {
                    return `
                    <div class="main-content row">
                        <img class="col-sm-4" src=${posts.image}>
                        <div class="col-sm-8">
                            <a href=${posts.url} target="_blank">${posts.title}</a>
                            <p>${posts.publishedAt}</p>
                            <p>${posts.content}</p>
                        </div>
                    </div>    
                    `;
                })
                var html = htmls.join("");
                
                
                document.getElementById("one").innerHTML = "";

                document.getElementById("one").innerHTML = html;

        })
}
    
    



