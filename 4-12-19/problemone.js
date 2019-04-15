$('#all').click(function () {
    $.get('http://jsonplaceholder.typicode.com/posts', function (all) {
      const list = $('#main')
      all.forEach(function (post) {
        const li = $('<li></li>')
        li.text(post.body)
        list.append(li)
      })
    })
  })
  
  $('#ten').click(function () {
    $.get('http://jsonplaceholder.typicode.com/posts', { id: 10 }, function (all) {
      const list = $('#main')
      all.forEach(function (post) {
        const li = $('<li></li>')
        li.text(post.body)
        list.append(li)
      })
    })
  })
  
  $('#twelve').click(function () {
    $.get('http://jsonplaceholder.typicode.com/comments?postId=12', function (
      all
    ) {
      const list = $('#main')
      all.forEach(function (post) {
        const li = $('<li></li>')
        li.text(post.body)
        list.append(li)
      })
    })
  })
  
  $('#two').click(function () {
    $.get('http://jsonplaceholder.typicode.com/posts', { userId: 2 }, function (
      all
    ) {
      const list = $('#main')
      all.forEach(function (post) {
        const li = $('<li></li>')
        li.text(post.body)
        list.append(li)
      })
    })
  })
  
  $('#two').click(function () {
    $.get('http://jsonplaceholder.typicode.com/posts', { userId: 2 }, function (
      all
    ) {
      const list = $('#main')
      all.forEach(function (post) {
        const li = $('<li></li>')
        li.text(post.body)
        list.append(li)
      })
    })
  })
  
  $('#post').click(function () {
    $.post(
      'http://jsonplaceholder.typicode.com/posts',
      {
        body: 'sup',
        title: 'New Post',
        userId: 1
      },
      function (post) {
        console.log(post.id)
      }
    )
  })
  
  $('#replace').click(function () {
    $.ajax({
      method: 'PUT',
      url: 'http://jsonplaceholder.typicode.com/posts/12',
      data: { body: 'updated', title: 'updated', userId: 1 },
      complete: function (response) {
        console.log(response.responseJSON)
      }
    })
  })
  
  $('#update').click(function () {
    $.ajax({
      method: 'PUT',
      url: 'http://jsonplaceholder.typicode.com/posts/12',
      data: { title: 'New Title' },
      complete: function (response) {
        console.log(response.responseJSON)
      }
    })
  })
  
  $('#delete').click(function () {
    $.ajax({
      method: 'DELETE',
      url: 'http://jsonplaceholder.typicode.com/posts/12',
      complete: function (response) {
        console.log(response.statusText)
      }
    })
  })
  
  $('#someposts').click(function () {
    $.get('http://jsonplaceholder.typicode.com/posts', function (
      all
    ) {
      const list = $('#main')
      all.forEach(function (post) {
        const li = $('<li></li>')
        li.text(post.body)
        list.append(li)
      })
    })
  })
  
  $('#postlist').on('click', function(){
      list.text("")
      $.get('http://jsonplaceholder.typicode.com/posts', function(posts){  
          posts.forEach(function(post){
              const li = $('<li>');
              li.text('Post' + post.id + ': ' + post.body)
              list.append(li);
              li.addClass((post.id).toString()) 
          })
      })
      $('ul').on('click',function(event){   
          $('li').css('display', 'none');   
          let chosenPost = event.target;   
          $.get('http://jsonplaceholder.typicode.com/comments', function(comments){   
          comments.forEach(function(comment){   
              if(chosenPost.className == (comment.postId).toString()){   
                  console.log('it works');   
                  const li = $('<li>'); 
                  li.text('Post' + post.id + ' comments: ' + comment.body);   
                  list.append(li);
              }
          })
      })
      })
  })