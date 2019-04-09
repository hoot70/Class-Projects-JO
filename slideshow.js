// ## Exercise: This

// Create a single object named `slideshow` that represents the data and functionality of a picture slideshow. There should be NO VARIABLES OUTSIDE THE OBJECT. The object should have properties for:

// 1. An array called `photoList` that contains the names of the photos as strings
// 2. An integer `currentPhotoIndex` that represents which photo in the `photoList` is currently displayed
// 3. A `nextPhoto()` function that moves `currentPhotoIndex` to the next index `if `there is one, and:
// 	4. logs the current photo name.
// 	4. Otherwise, log "End of slideshow";
// 4. A `prevPhoto()` function that does the same thing, but backwards.
// 5. A function `getCurrentPhoto()` that returns the current photo from the list.

// ### Exercise Answer

// ```javascript
// // Have fun :)
// ```

var slideshow = {
    photoList: ['img1', 'img2', 'img3', 'img4'],
    currentPhotoIndex: 0,
    nextPhoto() {
        if (this.currentPhotoIndex == (this.photoList.length)){  
            console.log('End of Slideshow')
            this.pause()
        } else {
            console.log(this.photoList[this.currentPhotoIndex])
            this.currentPhotoIndex++;
        }
    },   
    prevPhoto() {
        if (this.currentPhotoIndex == 0){ 
            console.log('Beginning of Slideshow')
        } else {
            console.log(this.photoList[this.currentPhotoIndex]);
            this.currentPhotoIndex--;
        }
    },
    getCurrentPhoto() {
        console.log(this.photoList[this.currentPhotoIndex])
    },
    playInterval: null,
    play(){
        this.playInterval = setInterval(this.nextPhoto.bind(this),2000)
    },
    pause(){
        clearInterval(this.playInterval)
    },
};


slideshow.play()