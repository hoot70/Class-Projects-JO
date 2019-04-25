var username = $('#username')

$('#myButton').click(function (event) { 
  $('#stuff').html('')
  findUser(username)
    .catch(handleUsernameError)
    .then(getPostsByUser)
    .then(renderPosts)

  findUser(username)
    .catch(handleUsernameError)
    .then(getAlbumsByUser)
    .then(renderAlbums)

  findUser(username)
    .then(renderName)
})

$('#return').click(function (event){ 
  $('#titleHeader').html('')
  $('#title').html('')
  $('#textHeader').html('')
  $('#text').html('')
  $('#commentHeader').html('')
  $('#comment').html('')
  $('#return').html('')
  
  findUser(username)
    .catch(handleUsernameError)
    .then(getPostsByUser)
    .then(renderPosts)

  findUser(username)
    .catch(handleUsernameError)
    .then(getAlbumsByUser)
    .then(renderAlbums)

  findUser(username)
    .then(renderName)
})

function findUser (username) {
  return new Promise(function (resolve, reject) {
    $.get(
      'http://jsonplaceholder.typicode.com/users?username=' + username.val(),
      function (users) {
        if (users.length) {
          resolve(users[0])
        } else {
          reject('User with name ' + username + ' not found')
        }
      }
    )
  })
}

function getPostsByUser (user) {
  return new Promise(function (resolve, reject) {
    $.get(
      'http://jsonplaceholder.typicode.com/posts?userId=' + user.id,
      function (posts) {
        resolve(posts)
      }
    )
  })
}

function getAlbumsByUser (user) {
  return new Promise(function (resolve, reject) {
    $.get(
      'http://jsonplaceholder.typicode.com/albums?userId=' + user.id,
      function (albums) {
        resolve(albums)
      }
    )
  })
}

function handleUsernameError (err) {
  console.warn(err, 'Using id=1 instead')
  return {
    username: 'Sample User',
    id: 1
  }
}

function renderPosts (posts) {
  $('#mainTitle').html('Post Titles')
  const list = $('#main')
  posts.forEach(function (post) {
    const li = $('<li></li>')
    li.click({ postId: post.id }, function (event) {
      $('#main').html('')
      $('#music').html('')
      $('#mainTitle').html('')
      $('#musicTitle').html('')
      $('#titleHeader').html('Post Title')
      $('#textHeader').html('Post')
      $('#commentHeader').html('Comments')
      $('#return').html('Click to Return to Home Page')

      $.get(
        'http://jsonplaceholder.typicode.com/posts?id=' + event.data.postId,
        function (posts) {
          posts.forEach(function (post) {
            $('#title').html(post.title)
          })
        }
      )
      $.get(
        'http://jsonplaceholder.typicode.com/posts?id=' + event.data.postId,
        function (posts) {
          posts.forEach(function (post) {
            $('#text').html(post.body)
          })
        }
      )
      $.get(
        'http://jsonplaceholder.typicode.com/comments?postId=' +
          event.data.postId,
        function (comments) {
          const lists = $('#comment')
          comments.forEach(function (comment) {
            const li = $('<li></li>')
            li.text(comment.body)
            lists.append(li)
          })
        }
      )
    })
    li.text(post.title)
    list.append(li)
  })
}

function renderAlbums (albums) {
  $('#musicTitle').html('Album Titles')
  const list = $('#music')
  albums.forEach(function (album) {
    const li = $('<li></li>')
    li.click({ albumId: album.id }, function (event) {
      $('#main').html('')
      $('#music').html('')
      $('#mainTitle').html('')
      $('#musicTitle').html('')
      $('#titleHeader').html('Album Title')
      // $('#textHeader').html('Post')
      $('#commentHeader').html('Thumbnail Pictures')
      $('#return').html('Click to Return to Home Page')
      $('#search').html('<input type="text" id="myInput" placeholder="Search for names.."></input>')
      
      $.get(
        'http://jsonplaceholder.typicode.com/albums?id=' + event.data.albumId,
        function (albums) {
          albums.forEach(function (album) {
            $('#title').html(album.title)
          })
        }
      )
      // $.get(
      //   'http://jsonplaceholder.typicode.com/albums?id=' + event.data.albumId,
      //   function (albums) {
      //     albums.forEach(function (album) {
      //       $('#text').html(album.body)
      //     })
      //   }
      // )
      $.get(
        'http://jsonplaceholder.typicode.com/photos?albumId=' +
          event.data.albumId,
        function (photos) {
          const lists = $('#comment')
          photos.forEach(function (photo) {
            const li = $('<li></li>')
            li.html(`<img src='${photo.thumbnailUrl}'><br>${photo.title}</img>`).css('list-style-type', 'none')
            lists.append(li)
          })
        }
      )
      
      const input = document.querySelector('#myInput')
      input.addEventListener('change', (e) => {
          if (photo.title.index(e) > -1){
        } else {
            li.html('');
            lists.append(li)
        }
    })
      // function myFunction() {
      //   // Declare variables
      //   var input, filter, ul, li, a, i, txtValue;
      //   input = document.getElementById('myInput');
      //   filter = input.value.toUpperCase();
      //   ul = document.getElementById("comment");
      //   li = ul.getElementsByTagName('li');
        
      //   for (i = 0; i < li.length; i++) {
      //     a = li[i].getElementsByTagName("img")[0];
      //     txtValue = a.textContent || a.innerText;
      //     if (txtValue.toUpperCase().indexOf(filter) > -1) {
      //       li[i].style.display = "";
      //     } else {
      //       li[i].style.display = "none";
      //     }
      //   }
      // }
    })
    li.text(album.title)
    list.append(li)
  })
}

function renderName (names) {
  $('#user').html(names.name)
}
